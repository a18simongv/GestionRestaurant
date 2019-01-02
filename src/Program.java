
import personal.*;
import places.*;
import resources.Stacks;

public class Program {

	public static void main(String[] args) {
		Restaurant rest = new Restaurant(10);
		Stacks stacks = new Stacks();
		Kitchen kitchen = new Kitchen();
//		Client clt = new Client("pepe","azucar",rest);
		Client[] clt = new Client[20];
		Waiter[] waitrs = new Waiter[5];
		Cooker[] cookrs = new Cooker[3];
		
		for(int i=0; i<clt.length; i++) {
			clt[i] = new Client("Client-"+i,"order-"+i,rest);
			clt[i].start();
		}
		for(int i=0; i<waitrs.length; i++) {
			waitrs[i] = new Waiter("Waiter-"+i,rest,stacks);
			waitrs[i].start();
		}
		for(int i=0; i<cookrs.length; i++) {
			cookrs[i] = new Cooker("Cooker-"+i,kitchen,stacks);
			cookrs[i].start();
		}
	}
	
}
