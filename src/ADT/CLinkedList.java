/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Desmond
 */
public class CLinkedList<T> implements CircularLinkedListADT<T>, Iterable<T>{
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
            head.next = head; // Link head to itself to make it circular
        } else {
            Node<T> current = head;
            // Find the last node in the list
            while (current.next != head) {
                current = current.next;
                if (newNode.data.equals(current.data)){
                    return false;
                }
            }
            current.next = newNode;
            newNode.next = head;
        }
        size++;
        return true;
    }

    @Override
    public void remove(T item){
        if (head == null){
            System.out.println("list is empty");
            return;
        }else{
            if (head.data.equals(item)){
                if (head.next == head){
                    head.next = null;
                }else{ 
                    Node<T> last = head;
                    while (last.next != head){
                        last = last.next;
                    }
                    last.next = head.next;
                    head = head.next;
                }
                size--;
                return;
            }
        }

        Node<T> current = head;
        Node<T> prev = null;

        do {
            if (current.data.equals(item)) {
                prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
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
            var first = firstIteration;
            var equalhead = current != head;
            var currentNull = current != null;
            var nice = (currentNull && (first || equalhead));
            return nice;
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
}
