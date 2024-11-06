import java.util.Scanner;

class LexicalAnalyzer {


    public static boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }


    public static boolean isDigit(char ch) {
        return (ch >= '0' && ch <= '9');
    }


    public static boolean isWhitespace(char ch) {
        return (ch == ' ' || ch == '\t' || ch == '\n');
    }


    public static boolean isKeyword(String lexeme) {
        return lexeme.equals("if") ||
                lexeme.equals("else") ||
                lexeme.equals("do") ||
                lexeme.equals("while") ||
                lexeme.equals("for") ||
                lexeme.equals("class") ||
                lexeme.equals("int") ||
                lexeme.equals("float");
    }


    public static boolean isIdentifier(String lexeme) {
        // First character must be a letter
        if (lexeme.length() == 0 || !isLetter(lexeme.charAt(0))) {
            return false;
        }

        for (int i = 1; i < lexeme.length(); i++) {
            char c = lexeme.charAt(i);
            if (!isLetter(c) && !isDigit(c)) {
                return false;
            }
        }
        return true;
    }


    public static void analyze(String input) {
        int length = input.length();
        String lexeme = "";

        for (int i = 0; i < length; i++) {
            char currentChar = input.charAt(i);


            if (isWhitespace(currentChar)) {
                continue;
            }


            lexeme = "";
            while (i < length && !isWhitespace(input.charAt(i))) {
                lexeme += input.charAt(i);
                i++;
            }


            if (isKeyword(lexeme)) {
                System.out.println(lexeme + " -> Keyword");
            }

            else if (isIdentifier(lexeme)) {
                System.out.println(lexeme + " -> Identifier");
            }

            else {
                System.out.println(lexeme + " -> Unrecognized lexeme error");
            }
        }
    }


}


public class Main
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String input = scanner.nextLine();


        LexicalAnalyzer.analyze(input);
    }
}
