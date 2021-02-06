package ro.playGame;

import ro.playGame.Computer;
import ro.playGame.Player;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public Player player;
    public Computer computer;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static final int GAME_LIMIT = 3;


    public static Player assignPlayer() {
        System.out.println("Enter name:");
        String playerName = scanner.next();
        return new Player(playerName);
    }


    public static Game initGame() {

        Player player = assignPlayer();
        Computer computer = new Computer();

        Game game = new Game();
        game.computer = computer;
        game.player = player;

        return game;

    }

    public void play() {

        int winner = decideWinner();
        switch (winner) {
            case 0:
                System.out.println("Tie");
                break;
            case 1:
                System.out.println("Player wins");
                break;
            case 2:
                System.out.println("Computer wins");
                break;
        }

        System.out.println("Play again? Y/N");
        String play = scanner.next().toUpperCase();

        if ("Y".equals(play)) {
            play();
        }

    }


    public int decideWinner() {

        System.out.println("Enter choice / R, P, S");
        String choice = scanner.next().toUpperCase();
        while (!"R".equals(choice.toUpperCase()) &&
                !"P".equals(choice.toUpperCase()) &&
        !"S".equals(choice.toUpperCase())) {
            System.out.println("Enter a valid statement");
            choice = scanner.next().toUpperCase();
        }
        switch (choice) {
            case "R":
                player.choice = 0;
                break;
            case "P":
                player.choice=1;
                break;
            case "S":
                player.choice=2;
                break;

        }

        computer.choice = random.nextInt(GAME_LIMIT);

        switch (computer.choice){
            case 0:
                System.out.println("Computer: Rocks");break;
            case 1:
                System.out.println("Computer: Paper");break;
            case 2:
                System.out.println("Computer: Scissors");break;
        }

        int count = 0;   //tie      0 for tie,1 for player, 2 for computer


        if (player.choice == 0 && computer.choice == 2) {
            count = 1;
        } else if (player.choice == 0 && computer.choice == 1) {
            count = 2;
        } else if (player.choice == 1 && computer.choice == 0) {
            count = 1;
        } else if (player.choice == 1 && computer.choice == 2) {
            count = 2;
        } else if (player.choice == 2 && computer.choice == 0) {
            count = 2;
        } else if (player.choice == 2 && computer.choice == 1) {
            count = 1;
        }
        return count;

    }
}
