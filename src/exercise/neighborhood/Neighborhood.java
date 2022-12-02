package exercise.neighborhood;

import exercise.Solution;
import exercise.job.Job;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static exercise.constant.Constant.*;

public class Neighborhood {

    private Solution best_solution;
    private Solution sol;

    public void createNeighborhood(List<Job> jobs) {
        sol = new Solution(jobs);
        best_solution = sol;

        boolean found = false;
        int n_found = -1;

        // Take randomly a number between 0 and the number of jobs in the list
        Random rn = new Random();

        var var_to_flip = rn.nextInt(jobs.size());

        System.out.format(FLIP_VAR, (var_to_flip + 1));
        System.out.format(FIRST_SOL, jobs.toString(), sol.getObj_fun());

        for (int i = 0; i < jobs.size(); i++) {
            //Make to swap in order to go back to initial situation. So I can define 1 flip neighborhood
            if (i != var_to_flip) {

                //sol = new Solution(jobs);
                Collections.swap(jobs, var_to_flip, i);
                System.out.format(FLIP_JOB, (var_to_flip + 1), (i + 1), jobs.toString(), new Solution(jobs).getObj_fun());

                //Make a swap between variable with index i and the one taked randomly

                if (sol.getObj_fun() < best_solution.getObj_fun()) {
                    if (found == false) {

                        Collections.swap(best_solution.getJobList(), i, var_to_flip);
                        n_found = i;
                        found = true;
                    } else {
                        Collections.swap(best_solution.getJobList(), n_found, var_to_flip);
                        n_found = i;
                        Collections.swap(best_solution.getJobList(), i, var_to_flip);
                    }
                    best_solution = sol;
                }
            }
            Collections.swap(jobs, var_to_flip, i);
        }
    }

    public void getBest_solution() {
        System.out.format(BEST_SOL, best_solution.toString(), best_solution.getObj_fun());
    }
}
