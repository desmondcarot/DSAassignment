package ADT;

public interface CircularListInterface<T extends Comparable<T>> extends Iterable<T> {
    
    /**
     * Add item of type T to the linked list
     * 
     * @param data the item to be added
     * @return true if the item is successfully added, false otherwise
     */
    boolean add(T data);
    boolean addSame(T data);
    void clear();
    
    /**
     * Removes the specified item from the circular linked list.
     * 
     * @param item the item to be removed
     */
    boolean remove(T item);

    /**
     * Checks if the circular linked list contains the specified item.
     * 
     * @param data the item to search for
     * @return true if the item is found, false otherwise
     * Make sure to override the equals method to get custom comparison for your object class
     */
    boolean contains(T data);

    /**
     * Displays all items in the circular linked list.
     */
    void display();

    /**
     * Gets the number of items in the circular linked list.
     * 
     * @return the size of the circular linked list
     */
    int size();
    
    /**
     * Updates an item in the circular linked list with a new value.
     * 
     * @param oldValue the old value to be updated
     * @param newValue the new value
     * @return true if the update is successful, false otherwise
     */
    boolean update(T oldValue, T newValue);

    /**
     * Converts the circular linked list into JSON format.
     * 
     * @return a JSON string representation of the circular linked list
     */
    String toJSON();

    boolean isEmpty();

    /**
     * Merges the current circular linked list with another circular linked list.
     * 
     * @param secondList the second circular linked list to be merged
     * @return true if the merge is successful, false otherwise
     */
    boolean merge(CircularListInterface<T> secondList);

    /**
     * Removes duplicate items from the circular linked list.
     * 
     * @return true if duplicates are removed, false otherwise
     */
    boolean removeDuplicates();

    /**
     * Sorts the circular linked list in ascending order.
     * 
     * @return true if the list is successfully sorted, false otherwise
     */
    boolean sort();

    /**
     * Gets the head node of the circular linked list.
     * 
     * @return the head node of the circular linked list
     */
    CLinkedList<T>.Node<T> getHead();

    /**
     * Gets the head node of the circular linked list.
     * @param dataref takes an instance of a reference object you want to get from the list.
     * @return an instance of the object that matches the reference object from the list.
     * Make sure to override the equals method to get custom comparison
     */
    T getData(T dataref );


}