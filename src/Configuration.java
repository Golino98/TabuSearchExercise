/**
 * Contenitore per le informazione di configurazione del progetto, come lette da file.
 */
public class Configuration {
    private int numThreads;
    private int presolve;
    private double mipGap;
    private int timeLimit;

    private String instPath = "";
    private String runName = "";

    public double getMipGap() {
        return mipGap;
    }

    public void setMipGap(double mipGap) {
        this.mipGap = mipGap;
    }

    public void setNumThreads(int numThreads) {
        this.numThreads = numThreads;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public int getNumThreads() {
        return numThreads;
    }

    public void setPresolve(int presolve) {
        this.presolve = presolve;
    }

    public int getPresolve() {
        return presolve;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

}