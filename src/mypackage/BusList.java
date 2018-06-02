package mypackage;

import java.util.ListIterator;

public class BusList implements Iterable<Bus> {
	
	private Node top = new Node();
	
	@Override
	public ListIterator<Bus> iterator() {
	    return new ListIterator<Bus>() {
	    	
	        @Override
	        public boolean hasNext() {
	            return top.next != null;
	        }
	        
	        @Override
	        public boolean hasPrevious() {
	        	return top.prev != null;
	        }

	        @Override
	        public Bus previous() {
	        	Bus b = null;
	        	if(hasPrevious()) {
	        		top = top.prev;
	        		b = top.b;
	        	} 
	        	return b;
	        }

			@Override
			public Bus next() {	
				Bus b = top.b;
				if(hasNext())
					top = top.next;
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
				top.b = b;
			}

			@Override
			public void add(Bus b) {
				Node n = new Node(b);
				if(top == null) {
					top = n;
				} else {
					n.next = top;
					top.prev = n;
					top = n;
				}
			}

			@Override
			public void remove() {
				
			}
			
	    };
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
