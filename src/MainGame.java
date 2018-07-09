import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {
        Scanner playAgain = new Scanner(System.in);
        GameLoop gameLoop = new GameLoop();
        boolean playing = true;
        String answer;

        while (playing) {
            playing = gameLoop.startGame();
            System.out.println("Thanks for playing! Would you like to play again?");
            if (!playing) {
                System.out.println("Try 'Y' or 'N'");
                answer = playAgain.nextLine();
                if (answer.equals("Y")) {
                    playing = true;
                } else {
                    System.out.println("Thanks for playing. Come back soon!");
                }
            }
        }
    }
}
