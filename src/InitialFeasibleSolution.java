import job.Job;

import java.util.ArrayList;
import java.util.List;

public class InitialFeasibleSolution {
    private List<Job> shuffle_list = new ArrayList<>();
    private int objective_function = 0;

    public InitialFeasibleSolution(List<Job> shuffle_list) {
        this.shuffle_list = shuffle_list;
        this.objective_function = CalculateInitialFeasibleSolution();
    }

    public int getObjective_function() {
        return objective_function;
    }

    private int CalculateInitialFeasibleSolution() {
        for (int i = 0; i < shuffle_list.size(); i++) {
            int C = 0;
            for (int j = 0; j == i; j++) {
                C += shuffle_list.get(j).getProcessingTime();
            }
            C -= shuffle_list.get(i).getDueDate();
            //C = Integer.max(0, C);
            objective_function += C;
        }
        return objective_function;
    }

}
