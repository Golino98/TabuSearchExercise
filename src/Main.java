import exercise.job.JobReader;
import exercise.neighborhood.Neighborhood;

import java.io.IOException;
import java.util.Collections;

import static exercise.constant.Constant.*;

public class Main {

    public static void main(String[] args) throws IOException {

        var jobs = new JobReader(INSTANCE).read();
        Collections.shuffle(jobs);

        System.out.println(ORDER);

        Neighborhood neighborhood = new Neighborhood();
        neighborhood.createNeighborhood(jobs);
        neighborhood.getBest_solution();
    }
}

