import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

//temp for testing
import java.util.concurrent.ThreadLocalRandom;

public class Percolation 
{	
	private boolean[][] _field;
	private WeightedQuickUnionUF _quickUnion;
	private int _virtualTopRoot = 0;
	private int _virtualBottomRoot = 0;
	private int _fieldArrayNumberOfElements = 0;
	private int _size = 0;
	private int _openedElementsCount = 0;
	
	/**
	* create n-by-n grid, with all sites blocked
	* @param n
	*/
	public Percolation(int n)
	{	   
		_size = n;
		_fieldArrayNumberOfElements = n * n;
		   
		_virtualTopRoot = 0;
		_virtualBottomRoot = _fieldArrayNumberOfElements + 1;
		   
		int fixedArraySizeWithVirtualElements = _fieldArrayNumberOfElements + 2;  // plus two virtual ids
		_quickUnion = new WeightedQuickUnionUF(fixedArraySizeWithVirtualElements);
					
		createField(n);
		
		// temp for testing
		showArray();
		
		// temp for testing
		randomOpenField();
		
		// temp for testing
		System.out.println("__");
		
		// temp for testing
		if (percolates())
		{
			System.out.println("Percolates!");			
		}
		
		// temp for testing
		showArray();			
	}
   
	/**
	* test client (optional)
	* @param args
	*/
	public static void main(String[] args)   
	{   
		// temp for testing
		new Percolation(5);
	}
   
	/**
	* is site (row, col) open?
	* @param row
	* @param col
	* @return boolean
	*/
	public boolean isOpen(int row, int col)
	{
		if (!isFull(row, col)) 
		{
			return _field[row][col];
		}
		else
		{
			return false;
		}
	}
   
	/**
	* Is site (row, col) full? 
	* @param row
	* @param col
	* @return boolean
	*/
    public boolean isFull(int row, int col)  
    {
	   boolean result = (col >= _size || col < 0 || row < 0 || row >= _size);
	   return result; 		
    }
   
	/**
	* number of open sites
	* @return integer
	*/
    public int numberOfOpenSites()       
    {
	   return _openedElementsCount;
    }
   
	/**
	* does the system percolate?
	* @return boolean
	*/
	public boolean percolates()              
	{
		return _quickUnion.connected(_virtualTopRoot, _virtualBottomRoot);
	}
   
	/**
	* open site (row, col) if it is not open already
	* @param row
	* @param col
	*/
	public void open(int row, int col)    // 
	{   
		if (!isOpen(row, col)) 
		{
			_field[row][col] = true;
			_openedElementsCount ++;
					   
			int currentId = getIdNumberFromArray(row, col);
					   
			if (row == 0) 
			{
				_quickUnion.union(currentId, _virtualTopRoot); 
			}
					   
			if (row == _size - 1) 
			{
				_quickUnion.union(currentId, _virtualBottomRoot); 
			}   
				
			if (isOpen(row-1, col)) 
			{				   
				_quickUnion.union(currentId, getIdNumberFromArray(row -  1, col));
			}
					   
			if (isOpen(row+1, col)) 
			{				   
				_quickUnion.union(currentId, getIdNumberFromArray(row +  1, col));
			}	
					   
			if (isOpen(row, col + 1)) 
			{
				_quickUnion.union(currentId, getIdNumberFromArray(row, col + 1));
			}
					   
			if (isOpen(row, col - 1)) 
			{
				_quickUnion.union(currentId, getIdNumberFromArray(row, col - 1));
			}
		}
	}
   
	/**
	* get position in the array (+virtual top id)
	* @param row
	* @param col
	* @return integer
	*/
	private int getIdNumberFromArray(int row, int col)
	{
		int result = (_size * row)  +  col + 1; //plus first virtual
		   
		return result;
	}
   
	/**
	* create array with default values with fixed size  - size * size
	* @param size
	*/
	private void createField(int size)
	{
		_field = new boolean[size][size];
			   
		for (int i = 0; i < size; i++) 
		{
			for (int y = 0; y < size; y ++)
			{
				_field[i][y] = false;
			}
		}
	}
   
	/**
	* print array to the console
	*/
	private void showArray()
	{
		String result = "";
		   
		for (int i = 0; i < _size; i++) 
		{			 
			result = "";
			   
			for (int y = 0; y < _size; y++)
			{				   
				if( _field[i][y]) 
				{
					result = result.concat("1 ");
				} 
				else 
				{
					result = result.concat("0 ");
				}   
			}				
					   
			System.out.println(result);
		}
	}
   
   
	/**
	* optional for testing, fills array with random values
	*/
	private void randomOpenField()
	{
		for (int i = 0; i < _size; i++)
		{
			for (int y = 0; y < _size; y ++)
			{			 
				int random = ThreadLocalRandom.current().nextInt(0, 2);
				if(random == 1)
				{						  
					open(i, y);
				}
			}
		}
	}
}
