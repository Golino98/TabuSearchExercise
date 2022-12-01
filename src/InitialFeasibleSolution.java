import job.Job;

import java.util.List;

public class InitialFeasibleSolution {
    private int objective_function = 0;

    public InitialFeasibleSolution(List<Job> shuffle_list) {
        CalculateInitialFeasibleSolution(shuffle_list);
    }

    public int getObjective_function() {
        return objective_function;
    }

    private void CalculateInitialFeasibleSolution(List<Job> shuffle_list) {
        for (int i = 0; i < shuffle_list.size(); i++) {
            int C = 0;
            for (int j = 0; j == i; j++) {
                C += shuffle_list.get(j).getProcessingTime();

            }
            C -= shuffle_list.get(i).getDueDate();
            C = Integer.max(0, C);
            objective_function += C;
        }
        // return objective_function;
    }

}
