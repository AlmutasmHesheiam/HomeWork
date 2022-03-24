import java.io.*;
import java.util.*;

class Illegal extends IllegalArgumentException {}
class Empty extends ArrayIndexOutOfBoundsException {}

/** Implements an integer list as a linked list data structure. 
 *
 * This linked list contains a pointer to the head and tail of the list.
 * This allows us to easily add elements to the end of the list.
 * Remove will always be an O(n) operation.
 *
 *
 * This properly handles exceptions.
 * Asking to remove from an empty list throws Empty
 * Asking to remove an invalid index throws Illegal 
 *
 *
 * All objects should implement:
 *   - toString
 *   - comparable, if needed
 *   - any other interfaces, if needed
 *
 * LinkedList ADT implements:
 *   - size
 *   - isEmpty
 *   - first 
 *   - last 
 *   - addFirst
 *   - addLast
 *   - removeFirst
 *
 * Notes:
 *	 - class definition
 *   - IntNode class goes INSIDE of IntList class
 *	 - constructor
 *	 - main method 
 */
public class IntList {

    // ------------- linked node class --------------
    /**
     * Linked list node class.
     *
     * Implements:
     *   - toString
     *   - getData
     *   - getNext
     *   - setNext
     *   - equals
     * */
     class IntNode {
        int data;
        IntNode next;

        /** New node with specified data and no next pointer. */
        public IntNode(int data) {
            this(data,null);
        }

        /** New node with specified data and specified next pointer. */
        public IntNode(int data, IntNode next) {
            this.data = data;
            this.next = next;
        }
        public int getData(){ return data; }
        public IntNode getNext(){ return next; }
        public void setNext(IntNode next){ this.next = next; }
        public boolean equals(int i) { return data==i; }
        public String toString() { return Integer.toString(this.data); }
    }

    // ------------- end linked node class ----------

    private IntNode head;
    private IntNode tail;
    private int size;

    /** Make an empty new IntList. */
    public IntList() {
        head = null;
        tail = null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        if(isEmpty()) {
            sb.append("]");
            return sb.toString();
        }
        IntNode runner = head;
        sb.append( runner.toString() );
        while(runner.getNext()!=null) {
            // Order is important here!
            runner = runner.getNext();
            sb.append(", ");
            sb.append( runner.toString() );
        }
        sb.append("]");
        return sb.toString();
    }

    /** Get size of list. */
    public int size() { return size; }

    /** Returns true if empty. */
    public boolean isEmpty() { return size==0; }

    /** Return the first integer in the list. */
    public int first() { return head.getData(); }

    /** Return the last integer in the list. */
    public int last() { return tail.getData(); }

    /** Add an integer at the beginning of the list. */
    public void addFirst(int x) {
        addFirst(new IntNode(x));
    }

    /** Add a node at the beginning of the list. */
    private void addFirst(IntNode newHead) {
        // Make sure you account for size 0
        newHead.setNext(this.head);
        this.head = newHead;
        if(size==0) {
            this.tail = newHead;
        }
        size++;
    }

    /** Add an integer at the end of the list. */
    public void addLast(int x) {
        addLast(new IntNode(x));
    }

    /** Add a node at the end of the list. */
    private void addLast(IntNode newlast) {
        // Make sure you account for size 0
        if(size==0) {
            this.head = newlast;
            this.tail = newlast;
        } else {
            this.tail.setNext(newlast);
            this.tail = newlast;
        }
        size++;
    }

    /** Add an integer to the end of the list. */
    public void add(int x) { addLast(x); }

    /** Remove the item at index rmi from the list. */
    public int remove(int rmi) throws Illegal, Empty {
        // What could possibly go wrong?
        //   - list is empty
        //   - specified index is too big/too small
        //   - specified index is first index (tricky)
        //   - everything else
        // The "everything else" case guarantees rmi is 
        // between 1 and (rmi-1)
        //
        if(isEmpty()) {
            throw new Empty();
        } else if(rmi>=size || rmi<0) {
            throw new Illegal();
        } else if(rmi==0) {
            int result = this.head.getData();

            // Zero case: remove first item in list
            IntNode newhead = this.head.getNext();
            this.head = newhead;
            size--;

            return result;
        } else {
            IntNode runner = this.head;
            IntNode lagger = this.head;
            for(int j=0;j<rmi;j++){
                runner = runner.getNext();
                if(j>=1) {
                    lagger = lagger.getNext();
                }
            }
            // Forget the runner
            int result = runner.getData();
            IntNode next = runner.getNext();
            lagger.setNext(runner.getNext());
            return result;
        }
    }

    /** Remove item at beginning of list. */
    public void removeFirst() {
        if(isEmpty()) {
            throw new Empty();
        } else {
            IntNode newhead = this.head.getNext();
            this.head = newhead;
        }
    }

    /** Remove item at end of list. */
    public void removeLast() {
        if(isEmpty()) {
            throw new Empty();
        } else {
            remove(size-1);
        }
    }




    public static IntList getIntList() {
        IntList l = new IntList();
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
        l.addFirst(0);
        return l;
    }

    // Main method
    public static void main(String[] args) throws Illegal, Empty {

        IntList list;

        System.out.println("Start:");
        list = getIntList();
        System.out.println(list);
        System.out.println("Size: "+list.size());

        System.out.println("Remove at 0 4 times:");
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        System.out.println(list);
        System.out.println("Size: "+list.size());

        list = getIntList();
        System.out.println("Start:");
        System.out.println(list);
        System.out.println("Removing index 1...");
        list.remove(1);
        System.out.println(list);

        list = getIntList();
        System.out.println("Start:");
        System.out.println(list);
        System.out.println("Removing index 2...");
        list.remove(2);

        list = getIntList();
        System.out.println("Start:");
        System.out.println(list);
        System.out.println("Removing index 3...");
        list.remove(3);
        System.out.println(list);

        list = getIntList();
        System.out.println("Start:");
        System.out.println(list);

        System.out.println("Adding first");
        list.addFirst(105);
        list.addFirst(104);
        list.addFirst(103);
        list.addFirst(102);
        list.addFirst(101);
        list.addFirst(100);
        System.out.println(list);
        System.out.println("Size: "+list.size());

        System.out.println("Adding last");
        list.addLast(997);
        list.addLast(998);
        list.addLast(999);
        list.addLast(1000);
        System.out.println(list);

        // should not throw a null pointer exception.
        for(int i=0; i<1000; i++) {
            try {
                list.remove(0);
            } catch(Illegal e) {
                System.out.println("Illegal index");
                break;
            } catch(Empty e) {
                System.out.println("Empty list");
                break;
            }

        }
        System.out.println("Finished with tests of IntList.");
    }

}

