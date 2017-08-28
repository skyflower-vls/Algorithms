import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private int _size = 0;
    private boolean[][] _cellGrid;    

    private int _virtualTopRoot = 0;
    private int _virtualBottomRoot = 0;
    
    private WeightedQuickUnionUF _weightedQuickUF;
    private WeightedQuickUnionUF _weightedQuickUFFull;


    /**
     * create N-by-N grid, with all sites blocked
     * @param n
     */
    public Percolation(int n) 
    { 
        if (n <= 0) 
        {
            throw new IllegalArgumentException("N should not be n <= 0");
        }
        
        _weightedQuickUF = new WeightedQuickUnionUF(n * n + 2);
        _weightedQuickUFFull = new WeightedQuickUnionUF(n * n + 1);

        _size = n;
        _cellGrid = new boolean[n][n];
        
        _virtualTopRoot = 0;
        _virtualBottomRoot = n * n + 1;
    }

    /**
     * open site (row i, column j) if it is not open already
     * @param row
     * @param col
     */
    public void open(int row, int col) 
    {   
        if (!isOut(row-1, col-1) && !isOpen(row, col)) 
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
            union(fieldIndex, row, col - 1);
            union(fieldIndex, row, col + 1);

            _cellGrid[row - 1][col - 1] = true;
        }
    }

    private void union(int cellIndex, int row, int col) {
        if (!isOut(row-1, col-1) && isOpen(row, col)) 
        {
            int neighboursCellIndex = getElementNumberInStructure(row, col);
            _weightedQuickUF.union(neighboursCellIndex, cellIndex);
            _weightedQuickUFFull.union(neighboursCellIndex, cellIndex);
        }
    }
    
    private boolean isOut(int row, int col) 
    {
	   boolean result = (col >= _size || col < 0 || row < 0 || row >= _size);
	   return result; 	
    }

    /**
     * does the system percolate?
     * @return
     */
    public boolean percolates() 
    {  
        return _weightedQuickUF.connected(_virtualTopRoot, _virtualBottomRoot);
    }
    
    private int getElementNumberInStructure(int row, int col) {
        return (row - 1) * _size + col;
    }
    
    /**
     * is cell Opened?
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) 
    {   
    	if (!isOut(row-1, col-1)) 
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
    public boolean isFull(int row, int col) {   
        if (isOpen(row, col)) 
        {
            int fieldIndex = getElementNumberInStructure(row, col);
            return _weightedQuickUFFull.connected(_virtualTopRoot, fieldIndex);
        }
        return false;
    }
}