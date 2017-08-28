import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats 
{
	private int _size;			// number of columns/rows in N x N grid
	private int _timesToRunStats;			
	private double[] _results;	// stores results of percolation experiments
	
	/**
	 * perform trials independent experiments on an n-by-n grid
	 * @param n
	 * @param trials
	 */
	public PercolationStats(int n, int trials) 
	{
		if(n <= 0 || trials <= 0) 
			throw new IllegalArgumentException("n & trials must be greater than 0.");
		
		_size = n;
		_timesToRunStats = trials;
		_results = new double[_timesToRunStats];
		
		for(int i = 0; i < _timesToRunStats; i++)
		{
			Percolation grid = new Percolation(_size);
			
			int numberOfTriesToOpen = 0;
			while( !grid.percolates() )
			{
				openRandomBlockedCell(grid);
				numberOfTriesToOpen++;
			}
			_results[i] = (double) numberOfTriesToOpen / (double) (_size * _size);
		}
	}
	
	private void openRandomBlockedCell(Percolation grid)
	{
		boolean isOpen = false;
		int randomRow = 0;
		int randomCol = 0;
					
		do
		{
			randomRow = StdRandom.uniform(0, _size);
			randomCol = StdRandom.uniform(0, _size);
			isOpen = grid.isOpen(randomRow, randomCol);
		}
		while(isOpen);
		
		grid.open(randomRow, randomCol);
	}
			   
	/**
	* sample mean of percolation threshold
	* @return double
	*/
	public double mean() 
	{
		return StdStats.mean(_results);
	}
			   
	/**
	* sample standard deviation of percolation threshold
	* @return double
	*/
	public double stddev()                       
	{
		return StdStats.stddev(_results);
	}
		   
	/**
	* low  endpoint of 95% confidence interval
	* @return double
	*/
	public double confidenceLo()                  
	{
		return mean() - ( (1.96*stddev() ) / Math.sqrt( _timesToRunStats ) );
	}
		   
	/**
	* high endpoint of 95% confidence interval
	* @return double
	*/
	public double confidenceHi()                  
	{
		return mean() + ( ( 1.96 * stddev() ) / Math.sqrt( _timesToRunStats ) );
	}
	
	/**
	* test client (described below)	   
	* @param args
	*/
	public static void main(String[] args)
	{
		int size = new Integer(50);
		int timesToRun = new Integer(10);
		
		PercolationStats stats = new PercolationStats(size, timesToRun);
		
		System.out.println("mean:\t\t\t\t = " + stats.mean());
		System.out.println("stddev:\t\t\t\t = " + stats.stddev());
		System.out.println("95% confidence interval:\t = " + stats.confidenceLo() + ", " + stats.confidenceHi());
	}
		  
}
