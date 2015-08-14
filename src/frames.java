import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.JTextComponent;


/*
 * Hello sorry this is messy code, a lot of it was hacked together to get it to work. Definitely not the most efficient program...
 * The file reader and saver was taken from the internet and implemented along with help from peers.
 */


public class frames extends JFrame {
	static JTextField unl;
	JButton okay, cancel, register;
	JPasswordField pswd;
	ArrayList<String> arr = new ArrayList<String>();
	
	
	JFrame ob = this;

	frames(String title) {
		super(title);

		this.init();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	void init() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/4, dim.height/4);
		readFile();
		JLabel userNameLabel = new JLabel("Enter username");
		JLabel passwordLabel = new JLabel("Password");

		pswd = new JPasswordField(10);
		unl = new JTextField(10);
		okay = new JButton("Ok");
		register = new JButton("Register");
		pswd.setEchoChar('*');
		
		pswd.addKeyListener(new KeyListener1());
		
			
			
		
		okay.addActionListener(new ButtonListener());
		register.addActionListener(new ButtonListener99());
		cancel = new JButton("Cancel");
		JPanel panel1 = new JPanel();

		cancel.addActionListener(new ButtonListener2());
		

		this.setLayout(new FlowLayout());
		this.add(panel1);
		panel1.add(userNameLabel);
		panel1.add(unl);
		panel1.add(passwordLabel);
		panel1.add(pswd);
		panel1.add(okay);
		panel1.add(register);
		panel1.add(cancel);
		this.pack();

		this.add(panel1);

	}
	
	public ArrayList<String> readFile()
	{
	   //String content = null;
	   File file = new File("database.txt"); //for ex foo.txt
	   ArrayList<String> read = new ArrayList<String>();
	   try {
	       BufferedReader reader = new BufferedReader(new FileReader(file));
//	       char[] chars = new char[(int) file.length()];
//	       reader.read(chars);
//	       content = new String(chars);
	       
	       //reader.
	        //in this method
	        
	       
	       String line = "";
	        while((line = reader.readLine())!=null)
	        {
	        	read.add(line);
	        }
	        
	        
	        
	        /*in which method is for ok button, make arraylist in method, set equal to frames.this.readFile();
	        * for(int i = 0; i < read.size(); i++)
	        *{
	        * 		if(temp.equals(read.get(i)
	        * 		{
	        * 			do stuff
	        * 		}
	        * }
	        * 
	        */
	       
	       while ((line=reader.readLine())!=null){
	    	   System.out.println(line); 
	    	   
	       }
	      
	       reader.close();
	   } catch (IOException e) {
	       e.printStackTrace();
	   }
	   return read; //return read
	}
	
	
//	private void openFile(){
//		 
//		JFileChooser fileChooser = new JFileChooser();
//		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//		 
//		int result = fileChooser.showOpenDialog(this);
//		 
//		if(result == JFileChooser.CANCEL_OPTION)
//		return;
//		 
//		File fileName = fileChooser.getSelectedFile();
//		 
//		if (fileName == null || fileName.getName().equals("")){
//		JOptionPane.showMessageDialog(this, "Invalid File Name", "This is an" + " invalid file name.", JOptionPane.ERROR_MESSAGE);
//		}//end if
//		 
//		else{
//		JOptionPane.showMessageDialog(this, fileName.getName());
//		BufferedReader input;
//		try{
//			input = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
//			String line;
//			 
//			while((line = input.readLine()) != null)
//			{
//			Writer page = null;
//			page.append(line+"\n");
//			}//end while
//			input.close();
//			}//end try
//			catch(Exception e){
//			JOptionPane.showMessageDialog(this, "Error", e.toString(), JOptionPane.ERROR_MESSAGE);
//			}//end catch
//		}//end else
//	}//end openFile
	private void saveFile(){
//	    JFileChooser fileChooser = new JFileChooser();
//	    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//	     
//	    int result = fileChooser.showSaveDialog(this);
//	     
//	    if(result == JFileChooser.CANCEL_OPTION)
//	    return;
//	     
//	    File fileName = fileChooser.getSelectedFile();
//	     
//	    if (fileName == null || fileName.getName().equals("")){
//	        JOptionPane.showMessageDialog(this, "Invalid File Name", "This is an" + " invalid file name.", JOptionPane.ERROR_MESSAGE);
//	    }//end if
//	    else{
	        BufferedWriter output;
	        try{
	            output = new BufferedWriter(new FileWriter("database.txt",true));
	            
	            for(int i = 0; i < arr.size(); i++)
	            {	
	            	output.write(arr.get(i), 0, arr.get(i).length());
	            	output.newLine(); //arr[i] is the same as arr.get(i) for arraylists
	            }
				
	            output.close();
	        }//end try
	        catch(Exception e){
	            JOptionPane.showMessageDialog(this, "Error", e.toString(), JOptionPane.ERROR_MESSAGE);
	        }//end catch
//	    }//end else
	}//end saveFile
	

	public class ButtonListener99 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String rUName = unl.getText();
			String rPswd = pswd.getText();
			if(!rUName.equals("") && !rPswd.equals("")){
				ArrayList<String> tempArr = frames.this.readFile();
				String temp = rUName + ":" + rPswd;
				if(!tempArr.contains(temp))
				{
				arr.add(temp); //String temp = 
				frames.this.saveFile();
				JOptionPane.showMessageDialog(rootPane, "You have succesfully registered.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "This combination already exists");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid username/password");
			}
			System.out.println(rUName);
			System.out.println(rPswd);
			
		}
		
	}

	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String enteredUName1 = unl.getText();
			String enteredPswd1 = pswd.getText();
			String bothEntered = enteredUName1+ ":" + enteredPswd1;
			System.out.println(bothEntered);
			ArrayList<String> read = frames.this.readFile();
	         //in which method is for ok button, make arraylist in method, set equal to frames.this.readFile();
			
			boolean isWrong = true;
			
	        for(int i = 0; i < read.size(); i++)
	        {
	        		if(bothEntered.equalsIgnoreCase(read.get(i)))
	        		{
	        			System.out.println("correct");
	        			isWrong = false;
	        			ob.setVisible(false);
	        			new MFrame();
	        			
	        		}
	        }
	        
	        if(isWrong == true)
	        {
	        	JOptionPane.showMessageDialog(rootPane, "Incorrect Username/Password");
	        }
	        
			
//			if (entered.equals("java")){
//				System.out.println("Correct password!");
//				ob.setVisible(false);
//				new MFrame();
//			}
		}
	}
	class ButtonListener2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			//panel1.dispatchEvent(new WindowEvent(panel1, WindowEvent.WINDOW_CLOSING));
			System.exit(0);

		}
	}
	
	class KeyListener1 implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
				System.out.println("Pressed!");
				String entered = pswd.getText();
				System.out.println(entered);
				ButtonListener b1 = new ButtonListener();
				b1.actionPerformed(null);
				
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}


	public static void main (String[] args) {
		new frames("Window");
		//String code = pswd.getText();

		//System.out.println(code);
	}
}
