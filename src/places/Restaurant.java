package places;

import java.util.concurrent.Semaphore;

import personal.*;
import resources.Order;

public class Restaurant {

	private Client[] desks;
	private boolean[] waiting;

	// semaphores
	private Semaphore clients;

	public Restaurant(int numDesks) {

		desks = new Client[numDesks];
		waiting = new boolean[desks.length];

		clients = new Semaphore(desks.length);
	}

	// --------------------------Clients-----------------------------------//

	public void sitDown(Client clt) throws Exception {
		clients.acquire();

		int desk = 0;
		while (desks[desk] != null && desk < desks.length - 1)
			desk++;

		desks[desk] = clt;
		waiting[desk] = true;
		clt.setWaiting(true);
		clt.putDesk(desk);

		System.out.println(clt.getCltName() + " sit down in desk " + desk);
	}

	public void standUp(Client clt) {
		int desk = clt.getOrder().getDesk();

		desks[desk] = null;
		clients.release();
	}

	// -------------------------------------------------------------------//
	// --------------------------Waiters-----------------------------------//
	public int posTakeNote() {

		int desk = 0;
		while (waiting[desk] == false && desk < desks.length - 1)
			desk++;

		if (waiting[desk] == false) {
			desk = -1;
		} else {
			waiting[desk] = false;
		}

		return desk;

	}

	public void takeNote(int pos, Waiter waiter) {
		waiter.setOrder(desks[pos].getOrder());
		System.out.println(desks[pos].getCltName() + " is waiting to be served");
	}
	
	public void serve(Order order, Waiter waiter) {
		System.out.println(waiter.getWtrName() + " serve " + desks[order.getDesk()].getCltName());
		desks[order.getDesk()].setWaiting(false);
	}

	// -------------------------------------------------------------------//

}
