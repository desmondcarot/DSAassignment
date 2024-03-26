package ADT;

public interface CircularLinkedListADT<T> {
    boolean add(T data);
    void remove(T data);
    void display();
    int size();
    String toJSON();
    // You can add more methods as needed


    
}