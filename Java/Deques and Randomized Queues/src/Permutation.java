
public class Permutation 
{
    public static void main(String[] args)
    {
    	int k = Integer.parseInt(args[0]);

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        for (int i = 1; i < args.length; i++) 
        {
            randomizedQueue.enqueue(args[i]);
        }

        for (int i = 0; i < k; i++) 
        {
            System.out.println(randomizedQueue.dequeue());
        }
    }
}