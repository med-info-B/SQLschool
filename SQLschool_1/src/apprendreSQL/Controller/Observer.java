package apprendreSQL.Controller;

public interface Observer {

	default void sendIsKeyWord(String word) {};
	default boolean sendResponse(boolean b) {return b;};
	
	
	
}
