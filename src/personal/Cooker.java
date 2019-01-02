package personal;

import places.Kitchen;
import resources.*;

public class Cooker extends Thread {

	private String name;
	private Order order;

	private Kitchen kitchen;
	private Stacks stacks;

	public Cooker(String name, Kitchen kitchen, Stacks stacks) {
		this.name = name;
		this.kitchen = kitchen;
		this.stacks = stacks;
	}

	public String getCkName() {
		return name;
	}

	@Override
	public void run() {

		while (true) {

			try {

				if (stacks.getNumToCook() > 0) {
					order = stacks.getToCook();
					int aux = 0;
					while (aux != 1) {
						aux = kitchen.cook(this);
					}
					stacks.putCooked(order);
				} else {
					System.out.println(name +" is peeling potatoes and cutting vegetables");
					Utils.goSleep(3);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

}
