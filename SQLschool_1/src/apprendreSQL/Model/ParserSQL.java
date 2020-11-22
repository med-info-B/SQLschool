package apprendreSQL.Model;


public class ParserSQL {

	private Lexer lexer;
	
	public ParserSQL()
	{
		lexer = new Lexer();
	}
	
	
	public Lexer getLexer()
	{
		return lexer;
	}
	
	
}
