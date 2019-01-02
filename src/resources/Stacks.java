package resources;

import java.util.LinkedList;

//¡¡¡¡¡¡¡¡¡¡¡OJO MIRAR SI PUEDEN ACCEDER AL MISMO TIEMPO A LAS DOS LISTAS(deberian)!!!!!!!!
public class Stacks {
	
	private static int numToCook = 0, numCooked = 0;
	
	private LinkedList<Order> toCook;
	private LinkedList<Order> cooked;
	
	//variables to control access
	private boolean takenCooked, takenToCook;

	public Stacks() {
		toCook = new LinkedList<>();
		cooked = new LinkedList<>();
		
		takenCooked = false;
		takenToCook = false;
	}
	
	public synchronized void putToCook(Order order) throws Exception{
		while(takenToCook) {
			wait();
		}
		
		takenToCook = true;
		Utils.goSleep(2);
		toCook.add(order);
		numToCook++;
		takenToCook = false;
		
		notify();
	}
	public synchronized Order getToCook() throws Exception{
		while(takenToCook) {
			wait();
		}
		
		takenToCook = true;
		Utils.goSleep(2);
		Order order = toCook.poll();
		numToCook--;
		takenToCook = false;
		
		notify();
		return order;
	}
	
	public synchronized void putCooked(Order order) throws Exception{
		while(takenCooked) {
			wait();
		}
		
		takenCooked = true;
		Utils.goSleep(2);
		cooked.add(order);
		numCooked++;
		takenCooked = false;
		
		notify();
	}
	public synchronized Order getCooked() throws Exception{
		while(takenCooked) {
			wait();
		}
		
		takenCooked = true;
		Utils.goSleep(2);
		Order order = cooked.poll();
		numCooked--;
		takenCooked = false;
		
		notify();
		return order;
	}
	
	public synchronized int getNumToCook() { return numToCook;}
	public synchronized int getNumCooked() { return numCooked;}
	
}
