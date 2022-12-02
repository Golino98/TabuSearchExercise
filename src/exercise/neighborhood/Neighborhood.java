package exercise.neighborhood;

import exercise.Solution;
import exercise.job.Job;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static exercise.constant.Constant.*;

public class Neighborhood {

    private Solution best_solution;

    public Neighborhood() {
    }

    public void createNeighborhood(List<Job> jobs) {
        best_solution = new Solution(jobs);
        // Take randomly a number between 0 and the number of jobs in the list
        Random rn = new Random();

        var var_to_flip = rn.nextInt(jobs.size());
        System.out.format(FLIP_VAR, (var_to_flip + 1));
        System.out.format(FIRST_SOL, jobs.toString(), new Solution(jobs).calculateSolution());

        for (int i = 0; i < jobs.size(); i++) {
            //Make to swap in order to go back to initial situation. So I can define 1 flip neighborhood
            if (i != var_to_flip)
            {
                Collections.swap(jobs, var_to_flip, i);
                var sol = new Solution(jobs);
                System.out.format(FLIP_JOB, (var_to_flip + 1), (i + 1), jobs.toString(), sol.getObj_fun());
                if ( sol.getObj_fun() < best_solution.getObj_fun()) {
                    best_solution = sol;
                }
                Collections.swap(jobs, var_to_flip, i);
            }
        }
    }

    public void getBest_solution() {
        System.out.format(BEST_SOL, best_solution, best_solution.getObj_fun());
    }
}
