package ro.playGame;

import ro.playGame.Computer;
import ro.playGame.Player;

import java.util.*;

public class Game {
    public Player player;
    public Computer computer;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public List<Choice> choices;


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
        System.out.println();
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
                player.choice = Choice.valueOf("ROCK");
                break;
            case "P":
                player.choice = Choice.valueOf("PAPER");
                break;
            case "S":
                player.choice = Choice.valueOf("SCISSORS");
                break;

        }


       computer.choice=getRandomChoice();
        System.out.println("Computer: " + computer.choice);

        int count;   //tie      0 for tie,1 for player, 2 for computer

        if (player.choice.equals(computer.choice)) {
            count = 0;
        } else if ((player.choice.name().equals("ROCK") && computer.choice.name().equals("SCISSORS")) ||
                (player.choice.name().equals("PAPER") && computer.choice.name().equals("ROCK")) ||
                player.choice.name().equals("SCISSORS") && computer.choice.name().equals("PAPER")) {
            count = 1;
        } else {
            count = 2;
        }

        return count;

    }

    public Choice getRandomChoice() {
        choices=Arrays.asList(Choice.values());
        Collections.shuffle(choices);
        return choices.get(0);
    }
}
