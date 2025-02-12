import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Random;

public class GuessNumberGame {

    private static int targetNumber;
    private static int attempts;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/game/start", new StartGameHandler());
        server.createContext("/game/guess", new GuessNumberHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class StartGameHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                targetNumber = new Random().nextInt(100) + 1;
                attempts = 0;
                String response = "🎯 New game started! Guess a number between 1 and 100.";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    static class GuessNumberHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                String query = exchange.getRequestURI().getQuery();
                int guess = Integer.parseInt(query.split("=")[1]);
                attempts++;

                String response;
                if (guess == targetNumber) {
                    response = "🎉 Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.";
                } else if (guess < targetNumber) {
                    response = "📉 Too low! Try again.";
                } else {
                    response = "📈 Too high! Try again.";
                }

                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}
