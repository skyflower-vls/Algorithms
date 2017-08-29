import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;

public class Percolation 
{
	private int _size = 0;  // size of each side in the cell grid 
    private boolean[][] _cellGrid;    

    private int _virtualTopRoot = 0;
    private int _virtualBottomRoot = 0;
    
    private WeightedQuickUnionUF _weightedQuickUF;  // for percolation checks from the top to the bottom
    private WeightedQuickUnionUF _weightedQuickUFFull; // for percolation checks to the "%element"


    /**
     * create N-by-N grid, with all sites blocked
     * @param n
     */
    public Percolation(int n) 
    { 
        if (n <= 0) 
        {
            throw new IllegalArgumentException("N should not be less than 0");
        }               
        
        int elementsInGrid = n * n;
        _weightedQuickUF = new WeightedQuickUnionUF(elementsInGrid + 2);
        _weightedQuickUFFull = new WeightedQuickUnionUF(elementsInGrid + 1);

        _size = n;
        _cellGrid = new boolean[n][n];
        
        _virtualTopRoot = 0;
        _virtualBottomRoot = elementsInGrid + 1;
        
//		// temp for testing
//		showArray();
//		
//		// temp for testing
//		randomOpenField();
//		
//		// temp for testing
//		System.out.println("__");
//		
//		// temp for testing
//		if (percolates())
//		{
//			System.out.println("Percolates!");			
//		}
//		
//		// temp for testing
//		showArray();	        
    }

    /**
     * open site if it is not open already
     * @param row
     * @param col
     */
    public void open(int row, int col) 
    {   
        if (!isOut(row - 1, col - 1) && !isOpen(row, col)) 
        {
            int fieldIndex = getElementNumberInStructure(row, col);

            if (row == 1) 
            {
            	_weightedQuickUF.union(_virtualTopRoot, fieldIndex);
                _weightedQuickUFFull.union(_virtualTopRoot, fieldIndex);
            }
            
            if (row == _size) 
            {
            	_weightedQuickUF.union(_virtualBottomRoot, fieldIndex);
            }

            union(fieldIndex, row + 1, col);
            union(fieldIndex, row - 1, col);
       
            union(fieldIndex, row, col + 1);
            union(fieldIndex, row, col - 1);

            _cellGrid[row - 1][col - 1] = true;
        }
    }

    private void union(int cellIndex, int row, int col) {
        if ( !isOut(row - 1, col - 1) && isOpen(row, col) ) 
        {
            int neighboursCellIndex = getElementNumberInStructure(row, col);
            _weightedQuickUF.union(neighboursCellIndex, cellIndex);
            _weightedQuickUFFull.union(neighboursCellIndex, cellIndex);
        }
    }
    
    /**
     * does the system percolate?
     * @return
     */
    public boolean percolates() 
    {  
        return _weightedQuickUF.connected(_virtualTopRoot, _virtualBottomRoot);
    }
    
    private int getElementNumberInStructure(int row, int col) 
    {
        return (row - 1) * _size + col;
    }
    
    private boolean isOut(int row, int col) 
    {
	   boolean result = (col >= _size || col < 0 || row < 0 || row >= _size);
	   return result; 	
    }
    
    /**
     * is cell Opened?
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) 
    {   
    	if (!isOut(row - 1, col - 1)) 
    	{
    		 return _cellGrid[row - 1][col - 1];	
    	}
    	return false;
    }

    /**
     * is cell connected to top?
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col) 
    {   
        if (isOpen(row, col)) 
        {
            int fieldIndex = getElementNumberInStructure(row, col);
            return _weightedQuickUFFull.connected(_virtualTopRoot, fieldIndex);
        }
        return false;
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
				if( _cellGrid[i][y]) 
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
		for (int i = 1; i <= _size; i++)
		{
			for (int y = 1; y <= _size; y ++)
			{			 				
				int random = StdRandom.uniform(0, 2);
				if(random == 1)
				{						  
					open(i, y);
				}
			}
		}
	}
    
    public static void main(String[] args)
    {
    	new Percolation(5);
    }
}