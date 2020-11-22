package apprendreSQL.Model;

import java.util.List;

import apprendreSQL.Controller.Observer;

public class Lexer {

	private List<Observer> obserers;
	
	
	public void register(Observer o)
	{
		this.obserers.add(o);
	}
	
	
	
}
