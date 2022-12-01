package job;

import java.util.ArrayList;
import java.util.List;

public class Job {
    private int jobNumber;
    private int processingTime;
    private int dueDate;
    private int penality;
    List<Job> jobs = new ArrayList<>();

    public Job(int jobNumber, int processingTime, int dueDate, int penality) {
        this.jobNumber = jobNumber;
        this.processingTime = processingTime;
        this.dueDate = dueDate;
        this.penality = penality;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public int getPenality() {
        return penality;
    }

    public void setPenality(int penality) {
        this.penality = penality;
    }

    public List<Job> createJobList(String instance) {
        return jobs;
    }

    public String toString() {
        return this.jobNumber + " " + this.processingTime + " " + this.dueDate + " " + this.penality;
    }

    public int calculateValue(List<Job> lista, int job2) {
        int res = lista.get(job2).calculateProcessingTime() - dueDate;
        return Integer.max(0, res);
    }

    private int calculateProcessingTime() {
        int sum = 0;
        for (int i = 0; i < this.getJobNumber(); i++) {
            sum += this.getProcessingTime();
        }
        return sum;
    }
}

