package exercise;

import exercise.job.Job;

import java.util.List;

public class Solution {

    private List<Job> s_l;
    private int obj_fun = 0;

    public Solution(List<Job> shuffle_list) {
        this.s_l = shuffle_list;
    }

    public List<Job> getS_l() {
        return s_l;
    }

    public int calculateSolution() {
        int C_j;
        for (int i = 0; i < s_l.size(); i++) {
            C_j = 0;
            for (int j = 0; j <= i; j++) {
                C_j = C_j + s_l.get(j).getProcessing_time();
            }
            C_j = C_j - s_l.get(i).getDue_date();
            obj_fun = obj_fun + Integer.max(C_j, 0);
        }
        return obj_fun;
    }

    public int getObj_fun() {
        if (obj_fun == 0) {
            return calculateSolution();
        }
        return obj_fun;
    }

    @Override
    public String toString() {
        String res = "[ ";
        for (var v : s_l) {
            res = res.concat(v.getJobNumber() + " - ");
        }

        res = res.substring(0, res.length()-3);
        res = res.concat(" ]");

        return res;
    }
}
