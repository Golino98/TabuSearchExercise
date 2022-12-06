package exercise;

import exercise.job.Job;

import java.util.ArrayList;

public class Solution {

    private final ArrayList<Job> jobList;
    private int obj_fun;

    public Solution(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }

    public ArrayList<Job> getJobList() {
        return this.jobList;
    }

    public int calculateSolution() {
        int C_j;
        for (int i = 0; i < jobList.size(); i++) {
            C_j = 0;
            for (int j = 0; j <= i; j++) {
                C_j = C_j + jobList.get(j).getProcessing_time();
            }
            C_j = C_j - jobList.get(i).getDue_date();
            obj_fun = obj_fun + jobList.get(i).getPenality_tardness() * Integer.max(C_j, 0);
        }
        return obj_fun;
    }

    public int getObj_fun() {
        if (obj_fun == 0) {
            return calculateSolution();
        }
        return obj_fun;
    }


    public String toString() {
        return jobList.toString();
    }

}
