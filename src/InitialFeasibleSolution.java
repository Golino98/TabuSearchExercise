import job.Job;

import java.util.List;

public class InitialFeasibleSolution {

    private List<Job> s_l;

    public InitialFeasibleSolution(List<Job> shuffle_list) {
        this.s_l = shuffle_list;

    }

    public int getObjective_function() {
        return CalculateInitialFeasibleSolution();
    }

    private int CalculateInitialFeasibleSolution() {
        int obj_fun = 0;
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
}
