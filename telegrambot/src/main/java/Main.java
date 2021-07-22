import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import pers.demos.bot.MyBot;

/**
 * @author JustEP
 * @version 1.0
 * @classname Main
 * @description TODO
 * @createtime 2019/10/13 23:15:00
 */
public class Main {
    public static void main(String[] args) {
        String proxyHost = "127.0.0.1";
        String proxyPort = "1080";
        System.setProperty("socksProxyHost", proxyHost);
        System.setProperty("socksProxyPort", proxyPort);
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new MyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}