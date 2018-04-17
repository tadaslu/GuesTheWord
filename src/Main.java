import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Guess the word");
        File file = new File("Zodziai.txt");
        Scanner scanner = new Scanner(file);
        int count = 0;
        List<String> listOfArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int wordsInLine = line.split(" ").length;
            count += wordsInLine;
            String[] words = line.split(" ");
            for (int i = 0; i < wordsInLine; i++)
                listOfArray.add(words[i]);
        }

        int randomNumber = (int) (Math.random() * count);
        String seacretWord = listOfArray.get(randomNumber);
        String[] seacretWordToString;
        seacretWordToString = new String[seacretWord.length()];
        for (int i = 0; i < seacretWord.length(); i++) {
            seacretWordToString[i] = String.valueOf('_');
        }
        int goodGues = seacretWord.length();
        int badGues = 5;


        boolean stop = true;
        while (stop) {
            for (int a = 0; a < seacretWordToString.length; a++) {
                System.out.print(seacretWordToString[a] + " ");
            }
            Scanner scannerChar = new Scanner(System.in);
            String guesChar = scannerChar.next();

            if (seacretWord.contains(guesChar)) {
                for (int i = 0; i < seacretWord.length(); i++) {
                    String a = String.valueOf(seacretWord.charAt(i));
                    String b = String.valueOf(guesChar.charAt(0));
                    if (a.equals(b)) {
                        seacretWordToString[i] = a;
                        goodGues--;
                    }

                }
                for (int a = 0; a < seacretWordToString.length; a++) {
                    System.out.print(seacretWordToString[a] + " ");
                }
                System.out.println();
                System.out.println("good gues");
            } else {
                System.out.println("bad gues");
                badGues--;
            }
            if (goodGues == 0) {
                System.out.println("You won");
                stop = false;
            }
            if (badGues == 0) {
                System.out.println("You lose");
                stop = false;
            }
        }
    }
}

