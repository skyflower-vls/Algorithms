import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {

    private double _mean;
    private double _stddev;
    private int _timesToRun = 0;
    
    
    /**
     * perform T independent experiments on an N-by-N grid
     * 
     * @param N
     * @param T
     */
    public PercolationStats(int N, int T) 
    { 
        if (N <= 0) 
        {
            throw new IllegalArgumentException("The grid size must be bigger 0");
        }
        
        if (T <= 0) 
        {
            throw new IllegalArgumentException("The number of experiments must be bigger 0");
        }

        _timesToRun = T;
        double[] percolationThresholds = new double[_timesToRun];
        
        for (int i = 0; i < _timesToRun; i++) {
            Percolation percolation = new Percolation(N);

            int runs = 0;
            while (!percolation.percolates()) 
            {
                int column;
                int row;

                do 
                {
                    column = 1 + StdRandom.uniform(N);
                    row = 1 + StdRandom.uniform(N);
                } while (percolation.isOpen(row, column));

                percolation.open(row, column);
                runs++;
            }

            percolationThresholds[i] = runs / (double) (N * N);
        }

        _mean = StdStats.mean(percolationThresholds);
        _stddev = StdStats.stddev(percolationThresholds);       
       
    }

    /**
     * sample mean of percolation threshold
     * @return
     */
    public double mean()
    {
        return _mean;
    }

    /**
     * sample standard deviation of percolation threshold
     * @return
     */
    public double stddev() 
    {  
        return _stddev;
    }

    /**
     * low  endpoint of 95% confidence interval
     * @return
     */
    public double confidenceLo() 
    {  
    	double confidenceFraction = (1.96 * stddev()) / Math.sqrt(_timesToRun);
        return mean() - confidenceFraction;
    }

    /**
     * high endpoint of 95% confidence interval
     * @return
     */
    public double confidenceHi() 
    {  
    	double confidenceFraction = (1.96 * stddev()) / Math.sqrt(_timesToRun);
        return mean() + confidenceFraction;
    }


    public static void main(String[] args) {
        int N = 50;
        int timesToRun = 5;
        
        PercolationStats stats = new PercolationStats(N, timesToRun);
        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
    }

}