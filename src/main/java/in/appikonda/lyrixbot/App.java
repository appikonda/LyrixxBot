package in.appikonda.lyrixbot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;


/**
 * Hello world!
 *
 */
public class App 
{
	 public static void main( String[] args )
	    {
	        System.out.println( "Hello World!" );
	        ApiContextInitializer.init();
	        TelegramBotsApi botsApi = new TelegramBotsApi();
	        try {
	            botsApi.registerBot( new LyricsBot());
	            
	            System.out.println("working!");
	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	    }
}
