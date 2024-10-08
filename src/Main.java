import exercise.job.JobReader;
import exercise.neighborhood.Neighborhood;
import exercise.utilities.UserInput;

import java.io.IOException;
import java.util.Collections;

import static exercise.constant.Constant.*;
import static exercise.utilities.ConstantInput.ITERATIONS;
import static exercise.utilities.ConstantInput.TABU;

public class Main {

    public static void main(String[] args) throws IOException {

        // Read the instance containing the values of jobs and create a List of them
        var iterations = UserInput.readIntegerLowerBound(ITERATIONS, 1);
        var tabu = UserInput.readIntegerLowerBound(TABU, 1);
        var jobs = new JobReader(INSTANCE).read();

        // Create an initial feasible solution sorting randomly the variable of the list jobs
        if (UserInput.yesOrNo()) {
            Collections.shuffle(jobs);
        }

        System.out.println(ORDER);
        Neighborhood neighborhood = new Neighborhood(jobs, tabu);

        for (int i = 0; i < iterations; i++) {
            System.out.format(ITERATION, (i + 1));
            neighborhood.createNeighborhood();
            neighborhood.printGoodSolution();
            neighborhood = new Neighborhood(neighborhood.getBest_solution().getJobList(), tabu);
            neighborhood.printTabuList();
        }

        System.out.println();
        neighborhood.printBestSolution();
        System.out.println();

    }
}

