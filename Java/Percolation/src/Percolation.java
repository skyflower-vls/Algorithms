import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
//temp
import java.util.concurrent.ThreadLocalRandom;

// NEED to connect first virtual el to first row and  last column to bottom virtual, virtual bottom connect to virtual top

public class Percolation {
	
	private boolean[][] _field;
	private WeightedQuickUnionUF _quickUnion;
	private int _topRoot = 0;
	private int _bottomRoot = 0;
	private int _fieldSize = 0;
	private int _numInRow = 0;
	private int _openedElementsCount = 0;
	
	   public Percolation(int n)                // create n-by-n grid, with all sites blocked
	   {
		   
		   _numInRow = n;
		   _fieldSize = n * n;
		   _bottomRoot = _fieldSize + 1;
		   
		   int corr = _fieldSize + 2;
			_quickUnion = new WeightedQuickUnionUF(corr); // plus two virtual ids
			//_quickUnion.union(_topRoot, _bottomRoot);
			
			createField(n);
			
				
			showArray();
			randomOpenField();
			System.out.println("__");
			if (percolates())
			{
				System.out.println("Hello, World");
				
			}
			showArray();	
			
			
			
			
	   }
	   
	   private void randomOpenField()
	   {
		   for (int i = 0; i < _numInRow; i++)
		   {
			   for (int y = 0; y < _numInRow; y ++)
			   {
				  if (_field[i][y]) {
					  open(i, y);
				  }
			   }
		   }
		}
	   
	   private int getIdNumberFromArray(int row, int col)
	   {
		   int result = (_numInRow * row)  +  col + 1; //plus first virtual
		   
		   return result;
	   }
	   
	   private void createField(int size)
	   {
		   _field = new boolean[size][size];
		   for (int i = 0; i < size; i++) 
		   {
			   for (int y = 0; y < size; y ++)
			   {
				   int tt = ThreadLocalRandom.current().nextInt(0, 2);
					  if(tt == 0)
					  {
						  _field[i][y] = true;
					  }
					  else {
						  
						  _field[i][y] = false;
					  }
			   }
		   }
	   }
	   
	   private void showArray()
	   {
		   String res = "";
		   for (int i = 0; i < _numInRow; i++) 
		   {			 
			   res = "";
			   for (int y = 0; y < _numInRow; y++)
			   {
				   
				   if( _field[i][y]) 
					{
						res = res.concat("1 ");
					} 
					else 
					{
						res = res.concat("0 ");
					}   
			   }
				
			   
				System.out.println(res);
		   }
	   }
	  	   
	   
	   public void open(int row, int col)    // open site (row, col) if it is not open already
	   {
		   //_field[row][col] = true;
		   _openedElementsCount ++;
		   
		   if (row == 0) 
		   {
			   _quickUnion.union(getIdNumberFromArray(row, col), _topRoot); 
		   }
		   if (row == _numInRow - 1) 
		   {
			   _quickUnion.union(getIdNumberFromArray(row, col), _bottomRoot); 
		   }
			   

		   if (isOpen(row-1, col)) {				   
			   _quickUnion.union(getIdNumberFromArray(row, col), getIdNumberFromArray(row -  1, col));
		   }
		   if (isOpen(row+1, col)) {				   
			   _quickUnion.union(getIdNumberFromArray(row, col), getIdNumberFromArray(row +  1, col));
		   }	
		   if(isOpen(row, col + 1)) {
			   _quickUnion.union(getIdNumberFromArray(row, col), getIdNumberFromArray(row, col + 1));
		   }
		   if(isOpen(row, col - 1)) {
			   _quickUnion.union(getIdNumberFromArray(row, col), getIdNumberFromArray(row, col - 1));
		   }
			 
	   }
	   
	   public boolean isOpen(int row, int col)  // is site (row, col) open?
	   {
		   if (!isFull(row, col)) {
			   return _field[row][col];
		   }
		   else
		   {
			   return false;
		   }
	   }
	   
	   public boolean isFull(int row, int col)  // is site (row, col) full?
	   {
		   boolean result = (col >= _numInRow || col < 0 || row < 0 || row >= _numInRow);
		   return result; 
		
	   }
	   
	   public int numberOfOpenSites()       // number of open sites
	   {
		   return _openedElementsCount;
	   }
	   
	   public boolean percolates()              // does the system percolate?
	   {
		   return _quickUnion.connected(_topRoot, _bottomRoot);
	   }

	   public static void main(String[] args)   // test client (optional)
	   {
		   
		   
		   Percolation percolation = new Percolation(5);
	   }		

}
