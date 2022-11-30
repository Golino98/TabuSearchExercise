import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;

import java.io.Console;
import java.io.IOException;
import java.util.List;

public class Main {
    private final static String CONFIG = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\config.txt";
    private final static String INSTANCE = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\instance.txt";
    private List<Job> jobs;

    public static void main(String[] args) throws IOException, GRBException {

        JobReader jobReader = new JobReader(INSTANCE);
        var jobs = jobReader.read();
        /*
        Configuration config = new ConfigurationReader(CONFIG).read();
        GRBEnv env = new GRBEnv();

        env.set(GRB.IntParam.OutputFlag, 0);
        env.set(GRB.IntParam.Presolve, config.getPresolve());
        env.set(GRB.IntParam.Threads, config.getNumThreads());
        env.set(GRB.DoubleParam.MIPGap, config.getMipGap());
        env.set(GRB.DoubleParam.TimeLimit, config.getTimeLimit());
        */

        for (var j : jobs) {
            System.out.println(j.toString());
        }


    }
}
