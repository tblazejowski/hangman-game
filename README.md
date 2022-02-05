## Hangman game

This is a simple hangman game. First result of author's interaction with Anglular. The project is based on 2 frameworks:
SpringBoot & Angular.

### How to run the game

**Prerequisites:** Java 8+ & npm (package manager for the JavaScript)

1. Download the repository code and enter the folder (by default named 'hangman-game')
2. Start the backend of the game with SpringBoot framework executing below commands one after another:
   ```
   ./mvnw clean install
   java -jar target/hangman-game-0.0.1-SNAPSHOT.jar
   ```
   This should start the backend server at http://localhost:8080
3. Switch to the 'angularclient' folder within downloaded repo
4. Start the frontend o the game with Angular framework executing below commands:
   ```
   npm install
   ng serve
   ```
   This should start the frontend server at http://localhost:4200
5. Open above link in your browser and enjoy the game!
