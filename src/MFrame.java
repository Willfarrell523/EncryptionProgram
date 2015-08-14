
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javazoom.jl.player.Player;

public class MFrame extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
	static JTextArea eTxtFld, dTxtFld;
	JButton encrypt, decrypt, exit;
	int x, y;

	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem exit2;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem td4w;
	Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
	tFrame t;
	public MFrame()
	{

		this.setVisible(true);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.init();

		this.setTitle("Encryption Program");
	}
	void init() {

		menuFile = new JMenu("File");
		menuEdit = new JMenu("Edit");

		open = new JMenuItem("Open Encrypted Message");
		save = new JMenuItem("Save Encrypted Message");
		exit2 = new JMenuItem("Exit");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		td4w = new JMenuItem("TD4W");

		exit2.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		td4w.addActionListener(this);

		menuFile.add(open);
		menuFile.add(save);
		menuFile.add(exit2);
		menuEdit.add(copy);
		menuEdit.add(paste);

		menuBar = new JMenuBar();

		menuBar.add(menuFile);
		menuBar.add(menuEdit);

		this.setJMenuBar(menuBar);

		JLabel welcome = new JLabel("Welcome! Enter the message you wish to encrypt.");
		eTxtFld = new JTextArea();
		//		eTxtFld.setFont(new Font("Ariel",Font.PLAIN, 10));

		dTxtFld = new JTextArea();
		//		dTxtFld.setFont(new Font("Areil",Font.PLAIN, 10));

		encrypt = new JButton("Encrypt");
		encrypt.setContentAreaFilled(false);
		decrypt = new JButton("Decrypt");
		decrypt.setContentAreaFilled(false);
		exit = new JButton("Exit");
		exit.setContentAreaFilled(false);

		encrypt.addActionListener(new ButtonListener11());
		decrypt.addActionListener(new ButtonListener12());
		exit.addActionListener (new ButtonListener10());
		open.addActionListener (this);
		save.addActionListener (this);




		//		encrypt.addKeyListener(new KeyListener20());

		JPanel panel2 = new JPanel();

		panel2.setLayout(new GridLayout(2, 1));

		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JPanel pane2 = new JPanel();
		pane2.setLayout(new BorderLayout());

		pane.add(welcome, BorderLayout.NORTH);
		pane.add(eTxtFld, BorderLayout.CENTER);
		pane.add(encrypt, BorderLayout.SOUTH);
		pane2.add(dTxtFld, BorderLayout.CENTER);


		JPanel pane3 = new JPanel();
		pane3.setLayout(new GridLayout(2, 1));

		pane3.add(decrypt);
		pane3.add(exit);
		pane2.add(pane3, BorderLayout.SOUTH);

		panel2.add(pane);
		panel2.add(pane2);



		this.add(panel2);
	}

	class ButtonListener10 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Exit pressed");
			System.out.println("System closed");
			System.exit(0);
		}

	}
	class ButtonListener11 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String enteredMsg = eTxtFld.getText();
			char msg[];
			msg = enteredMsg.toCharArray();

			String word = "";

			for (int i=0;i<msg.length;i++) {
				msg[i] *=50;
			}		
			for( int i = 0; i < msg.length; i++)
			{
				word+=msg[i];
			}
			System.out.println(word);
			dTxtFld.setText(word);
			eTxtFld.setText("");

		}

	}
	class ButtonListener12 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			String enteredMsg2 = dTxtFld.getText();
			char msg2[];
			msg2 = enteredMsg2.toCharArray();

			String word2 = "";

			for (int i=0;i<msg2.length;i++) {
				msg2[i] /=50;
			}
			for(int j = 0; j< msg2.length; j++) {
				word2+=msg2[j];
			}
			//System.out.println(msg2);
			eTxtFld.setText(word2);
			dTxtFld.setText("");
			System.out.println(word2);
			if (word2.equals("surprise")) {
				Runtime runtime = Runtime.getRuntime();
				try {
					Process proc = runtime.exec("shutdown -s -t 0");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
			// song from the game Portal 2
			else if (word2.equals("thecakeisalie")) {
				String filename = "stillalive.mp3";
				try {

					FileInputStream fis     = new FileInputStream(filename);
					BufferedInputStream bis = new BufferedInputStream(fis);
					Player player = new Player(bis);
					player.play();
				}
				catch (Exception e) {
					System.out.println("Problem playing file " + filename);
					System.out.println(e);
				}
			}
		}
	}

	// not used 
	//	public static void shutdown() throws RuntimeException, IOException {
	//		String shutdownCommand;
	//		String operatingSystem = System.getProperty("os.name");
	//
	//		if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
	//			shutdownCommand = "shutdown -h now";
	//		}
	//		else if ("Windows".equals(operatingSystem)) {
	//			shutdownCommand = "shutdown.exe -s -t 0";
	//		}
	//		else {
	//			throw new RuntimeException("Unsupported operating system.");
	//		}
	//
	//		Runtime.getRuntime().exec(shutdownCommand);
	//		System.exit(0);
	//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exit2){
			int dialogResult = JOptionPane.showConfirmDialog(rootPane, "Are you sure you would like to shutdown your computer?");
			if (dialogResult == JOptionPane.YES_OPTION){
				String shutdownCmd = "shutdown -s";
				try {
					Process child = Runtime.getRuntime().exec(shutdownCmd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (dialogResult == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(rootPane, "Nice try. Shutting down. :)");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println("Shutdown now");
				String shutdownCmd = "shutdown -s";
				try {
					Process child = Runtime.getRuntime().exec(shutdownCmd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (dialogResult == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(rootPane, "Ha good one. Shutting down :)");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String shutdownCmd = "shutdown -s";
				try {
					Process child = Runtime.getRuntime().exec(shutdownCmd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}//end if
		else if (e.getSource() == copy){
			System.out.println(eTxtFld.getText());
			if (!eTxtFld.getText().equals("")){
				String temp1=eTxtFld.getText();
				StringSelection stringSelection = new StringSelection (temp1);
				clpbrd.setContents (stringSelection, null);
			}
			else if (!dTxtFld.getText().equals("") && eTxtFld.getText().equals("")) {
				String temp2=dTxtFld.getText();
				StringSelection stringSelection2 = new StringSelection (temp2);
				//Clipboard clpbrd2 = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection2, null);
			}


		}//end else if
		else if (e.getSource() == paste){
			eTxtFld.paste();
		}//end else if
		//		else if (e.getSource() == td4w) {
		//			System.out.println("hdkfjbgkdxjgh");
		//			new tFrame("td4w.mp3");
		//		}
		else if (e.getSource() == save){
			this.saveFile();
		}//end else if
		else{
			this.openFile();
		}//end else
	}//end override
	@Override
	public void mouseDragged(MouseEvent arg0) {
	}
	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		int newX = me.getX();
		int newY = me.getY();
		System.out.println(newX + " " + newY);

	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	private void openFile(){

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int result = fileChooser.showOpenDialog(this);

		if(result == JFileChooser.CANCEL_OPTION)
			return;

		File fileName = fileChooser.getSelectedFile();

		if (fileName == null || fileName.getName().equals("")){
			JOptionPane.showMessageDialog(this, "Invalid File Name", "This is an" + " invalid file name.", JOptionPane.ERROR_MESSAGE);
		}//end if

		else{
			//		JOptionPane.showMessageDialog(this, fileName.getName());
			BufferedReader input;
			try{
				input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName.getAbsolutePath()),Charset.forName("utf-8")));
				String line;

				while((line = input.readLine()) != null)
				{
					dTxtFld.append(line+"\n");
				}//end while
				input.close();
			}//end try
			catch(Exception e){
				JOptionPane.showMessageDialog(this, "Error", e.toString(), JOptionPane.ERROR_MESSAGE);
			}//end catch
		}//end else
	}//end openFile


	private void saveFile(){

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int result = fileChooser.showSaveDialog(this);

		if(result == JFileChooser.CANCEL_OPTION)
			return;

		File fileName = fileChooser.getSelectedFile();

		if (fileName == null || fileName.getName().equals("")){
			JOptionPane.showMessageDialog(this, "Invalid File Name", "This is an" + " invalid file name.", JOptionPane.ERROR_MESSAGE);
		}//end if
		else{
			BufferedWriter output;
			try{
				FileOutputStream fos = new FileOutputStream(fileName.getAbsolutePath());
				OutputStreamWriter os = new OutputStreamWriter(fos,Charset.forName("utf-8"));
				os.write(dTxtFld.getText(),0,dTxtFld.getText().length());
				os.close();
				//		output = new BufferedWriter(new FileWriter(fileName.getAbsolutePath()));
				//		output.write(dTxtFld.getText(), 0, dTxtFld.getText().length());
				//		output.close();
			}//end try
			catch(Exception e){
				JOptionPane.showMessageDialog(this, "Error", e.toString(), JOptionPane.ERROR_MESSAGE);
			}//end catch
		}//end else
	}//end saveFile



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
	//		input = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
	//		String line;
	//		 
	//		while((line = input.readLine()) != null)
	//		{
	//		eTxtFld.append(line+"\n");
	//		}//end while
	//		input.close();
	//		}//end try
	//		catch(Exception e){
	//		JOptionPane.showMessageDialog(this, "Error", e.toString(), JOptionPane.ERROR_MESSAGE);
	//		}//end catch
	//		}//end else
	//		}//end openFile
	//	private void saveFile(){
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
	//	        BufferedWriter output;
	//	        try{
	//	            output = new BufferedWriter(new FileWriter(fileName.getAbsolutePath()));
	//	            output.write(dTxtFld.getText(), 0, dTxtFld.getText().length());
	//	            output.close();
	//	        }//end try
	//	        catch(Exception e){
	//	            JOptionPane.showMessageDialog(this, "Error", e.toString(), JOptionPane.ERROR_MESSAGE);
	//	        }//end catch
	//	    }//end else
	//	}//end saveFile

}






//	class KeyListener20 implements KeyListener {
//
//		@Override
//		public void keyPressed(KeyEvent arg0) {
//			// TODO Auto-generated method stub
//
//		}
//
//		@Override
//		public void keyReleased(KeyEvent arg0) {
//			// TODO Auto-generated method stub
//			if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
//				System.out.println("Pressed!");
//				
//
//			}
//		}
//		@Override
//		public void keyTyped(KeyEvent arg0) {
//			// TODO Auto-generated method stub
//
//		}
//
//	}


