import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static int calculateTotal(ArrayList<Integer> cards) {
        int total = 0;
        for (int card : cards) {
            total += card;
        }
        return total;
    }

    public static void main(String[] args) {
        String multipleLines = ".------.            _     _            _    _            _\n" +
                              "|A_  _ |.          | |   | |          | |  (_)          | |\n" +
                              "|( \\/ ).-----.     | |__ | | __ _  ___| | ___  __ _  ___| | __\n" +
                              "| \\  /|K /\\  |     | '_ \\| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n" +
                              "|  \\/ | /  \\ |     | |_) | | (_| | (__|   <| | (_| | (__|   <\n" +
                              "`-----| \\  / |     |_.__/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n" +
                              "      |  \\/ K|                            _/ |\n" +
                              "      `------'                           |__/";

        System.out.println(multipleLines);
        Scanner newScanner = new Scanner(System.in);

        System.out.println("Ketik 'p' untuk bermain, 's' untuk berhenti");

        String gameIsOn = newScanner.nextLine();

        int[] cards = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        Random random = new Random();

        ArrayList<Integer> myCards = new ArrayList<Integer>();
        ArrayList<Integer> computerCards = new ArrayList<Integer>();

        while (!gameIsOn.equals("s")) {
            for (int i = 0; i < 2; i++) {
                int randomNumber = cards[random.nextInt(cards.length)];
                myCards.add(randomNumber);
                computerCards.add(cards[random.nextInt(cards.length)]);
            }

            System.out.println("Kartu anda:");
            System.out.println(myCards);
            System.out.println("Kartu komputer:");
            System.out.println("[" + computerCards.get(0) + "]");

            int totalMyCards = calculateTotal(myCards);
            int totalComputerCards = calculateTotal(computerCards);

            while (totalMyCards < 21) {
                System.out.println("Apakah Kamu ingin menambah kartu?");
                System.out.println("Ketika 'y' jika iya, 'n' jika tidak");
                String hitOrStand = newScanner.nextLine();
                if (hitOrStand.equals("y")) {
                    int newCard = cards[random.nextInt(cards.length)];
                    myCards.add(newCard);
                    totalMyCards = calculateTotal(myCards);
                    while (calculateTotal(computerCards) < 17) {
                        computerCards.add(newCard);
                    }
                    System.out.println("Kartu anda:");
                    System.out.println(myCards);
                } else {
                    break;
                }
            }


            totalMyCards = calculateTotal(myCards);
            totalComputerCards = calculateTotal(computerCards);
            
            if (totalMyCards > 21 && totalComputerCards > 21) {
                System.out.println("It's a draw!");
            } else if (totalMyCards == 21 && totalComputerCards == 21) {
                System.out.println("It's a draw!");
            } else if (totalMyCards > 21) {
                System.out.println("You lose! Game over!");
            } else if (totalComputerCards > 21) {
                System.out.println("You WIN! CONGRATULATIONS!!!");
            } else if (totalMyCards > totalComputerCards) {
                System.out.println("You WIN! CONGRATULATIONS!!!");
            } else if (totalMyCards < totalComputerCards) {
                System.out.println("You lose! Game over!");
            }

            System.out.println("Kartu anda:");
            System.out.println(myCards);
            System.out.println("Kartu komputer:");
            System.out.println(computerCards);
            
            System.out.println("Apakah anda ingin bermain lagi?");
            System.out.println("Ketika 'y' jika iya, 'n' jika tidak");
            String playAgain = newScanner.nextLine();
            myCards.clear();
            computerCards.clear();

            if (playAgain.equals("n")) {
                gameIsOn = "s";
            }
        }
        System.out.println("game is stopped");
    }
}
