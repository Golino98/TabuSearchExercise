package exercise.neighborhood;

import exercise.Solution;
import exercise.job.Job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static exercise.constant.Constant.*;

public class Neighborhood {
    public void createNeiborhood(List<Job> jobs) {
        List<Solution> neighborhood = new ArrayList<>();

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
                Collections.swap(jobs, var_to_flip, i);
            }
        }
    }
}
