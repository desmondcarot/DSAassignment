/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;
/**
 *
 * @author Desmond
 */
public class StudentCLL<T> implements CircularLinkedListADT<T>{
    private Node<T> head;
    private int size;


    public StudentCLL(){
        head = null;
        size = 0;
    }

    @Override
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            head.next = head;
        }else{
            Node<T> current = head;
            while (current.next != head){
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
        size++;
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

    public void display() {
        Node <T> current = head;
        if (head != null){
            do{
                System.out.println(head.data.toString());
                head = head.next;
            }while (head!= current);
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
}
