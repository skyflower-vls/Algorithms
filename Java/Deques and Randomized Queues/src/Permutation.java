import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation 
{
    public static void main(String[] args)
    {
    	int k = Integer.parseInt(args[0]);
    	
        RandomizedQueue<String> randQueue = new RandomizedQueue<String>();
          
	    String values = StdIn.readString();
	    while(values != null)
	    {
	    	randQueue.enqueue(values);
	        values = StdIn.readString();
	    }
       
        for (int i = 0; i < k; i++) {
        	StdOut.println(randQueue.dequeue());
        }
        
    }
}