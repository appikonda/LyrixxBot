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
			/*

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/start")) {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText(message_text);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/fellow")) {
            	 SendMessage message = new SendMessage() // Create a message object object
                         .setChatId(chat_id)
                         .setText("fuck off fellow!!!!!");
                 try {
                     execute(message); // Sending our message object to user
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
            }
            else if (message_text.equals("/arvind")) {
           	 SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Welcome Dr. Surgery!!!!!");
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
           }
            else if (message_text.equals("/alekya")) {
              	 SendMessage message = new SendMessage() // Create a message object object
                           .setChatId(chat_id)
                           .setText("Saayu potti, aleky potti");
                   try {
                       execute(message); // Sending our message object to user
                   } catch (TelegramApiException e) {
                       e.printStackTrace();
                   }
              }
            else if (message_text.equals("/srikanth")) {
             	 SendMessage message = new SendMessage() // Create a message object object
                          .setChatId(chat_id)
                          .setText("Srikanth hate CR7");
                  try {
                      execute(message); // Sending our message object to user
                  } catch (TelegramApiException e) {
                      e.printStackTrace();
                  }
             }else if(message_text.equals("/lyrics")) {
            	MusixMatchService mms = new MusixMatchService();
            	 try {
            	 SendMessage message = new SendMessage() // Create a message object object
                         .setChatId(chat_id)
                         .setText(mms.findLyrics());
            	 
            	 
            	 GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates());
            	 List<Update> updates = updatesResponse.updates();
         
            	 InlineQuery inlineQuery = update.inlineQuery();
            	 ChosenInlineResult chosenInlineResult = update.chosenInlineResult();
            	 CallbackQuery callbackQuery = update.callbackQuery();
            	
                     execute(message); // Sending our message object to user
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 } catch (MusixMatchException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            }
            
            
            
            
            
            else if (message_text.equals("/markup")) {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Here is your keyboard");
                // Create ReplyKeyboardMarkup object
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                // Create the keyboard (list of keyboard rows)
                List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
                // Create a keyboard row
                KeyboardRow row = new KeyboardRow();
                // Set each button, you can also use KeyboardButton objects if you need something else than text
                row.add("Row 1 Button 1");
                row.add("Row 1 Button 2");
                row.add("Row 1 Button 3");
                // Add the first row to the keyboard
                keyboard.add(row);
                // Create another keyboard row
                row = new KeyboardRow();
                // Set each button for the second line
                row.add("Row 2 Button 1");
                row.add("Row 2 Button 2");
                row.add("Row 2 Button 3");
                // Add the second row to the keyboard
                keyboard.add(row);
                // Set the keyboard to the markup
                keyboardMarkup.setKeyboard(keyboard);
                // Add it to the message
                message.setReplyMarkup(keyboardMarkup);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("Row 1 Button 1")) {
                SendPhoto msg = new SendPhoto()
                        .setChatId(chat_id)
                        .setPhoto("AgADAgAD6qcxGwnPsUgOp7-MvnQ8GecvSw0ABGvTl7ObQNPNX7UEAAEC")
                        .setCaption("Photo");

                try {
                    sendPhoto(msg); // Call method to send the photo
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Unknown command");
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } */
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
