package exercise.utilities;

public class ConstantInput {
    static final char YES = 'Y';
    static final char NO = 'N';


    static final String RED = "\u001B[31m";
    public static String YELLOW = "\u001B[33m";
    public static String RESET = "\u001B[0m";

    static final String SHUFFLE = YELLOW.concat("\nDo you want to shuffle the order od the initial solution provided by the file .txt in input? -> ").concat(RESET);
    public static final String ITERATIONS = YELLOW.concat("\nInsert the number of iterations of Tabu Search to compute: ").concat(RESET);

    static final String ERROR_FORMAT = RED.concat("Attention! You provided a data with a wrong format.").concat(RESET);
    static final String ERROR_MINIMUM = RED.concat("Attention! You have to insert a value greater or equal to: ").concat(RESET);
    static final String ERROR_INPUT = "Attention! You can only insert the response: ";
    static final String ERROR_EMPTY_STRING = "Attention! You tried to insert an empty response.";
}
