package resources;

public class Utils {
	
//	public int randomNumb(int sec) {
//		return (int) (Math.random()*1000*sec);
//	}

	public static void goSleep(int sec) {
		try {
			Thread.sleep((int) (Math.random()*1000*sec));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
