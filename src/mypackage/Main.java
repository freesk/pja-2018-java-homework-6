package mypackage;

import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		
		BusList list = new BusList();
		
		ListIterator<Bus> iterator = list.iterator(); 
		
		System.out.println("add 3 records");
		try {
			iterator.add(new Bus("Bus-1", getDate(), 151515, 3000, 2, false, true));
			iterator.add(new Bus("Bus-2", getDate(), 151515, 3000, 2, false, true));
			iterator.add(new Bus("Bus-3", getDate(), 151515, 3000, 2, false, true));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("size: " + list.size());
		
		System.out.println("iterate with for-each");
		for (Bus b : list) System.out.println(b);
		
		ListIterator<Bus> i = list.iterator();
		
		System.out.println("iterate with while");
		
		while (i.hasNext()) {
			Bus item = i.next();
		    System.out.println(item);
		}
		
		System.out.println("reverse iterate with while");
		while (i.hasPrevious()) {
			Bus item = i.previous();
		    System.out.println(item);
		}
		
		System.out.println("go to the middle");
		System.out.println(iterator.previous());
		System.out.println(iterator.previous());
		
		System.out.println("add a new record");
		try {
			iterator.add(new Bus("Bus-4", getDate(), 151515, 3000, 2, false, true));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// new iterator 
		i = list.iterator();
		
		System.out.println("iterate with while");
		while (i.hasNext()) {
			Bus item = i.next();
		    System.out.println(item);
		}
		
		System.out.println("reverse iterate with while");
		while (i.hasPrevious()) {
			Bus item = i.previous();
		    System.out.println(item);
		}
		
		System.out.println("size: " + list.size());
		
		TrainList list2 = new TrainList();
		
		ListIterator<Train> iterator2 = list2.iterator(); 
		
		System.out.println("add 3 records");
		try {
			iterator2.add(new Train("Train-1", getDate(), 151515));
			iterator2.add(new Train("Train-2", getDate(), 151515));
			iterator2.add(new Train("Train-3", getDate(), 151515));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("iterate with for-each");
		for (Train t : list2) System.out.println(t);

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
