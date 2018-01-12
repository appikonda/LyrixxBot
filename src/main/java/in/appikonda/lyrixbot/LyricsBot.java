package in.appikonda.lyrixbot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jmusixmatch.MusixMatchException;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.updates.GetUpdates;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class LyricsBot  extends TelegramLongPollingBot  {

	public String getBotUsername() {
	
		return "LyrixxBot";
	}

	public void onUpdateReceived(Update update) {
		
		
		Message message = update.getMessage();
		
		if(message != null && message.hasText())
		{
			if (message.getText().startsWith("/lyrics")) {
                onStartLyrics(message);
            }
			else if (message.getReplyToMessage().hasText()) {
				MusixMatchService mms = new MusixMatchService();
         
         
           	 
           	 
               
                    SendMessage sendMessageRequest = new SendMessage();
                    try {
                    sendMessageRequest.setText(mms.findLyrics(message.getText()));
                    sendMessageRequest.setChatId(message.getChatId());
                  
                        sendMessage(sendMessageRequest);
                    } catch (TelegramApiException e) {
                    	 e.printStackTrace();
                    } catch (MusixMatchException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                
			}
		}
			
    }

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "519011045:AAE6NX8ITgoQUbF-9GBt6Xej2QoqMIUc-Tw";
	}
	
	private void log(String first_name, String last_name, String user_id, String txt, String bot_answer) {
        System.out.println("\n ----------------------------");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("Message from " + first_name + " " + last_name + ". (id = " + user_id + ") \n Text - " + txt);
        System.out.println("Bot answer: \n Text - " + bot_answer);
    }
	
	 private void onStartLyrics(Message message) {
	        SendMessage sendMessageRequest = new SendMessage();
	        sendMessageRequest.setChatId(message.getChatId());
	        sendMessageRequest.setReplyToMessageId(message.getMessageId());
	        ForceReplyKeyboard forceReplyKeyboard = new ForceReplyKeyboard();
	        forceReplyKeyboard.setSelective(true);
	        sendMessageRequest.setReplyMarkup(forceReplyKeyboard);
	        sendMessageRequest.setText("enter song name:");
	      
	        try {
				execute(sendMessageRequest);
			} catch (TelegramApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      

	    }


}
