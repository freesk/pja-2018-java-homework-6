package mypackage;

import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BusListTest {
	
	BusList list = null;
	ListIterator<Bus> iterator = null;
	
	@Before
	public void setUp() throws Exception {		
		list = new BusList();
		iterator = list.iterator();
		
		try {
			iterator.add(new Bus("Bus-1", getDate(), 151515, 3000, 2, false, true));
			iterator.add(new Bus("Bus-2", getDate(), 151515, 3000, 2, false, true));
			iterator.add(new Bus("Bus-3", getDate(), 151515, 3000, 2, false, true));	
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void forEachLoop() {				
		int n = 0;
		
		try {
			for (Bus b : list) n++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Assert.assertEquals(3, n);	
	}
	
	@Test
	public void reverseLoop() {
		int n = 0;
		while (iterator.hasNext()) iterator.next();
		while (iterator.hasPrevious()) {
			iterator.previous();
		    n++;
		}
		Assert.assertEquals(3, n);	
	}
	
	@Test
	public void isCorrectSize() {				
		Assert.assertEquals(3, list.size());	
	}
	
	@Test
	public void removeTheFirstItem() {
		iterator.previous();
		iterator.previous();
		iterator.previous();
		
		iterator.remove();
		
		Assert.assertEquals(2, list.size());	
	}
	
	@Test 
	public void removeTheLastItem() {		
		iterator.remove();
		
		Assert.assertEquals(2, list.size());	
	}
	
	@Test 
	public void removeTheMiddleItem() {
		iterator.previous();
		
		iterator.remove();
		
		Assert.assertEquals(2, list.size());	
	}
	
	@Test 
	public void insertInTheMiddle() {
		iterator.previous();
		iterator.previous();
		
		Bus a = null;
		
		try {
			a = new Bus("Bus-4", getDate(), 151515, 3000, 2, false, true);
			iterator.add(a);	
		} catch (Exception e) {
			
		}
		
		Bus b = iterator.previous();
		
		Assert.assertEquals(true, a.equals(b));
	}
	
	
	public static Date getDate() {
		Date date = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, -1);
		date = c.getTime();
		return date;
	}

}
