import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyEventClass extends JFrame implements KeyListener {
	private int key;
	JTextArea outputfield;
    



	public JTextArea getOutputfield() {
		return outputfield;
	}

	public void setOutputfield(JTextArea outputfield) {
		this.outputfield = outputfield;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	KeyEventClass(){
        this.setLayout(new BorderLayout());
        JTextField field = new JTextField();
        field.addKeyListener(this);
        this.add(field, BorderLayout.CENTER);
        outputfield = new JTextArea("",60,80);
        outputfield.setSize(1000, 1000);
        this.add(outputfield, BorderLayout.SOUTH);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(500,600);
        this.setTitle("This is a test");
        this.setLayout(new GridLayout(5,5));
        this.setLocation(1200, 0);
        Font f=new Font("Arial", 30, 50);
		field.setFont(f);
		
//		JPanel panel = new JPanel();
//		panel.add(field);
//		panel.add(outputfield);
//		 
        // JButton mit Text "Drück mich" wird erstellt
        JButton button = new JButton("Drück mich");
 
        // JButton wird dem Panel hinzugefügt
//        panel.add(button);
//        this.add(panel);
        this.setVisible(true);
    }
	
	public void KeyEventClassxx(){
		String content="sss";
	    JFrame f = new JFrame("Text Area Examples");
	    JPanel upperPanel = new JPanel();
	    JPanel lowerPanel = new JPanel();
	    f.getContentPane().add(upperPanel, "North");
	    f.getContentPane().add(lowerPanel, "South");
	    
	    JTextField field = new JTextField();
        field.addKeyListener(this);

	    upperPanel.add(field);

	    lowerPanel.add(new JScrollPane(new JTextArea(content, 6, 8)));
	    outputfield = new JTextArea(content, 6, 8);
	    outputfield.setLineWrap(true);
	    lowerPanel.add(new JScrollPane(outputfield));

	    outputfield = new JTextArea(content, 6, 8);
	    outputfield.setLineWrap(true);
	    outputfield.setWrapStyleWord(true);
	    lowerPanel.add(new JScrollPane(outputfield));

	    f.pack();
	    f.setVisible(true);
	}

    public void keyTyped(KeyEvent e) {
//        System.out.println("KeyTyped: ");
        if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED){
//            System.out.println("Kein Unicode-Character gedr\u00FCckt!");
        }else{
//            System.out.println(e.getKeyChar() + " gedr\u00FCckt!");
        }
        System.out.println("---");
    }
    public void keyPressed(KeyEvent e) {
//        System.out.println("Taste: " + e.getKeyChar() + ", Code: " + e.getKeyCode());
//        System.out.println("Tastenposition: " + e.getKeyLocation());
//        System.out.println("---");
//        
//		Integer valueOf = Integer.valueOf(key);
//		System.out.println("valueOf: "+valueOf);
        setKey(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
//        System.out.println("KeyReleased: ");
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Programmabbruch!");
            System.exit(0);
        }    
//        System.out.println("Taste: " + e.getKeyChar() + ", Code: " + e.getKeyCode());
//        System.out.println("---");
        
        setKey(e.getKeyCode());
    }
    
    public static void main(String[] args) {
        new KeyEventClass();
    }
}