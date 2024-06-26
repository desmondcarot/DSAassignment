package ADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CLinkedList<T extends Comparable<T>> implements CircularListInterface<T>{
    private Node<T> head;
    private int size;


    //Constructor initializes the variables
    public CLinkedList(){
        head = null;
        size = 0;
    }

    //Add method, first it checks if the list is empty, if it is empty, the newNode is the head. 
    //if its not empty, it will iterate 
    @Override
    public boolean add(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
        head = newNode;
        head.next = head;
    } else {
        Node<T> current = head;
        // Traverse the list until the last node
        while (current.next != head) {
            if (data.equals(current.data)) {
                // Duplicate data found, return false
                return false;
            }
            current = current.next;
        }
        if (data.equals(current.data)) {
            return false;
        }
        current.next = newNode;
        newNode.next = head;
    }
    sort();
    size++;
    return true;
}

    public boolean addSame(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
        size++;
        return true;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    

    @Override
    public boolean remove(T item){
        if (head == null){
            return false; // list is empty
        }
        else{
            //remove if first node matches item
            if (head.data.equals(item)){
                //checks if the item removed is the head and is the last item
                if (head.next == head){
                    clear();

                //checks if the head is the item is removed but maintain the rest of item
                }else{ 
                    Node<T> last = head;
                    while (last.next != head){
                        last = last.next;
                    }
                    last.next = head.next;
                    head = head.next;
                }
                size--;
                return true;
            }
        }

        Node<T> current = head;
        Node<T> prev = null;

        do { // handle removal of nodes other than head.
            if (current.data.equals(item)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        return false;
    }

    public boolean contains(T data) {
        if (head != null) {
            Node<T> current = head;
            do {
                if (current.data.equals(data)) {
                    return true;
                }
                current = current.next;
            } while (current != head);
        }
        return false;
    }

    public void display() {
        if (head != null) {
            Node<T> current = head;
            do {
                System.out.println(current.data.toString());
                current = current.next;
            } while (current != head);
        }
    }

    @SuppressWarnings("hiding")
    public class Node<T>{
        Node<T> next;
        T data;

        public Node (T data){
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public boolean update(T oldValue, T newValue) {
        if (head == null) {
            return false; // List is empty, no elements to update
        }
    
        Node<T> current = head;
        do {
            if (current.data.equals(oldValue)) {
                current.data = newValue; // Update the data of the node
                return true; // Update successful
            }
            current = current.next;
        } while (current != head);
    
        return false; // Node with oldValue not found
    }

    //Converts the list into JSON, returns JSON String
    //Requires the dataclass toString Method to return JSON obj string
    @Override
    public String toJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        if (head != null) {
            Node<T> current = head;
            boolean isFirst = true;
            do {
                if (!isFirst) {
                    jsonBuilder.append(",");
                } else {
                    isFirst = false;
                }
                jsonBuilder.append(current.data.toString());
                current = current.next;
            } while (current != head);
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean merge (CircularListInterface<T> secondList){

        Node<T> current = head;
        if (secondList == null || secondList.isEmpty()){
            return false;
        }

        if (this.isEmpty() || this.head == null){
            this.head = secondList.getHead();
            this.size = secondList.size();
            return true;
        }
        
        while(current.next != head){
            current = current.next;
        }
        //make current last node reference the secondlist head
        current.next = secondList.getHead();
        this.size += secondList.size();

        //get last node of second list
        Node<T> secondListLast = secondList.getHead();
        do{
            secondListLast = secondListLast.next;
        }while(secondListLast.next != secondList.getHead());
        
        //make second list last node point to the current head maintaining circularity.
        secondListLast.next = this.head;
        return true;
    }


    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current;
        private boolean firstIteration;
    
        public LinkedListIterator() {
            current = head;
            firstIteration = true;
        }
    
        @Override
        public boolean hasNext() {
            return current != null && (firstIteration || current != head);
        }
    
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements to iterate over.");
            }
            if (firstIteration) {
                firstIteration = false;
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    //MergeSort method (recursive)
    @Override
    public boolean sort() {
        if (head == null || head.next == head) {
            // If the list is empty or has only one element, it's already sorted
            return false;
        }
        //temporarily unlinked the circular linked list
        Node<T> lastNode = head.next;
        while (lastNode.next != head){
            lastNode = lastNode.next;
        }
        lastNode.next = null;

        head = mergeSort(head);
        //linked back the circular linked list
        Node<T> newLastNode = head.next;
        while (newLastNode.next != null){
            newLastNode = newLastNode.next;
        }
        newLastNode.next = head;
        
        return true;
    }


    //Start = head
    private Node<T> mergeSort(Node<T> start) {
        if (start == null || start.next == null) {
            // Base case: If the list is empty or has only one element, it's already sorted
            return start;
        }

        // Find the middle node of the list
        Node<T> middle = getMiddle(start);
        Node<T> nextOfMiddle = middle.next;

        // Split the list into two halves
        middle.next = null;

        // Recursively sort the two halves
        Node<T> left = mergeSort(start);
        Node<T> right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        return merge(left, right);
    }

    private Node<T> getMiddle(Node<T> start) {
        if (start == null || start.next == null) {
            // Base case: If the list is empty or has only one element, return the start
            return start;
        }
    
        Node<T> slow = start;
        Node<T> fast = start;
    
        //move fast 2 step while slow 1 step
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        

        //fast will reach end while slow will reach halfway which is the middle node
        return slow;
    }

    private Node<T> merge(Node<T> left, Node<T> right) {
        Node<T> result = null;

        // Base cases
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
    // Compare the data of the nodes and merge them in ascending order
        if (left.data.compareTo(right.data) <= 0) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    public T getData(T dataref){
        Node<T> current = null;
        if (head != null) {
            current = head;
            do {
                if (current.data.equals(dataref)) {
                    return current.data;
                }
                current = current.next;
            } while (current != head);
        }
        return null;
    }

    public CLinkedList<T>.Node<T> getTail() {
        Node<T> current = head;
        while(current.next != head){
            current = current.next;
        }
        return current;
    }


    @Override
    public CLinkedList<T>.Node<T> getHead() {
        return this.head;
    }
}
