package exercise.constant;

public class Constant {

    public final static String INSTANCE = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\instance.txt";
    public static String ORDER = "\nGeneration of an initial feasible solution." +
            "\nThis solution is obtained by taking the jobs in a random order and trying to improve that later.\n";
    public static String FLIP_VAR = "\nVar to flip: %d\n";
    public static String FLIP_JOB = "\nFlip between job(%d) and job(%d) -> %s - o.f. = %d";
    public static String FIRST_SOL = "\nInitial solution: %s - o.f. = %d\n";

    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";

    public static String RED = "\u001B[31m";
    public static String RESET = "\u001B[0m";
    public static String BEST_SOL = GREEN.concat("\n\nBest solution found -> %s - o.f. = %d\n\n").concat(RESET);

    public static String ITERATION = YELLOW.concat("--------- Iteration %d ---------\n").concat(RESET);

    public static String TABU_LIST = RED.concat("--------- List of tabu moves ---------\n");
    public static String TABU_EMPTY = RED.concat("\nNo moves were found.\n").concat(GREEN).concat("Initial solution %s was a good starting solution.\n").concat(RESET);

    public static String TABU_MOVE = RED.concat(" - (%d) -> (%d).\n").concat(RESET);
}
