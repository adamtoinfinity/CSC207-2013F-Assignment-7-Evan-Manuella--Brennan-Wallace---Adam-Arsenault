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
    	Cursor newIterator = new Cursor(front);
        return (Iterator<T>) newIterator; 
    } // iterator()

    // LISTOF METHODS
    public void insert(T val, Cursor c) throws Exception {
         
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

    public void prepend(T val) throws Exception { //copied from eboard
    	    // Create a new node, with T as a val and front as next
    	Node newFront = new Node(val); 
    	
    	newFront.next = this.front; 
    	this.front = new Node(val);
    	if (this.back == null){
    		this.back = newFront;
    	}
    	} // prepend(T)
    } // prepend(T)

    
    
    public void delete(Cursor c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // delete(Cursor)

    public Cursor front() throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // front()

    public void advance(Cursor c) throws Exception {
        	c.pos = c.pos.next;
        	//how do we throw an exception if pos.next is null, lets use has next instead
    } // advance(Cursor)

    public void retreat(Cursor c) throws Exception {
        c.pos = c.pos.prev;
        //same deal as advance, i hate exceptions i know its easy but im not sure what a good google would be
    } // retreat(Cursor)

    public T get(Cursor c) throws Exception {
        throw new UnsupportedOperationException("STUB");
        //what is before the curser it potints right to a pos
    } // get

    public T getPrev(Cursor c) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // getPrev(Cursor)

    public boolean hasNext(Cursor c) {
        if (c.pos.next != null){
        	return true;
        }
        else {
    	return false;
        }
    } // hasNext

    public boolean hasPrev(Cursor c) {
        if (c.pos.prev != null){
        	return true;
        }
        else {
    	return false;
        }
    } // hasPrev

    public void swap(Cursor c1, Cursor c2) throws Exception {
        Node temp = c1.pos;
        c1.pos = c2.pos;
        c2.pos = temp;  	
    } // swap(Cursor, Cursor)

    public boolean search(Cursor c, Predicate<T> pred) throws Exception {
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
    public ListOf<T> subList(Cursor start, Cursor end) throws Exception {
        throw new UnsupportedOperationException("STUB");
    } // subList(Cursor, Cursor)
    /**
     * Determine if one iterator precedes another iterator.
     */
    public boolean precedes(Cursor c1, Cursor c2) throws Exception {
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
*
*
*/


//
//_Overview_
//
//* Preliminaries.
//    * Admin.
//    * About the exam.
//* Making our list interface generic.
//* Beyond our own design: The collections API.
//
//_Admin_
//
//* No readings for Monday.  Work on the exam!
//* Upcoming extra credit opportunities
//    * Codebreaker Friday night at 7pm in Harris.
//    * Codebreaker discussion after the movie.
//* Drake Library book sale this weekend
//* I already have corrections to the exam, but have not made them.  Keep
//  sending them in.
//* I should have the repo up soon.
//* Cool booksale this weekend.
//* 10/10 is this weekend.  Please behave responsibly.  Please take care of
//  yourself and each other.
//    * And lock your doors
//    * And help the people on Cowles and Younker 1st recover
//* EC for going to Wartburg this weekend and cheering on Xcountry
//
//_Exam Questions_
//
//* What's the name of the class that sorts for DNF (DNF.dnf).
//* Can DNF.dnf throw exceptions?  No.  If you fail to meet preconditions,
//  it can do whatever it wants.
//* Do we have to deal with incorrect inputs for DNF.dnf?  No.  You just want
//  to make sure that it works correctly with correct inputs.
//* For problems 4 and 5, do we just have to implement the STUBs, or add procedures.
//    * Just finish the STUBs.
//* Can you explain a bit more about what you want for loop invariants?
//    * A loop invariant is a condition/assesrtion that, if holds at beginning of
//      the loop, also holds at the end.
//    * Specific enough that it helps you understand the problem.
//    * General enough that you can guarantee that it holds.
//    * Note: The invariant can be temporarily invalidated in the middle
//    * For this problem, the only things we know about are:
//        * The total number of beans in the jar
//        * The number of dark beans
//        * The number of light beans
//
//Making our list interface generic
//---------------------------------
//
//* How do we generalize the following so that it works for Integers or 
//  UshahidiIncidents, or BigDecimals, or whatever?
//* Strategy one (early Java): Use Objects
//     * Yay polymorphism!  We can put Strings or UshahidiIncidents or ...
//       into the list.
//     * And our lists can be heterogeneous - We can have an Integer and a String
//* But heterogeneity can be problematic.  How do you map or sort or .... a
//  heterogeneous list?
//     * Java philosophy: Catch possible type errors at compile time rather than
//       run time
//         Scheme: (define whatever (x) (* x x))
//         ...
//         (define morestuff (fun y)
//            (whatever (fun y)))
//        Java wants to know before you run the program whether you'll have
//          type errors.
//* Java redesign: Allow "generic" structures that still do some kind of type checking,
//  so that we can enforce type safety.
//* Soln': Parameterize a class definition ("Generics")
//     class ListOf<Type>
//        we can plug in type variables, much like we plug in variables elsewhere
//
//     ListOf<Integer> grades;
//     ListOf<Student> csc207;
//     ListOf<Object> randomCrapInSamsOffice;
//       and ...
//
//    /**
//     * Lists have cursors/iterators, which fall between elements (or before
//     * the first element or after the last element).
//     */
//    public interface ListOf<Type> {
//        // Adding Elements
//        
//        /**
//         * Insert an element at the location of the cursor (between two
//         * elements).
//         *
//         * @pre
//         *   lit must be associated with the list and in the list.
//         *
//         * @throws Exception
//         *   If the precondition is not met.
//         * @throws Exception
//         *   If there is no memory to expand the list.
//         *
//         * @post
//         *   The previous elemetn to the iterator remains the same
//         *   str is immediately after the iterator
//         *   The element that previously followed the iterator follows str
//         *   And writing postconditions is a PITN
//         */
//        public void insert(Type str, ListIterator<Type> lit) throws Exception;
//
//        /**
//         * Add an element to the end of the list.  (Creates a one-element
//         * list if the list is empty.)
//         *
//         * @throws Exception
//         *   If there is no memory to expand the list.
//         */
//        public void append(Type str) throws Exception;
//
//        /**
//         * Add an element to the front of the list.  (Creates a one-element
//         * list if the list is empty.)
//         *
//         * @throws Exception
//         *   If there is no memory to expand the list.
//         */
//        public void prepend(Type str) throws Exception;
//
//        // Removing Elements
//        /**
//         * Delete the element immediately after the iterator.
//         *
//         * @post
//         *    The remaining elements retain their order.
//         * @post
//         *    The iterator is at the position
//         *    The successor of the element immediately before the iterator
//         *      is the successor of the now-deleted element.
//         */
//        public void delete(ListIterator<Type> lit);
//
//        // Iterating Lists
//        /**
//         * Get an iterator right before the front of the list.
//         *
//         * @throws Exception
//         *   If the list is empty.
//         */
//        public ListIterator<Type> front() throws Exception;
//
//        /**
//         * Advance to the next position between elements
//         *
//         * @pre
//         *   The list has a next element.
//         * @throws Exception
//         *   If there is no next element.
//         */
//        public void advance(ListIterator<Type> it) throws Exception;
//
//        /**
//         * Get the element immediately following this iterator.
//         *
//         * @pre
//         *   it is valid and associated with this list.
//         * @throws Exception
//         *   If the preconditions are not met.
//         */
//        public Type get(ListIterator<Type> it) throws Exception;
//
//        /**
//         * Get the element immediately before this iterator.
//         */
//        public Type getPrev(ListIterator<Type> it) throws Exception;
//
//        /**
//         * Determine if it's safe to advance to the next position.
//         *
//         * @pre
//         *   pos is valid and associated with the list.
//         */
//        public boolean hasNext(ListIterator<Type> it);
//
//        // Other operations
//
//        /**
//         * Swap the elements at the positions the corresopnd to it1 and it2.
//         *
//         * @pre
//         *   Both it1 and it2 are valid and associated with this list.
//         *   v1 = get(it1), v2 = get(it2)
//         * @post
//         *   it1 and it2 are unchanged.
//         *   v1 = get(it2), v2 = get(it1)
//         */
//        public void swap(ListIterator<Type> it1, ListIterator<Type> it2);
//
//        /**
//         * Search for a value, moving the iterator to that value.
//         *
//         * @return true, if the value was found
//         * @return false, if the value was not found
//         *
//         * @post If the value is not found, the iterator has not moved.
//         * @post IF the value is found, get(it) is value
//         */
//        public boolean search(ListIterator<Type> it, Type val);
//
//        /** 
//         * Grab a sublist.  (Detailed discussion not included.)
//         *
//         * @pre
//         *    Valid iterators.
//         *    start precedes end.
//         * @throws Exception
//         *    If the iterators are invalid.
//         */
//        public ListOf<Type> subList(ListIterator<Type> start, ListIterator<Type> end)
//           throws Exception;
//
//        /**
//         * Determine if one iterator precedes another iterator.
//         */
//        public boolean precedes(ListIterator<Type> it1, ListIterator<Type> it2);
//    } // interface ListOf<Type>
//
//Continuing the example
//
//     ListOf<Integer> grades;
//     ListOf<Student> csc207;
//     ListOf<Object> randomCrapInSamsOffice;
//     ...
//     grades.prepend(5);
//     csc207.prepend(5); // COMPILATION ERROR!  5 is not of the appropriate type
//     Professor SamR = ...;
//     csc207.prepend(SamR); // COMPILATION ERROR!  SamR is not a student
//
//     ListOf<Person> grinnellcs;
//     grinnellcs.prepend(SamR);  // OKAY, Profesor is a subtype of person, whether or
//                                //   not most students believe that claim
//     grinnellcs.prepend(new Student("A", "A", "A");
//    
//
//Beyond our own design: The collections API
//
//* At some point, the designers of Java said "Everyone is going to build these 
//  ADTs, so let's just put them in the language".
//* Benefits
//     * Standardized: Easier for someone joining a project to understand the interface
//     * Programmers become more efficient.  (Of course, good programmers already
//       have their libraries that the plug in to whatever project the use.)
//     * Subclassing might allow you to customize.
//     * Likely to be well tested and implemented.
//* Disadvantages
//     * You don't know what's going on behind the scenes - efficiency issues
//     * You might not understand the documentation (because you and the
//       documenters think differently)
//     * If you only use prebuilt ADTs and switch to a new language that doesn't,
//       you'll be clueless as to how to design your own.
//     * Sometimes you will have to change your client code to match the
//       standard ADT.
    