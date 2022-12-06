package exercise.constant;

public class Constant {

    public final static String INSTANCE = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\instance.txt";
    public static String ORDER = """

            Generation of an initial feasible solution.
            This solution is obtained by taking the jobs in a random order and trying to improve that later.
            """;
    public static String FLIP_VAR = "\nVar to flip: %d\n";
    public static String FLIP_JOB = "\nFlip between job(%d) and job(%d) -> %s - o.f. = %d";
    public static String FIRST_SOL = "\nInitial solution: %s - o.f. = %d\n";

    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";
    public static String RED = "\u001B[31m";
    public static String BLACK = "\u001B[30m";
    public static String RESET = "\u001B[0m";

    public static String GREEN_B = "\u001B[042m";

    public static String GOOD_SOLUTION = GREEN.concat("\n\nBest solution found -> %s - o.f. = %d\n\n").concat(RESET);
    public static String BEST_SOLUTION = GREEN_B.concat(BLACK.concat("With the configuration provided the best solution found is -> %s - o.f. = %d")).concat(RESET);

    public static String ITERATION = YELLOW.concat("--------- Iteration %d ---------\n").concat(RESET);

    public static String TABU_LIST = RED.concat("--------- List of tabu moves ---------\n");
    public static String TABU_EMPTY = RED.concat("\nNo moves were found.\n").concat(GREEN).concat("Initial solution %s was a good starting solution.\n").concat(RESET);

    public static String TABU_MOVE = RED.concat(" - (%d) -> (%d).\n").concat(RESET);
}
