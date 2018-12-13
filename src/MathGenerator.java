import java.util.Scanner;

public class MathGenerator {
    public static void main(String[] args) {

        String userResponse;
        boolean gameTwo = true;
        boolean notReady = true;
        boolean game = true;
        boolean difficulty = true;
        boolean man = true;
        boolean wholeGame = true;
        boolean playAgain = true;
        boolean yes = true;
        Scanner user;
        user = new Scanner(System.in);
        String hangmanWord;
        String guessedLetter;
        int hangman;
        int hangmanTries;
        hangmanTries = 0;
        int score = 1000;
        String dashes;


        System.out.println("WELCOME TO HANGMAN.");
        System.out.println("HERE ARE THE RULES!");
        System.out.println("FIRST, I WILL GIVE YOU A WORD TO GUESS BASED ON YOUR DIFFICULTY LEVEL. THEN YOU WILL GET SO MANY TRIES TO GUESS THAT WORD.");
        System.out.println("GET IT RIGHT ON THE FIRST TRY AND GET 1000 PTS AUTOMATICALLY.");
        System.out.println("RUN OUT OF TRIES AND 150 PTS WILL BE SUBTRACTED FROM YOUR TOTAL SCORE.");

        while (wholeGame) {
            String[] alphabet = {"a ", "b ", "c ", "d ", "e ", "f ", "g ", "h ", "i ", "j", "\n", "k ", "l ", "m ", "n ", "o ", "p ", "q ", "r ", "s ", "t", "\n", "u ", "v ", "w ", "x ", "y ", "z", "\n"};
            while (notReady) {
                System.out.println("ARE YOU READY?(Enter \"yes\" or \"no\")");
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
            hangman = 0;
            while (difficulty) {
                System.out.println("\nNow choose your difficulty.\nEASY    MEDIUM    HARD");
                user = new Scanner(System.in);
                userResponse = user.nextLine().toLowerCase();

                if (userResponse.equals("easy")) {
                    difficulty = false;
                    man = true;
                }
                if (userResponse.equals("medium")) {
                    difficulty = false;
                    hangman++;
                    man = true;
                }
                if (userResponse.equals("hard")) {
                    difficulty = false;
                    hangman += 2;
                    man = true;
                }
                if (!userResponse.equals("easy") && !userResponse.equals("medium") && !userResponse.equals("hard")) {
                    System.out.println("Nah Bruh. Read the instructions.");
                    difficulty = true;
                    man = false;
                }
            }
            while (man) {
                System.out.println("NOW... CHOOSE YOUR MAN.");
                System.out.println("    \\\n" +
                        "   o/\\_\n" +
                        "  <\\__,\\\n" +
                        "   \">   |\n" +
                        "    `   |\n" +
                        "         \\\n" +
                        "          \\\n" +
                        " ~~~~~~~~~~/|~~~\n" +
                        "         c'__,={\n" +
                        "          \n BOB        ");
                System.out.println("         \n  \\\\OR\\\\");
                System.out.println("/   (  .' .   \\\n" +
                        "\\ ( ' ,_) ) \\_/\n" +
                        " (_ , /\\  ,_/\n" +
                        "   '--\\ `\\--`\n" +
                        "       \\ _\\\n" +
                        "      `\\ \\\n" +
                        "       _\\_\\\n" +
                        "       `\\\\\n" +
                        "         \\\\\n" +
                        "          \\\n" +
                        "            \n" +
                        "           _\\|/^\n" +
                        "           (_oo\n" +
                        "            |  \n  " +
                        "         /|\\\n" +
                        "            |\n" +
                        "            LL\n" +
                        "            \n  TED           ");

                userResponse = user.nextLine().toLowerCase();
                if (userResponse.equals("bob")) {
                    man = false;
                    game = true;
                    gameTwo = false;
                } else if (userResponse.equals("ted")) {
                    man = false;
                    game = false;
                    gameTwo = true;
                } else if (!userResponse.equals("bob") && !userResponse.equals("ted")) {
                    System.out.println("No imbecile, choose Bob or Ted.");
                    man = true;
                    game = false;
                    gameTwo = false;
                }
            }
            hangmanWord = difficulty(hangman);
            System.out.println(hangmanWord);
            dashes = wordDashes(hangmanWord);
            System.out.println(dashes);
            System.out.println("Now guess a letter.");
            while (game) {
                System.out.println("YOUR SCORE: " + score + ".");
                guessedLetter = user.nextLine().toLowerCase();
                dashes = letterReplacementDashes(hangmanWord, guessedLetter, dashes);
                if (guessedLetterRight(hangmanWord, guessedLetter)) {
                    System.out.println(dashes);
                    System.out.print("That's odd, that seems to be correct.");
                } else {
                    System.out.println(hangMan(hangmanTries, false));
                    hangmanTries++;
                }
                if (hangmanTries > 11) {
                    score -= 150;
                    gameTwo = false;
                    System.out.println(hangMan(hangmanTries, false));
                    break;
                }
                if (hangmanWord.equalsIgnoreCase(guessedLetter) && hangmanTries == 11) {
                    score += 750;
                    System.out.println("LAST CHANCE ACHIEVEMENT!");
                    gameTwo = false;
                    break;
                }
                if (hangmanWord.equalsIgnoreCase(guessedLetter) && hangmanTries == 0) {
                    score += 1000;
                    System.out.println(" Did you cheat?");
                    gameTwo = false;
                    break;
                }
                if (hangmanWord.equalsIgnoreCase(guessedLetter)) {
                    System.out.println(hangMan(hangmanTries, true));
                    score += 500;
                    gameTwo = false;
                    break;
                }
                alphabet = Beta(alphabet, guessedLetter);
                System.out.println(" ");
                for (String letter : alphabet) {
                    System.out.print(letter);
                }
                System.out.println(" ");
            }


            while (gameTwo) {
                guessedLetter = user.nextLine().toLowerCase();
                dashes = letterReplacementDashes(hangmanWord, guessedLetter, dashes);
                if (guessedLetterRight(hangmanWord, guessedLetter)) {
                    System.out.println(dashes);
                    System.out.print("That's odd, that seems to be correct.");
                } else {
                    System.out.println(hangManTwo(hangmanTries, false));
                    hangmanTries++;
                }
                if (hangmanTries > 13) {
                    score -= 150;
                    System.out.println(hangManTwo(hangmanTries, false));
                    break;
                }
                if (hangmanWord.equalsIgnoreCase(guessedLetter) && hangmanTries == 13) {
                    score += 750;
                    System.out.println("LAST CHANCE ACHIEVEMENT!");
                    break;
                }
                if (hangmanWord.equalsIgnoreCase(guessedLetter) && hangmanTries == 0) {
                    score += 1000;
                    System.out.println(" Did you cheat?");
                    break;
                }
                if (hangmanWord.equalsIgnoreCase(guessedLetter)) {
                    System.out.println(hangManTwo(hangmanTries, true));
                    score += 500;
                    break;
                }
                alphabet = Beta(alphabet, guessedLetter);
                System.out.println(" ");
                for (String letter : alphabet) {
                    System.out.print(letter);
                }
                System.out.println(" ");
            }


            while (playAgain) {
                System.out.println("Do you want to play again?");
                userResponse = user.nextLine().toLowerCase();
                if (userResponse.equals("no")) {
                    playAgain = false;
                    wholeGame = false;
                    yes = false;
                }
                if (userResponse.equals("yes")) {
                    playAgain = false;
                    wholeGame = true;
                    yes = true;
                }
                while (yes) {
                    System.out.println("Would you like to choose a new difficulty level? Enter \"yes\" or \"no\".");
                    userResponse = user.nextLine().toLowerCase();
                    if (userResponse.equals("yes")) {
                        difficulty = true;
                        yes = false;
                    }

                    if (userResponse.equals("no")) {
                        difficulty = false;
                        yes = false;
                    }
                    System.out.print("Would you like to choose a new stick man? Enter \"yes\" or \"no\".\n");
                    userResponse = user.nextLine().toLowerCase();
                    if (userResponse.equals("yes")) {
                        man = true;
                        yes = false;
                    }
                    if (userResponse.equals("no")) {
                        man = false;
                        yes = false;
                    }
                }
                System.out.println("      ___           ___           ___           ___                    ___           ___           ___           ___              \n" +
                        "     /\\  \\         /\\  \\         /\\__\\         /\\  \\                  /\\  \\         /\\__\\         /\\  \\         /\\  \\             \n" +
                        "    /::\\  \\       /::\\  \\       /::|  |       /::\\  \\                /::\\  \\       /:/  /        /::\\  \\       /::\\  \\            \n" +
                        "   /:/\\:\\  \\     /:/\\:\\  \\     /:|:|  |      /:/\\:\\  \\              /:/\\:\\  \\     /:/  /        /:/\\:\\  \\     /:/\\:\\  \\           \n" +
                        "  /:/  \\:\\  \\   /::\\~\\:\\  \\   /:/|:|__|__   /::\\~\\:\\  \\            /:/  \\:\\  \\   /:/__/  ___   /::\\~\\:\\  \\   /::\\~\\:\\  \\          \n" +
                        " /:/__/_\\:\\__\\ /:/\\:\\ \\:\\__\\ /:/ |::::\\__\\ /:/\\:\\ \\:\\__\\          /:/__/ \\:\\__\\  |:|  | /\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\         \n" +
                        " \\:\\  /\\ \\/__/ \\/__\\:\\/:/  / \\/__/~~/:/  / \\:\\~\\:\\ \\/__/          \\:\\  \\ /:/  /  |:|  |/:/  / \\:\\~\\:\\ \\/__/ \\/_|::\\/:/  /         \n" +
                        "  \\:\\ \\:\\__\\        \\::/  /        /:/  /   \\:\\ \\:\\__\\             \\:\\  /:/  /   |:|__/:/  /   \\:\\ \\:\\__\\      |:|::/  /          \n" +
                        "   \\:\\/:/  /        /:/  /        /:/  /     \\:\\ \\/__/              \\:\\/:/  /     \\::::/__/     \\:\\ \\/__/      |:|\\/__/           \n" +
                        "    \\::/  /        /:/  /        /:/  /       \\:\\__\\                 \\::/  /       ~~~~          \\:\\__\\        |:|  |             \n" +
                        "     \\/__/         \\/__/         \\/__/         \\/__/                  \\/__/                       \\/__/         \\|__|           ");
            }


        }
    }
        public static String difficulty( int levels){
            String easyMediumHard = "";
            switch (levels) {
                default:
                case 0:
                    String[] easyWords = {"favorite", "vacation", "quarter", "discover", "laughter", "inventor",};
                    int generatedNumber = (int) (Math.random() * easyWords.length);
                    easyMediumHard = easyWords[generatedNumber];
                    break;
                case 1:
                    String[] mediumWords = {"outrageous", "religious", "permeate", "lucrative", "procrastinate", "serviceable"};
                    generatedNumber = (int) (Math.random() * mediumWords.length);
                    easyMediumHard = mediumWords[generatedNumber];
                    break;
                case 2:
                    String[] hardWords = {"propagandize", "massachusetts", "enzyme", "fuchsia", "lamborghini", "fettuccine"};
                    generatedNumber = (int) (Math.random() * hardWords.length);
                    easyMediumHard = hardWords[generatedNumber];
                    break;
            }
            return easyMediumHard;


        }

        public static String hangMan ( int tries, boolean win){
            String mistake;
            String feedback;
            String triesFeed = "\nTries Left: ";
            int triesFeedback = 12;
            if (win) {
                feedback = "Wow. You won.";
            } else {
                feedback = "\nNope you wrong.";
            }
            switch (tries) {

                default:
                case 0:
                    mistake = "    \\\n" +
                            feedback + " Guess again." + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 1:
                    mistake = "    \\\n" +
                            "   o/\\_\n" +
                            feedback + "Guess again." + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 2:
                    mistake = "    \\\n" +
                            "   o/\\_\n" +
                            "  <\\__,\\\n" +
                            feedback + " Guess again." + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 3:
                    mistake = "    \\\n" +
                            "   o/\\_\n" +
                            "  <\\__,\\\n" +
                            "   \">   |\n" +
                            feedback + " Guess again." + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 4:
                    mistake = "    \\\n" +
                            "   o/\\_\n" +
                            "  <\\__,\\\n" +
                            "   \">   |\n" +
                            "    `   |\n" +
                            feedback + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 5:
                    mistake = "    \\\n" +
                            "   o/\\_\n" +
                            "  <\\__,\\\n" +
                            "   \">   |\n" +
                            "    `   |\n" +
                            "         \\\n" +
                            feedback + " Guess again." + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 6:
                    mistake = "    \\\n" +
                            "   o/\\_\n" +
                            "  <\\__,\\\n" +
                            "   \">   |\n" +
                            "    `   |\n" +
                            "         \\\n" +
                            "          \\\n" +
                            feedback + " Guess again." + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 7:
                    mistake = "    \\\n" +
                            "   o/\\_\n" +
                            "  <\\__,\\\n" +
                            "   \">   |\n" +
                            "    `   |\n" +
                            "         \\\n" +
                            "          \\\n" +
                            " ~~~~~~~~~~/|~~~\n" +
                            feedback + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 8:
                    mistake = "    \\\n" +
                            "   o/\\_\n" +
                            "  <\\__,\\\n" +
                            "   \">   |\n" +
                            "    `   |\n" +
                            "         \\\n" +
                            "          \\\n" +
                            " ~~~~~~~~~~/|~~~\n" +
                            "         c'__,={" +
                            feedback + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 9:
                    mistake = "         \\\n" +
                            "          \\_\n" +
                            "            \\\n" +
                            "   o/       |\n" +
                            "  <\\__,     |\n" +
                            "    \">       \\\n" +
                            "     `        \\\n" +
                            " ~~~~~~~~~~/|~~~\n" +
                            "         c'__,={" +
                            feedback + " Guess again" + triesFeed + triesFeedback;
                    break;
                case 10:
                    mistake = "         \\\n" +
                            "          \\_\n" +
                            "            \\\n" +
                            "            |\n" +
                            "            |\n" +
                            "             \\\n" +
                            "              \\\n" +
                            " ~~~\\o/~~~~/|~~~\n" +
                            "         c'__,={" +
                            feedback + " Guess again" + "\n  \\\\ WARNING \\\\  \n You have one try left.";
                    break;
                case 11:
                    mistake = "         .-.\n" +
                            "        (0.0)\n" +
                            "      '=.|m|.='\n" +
                            "      .='`\"``=." +
                            feedback + "\nYOU LOSE";
            }
            return mistake;
        }

        public static String hangManTwo ( int triesTwo, boolean winTwo){
            String mistakeTwo;
            String feedbackTwo;
            String triesFeed = "Tries Left: ";
            int triesFeedback = 15;
            if (winTwo) {
                feedbackTwo = "Wow. You won.";
            } else {
                feedbackTwo = "\nNope you wrong.\n Try again";
            }
            switch (triesTwo) {
                default:
                case 0:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 1:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            feedbackTwo + " Guess again " + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 2:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 3:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 4:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 5:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 6:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            "         \\\\\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 7:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            "         \\\\\n" +
                            "          \\\n" +
                            "            \n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 8:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            "         \\\\\n" +
                            "          \\\n" +
                            "            \n" +
                            "           _\\|/^\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 9:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            "         \\\\\n" +
                            "          \\\n" +
                            "            \n" +
                            "           _\\|/^\n" +
                            "           (_oo\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 10:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            "         \\\\\n" +
                            "          \\\n" +
                            "            \n" +
                            "           _\\|/^\n" +
                            "           (_oo\n" +
                            "            |  \n  " +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 11:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            "         \\\\\n" +
                            "          \\\n" +
                            "            \n" +
                            "           _\\|/^\n" +
                            "           (_oo\n" +
                            "            |  \n  " +
                            "         /|\\\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 12:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            "         \\\\\n" +
                            "          \\\n" +
                            "            \n" +
                            "           _\\|/^\n" +
                            "           (_oo\n" +
                            "            |  \n  " +
                            "         /|\\\n" +
                            "            |\n" +
                            feedbackTwo + " Guess again" + triesFeed + triesFeedback;
                    triesFeedback --;
                    break;
                case 13:
                    mistakeTwo = "/   (  .' .   \\\n" +
                            "\\ ( ' ,_) ) \\_/\n" +
                            " (_ , /\\  ,_/\n" +
                            "   '--\\ `\\--`\n" +
                            "       \\ _\\\n" +
                            "      `\\ \\\n" +
                            "       _\\_\\\n" +
                            "       `\\\\\n" +
                            "         \\\\\n" +
                            "          \\\n" +
                            "            \n" +
                            "           _\\|/^\n" +
                            "           (_oo\n" +
                            "            |  \n  " +
                            "         /|\\\n" +
                            "            |\n" +
                            "            LL\n" +
                            feedbackTwo + " Guess again" + "\n  \\\\ WARNING \\\\  \n You have one try left.";
                    break;
                case 14:
                    mistakeTwo =  "     .-.\n" +
                            "        (0.0)\n" +
                            "      '=.|m|.='\n" +
                            "      .='`\"``=." +
                            feedbackTwo + "\nYOU LOSE";
            }
            return mistakeTwo;
        }

        public static boolean guessedLetterRight (String secretWord, String guessedLetter){
            //System.out.println("The "+secretWord + " contains " + guessedLetter + ": "+ secretWord.contains(guessedLetter));
            return secretWord.contains(guessedLetter);
        }

        public static String[] Beta (String[]args, String currentGuess){
            for (int i = 0; i < args.length; i++) {
                if (args[i].contains(currentGuess)) {
                    args[i] = "_ ";
                    return args;
                }

            }
            return args;
        }

        public static String letterReplacementDashes(String word, String guess, String guessPhrase){
        for (int position = 0; position < word.length(); position ++){
            if(guess.charAt(0) == word.charAt(position)){
                guessPhrase = guessPhrase.substring(0,position) + guess + guessPhrase.substring(position+1);
            }

        }
        return guessPhrase;
        }


        public static String wordDashes (String word) {
            String dashes= "";
            for (int i = 0; i < word.length(); i++) {
                dashes += "-";
            }
            return dashes;
        }
}


