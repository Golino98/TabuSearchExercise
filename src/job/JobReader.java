package job;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobReader {

    private static final String SEPARATOR = "\\s+";
    private static String path;

    public JobReader(String path) {
        this.path = path;
    }

    public List<Job> read() throws IOException {
        var br = Files.newBufferedReader(Path.of(path));
        var lines = br.lines().toList();
        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            var splitLine = lines.get(i).split(SEPARATOR);
            var job_number = Integer.parseInt(splitLine[0]);                        //job
            var penality_tardness = Integer.parseInt(splitLine[1]);                 //w_j
            var processing_time = Integer.parseInt(splitLine[2]);                   //p_j
            var due_date = Integer.parseInt(splitLine[3]);                          //d_j
            Job j = new Job(job_number, penality_tardness, processing_time, due_date);
            jobs.add(j);
        }
        Collections.shuffle(jobs);
        return jobs;
    }
}
