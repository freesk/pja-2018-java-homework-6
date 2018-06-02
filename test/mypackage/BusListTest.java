package mypackage;

import static org.junit.Assert.*;

import java.util.ListIterator;

import org.junit.Test;

public class BusListTest {

	@Test
	public void addingNewItems() {
		BusList list = new BusList();
		
		ListIterator<Bus> iterator = list.iterator();
		
		iterator.add(new Bus());
		iterator.add(new Bus());
		iterator.add(new Bus());
		
		
	}

}
