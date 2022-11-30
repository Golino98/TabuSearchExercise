import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;

import java.io.IOException;

public class Main {
    private final static String CONFIG = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\config.txt";

    public static void main(String[] args) throws IOException, GRBException {

        Configuration config = new ConfigurationReader(CONFIG).read();
        GRBEnv env = new GRBEnv();

        env.set(GRB.IntParam.OutputFlag, 0);
        env.set(GRB.IntParam.Presolve, config.getPresolve());
        env.set(GRB.IntParam.Threads, config.getNumThreads());
        env.set(GRB.DoubleParam.MIPGap, config.getMipGap());
        env.set(GRB.DoubleParam.TimeLimit, config.getTimeLimit());

    }
}
