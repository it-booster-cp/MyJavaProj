import java.util.Date;

public class Threadtest implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Starte Main-Class");
		Thread t = new Thread(new Threadtest());
		t.start();
		System.out.println("Ende der Mains-Class!");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Bin in Run-Methode - hier passiert nichts");
		System.out.println("Mache sleep!");
		
		try {
			
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println("Step " + new Date());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new SKATDummy().langeSChleife();;
		
		
	
		System.out.println("Ende des Runs! Schluss.Finito!");
	}

}
