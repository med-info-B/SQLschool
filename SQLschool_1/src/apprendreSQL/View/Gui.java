package apprendreSQL.View;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.IntPredicate;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import apprendreSQL.Controller.Controller;
import apprendreSQL.Controller.Observer;

public class Gui extends JFrame implements Observer {


	private static final long serialVersionUID = 1L;

    // *******************************  CONSTANTES  **************************************************//
		//   JFRAME : root graphic
	private final int WEIGHT = 600, HEIGHT = 600;
	private final String  TITLE_FRAME = "*** APPRENDRE SQL ***";
	private final boolean ISVISIBLE_JFRAME = true;
       //   JPanel : HEADER
	private final String TITLE_HEADER = "VERSION TEST";
	private final Color HCOLOR = new Color(89, 91, 82);
	  //    JPanel : Body
	private final int WEIGHT_TEXTAREA = 400, HEIGHT_TEXTAREA = 90;
	private final String TITLE_INPUT = "INSERER UNE REQUÊTE SQL ", TITLE_OUTPUT = "CORRECTION";
	
	
	// ********************************************************************************************//
	
	// ******************************** VARIABLES  ***********************************************// 
	
	private JPanel panBody, panHeader, panParent, panFooter;
	private JTextPane input, ouput;
	private JLabel title_version;
	private StyledDocument document;
	private Style style;
	
	
	private Controller controller;
	
	
	// ********************************************************************************************//

	
	public Gui(Controller con)
	{
		controller = con;
	}
	
	

	
	public void display()
	{
		reset_Frame();
		create_Container();
		listner();
	}
	
	/**
	 *   La vue envoi une requete au controlleur que lui à son tour l'envoi au Model pour s'assurer est ce mot est 
	 *   un mot clè { SELECT, FROM ......}
	 */
	@Override
	public void sendIsKeyWord(String word) {
		controller.sendIsKeyWord(word);
	}
	
	

	private void isKeyWord(String[] text) 
	{
		int size = text.length -1;
		style = input.addStyle("",null);
		if(text[size].equals("select")) {
			try {
				input.setText(null);
				StyleConstants.setForeground(style, Color.RED);
				document.insertString(document.getLength(),text[size] , style);
				StyleConstants.setForeground(style, Color.WHITE);
				document.insertString(document.getLength()," " , style);
			} catch (BadLocationException e) {} 
		} else {
			try {
				document.insertString(document.getLength(),"" , style);
			} catch (BadLocationException e) {	}
		}
		
		
	}
	
	private void listner() {
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_SEMICOLON) {
					String mots[] = input.getText().split(" ");
					isKeyWord(mots);
				}
				
		
			}
		});	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//************************************ Contruction de la fenêtre ********************************************/
	
	
	/**
	 * [1]  réinitialiser des paramétres de la fenêtre  
	 */
	private void reset_Frame() {
		setTitle(TITLE_FRAME);
		setSize(WEIGHT, HEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(ISVISIBLE_JFRAME);
		setLayout(new BorderLayout());
	}
	
	/**
	 *  Création du conteneur 
	 */
	private void create_Container()
	{	
		// Conteneur
		panParent = (JPanel) getContentPane();
		
		create_Header();
		create_Body();
		create_Footer();		
	
		panParent.add(panHeader, BorderLayout.NORTH);
		panParent.add(panBody, BorderLayout.CENTER);
		panParent.add(panFooter, BorderLayout.SOUTH);
		
		revalidate();
		repaint();
	}
	
	/**
	 *   
	 */
	private void create_Header()
	{		
		panHeader = new JPanel();
		panHeader.setBackground(HCOLOR);
		panHeader.setPreferredSize(new Dimension(0,80));
		
		title_version = new JLabel(TITLE_HEADER );
		title_version.setForeground(Color.black);
		title_version.setBackground(Color.YELLOW);
		title_version.setPreferredSize(new Dimension(189,40));
		title_version.setOpaque(true);
		title_version.setHorizontalAlignment(SwingConstants.CENTER);
		title_version.setBorder(BorderFactory.createLineBorder(Color.black, 5, true));
	      // Insertion dans le panel Header
		panHeader.add(title_version);
	}
	
	/**
	 * 
	 */
	private void create_Body()
	{
		panBody = new JPanel();
		panBody.setLayout(new FlowLayout());	
		panBody.setLayout(new FlowLayout(FlowLayout.CENTER,10,90));
		panBody.setBackground(new Color(203, 247, 93));
		panBody.setPreferredSize(new Dimension(0, 100));
		
		Border line = BorderFactory.createLineBorder(new Color(162, 181, 200), 4);
	
		input = new JTextPane();
		document = input.getStyledDocument();
		ouput = new JTextPane();

		input.setPreferredSize(new Dimension(WEIGHT_TEXTAREA, HEIGHT_TEXTAREA));
		input.setBorder(BorderFactory.createTitledBorder(line, TITLE_INPUT));
		input.setForeground(Color.WHITE);
		input.setFont(new Font(Font.SERIF,Font.BOLD, 25));
		input.setBackground(Color.BLUE);
	
				
		ouput.setEditable(false);
		ouput.setPreferredSize(new Dimension(WEIGHT_TEXTAREA, HEIGHT_TEXTAREA));
		ouput.setBorder(BorderFactory.createTitledBorder(line, TITLE_OUTPUT));
		
		panBody.add(input);
		panBody.add(ouput);
	}

	/**
	 * 
	 */
	private void create_Footer()
	{
		panFooter = new JPanel();
		panFooter.setBackground(HCOLOR);
		panFooter.setPreferredSize(new Dimension(0,50));
	}
	



}
