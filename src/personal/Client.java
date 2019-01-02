package personal;

import resources.*;
import places.Restaurant;

public class Client extends Thread {

	private String name;
	private Order order;
	private boolean waiting;

	private Restaurant rest;

	public Client(String name, String order, Restaurant rest) {
		this.name = name;
		this.order = new Order(order);
		this.rest = rest;
	}

	public void putDesk(int desk) {
		order.setDesk(desk);
	}

	public void setWaiting(boolean wait) {
		waiting = wait;
	}

	public Order getOrder() {
		return order;
	}

	public String getCltName() {
		return name;
	}

	@Override
	public void run() {

		try {
			rest.sitDown(this);
			// wait to be attend
			while (waiting)
				Utils.goSleep(1);
			// eat menu
			System.out.println(name + " starts to have lunch");
			Utils.goSleep(5);
			// finish and stand up
			System.out.println(name + " finish and go home");
			rest.standUp(this);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
