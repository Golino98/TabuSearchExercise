package exercise.constant;

public class Constant {

    public final static String INSTANCE = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\instance.txt";
    public static String ORDER = "\nGeneration of an initial feasible solution." +
            "\nThis solution is obteined by taking the jobs in a random order and trying to improve that later.";
    public static String FLIP_VAR = "\nVar to flip: %d\n";
    public static String FLIP_JOB = "\nFlip between job(%d) and job(%d) -> %s - o.f. = %d";
    public static String FIRST_SOL = "\nInitial solution: %s - o.f. = %d\n";

    public static String GREEN = "\u001B[32m";
    public static String RESET = "\u001B[0m";
    public static String BEST_SOL = GREEN.concat("\n\nBest solution found -> %s - o.f. = %d\n\n").concat(RESET);

}
