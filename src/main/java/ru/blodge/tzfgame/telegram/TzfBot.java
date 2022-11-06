package ru.blodge.tzfgame.telegram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static ru.blodge.tzfgame.configuration.TelegramBotConfig.TELEGRAM_BOT_TOKEN;
import static ru.blodge.tzfgame.configuration.TelegramBotConfig.TELEGRAM_BOT_USERNAME;

public class TzfBot extends TelegramLongPollingBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(TzfBot.class);

    private static final TzfBot instance = new TzfBot();

    public static TzfBot instance() {
        return instance;
    }

    private TzfBot() {}

    @Override
    public void onUpdateReceived(Update update) {
        LOGGER.info("Received new update {}", update);

        SendMessage echo = new SendMessage();
        echo.setChatId(update.getMessage().getChatId());
        echo.setText(update.getMessage().getText());

        try {
            execute(echo);
        } catch (TelegramApiException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public String getBotToken() {
        return TELEGRAM_BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return TELEGRAM_BOT_USERNAME;
    }
}
