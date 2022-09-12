package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ASCIIMirror {

    private File file;
    List<String> text = new ArrayList<>();
    private int longestLength;


    public StringBuilder getFilePath() {
        Scanner fileScanner = new Scanner(System.in);
        String pathToFile = fileScanner.nextLine();
        file = new File(pathToFile);
        return tryCreatingFile();
    }

    private StringBuilder tryCreatingFile() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                text.add(line);
            }
            findLongestLine();
            return printFile();
        } catch (FileNotFoundException e) {
            return new StringBuilder("File not found!");
        }
    }

    private void findLongestLine() {
        String longest = text.get(0);
        for (String string : text) {
            if (string.length() > longest.length()) {
                longest = string;
            }
        }
        longestLength = longest.length();
    }

    private StringBuilder printFile() {
        StringBuilder file = new StringBuilder();
        for (String string : text) {
            String formattedString = String.format("%-" + longestLength + "s", string);
            file.append(formattedString).append(" | ").append(reverseText(formattedString)).append("\n");
        }
        return file;
    }

    private String reverseText(String formattedString) {
        StringBuilder reversed = new StringBuilder();
        reversed.append(formattedString).reverse();
        char[] reversedArray = reversed.toString().toCharArray();
        for (int i = 0; i < reversedArray.length; i++) {
            switch (reversedArray[i]) {
                case '<':
                    reversedArray[i] = '>';
                    break;
                case '>':
                    reversedArray[i] = '<';
                    break;
                case '[':
                    reversedArray[i] = ']';
                    break;
                case ']':
                    reversedArray[i] = '[';
                    break;
                case '{':
                    reversedArray[i] = '}';
                    break;
                case '}':
                    reversedArray[i] = '{';
                    break;
                case '(':
                    reversedArray[i] = ')';
                    break;
                case ')':
                    reversedArray[i] = '(';
                    break;
                case '/':
                    reversedArray[i] = '\\';
                    break;
                case '\\':
                    reversedArray[i] = '/';
                    break;
                default:
                    break;
            }
        }
        return String.valueOf(reversedArray);
    }


}
