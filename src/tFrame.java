import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.swing.*;

import javazoom.jl.player.Player;
/*
 * This class was mostly a test for a big button that played audio. The button worked but i have removed it. 
 * The play method is used in MFrame
 * So a lot of things in this class are irrelevant but I am keeping them in case I want to use or reference them later.
 * The play method uses a custom library a peer found online. He helped me implement it and do not claim it as my own.
 */
public class tFrame extends JFrame implements ActionListener {
//	JButton td4w2;
	public String filename;
	private Player player;	
	
	
	public tFrame(String fileName) {
		System.out.println("hihihihi");
		
		
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		this.init(fileName);

		this.setTitle("td4w");
	}
	public void init(String name) {
    	filename = name;
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setLocation(dim.width/4, dim.height/4);
//		td4w2 = new JButton("#TD4W");
//		td4w2.setToolTipText("test");
//		td4w2.addActionListener(new ButtonListener40());
//		td4w2.setPreferredSize(new Dimension(500,500));
//		this.add(td4w2);				
//
//		this.setLayout(new FlowLayout());
//		this.pack();
//		this.setVisible(true);
//
//	}
//	
//	class ButtonListener40 implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			// TODO Auto-generated method stub
//			System.out.println("td4w");
//			play();
//			
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	public void play() {
        try {

            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
            player.play();
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }
	}

}
	
	
	
	

	

