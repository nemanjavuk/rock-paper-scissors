# rock-paper-scissors

## Running the app (*nix systems)
To run the application from terminal git clone the project and then type: `./gradlew run -q`

To run the tests from terminal type: `./gradlew test`

All of this can be done from your favorite IDE (I used IntelliJ IDEA 15 CE)

## Context of this MVP
This project is implemented in the context of playing a game between two players. If the context demanded that we should have kept the highscores for example, Player and Game could have been a little different and could be real entities in the DDD sense. Here I took some freedom in expressing Player as basically a stream of data that provides turns for the game.