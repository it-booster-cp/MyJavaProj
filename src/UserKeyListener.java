
public class UserKeyListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyEventClass keyEventClass = new KeyEventClass();
		int key = keyEventClass.getKey();

		
		
		while(key!=83){
			key = keyEventClass.getKey();
//			System.out.println(key);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(key==65){
				
			keyEventClass.getOutputfield().setText(keyEventClass.getOutputfield().getText()+"\n mami");
			}
		}
		System.out.println("ENDE");
	}

}
