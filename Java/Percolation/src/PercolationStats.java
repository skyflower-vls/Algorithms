import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats 
{
	private int N;			// number of columns/rows in N x N grid
	private int T;			// number of times to run stats
	private double[] results;	// stores results of percolation experiments
	
	/**
	 * perform trials independent experiments on an n-by-n grid
	 * @param n
	 * @param trials
	 */
	public PercolationStats(int n, int trials) 
	{
		if(n<=0 || trials<=0) 
			throw new IllegalArgumentException("N & T must be greater than 0.");
		
		this.N = n;
		this.T = trials;
		results = new double[T];
		
		for(int i=0;i< T;i++)
		{
			Percolation grid = new Percolation(N);
			int result = 0;
			while(!grid.percolates())
			{
				openRandomBlockedNode(grid);
				result++;
			}
			results[i] = (double) result / (double) (N*N);
		}
	}
	
	private void openRandomBlockedNode(Percolation grid)
	{
		boolean isOpen = false;
		int randomRow = 0;
		int randomCol = 0;
		
		do
		{
			randomRow = StdRandom.uniform(1,N);
			randomCol = StdRandom.uniform(1,N);
			isOpen = grid.isOpen(randomRow,randomCol);
		}
		while(isOpen);
		
		grid.open(randomRow,randomCol);
	}
			   
	/**
	* sample mean of percolation threshold
	* @return double
	*/
	public double mean() 
	{
		return StdStats.mean(results);
	}
			   
	/**
	* sample standard deviation of percolation threshold
	* @return double
	*/
	public double stddev()                       
	{
		return StdStats.stddev(results);
	}
		   
	/**
	* low  endpoint of 95% confidence interval
	* @return double
	*/
	public double confidenceLo()                  
	{
		return mean()-((1.96*stddev())/Math.sqrt(T));
	}
		   
	/**
	* high endpoint of 95% confidence interval
	* @return double
	*/
	public double confidenceHi()                  
	{
		return mean()+((1.96*stddev())/Math.sqrt(T));
	}
	
	/**
	* test client (described below)	   
	* @param args
	*/
	public static void main(String[] args)
	{
		int N = new Integer(50);
		int T = new Integer(5);
		
		PercolationStats stats = new PercolationStats(N,T);
		
		System.out.println("mean:\t\t\t\t = " + stats.mean());
		System.out.println("stddev:\t\t\t\t = " + stats.stddev());
		System.out.println("95% confidence interval:\t = " + stats.confidenceLo() + ", " + stats.confidenceHi());
	}
		  
}
