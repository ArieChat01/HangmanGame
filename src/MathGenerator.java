import java.util.Scanner;

public class MathGenerator {
    public static void main(String[] args) {

        String userResponse;
        boolean notReady, game;
        notReady = true;
        game = true;
        Scanner user;
        user = new Scanner(System.in);
        String guessedLetter;

        System.out.println("WELCOME TO HANGMAN.");
        System.out.println("HERE ARE THE RULES!");
        System.out.println("FIRST, I WILL GIVE YOU A WORD TO GUESS. THEN YOU WILL GET 15 TRIES TO GUESS THAT WORD.");
        System.out.println("EACH LETTER YOU GUESS RIGHT EARNS YOU 100 PTS. EACH ONE YOU GUESS WRONG EARNS YOU 0 PTS.");
        System.out.println("GET IT RIGHT ON THE FIRST TRY AND GET 1000 PTS AUTOMATICALLY.");
        System.out.println("RUN OUT OF TRIES AND ... PTS WILL BE SUBTRACTED FROM YOUR TOTAL SCORE.");
        System.out.println("I'M NOT TOO UNKIND THOUGH. YOU WILL RECEIVE 3 HINTS EVERY ROUND. HOWEVER EVERY HINT ACCEPTED " +
                "WILL AFFECT THE AMOUNT OF POINTS YOU ARE ABLE TO RECEIVE FOR EACH ADDITIONAL LETTER.");

        while (game) {
            while (notReady) {
                System.out.println("ARE YOU READY?(Enter \"yes\" or \"no\"");
                userResponse = user.nextLine();
                if (userResponse.equals("yes")) {
                    notReady = false;
                } else if (userResponse.equals("no")) {
                    System.exit(0);
                } else if (!userResponse.equals("yes") && !userResponse.equals("no")) {
                    System.out.println("I said are you ready? This is not a rhetorical question, I actually need to know.");
                    notReady = true;
                }
            }
            System.out.println("Alright, now choose your difficulty.\nEASY    MEDIUM    HARD");
            userResponse = user.nextLine();
            if (userResponse.equals("easy") || userResponse.equals("EASY")) {
                String[] easyWords = {"favorite", "vacation", "quarter", "discover", "laughter", "inventor",};
                int generatedNumber = (int) (Math.random() * 6);
                System.out.println(easyWords[generatedNumber]);
                System.out.println("Alright, now guess a letter.");

            } else if (userResponse.equals("medium") || userResponse.equals("MEDIUM")) {
                String[] mediumWords = {"outrageous", "religious", "permeate", "lucrative", "procrastinate", "serviceable"};
                int generatedNumber = (int) (Math.random() * 6);
                System.out.println(mediumWords[generatedNumber]);
                System.out.println("Alright, now guess a letter.");
            } else if (userResponse.equals("hard") || userResponse.equals("HARD")) {
                String[] hardWords = {"propagandize", "massachusetts", "enzyme", "fuchsia", "lamborghini", "fettuccine"};
                int generatedNumber = (int) (Math.random() * 6);
                System.out.println(hardWords[generatedNumber]);
                System.out.println("Alright, now guess a letter.");
            }

        }
    }
}

public static String hangMan(int tries, boolean win){
    String respsonse = "";
    String feedback;
    if (win){feedback = "Wow. You won. "}

        }






















/*

        System.out.println("SELECT A PARTICIPANT");

        System.out.println("  \\\n" +
                "   o/\\_\n" +
                "  <\\__,\\\n" +
                "   \">   |\n" +
                "    `   |\n" +
                "         \\\n" +
                "          \\" +
                " ~~~~~~~~~~/|~~~\n" +
                "         c'__,={");















        System.out.println("" +
                " \n" +
                "/   (  .' .   \\\n" +
                "\\ ( ' ,_) ) \\_/\n" +
                " (_ , /\\  ,_/\n" +
                "   '--\\ `\\--`\n" +
                "       \\ _\\\n" +
                "      `\\ \\\n" +
                "       _\\_\\\n" +
                "       `\\\\\n" +
                "         \\\\\n" +
                "          \\"+
                "           _\\|/^\n" +
                "           (_oo\n" +
                "            |  \n  " +
                "         /|\\\n" +
                "            |\n" +
                "            LL\n");

*/


























        /* System.out.println("_____________________\n\n");
        System.out.println("" +
                "     /:\"\"|       .@@@@@,\n" +
                "     |: 66|_      @@@@@@@@,\n" +
                "     C     _)     aa`@@@@@@\n" +
                "      \\ ._|      (_   ?@@@@\n" +
                "       ) /        =' @@@@\"\n" +
                "      /`\\\\         \\(```\n" +
                "     || |Y|       //`\\        .\"~~~~~\".\n" +
                "     || |#|      / | ||       |  .:.  |\n" +
                "     || |#|      \\ | ||    A  | /6 6\\ |\n" +
                "     || |#|      / | ||   |~|_|_\\ e /_|_     .@@@@,\n" +
                "     :| |=:     /  | |\\   |_|)___`\"`___(8    aa`@@@,\n" +
                "     ||_|,|    |   |_| \\     |~~~~~~~~~|     =  `@@@\n" +
                "     \\)))||    |   (((  |    \\_________/       )_/`@'\n" +
                "  |~~~`-`~~~|  `~\\~~~~~~|     |/ /_\\ \\|       / || @\n" +
                "  |         |     `\\   /      ()/___\\()       | || @\n" +
                "  |_________|       ( ||      ||~~~~~||       /~|| \"`\n" +
                "  |_________|       | ||      ||     ||      /__W_\\\n" +
                "      | ||          | ||      ||     ||        |||\n" +
                "      |_||__      __|_||      ||_____||       _|||\n" +
                "      (____))    (:;:;))      ||-----||      ((___)");
        System.out.println("       BILL       DEBRA       LIL JOHNNY      SUSIE    ");*/



