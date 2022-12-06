package exercise.utilities;

import java.nio.charset.StandardCharsets;
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
        String message = SHUFFLE + '(' + YES + '|' + NO + ')';
        char response = leggiUpperChar(message, YES + String.valueOf(NO));
        return response == YES;
    }

    public static char leggiUpperChar(String messageToPrint, String possibleResponse) {
        boolean exit = false;
        char charRead;
        do {
            charRead = leggiChar(messageToPrint);
            charRead = Character.toUpperCase(charRead);
            if (possibleResponse.indexOf(charRead) != -1) {
                exit = true;
            } else {
                System.out.println(ERROR_INPUT + possibleResponse);
            }
        } while (!exit);
        return charRead;
    }

    public static char leggiChar(String messaggio) {
        boolean exit = false;
        char readValue = '\0';
        do {
            System.out.print(messaggio);
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

}
