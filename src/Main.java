import exercise.job.JobReader;
import exercise.neighborhood.Neighborhood;
import exercise.utilities.UserInput;

import java.io.IOException;
import java.util.Collections;

import static exercise.constant.Constant.*;
import static exercise.utilities.ConstantInput.ITERATIONS;

public class Main {

    public static void main(String[] args) throws IOException {
        // Read the instance containing the values of jobs and create a List of them
        var iterations = UserInput.readIntegerLowerBound(ITERATIONS, 1);
        var jobs = new JobReader(INSTANCE).read();

        // Create an initial feasible solution sorting randomly the variable of the list jobs
        if (UserInput.yesOrNo()) {
            Collections.shuffle(jobs);
        }

        System.out.println(ORDER);
        Neighborhood neighborhood = new Neighborhood(jobs);


        for (int i = 0; i < iterations; i++) {
            System.out.format(ITERATION, (i + 1));
            neighborhood.createNeighborhood();
            neighborhood.printBestSolution();
            neighborhood = new Neighborhood(neighborhood.getBest_solution().getJobList());
        }

        neighborhood.printTabuList();
        System.out.println();

    }
}

