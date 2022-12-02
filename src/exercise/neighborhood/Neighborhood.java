package exercise.neighborhood;

import exercise.Solution;
import exercise.job.Job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static exercise.constant.Constant.*;

public class Neighborhood {

    public Neighborhood() {
    }

    Solution best_solution;

    public void createNeighborhood(List<Job> jobs) {
        List<Solution> neighborhood = new ArrayList<>();
        best_solution = new Solution(jobs);

        // Take randomly a number between 0 and the number of jobs in the list
        Random rn = new Random();

        var var_to_flip = rn.nextInt(jobs.size());
        System.out.format(FLIP_VAR, (var_to_flip + 1));
        System.out.format(FIRST_SOL, jobs.toString(), new Solution(jobs).calculateSolution());

        for (int i = 0; i < jobs.size(); i++) {
            //Make to swap in order to go back to initial situation. So I can define 1 flip neighborhood
            if (i != var_to_flip) {
                Collections.swap(jobs, var_to_flip, i);
                System.out.format(FLIP_JOB, (var_to_flip + 1), (i + 1), jobs.toString(), new Solution(jobs).calculateSolution());
                if (best_solution.getObj_fun() > new Solution(jobs).calculateSolution()) {
                    best_solution = new Solution(jobs);
                }
                Collections.swap(jobs, var_to_flip, i);
            }
        }
    }

    public void getBest_solution()
    {
        System.out.format(BEST_SOL, best_solution.toString(), best_solution.getObj_fun());
    }
}
