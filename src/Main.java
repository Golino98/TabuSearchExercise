import gurobi.GRBException;
import job.JobReader;

import java.io.IOException;
import java.util.Collections;

public class Main {
    private final static String CONFIG = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\config.txt";
    private final static String INSTANCE = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\instance.txt";

    private static String ORDER = "\"Generation of an initial feasible solution.\n" +
            "This solution is obteined by taking the jobs in a random order and trying to improve that later.\n\n"
            + "The order of the jobs is: ";

    public static void main(String[] args) throws IOException, GRBException {

        var jobs = new JobReader(INSTANCE).read();
        Collections.shuffle(jobs);
        //configuration.Configuration config = new configuration.ConfigurationReader(CONFIG).read();
        /*
        GRBEnv env = new GRBEnv("C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\logFile.log");

        env.set(GRB.IntParam.OutputFlag, 0);
        env.set(GRB.IntParam.Presolve, config.getPresolve());
        env.set(GRB.IntParam.Threads, config.getNumThreads());
        env.set(GRB.DoubleParam.MIPGap, config.getMipGap());
        env.set(GRB.DoubleParam.TimeLimit, config.getTimeLimit());

        GRBModel model = new GRBModel(env);
        var dimension = jobs.size();

        GRBVar[][] x = new GRBVar[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                x[i][j] = model.addVar(0, 1, 0, GRB.BINARY, "x_" + (i + 1) + "_" + (j + 1));
            }
        }

        //c_1_5 mi indica se il job 1 viene fatto prima del 5. Posso andare a calcolare il C semplicemente con una semplice somma
        // sul lavoro 5

        var linExpr = new GRBLinExpr();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                {
                    linExpr.addTerm(jobs.get(i).calculateValue(jobs, j), x[i][j]);
                }
            }
        }

        model.setObjective(linExpr, GRB.MINIMIZE);

        linExpr = new GRBLinExpr();
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                linExpr.addTerm(1, x[i][j]);
            }
            model.addConstr(linExpr, GRB.EQUAL, dimension, "VINCOLO_SELEZIONE_ZAINO");
        }

        model.optimize();
        System.out.println("Valore funzione obiettivo: " + model.get(GRB.DoubleAttr.ObjVal));

        for (GRBVar var : model.getVars())
        {
            System.out.println(var.get(GRB.StringAttr.VarName) + " - " + var.get(GRB.DoubleAttr.X));
        }

         */
        for (var job : jobs) {
            ORDER = ORDER.concat(job.getJobNumber() + " - ");
        }

        System.out.println(ORDER);
        InitialFeasibleSolution ifs = new InitialFeasibleSolution(jobs);
        System.out.println("Initial feasible solution " + ifs.getObjective_function());
    }
}

