import job.JobReader;

import java.io.IOException;
import java.util.Collections;
import static constant.Constant.*;
public class Main {

    public static void main(String[] args) throws IOException {

        var jobs = new JobReader(INSTANCE).read();
        Collections.shuffle(jobs);

        for (var job : jobs) {
            ORDER = ORDER.concat(job.getJobNumber() + " - ");
        }

        System.out.println(ORDER);
        Solution ifs = new Solution(jobs);
        System.out.println(IFS + ifs.getObjective_function());
    }
}

