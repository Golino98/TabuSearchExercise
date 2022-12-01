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
            var j_n = Integer.parseInt(splitLine[0]);
            var pr_t = Integer.parseInt(splitLine[1]);
            var d_d = Integer.parseInt(splitLine[2]);
            var pe = Integer.parseInt(splitLine[3]);
            Job j = new Job(j_n, pr_t, d_d, pe);
            jobs.add(j);
        }
        Collections.shuffle(jobs);
        return jobs;
    }
}
