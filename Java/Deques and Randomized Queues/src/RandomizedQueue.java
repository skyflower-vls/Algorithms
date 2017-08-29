import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
	/**
	 * construct an empty randomized queue
	 */
	public RandomizedQueue() 
	{
		
	}

	/**
	 * is the queue empty?
	 * @return
	 */
	public boolean isEmpty()
	{
		return false;
	}
	   
	/**
	 * return the number of items on the queue	 
	 * @return
	 */
	public int size()                        
	{
		return 0;
	}

	/**
	 * add the item
	 * @param item
	 */
	public void enqueue(Item item)            
	{
		
	}
	 
	/**
	 * remove and return a random item
	 * @return
	 */
	public Item dequeue()                    
	{
		return null;
	}
   
	/**
	 * return (but do not remove) a random item
	 * @return
	 */
	public Item sample()                     
	{
		return null;
	}
	   
	/**
	 * return an independent iterator over items in random order
	 */
	public Iterator<Item> iterator()          
	{
		return new RandomizedQueueIterator();
	}
	
	/**
	 * unit testing (optional)
	 * @param args
	 */
	public static void main(String[] args) 
	{		
	}
	
	private class RandomizedQueueIterator implements Iterator<Item> 
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
	
}