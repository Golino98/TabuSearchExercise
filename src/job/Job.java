package job;

import java.util.ArrayList;
import java.util.List;

public class Job {
    private int jobNumber;
    private int penality_tardness;
    private int processing_time;
    private int due_date;

    public Job(int job_number, int penality_tardness, int processing_time, int due_date) {
        this.jobNumber = job_number;
        this.penality_tardness = penality_tardness;
        this.processing_time = processing_time;
        this.due_date = due_date;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public int getProcessing_time() {
        return processing_time;
    }

    public int getDue_date() {
        return due_date;
    }

    /**
     * Method used during the testing phase to see if the jobs were read correctly
     *
     * @return a string who provides the data read
     */
    public String toString() {
        return this.jobNumber + " " + this.penality_tardness + " " + this.processing_time + " " + this.due_date;
    }
}

