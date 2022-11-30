public class Job {
    private int jobNumber;
    private int processingTime;
    private int dueDate;
    private int penality;

    private int value;

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
}
