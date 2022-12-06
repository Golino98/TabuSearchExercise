package exercise.neighborhood;

import exercise.Solution;
import exercise.job.Job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static exercise.constant.Constant.*;


public class Neighborhood {
    /**
     * solution -> initial solution passed by the user
     * best_solution -> it's an instance who contains the best solution of the neighborhood
     */
    private Solution solution, best_solution;
    private Tabu tabu;
    private static ArrayList<Tabu> tabuList = new ArrayList<>();

    public Solution getSolution() {
        return solution;
    }

    private ArrayList<Job> copy = new ArrayList<>();

    private boolean found = false;
    private int index_best_sol;


    /**
     * @param jobs -> is a list of jobs used to create the neighborhood of an initial feasible solution
     */
    public Neighborhood(ArrayList<Job> jobs) {
        solution = new Solution(jobs);
        best_solution = solution;
    }

    /**
     * method that create a neighborhood from an initial provided solution
     */
    public void createNeighborhood() {
        found = false;
        // Take randomly a number between 0 and the number of jobs in the list
        // This parameter will be used to choose randomly a variable will be used in order to make a move to create the
        // neighborhood
        Random rn = new Random();
        var var_to_flip = rn.nextInt(solution.getJobList().size());

        // Get the list of jobs, used to stamp the initial feasible solution
        var jobs = solution.getJobList();

        System.out.format(FLIP_VAR, (var_to_flip + 1));
        System.out.format(FIRST_SOL, jobs.toString(), solution.getObj_fun());

        for (int i = 0; i < jobs.size(); i++) {
            if (i != var_to_flip || !tabuList.contains(new Tabu(i, var_to_flip)) || !tabuList.contains(new Tabu(var_to_flip, i))) {

                // Swap the i-jobs with the one taken randomly
                Collections.swap(jobs, var_to_flip, i);

                // Create a new solution with the list of jobs flipped
                solution = new Solution(jobs);
                System.out.format(FLIP_JOB, (var_to_flip + 1), (i + 1), jobs.toString(), solution.getObj_fun());

                if (solution.getObj_fun() < best_solution.getObj_fun()) {
                    found = true;
                    index_best_sol = i;
                    // Delete all the elements in the arraylist copy
                    // It's used as support to create the best solution found.
                    copy.clear();
                    for (var v : solution.getJobList()) {
                        // Insert one by one all flipped in the arraylist copy
                        copy.add(v);
                    }
                    best_solution = new Solution(copy);
                }

                // Redo the flip in order to have the initial solution
                Collections.swap(jobs, var_to_flip, i);
                solution = new Solution(jobs);
            }
        }
        if (found) {
            tabu = new Tabu(index_best_sol, var_to_flip);
            tabuList.add(tabu);
        }
    }

    public Solution getBest_solution() {
        return best_solution;
    }

    /**
     * Method that print the best solution of N(x) and the value of the o.f.
     */
    public void printBestSolution() {
        System.out.format(BEST_SOL, best_solution, best_solution.getObj_fun());
    }

    public void printTabuList() {
        System.out.format(TABU_LIST);
        if (!tabuList.isEmpty()) {
            for (var t : tabuList) {
                System.out.format(TABU_MOVE, t.getTabu_var_one() + 1, t.getTabu_var_two() + 1);
            }
        } else {
            System.out.format(TABU_EMPTY, solution.getJobList());
        }
    }
}