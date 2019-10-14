package pers.demos.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;

/**
 * @author JustEP
 * @version 1.0
 * @classname pers.demos.bot.MyBot
 * @description 复读机机器人
 * @createtime 2019/10/13 23:17:00
 */
public class MyBot extends TelegramLongPollingBot {
    private static String bot_token =  null;
    private static String bot_name =  null;
    static {
        Properties properties = new Properties();
        try {
            String path = Objects.requireNonNull(MyBot.class.getClassLoader().getResource("config.properties")).getPath();
            properties.load(new FileReader(path));
            bot_token = (String) properties.get("bot_token");
            bot_name = (String) properties.get("bot_name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Create a SendMessage object with mandatory fields
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                // Call method to send the message
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return bot_name;
    }

    @Override
    public String getBotToken() {
        return bot_token;
    }
}
