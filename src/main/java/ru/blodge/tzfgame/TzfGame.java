package ru.blodge.tzfgame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.blodge.tzfgame.telegram.TzfBot;

public class TzfGame {

    private static final Logger LOGGER = LoggerFactory.getLogger(TzfGame.class);

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(TzfBot.instance());

            LOGGER.info("TzfBot bot is up and running!");
        } catch (TelegramApiException e) {
            LOGGER.error("Error while starting TzfBot bot!", e);
        }
    }

}
