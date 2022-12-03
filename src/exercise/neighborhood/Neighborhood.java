package exercise.neighborhood;

import exercise.Solution;
import exercise.job.Job;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static exercise.constant.Constant.*;

public class Neighborhood {
    private Solution solution, best_solution;

    public Neighborhood(List<Job> jobs) {
        best_solution = solution = new Solution(jobs);
    }

    public void createNeighborhood() {
        // Take randomly a number between 0 and the number of jobs in the list
        Random rn = new Random();

        //var var_to_flip = rn.nextInt(solution.getJobList().size());
        var var_to_flip = 3;
        var jobs = solution.getJobList();

        System.out.format(FLIP_VAR, (var_to_flip + 1));
        System.out.format(FIRST_SOL, jobs.toString(), solution.getObj_fun());

        for (int i = 0; i < jobs.size(); i++) {
            if (i != var_to_flip) {
                //Make to swap in order to go back to initial situation. So I can define 1 flip neighborhood
                Collections.swap(jobs, var_to_flip, i);
                solution = new Solution(jobs);
                System.out.format(FLIP_JOB, (var_to_flip + 1), (i + 1), jobs.toString(), solution.getObj_fun());

                if (solution.getObj_fun() < best_solution.getObj_fun()) {
                    best_solution = solution;
                }

                Collections.swap(jobs, var_to_flip, i);
                solution = new Solution(jobs);
            }
        }
    }

    public void getBest_solution() {
        System.out.format(BEST_SOL, best_solution, best_solution.getObj_fun());
    }
}