import gurobi.*;

import java.io.Console;
import java.io.IOException;
import java.util.List;

public class Main {
    private final static String CONFIG = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\config.txt";
    private final static String INSTANCE = "C:\\Users\\giaco\\IdeaProjects\\tabuSearchExercise\\instance.txt";

    public static void main(String[] args) throws IOException, GRBException {

        JobReader jobReader = new JobReader(INSTANCE);
        var jobs = jobReader.read();

        Configuration config = new ConfigurationReader(CONFIG).read();
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

    }
}

