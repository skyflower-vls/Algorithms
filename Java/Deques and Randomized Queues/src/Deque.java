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
		this.first = null;
		this.last = null;
	}
	   
	/**
	 * is the deque empty?
	 * @return
	 */
	public boolean isEmpty()                  
	{
		return first == null;
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
		if (isItemCorrect(item)) 		 
		{
			size++;
			
			if (isEmpty())
			{
				addInitialItem(item);			
			}
			else
			{
				Node<Item> oldFirst = this.first;
				this.first = new Node<>(item);
				
				oldFirst.setPrevious(this.first);
				this.first.setItem(item);
				this.first.setNext(oldFirst);
			}
			
		}
	}
	

	
	/**
	 * add the item to the end
	 * @param item
	 */
	public void addLast(Item item)           
	{		
		if (isItemCorrect(item)) 		
		{
			size++;

			if (isEmpty())
			{
				addInitialItem(item);				
			}
			else
			{	
				Node<Item> newItemNode = new Node<>(item);		
				this.last.setNext(newItemNode);
				newItemNode.setItem(item);
				newItemNode.setPrevious(this.last);				
				
				this.last = newItemNode;						
			}	
		}
	}
	   
	/**
	 * remove and return the item from the front
	 * @return
	 */
	public Item removeFirst()                
	{	
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException("There is no first element");
		}
		else 
		{
			size--;
			
			Item item = this.first.getItem();
			this.first = this.first.getNext();
			this.first.setPrevious(null);			
			return item;
		}
	}
	   
	/**
	 * remove and return the item from the end
	 * @return
	 */
	public Item removeLast()                  
	{		
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException("There is no last element");
		}
		else 
		{
			size--;
			
			Item item = this.last.getItem();
			this.last = this.last.getPrevious();
			this.last.setNext(null);
			return item;
		}
	}
	   
	/**
	 * return an iterator over items in order from front to end
	 */
	public Iterator<Item> iterator()         
	{
		return new DequeIterator();
	}
	   	
	/**
	 * Iterator for Deque 
	 */
	private class DequeIterator implements Iterator<Item> 
	{
		private Node<Item> currentElement = first;
		
		public boolean hasNext() 
		{ 
			return currentElement != null;
		}
		
		public void remove() 
		{ 
			throw new java.lang.UnsupportedOperationException("You can't use remove in the iterator");
		}
		
		public Item next() 
		{
			Item item = currentElement.getItem();
			currentElement = currentElement.getNext(); 
			return item;
		}		
	}
	
	/**
	 * Node item for iterations 
	 */
	private class Node<Item> 
	{		
		Item item;
		Node<Item> next;
		Node<Item> previous;
		
		private Node(Item item) 
		{
            this.item = item;
            next = null;
            previous = null;
        }
		
		public void setItem(Item item)
		{
			this.item = item;
		}
		
		public Item getItem()
		{
			return this.item;
		}
		
		public void setNext(Node<Item> node)
		{
			this.next = node;
		}
		
		public Node<Item> getNext()
		{
			return this.next;
		}
		
		public void setPrevious(Node<Item> node)
		{
			this.previous = node;
		}
		
		public Node<Item> getPrevious()
		{
			return this.previous;
		}
	}
	
	/**
	 * check if item is not NULL
	 * if item is null -> throw an exception
	 * @param item
	 * @return
	 */
	private boolean isItemCorrect(Item item)
	{
		boolean result = true;
		
		if (item == null) 
		{
			result = false;
			throw new java.lang.IllegalArgumentException("Item should not be null");
		}
		
		return result;
	}
	
	/**
	 * add a very first item to the deque
	 * @param item
	 */
	private void addInitialItem(Item item)
	{
		assert(item != null);

		if (isEmpty())
		{
			this.first = new Node<>(item);
			this.first.item = item;
			
			this.last = this.first;				
		}
		
	}
	
	/**
	 * unit testing (optional)
	 * @param args
	 */
	public static void main(String[] args)   
	{		
		  Deque<String> deq = new Deque<>();
		  deq.addFirst("one");
		  deq.addFirst("two");
		  deq.addFirst("three");
		  deq.removeFirst();
		  deq.addLast("Ford");
		  deq.addLast("Audi");
		  deq.removeLast();
		  deq.addLast("Ford3+");
		  
		  for (String item: deq)
		  {
			  System.out.print(item);
		  }
	}
	 
}