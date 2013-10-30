
class DoublyLinkedListCursor<T> implements Cursor {
	Node<T> pos;
	
	/**
	 * Create a new cursor that points to a node.
	 */
	public DoublyLinkedListCursor(Node<T> pos) {
		this.pos = pos;
	} // DoublyLinkedListCursor
}
