package personal;

import places.*;
import resources.*;

public class Waiter extends Thread {

	private String name;
	private Order order;

	private Restaurant rest;
	private Stacks stacks;

	public Waiter(String name, Restaurant rest, Stacks stk) {
		this.name = name;
		this.rest = rest;
		stacks = stk;
	}

	public String getWtrName() {return name;}
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public void run() {
		while (true) {
			int cont = 0;

			try {
				int posTakeNote = rest.posTakeNote();
				if (posTakeNote != -1) {
					Utils.goSleep(3);
					rest.takeNote(posTakeNote, this);
					stacks.putToCook(order);
				} else {
					cont++;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			try {
				if (stacks.getNumCooked() > 0) {
					order = stacks.getCooked();
					rest.serve(order, this);
				} else {
					cont++;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			if(cont==2) {
				System.out.println(name + " is seeping and looking to the clients");
				Utils.goSleep(8);
			}
			cont = 0;

		}
	}

}
