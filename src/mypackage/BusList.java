package mypackage;

import java.util.ListIterator;

public class BusList implements Iterable<Bus> {
	
	private Node entry = new Node();
	
	@Override
	public ListIterator<Bus> iterator() {
	    return new ListIterator<Bus>() {
	    	
	    	private Node head = entry;
	    	
	        @Override
	        public boolean hasNext() {
	            return head.next != null;
	        }
	        
	        @Override
	        public boolean hasPrevious() {
	        	return head.prev != null;
	        }

	        @Override
	        public Bus previous() {
	        	Bus b = null;
	        	if (hasPrevious()) {
	        		head = head.prev;
	        		b = head.b;
	        	} 
	        	return b;
	        }
	        
			@Override
			public Bus next() {	
				Bus b = head.b;
				if(hasNext()) head = head.next;
				return b;
			}

			@Override
			public int nextIndex() {
				return 0;
			}

			@Override
			public int previousIndex() {
				return 0;
			}

			@Override
			public void set(Bus b) {
				if (hasPrevious()) head.prev.b = b;
			}

			@Override
			public void add(Bus b) {
				Node n = new Node(b);
				if (hasPrevious()) {
					head.prev.next = n;
					n.prev = head.prev;
					n.next = head;
					head.prev = n;					
				} else {
					n.next = entry;
					entry.prev = n;
					entry = n;	
				}				
			}

			@Override
			public void remove() {				
				if (!hasPrevious()) {
					if (hasNext()) {
						entry.next = entry.next.next;
						entry.next.prev = entry;	
					}
				} else {
					head.prev = head.prev.prev;
					head.prev.next = head;
				}
			}
			
	    };
	}
	
	public int size() {
		int n = 0;
		ListIterator<Bus> i = iterator(); 
		for (; i.hasNext(); i.next()) n++;
		return n;
	}
		
	private class Node {
		
		private Bus b;
		private Node next;
		private Node prev;
		
		Node() {
			this.b = null;
			this.next = null;
			this.prev = null;
		}
		
		Node(Bus b) {
			this.b = b;
			this.next = null;
			this.prev = null;
		}
		
	}
	
}
