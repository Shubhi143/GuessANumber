# 🎯 Guess Number API

A simple Java-based API to play the classic "Guess the Number" game using HTTP requests. Built with Java's built-in `HttpServer` and easily testable using tools like **Postman**.

---

## 🚀 Features

- Start a new guessing game.
- Submit guesses and receive feedback.
- Tracks the number of attempts.

---

## 📦 Prerequisites

- **Java 8 or above**
- **Postman** (or any API testing tool)

---

## ⚡ How to Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Shubhi143/GuessANumber
   cd GuessANumber
   ```

2. **Compile the Java File:**
   ```bash
   javac GuessNumberGame.java
   ```

3. **Run the Server:**
   ```bash
   java GuessNumberGame
   ```

   ✅ You'll see:
   ```
   Server started on port 8080
   ```

---

## 🌐 API Endpoints

### 1️⃣ Start a New Game

- **URL:** `http://localhost:8080/game/start`
- **Method:** `GET`

**Response:**
```
🎯 New game started! Guess a number between 1 and 100.
```

---

### 2️⃣ Make a Guess

- **URL:** `http://localhost:8080/game/guess?guess=50`
- **Method:** `POST`

**Possible Responses:**
- `📉 Too low! Try again.`
- `📈 Too high! Try again.`
- `🎉 Congratulations! You guessed the number 42 in 3 attempts.`

---

## 🤔 How It Works

- The game generates a **random number between 1 and 100**.
- Each guess increases the **attempt count**.
- Feedback is provided until the correct guess is made.

---

## 📦 Folder Structure

```
📦 guess-number-api
 └── 📄 GuessNumberGame.java
 └── 📄 README.md
```

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Acknowledgments

- Built with 💙 using **Java**
- Tested using **Postman**

---

Feel free to fork, contribute, and play around with the code! 🚀

