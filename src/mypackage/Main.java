package mypackage;

import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		
		BusList list = new BusList();
		
		ListIterator<Bus> iterator = list.iterator(); 
		
		Date date = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, -1);
		date = c.getTime();
		
		try {
			iterator.add(new Bus("Bus-1", date, 151515, 3000, 2, false, true));
			iterator.add(new Bus("Bus-2", date, 151515, 3000, 2, false, true));
			iterator.add(new Bus("Bus-3", date, 151515, 3000, 2, false, true));
			iterator.add(new Bus("Bus-4", date, 151515, 3000, 2, false, true));	
			iterator.add(new Bus("Bus-5", date, 151515, 3000, 2, false, true));	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (Bus b : list) {
			System.out.println(b);
		}
		
//		for (ListIterator<Bus> i = list.iterator(); i.hasNext();) {
//			Bus item = i.next();
//		    System.out.println(item);
//		}
		
		for (ListIterator<Bus> i = list.iterator(); i.hasPrevious();) {
			Bus item = i.previous();
		    System.out.println(item);
		}
				
	}

}
