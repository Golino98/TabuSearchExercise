package exercise.job;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class JobReader {

    private static final String SEPARATOR = "\\s+";
    private static String path;

    public JobReader(String path) {
        JobReader.path = path;
    }

    public ArrayList<Job> read() throws IOException {
        var br = Files.newBufferedReader(Path.of(path));
        var lines = br.lines().toList();
        ArrayList<Job> jobs = new ArrayList<>();

        for (String line : lines) {
            var splitLine = line.split(SEPARATOR);
            var job_number = Integer.parseInt(splitLine[0]);                        //exercise.job
            var penality_tardness = Integer.parseInt(splitLine[1]);                 //w_j
            var processing_time = Integer.parseInt(splitLine[2]);                   //p_j
            var due_date = Integer.parseInt(splitLine[3]);                          //d_j
            Job j = new Job(job_number, penality_tardness, processing_time, due_date);
            jobs.add(j);
        }
        return jobs;
    }
}
