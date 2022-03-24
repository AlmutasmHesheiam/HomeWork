package Q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatingQueue<T> {

    private T element;

    public RotatingQueue(int capacity) {
        size = capacity;
        queue = new ArrayList<T>(capacity);
        mostRecentItem = capacity-1;
    }

    /**
     * Inserts an element to the head of the queue, pushing all other elements
     * one position forward.
     *
     * @param element
     */
    public void enqueue(T element) {

        //Get index
        mostRecentItem = advancePointer(mostRecentItem);

        //Check if list already has an element
        if(queue.size() == mostRecentItem ) {
            queue.add(element);
        } else {
            queue.set(mostRecentItem, element);
        }
    }
    public void Dnqueue() {
        mostRecentItem = advancePointer(mostRecentItem);
      while (queue.size()>0)
      {
        queue.remove( getElement(mostRecentItem));

    }}
    public T getElement(int index) {
        // Normalize index to size of queue
        index = index % size;

        // Translate wanted index to queue index
        int queueIndex = mostRecentItem - index;
        // If negative, add size
        if(queueIndex < 0) {
            queueIndex += size;
        }

        // Check if element already exists in queue
        if(queueIndex < queue.size()) {
            return queue.get(queueIndex);
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }

    private int advancePointer(int oldPointer) {
        int pointer = oldPointer+1;
        if(pointer < size) {
            return pointer;
        } else {
            return 0;
        }
    }

    ///
    // INSTANCE VARIABLES
    ///
    private ArrayList<T> queue;
    private int mostRecentItem;
    private int size;

    public static void main(String[] args) {
        RotatingQueue q=new RotatingQueue<>(5);
        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(13);
        System.out.print(Arrays.toString(q.queue.toArray())+"\n");
      q.Dnqueue();

        System.out.print(Arrays.toString(q.queue.toArray())+"\n");

    }
}