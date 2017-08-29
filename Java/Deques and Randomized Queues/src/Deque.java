import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> 
{
    private Node<Item> first;
    private Node<Item> last;
    
	private int size = 0;
	
	/**
	 * construct an empty deque
	 */
	public Deque()                            
	{
		
	}
	   
	/**
	 * is the deque empty?
	 * @return
	 */
	public boolean isEmpty()                  
	{
		return false;
	}
	   
	/**
	 * return the number of items on the deque
	 * @return
	 */
	public int size()                        
	{	 
		return size;
	}
	   
	/**
	 * add the item to the front
	 * @param item
	 */
	public void addFirst(Item item)          
	{
		if (item == null) 
		{
			throw new java.lang.IllegalArgumentException("Item should not be null");
		}
	}
	
	/**
	 * add the item to the end
	 * @param item
	 */
	public void addLast(Item item)           
	{
		if (item == null) 
		{
			throw new java.lang.IllegalArgumentException("Item should not be null");
		}
	}
	   
	/**
	 * remove and return the item from the front
	 * @return
	 */
	public Item removeFirst()                
	{
		if (size() == 0)
		{
			throw new java.util.NoSuchElementException("There is no first element");
		}
		return null;
	}
	   
	/**
	 * remove and return the item from the end
	 * @return
	 */
	public Item removeLast()                  
	{
		if (size() == 0)
		{
			throw new java.util.NoSuchElementException("There is no last element");
		}
		return null;
	}
	   
	/**
	 * return an iterator over items in order from front to end
	 */
	public Iterator<Item> iterator()         
	{
		return new DequeIterator();
	}
	   
	/**
	 * unit testing (optional)
	 * @param args
	 */
	public static void main(String[] args)   
	{
		   
	}
	
	/**
	 * Iterator for Deque 
	 */
	private class DequeIterator implements Iterator<Item> 
	{
		public boolean hasNext() 
		{ 
			return false;
		}
		
		public void remove() 
		{ 
			throw new java.lang.UnsupportedOperationException("You can't use remove in the iterator");
		}
		
		public Item next() 
		{
			return null;
		}
		
	}
	
	/**
	 * Node item for iterations 
	 */
	private class Node<Item> 
	{
		private Node(Item item) 
		{
			
		}
	}
	 
}