package apprendreSQL.Controller;

import apprendreSQL.Model.ParserSQL;
import apprendreSQL.View.Gui;

public class Controller implements Observer{

	private ParserSQL parser;
	private Gui view;
	
	public Controller()
	{
		view = new Gui(this);
		parser = new ParserSQL();
	}
	
	// Requete envoyé au Model pour verifié  à tmp réel est ce  mot est un mot clè 
	@Override
	public void sendIsKeyWord(String word) {
		
	}
	
	
	
	
	
	
	
	public void DisplayView()
	{
		view.display();
	}
	
}
