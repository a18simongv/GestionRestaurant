package places;

import java.util.concurrent.Semaphore;

import personal.Cooker;
import resources.Utils;

public class Kitchen {

	private Semaphore cookers = new Semaphore(2);
	
	public int cook(Cooker cooker) {
		
		if (cookers.tryAcquire()) {
			
			System.out.println(cooker.getCkName() +" starts to cook");
			Utils.goSleep(8);
			cookers.release();
			return 1;
			
		} else {
			System.out.println(cooker.getCkName() +" is peeling potatoes and cutting vegetables");
			Utils.goSleep(3);
			return 0;
		}
		
	}
	
}
