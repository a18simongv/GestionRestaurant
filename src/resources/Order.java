package resources;

public class Order {

	private String order;
	private int desk;

	public Order(String order) {
		this.order = order;
	}

	public String getOrder() {
		return order;
	}

	public int getDesk() {
		return desk;
	}
	public void setDesk(int desk) {
		this.desk = desk;
	}
}
