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
        Player player = new Player(playerName);
        return player;
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
        } else if ("N".equals(play)) {
        }

    }


   /* public void sayAnything() {
        System.out.println(player.name);
    }*/


    public int decideWinner() {

        System.out.println("Enter choice");
        player.choice = scanner.nextInt();
        while (player.choice>2){
            System.out.println("Enter a valid number");
            player.choice = scanner.nextInt();     }
        computer.choice = random.nextInt(GAME_LIMIT);
        System.out.println(computer.choice);

        int count = 0;   //tie      0 for tie,1 for player, 2 for computer


        if (player.choice == computer.choice) {
            count = 0;

        } else if (player.choice == 0 && computer.choice == 2) {
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
        } else count = -1;
        return count;

    }
}
