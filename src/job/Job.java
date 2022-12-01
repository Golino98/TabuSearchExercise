package job;

import java.util.ArrayList;
import java.util.List;

public class Job {
    private int jobNumber;
    private int penality_tardness;
    private int processing_time;
    private int due_date;
    List<Job> jobs = new ArrayList<>();

    public Job(int job_number, int penality_tardness, int processing_time, int due_date) {
        this.jobNumber = job_number;
        this.penality_tardness = penality_tardness;
        this.processing_time = processing_time;
        this.due_date = due_date;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public int getPenality_tardness() {
        return penality_tardness;
    }

    public int getProcessing_time() {
        return processing_time;
    }

    public int getDue_date() {
        return due_date;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public String toString() {
        return this.jobNumber + " " + this.penality_tardness + " " + this.processing_time + " " + this.due_date;
    }
}

