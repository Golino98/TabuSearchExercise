package exercise.utilities;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

import static exercise.utilities.ConstantInput.*;

public class UserInput {

    private static final Scanner sc = createScanner();

    private static Scanner createScanner() {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        sc.useDelimiter("\\n");
        return sc;
    }

    public static boolean yesOrNo() {
        String message = SHUFFLE + YELLOW + '(' + YES + " \\ " + NO + ") : " + RESET;
        char response = readUpperChar(message, YES + String.valueOf(NO));
        return response == YES;
    }

    public static char readUpperChar(String messageToPrint, String possibleResponse) {
        boolean exit = false;
        char charRead;
        do {
            charRead = readChar(messageToPrint);
            charRead = Character.toUpperCase(charRead);
            if (possibleResponse.indexOf(charRead) != -1) {
                exit = true;
            } else {
                System.out.println(ERROR_INPUT + possibleResponse);
            }
        } while (!exit);
        return charRead;
    }

    public static char readChar(String message) {
        boolean exit = false;
        char readValue = '\0';
        do {
            System.out.print(message);
            String lettura = sc.next();
            if (!lettura.isEmpty()) {
                readValue = lettura.charAt(0);
                exit = true;
            } else {
                System.out.println(ERROR_EMPTY_STRING);
            }
        } while (!exit);
        return readValue;
    }

    public static int inputInteger(String message) {
        boolean exit = false;
        int readValue = 0;
        do {
            System.out.print(message);
            try {
                readValue = sc.nextInt();
                exit = true;
            } catch (InputMismatchException e) {
                System.out.println(ERROR_FORMAT);
                sc.next();
            }
        } while (!exit);
        return readValue;
    }

    public static int readIntegerLowerBound(String message, int lowerBound) {
        boolean exit = false;
        int readValue;
        do {
            readValue = inputInteger(message);
            if (readValue >= lowerBound) {
                exit = true;
            } else {
                System.out.println(ERROR_MINIMUM + lowerBound);
            }
        } while (!exit);

        return readValue;
    }

}
