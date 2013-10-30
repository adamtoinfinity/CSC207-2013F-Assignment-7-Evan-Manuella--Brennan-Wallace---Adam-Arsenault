import java.util.Iterator;
/*
 * hey evan i think i have a much better understanding of what we need to do:
 * basically to implement this we need to look at the ListOf interface and make these 
 * match the description there I didnt know the description were there at first so I 
 * was unsure what to do. Any ways it hink I go through a lot of them but there there
 * are issues with exception, the types (what we were running into earlier) and exceptions
 * 
 */


/**
 * Doubly linked lists.
 */
public class DoublyLinkedList<T> implements ListOf<T> {

    // FIELDS


	Node<T> front;
	Node<T> back;
	
	
    // CONSTRUCTORS
    /**
     * Create a new linked list.
     */
    public DoublyLinkedList() {
    } // DoublyLinkedList

    // ITERABLE METHODS
    /**
     * Get a standard interator at the front of the list.
     */
    @Override
    public Iterator<T> iterator() {
    	
    	// Create a new iterator, set it equivelant to a cursor
    	//
    	// return a iterator
    	
    	//Cursor<T> newIterator = new Cursor<T>() ;
    	 //DoublyLinkedListCursor<T> d1 = new DoublyLinkedListCursor<T>(this.front);
    	
    	
    	//black magic vvv
    	return (Iterator<T>) new DoublyLinkedListCursor<T>(this.front); 
    } // iterator()

    // LISTOF METHODS
    
    /**
     * Insert an element at the location of the Cursor<T> (between two
     * elements).
     *
     * @pre
     *   lit must be associated with the list and in the list.
     *
     * @throws Exception
     *   If the precondition is not met.
     * @throws Exception
     *   If there is no memory to expand the list.
     *
     * @post
     *   The previous element to the iterator remains the same
     *   str is immediately after the iterator
     *   The element that previously followed the iterator follows str
     *   And writing postconditions is a PITN
     */

    public void insert(T val, Cursor<T> c) throws Exception {
    	Node toInsert = new Node(val);  
    	if(this.front.equals(null)){
        	 
        	 this.front = toInsert;
        	 this.back = toInsert;
         }
         else{
        	DoublyLinkedListCursor<T> d = (DoublyLinkedListCursor<T>) c;
        	d.pos.prev.next = toInsert;
         }
    	
    } // insert(T, Cursor)
    /**
     * Add an element to the end of the list.  (Creates a one-element
     * list if the list is empty.)
     *
     * @throws Exception
     *   If there is no memory to expand the list.  <<<< how shall we do this how do we run out of memory since its a linked list?
     */
    public void append(T val) throws Exception {
    	// Create a new node with val and no successor
    	// Update the former back of the list to make this new node the next node
    	this.back.next =  new Node(val);
    	// Update our notion of the back of the list
    	this.back = this.back.next;
    	if (this.front == null){
    		this.front = this.back;
    	} // append(T)
    }
    public void prepend(T val) throws Exception { //copied from eboard
    	// Create a new node, with T as a val and front as next
    	Node newFront = new Node(val); 

    	newFront.next = this.front; 
    	this.front = new Node(val);
    	if (this.back == null){
    		this.back = newFront;
    	}
    } // prepend(T)



    public void delete(Cursor<T> c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // delete(Cursor)

    public Cursor<T> front() throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // front()

    public void advance(Cursor<T> c) throws Exception {
        	c.pos = c.pos.next;
        	//how do we throw an exception if pos.next is null, lets use has next instead
    } // advance(Cursor)

    public void retreat(Cursor<T> c) throws Exception {
        c.pos = c.pos.prev;
        //same deal as advance, i hate exceptions i know its easy but im not sure what a good google would be
    } // retreat(Cursor)

    public T get(Cursor<T> c) throws Exception {
        throw new UnsupportedOperationException("STUB");
        //what is before the curser it potints right to a pos
    } // get

    public T getPrev(Cursor<T> c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // getPrev(Cursor)

    public boolean hasNext(Cursor<T> c) {
        if (c.pos.next != null){
        	return true;
        }
        else {
    	return false;
        }
    } // hasNext

    public boolean hasPrev(Cursor<T> c) {
        if (c.pos.prev != null){
        	return true;
        }
        else {
    	return false;
        }
    } // hasPrev

    public void swap(Cursor<T> c1, Cursor<T> c2) throws Exception {
        DoublyLinkedListCursor<T> d1 = (DoublyLinkedListCursor<T>) c1;
        DoublyLinkedListCursor<T> d2 = (DoublyLinkedListCursor<T>) c2;
    	Node<T> temp = d1.pos;
        d1.pos = d2.pos; //wrong
        d2.pos = temp;  	
    } // swap(Cursor, Cursor) need to do underlying not just what they are pointing to

    public boolean search(Cursor<T> c, Predicate<T> pred) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // search(Cursor, Predicate<T>)
     
    public ListOf<T> select(Predicate<T> pred) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // select(Predicate<T>)
    /** 
     * Grab a sublist.  (Detailed discussion not included.)
     *
     * @pre
     *    Valid iterators.
     *    start precedes end.
     * @throws Exception
     *    If the iterators are invalid.
     */
    public ListOf<T> subList(Cursor<T> start, Cursor<T> end) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // subList(Cursor, Cursor)
    /**
     * Determine if one iterator precedes another iterator.
     */
    public boolean precedes(Cursor<T> c1, Cursor<T> c2) throws Exception {
        new Node current = this.front;
        //the order of teh ifs maters
        while (current != null){
        	if (current == c2.pos){
        		return false;
        	}
        	else if (current == c1.pos){
        		return true;
        	}
        	current = current.next;                          
        }
        return false;
        /*
         * We may want to throw some errors
         * 
         */
        
    } // precedes(Cursor, Cursor)
} // class DoublyLinkedList



/*
*
*Worked from 3 to 4:40
*Worked from 10:15 to 11:35
*Worked from 2:50 to 
*
*/


