import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> 
{	
	private Item[] array;
	private int elementsCounter = 0;
	private int randomIndex = 0;
	
	/**
	 * construct an empty randomized queue
	 */
	public RandomizedQueue() 
	{	
		array = (Item[]) new Object[1];
	}

	/**
	 * is the queue empty?
	 * @return
	 */
	public boolean isEmpty()
	{
		return elementsCounter == 0;
	}
	   
	/**
	 * return the number of items on the queue	 
	 * @return
	 */
	public int size()                        
	{
		return elementsCounter;
	}

	/**
	 * add the item
	 * @param item
	 */
	public void enqueue(Item item)            
	{
		if (item == null)
		{
			throw new java.lang.IllegalArgumentException("Item should not be null");
		}
		else 
		{
			elementsCounter++;
			
			int length = array.length;
			
			if (elementsCounter-1 == length)
			{	
				array = resizeArray(length * 2);
				length = array.length;		
			}
						
			randomIndex = StdRandom.uniform(length);
			if (array[randomIndex] != null)
			{
				for (int i = length - 1; i > randomIndex; i--)
				{	
					array[i] = array[i-1]; 
				}
			}
			array[randomIndex] = item;	
		}		
	}
	 
		
	/**
	 * remove and return a random item
	 * @return
	 */
	public Item dequeue()                    
	{
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException("There is no element");
		}
		else
		{	
			elementsCounter--;
			
			int length = array.length;
			Item randomItem = sample();		
			
			for (int i = randomIndex; i < length - 1; i++)
			{	
				array[i] = array[i+1]; 
			}			
			
			array[length - 1] = null;
			
			int haveALength = length/2;
			
			if (elementsCounter == haveALength && haveALength != 0)
			{	
				array = resizeArray(haveALength);				
			}
			
			return randomItem;
		}
		
	}
   
	/**
	 * return (but do not remove) a random item
	 * @return
	 */
	public Item sample()                     
	{
		int length = array.length;		
		Item result = null;
		
		if (isEmpty()) {
			throw new java.util.NoSuchElementException("There is no element");
		}
		else
		{
//			do 
//			{
				randomIndex = StdRandom.uniform(length);
				
				result = array[randomIndex];
//			}
//			while(result == null);	
		}
		
		
		return result;
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
		
		RandomizedQueue<String> randomQ = new RandomizedQueue<>();
//		  randomQ.enqueue("one");
//		  for (String item: randomQ)
//		  {
//			  System.out.print(item + " ");
//		  }
//		  
		  System.out.print("\n");
		  randomQ.dequeue();
		  for (String item: randomQ)
		  {
			  System.out.print(item + " ");
		  }
		  
//		  System.out.print("\n");
//		  randomQ.enqueue("three");
//		  for (String item: randomQ)
//		  {
//			  System.out.print(item + " ");
//		  }
//		  
//		  System.out.print("\n");
//		  randomQ.dequeue();
//		  for (String item: randomQ)
//		  {
//			  System.out.print(item + " ");
//		  }
//		  
//		  System.out.print("\n");
//		  randomQ.enqueue("Ford");
//		  for (String item: randomQ)
//		  {
//			  System.out.print(item + " ");
//		  }
//		  
//		  System.out.print("\n");
//		  randomQ.enqueue("Audi");
//		  for (String item: randomQ)
//		  {
//			  System.out.print(item + " ");
//		  }
//		  
//		  System.out.print("\n");
//		  randomQ.dequeue();
//		  for (String item: randomQ)
//		  {
//			  System.out.print(item + " ");
//		  }
//		  
//		  System.out.print("\n");
//		  randomQ.enqueue("Ford3+");
//		  
//		  for (String item: randomQ)
//		  {
//			  System.out.print(item + " ");
//		  }		
	}
	
	private class RandomizedQueueIterator implements Iterator<Item> 
	{
		int iteratorCounter = 0;
		public boolean hasNext() 
		{ 
			return array.length > iteratorCounter;
		}
		
		public void remove() 
		{ 
			throw new java.lang.UnsupportedOperationException("You can't use remove in the iterator");
		}
		
		public Item next() 
		{
			if (hasNext())
			{
				Item item = array[iteratorCounter];
				iteratorCounter++;
				return item;
			}
			else 
			{
				throw new java.util.NoSuchElementException("There is no Next element for iteration");
			}
			
		}
	}
	
	private Item[] resizeArray(int size)
	{
		Item[] resizedArray = (Item[]) new Object[size];
		int y = 0;
		int len = array.length;
		Item item = null;
		for (int i = 0; i < len; i++)
		{
			item = array[i];
			if (item != null)
			{
				resizedArray[y] = item;
				y++;	
			}			
		}
		
		return resizedArray;
	}	
}