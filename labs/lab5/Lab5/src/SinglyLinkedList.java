public class SinglyLinkedList<I extends Number> {

    private static class Node<Integer> {
        private Integer element;
        private Node<Integer> next;
        private Node<Integer> penultimate;

        public Node(Integer e, Node<Integer> n) {
            element = e;
            next = n;
            penultimate = null;
        }

        public Integer getElement() {
            return element;
        }

        public Node<Integer> getNext() {
            return next;
        }

        public void setNext(Node<Integer> n) {
            next = n;
        }

        public Node<Integer> penultimate(Node<Integer> head) {
            Node<Integer> current = head;
            while (current != null) {
                if (head.getNext() == null) {
                    penultimate = head;
                } else {
                    current = current.getNext();
                }
            }
            return penultimate;
        }
    }

    private Node<Integer> head = null;
    private Node<Integer> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public Integer last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(Integer i) {
        head = new Node<>(i, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(Integer i) {
        Node<Integer> newest = new Node<>(i, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
            tail = newest;
            size++;
        }
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Integer answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    public void getPenultimate() {

        if (isEmpty()) {
            System.out.println("List is empty. Please check.");
        } else {
            System.out.println("The second last node is: " + head.penultimate(head));
        }

    }

    public static void main(String[] args) {
       SinglyLinkedList<Integer> q=new SinglyLinkedList<>();
        q.addFirst(45);
        q.addFirst(2);
        q.addLast(3);
        q.addFirst(4);
        q.addLast(5);
        System.out.println("size="+q.size());

        q. getPenultimate();


    }
}