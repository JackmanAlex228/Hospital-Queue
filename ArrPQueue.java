package PainQueue;

/* Figure 12-9a is an array-based priority queue

   QItemType is the type of the items
   stored in the priority queue

+createPQueue()
   Creates an empty priority queue

+pqIsEmpty():boolean {query}
   Determines whether a priority queue is empty

+pqInsert(in newItem:PQItemType) throws PQueueException
   Inserts newItem into a priority queue. Throws
   PQueueException if priority queue is full.

+pqDelete():PQItemType
   Retrieves and then deletes the item in the priority queue
   with the highest priority value */

// Priority queue exception class
class pqException extends RuntimeException 
{
    public pqException(String s) 
    {
        super(s);
    }
}

public class ArrPQueue 
{
    // Pricate variable declorators
    // Using the Comparable data type for prioritization when deleting
    private Comparable[] array;
    private final int MAX_SIZE = 8;
    private int index;
    
    // Creates a priority queue, works as constructor
    public void createPQueue() 
    {
        array = new Comparable[MAX_SIZE];
    }
    
    // Determines whether or not the priority queue is empty
    public boolean pqIsEmpty() 
    {
        return index == 0;
    }
    
    // Inserts a value into the priority queue, throws exception if queue is full
    public void pqInsert(Comparable item) throws pqException 
    {
        // If the queue is full
        if (index == array.length)
        {
            throw new pqException("ERROR: Exception on pqInsert, queue is full");
        }
        
        // Assigning the item to the index of the array
        array[index] = item;
        index++;
        System.out.println("Adding pacient with pain level of " + item + " to the queue");
    }
    
    // Priority queue delete method:
    // Deletes the element with the highest value
    public Comparable pqDelete() 
    {
        // If the queue is empty
        if (pqIsEmpty()) 
        {
            System.out.println("ERROR: Exception on pqDelete, queue is empty.");
            return null;
        }
        
        // find the item with the highest priority
        int maxIndex = 0;
        for (int i = 1; i < index; i++) 
            if (array[i].compareTo (array[maxIndex]) > 0)
                maxIndex = i;
        
        // Remove the value of highest priority
        Comparable result = array[maxIndex];
        System.out.println("Calling on pacient with pain level of " + result);
        
        // Move the last item into the empty slot
        index--;
        array[maxIndex] = array[index];
        
        // Empty the slot where the last item once was
        array[index] = null;
        
        return result;
    }
    
    // Non-required method. Prints the current status of theg priority queue
    public void displayPQueue()
    {
        if (!pqIsEmpty()) 
        {
            for (int i = 0; i < array.length; i++)
                if (array[i] != null)
                    System.out.println("- Pacient " + (i+1) + ": " + array[i]);
        }
        else
            System.out.println("The queue appears to be empty. ");
    }
}
