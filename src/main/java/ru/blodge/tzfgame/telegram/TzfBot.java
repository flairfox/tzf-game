package ru.blodge.tzfgame.telegram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.blodge.tzfgame.engine.map.MapGenerator;
import ru.blodge.tzfgame.engine.map.impl.WorldMapDefaultGenerator;
import ru.blodge.tzfgame.engine.model.WorldMap;

import static ru.blodge.tzfgame.configuration.TelegramBotConfig.TELEGRAM_BOT_TOKEN;
import static ru.blodge.tzfgame.configuration.TelegramBotConfig.TELEGRAM_BOT_USERNAME;

public class TzfBot extends TelegramLongPollingBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(TzfBot.class);

    private static final TzfBot instance = new TzfBot();

    private final MapGenerator mapGenerator = new WorldMapDefaultGenerator();
    private final MapRenderer mapRenderer = new MapRenderer();

    public static TzfBot instance() {
        return instance;
    }

    private TzfBot() {
    }

    @Override
    public void onUpdateReceived(Update update) {
        LOGGER.info("Received new update {}", update);

        int roomsCount = Integer.parseInt(update
                .getMessage()
                .getText()
                .trim());

        WorldMap worldMap = mapGenerator.generate(roomsCount);

        SendMessage renderedMap = new SendMessage();
        renderedMap.setChatId(update.getMessage().getChatId());
        renderedMap.setText(mapRenderer.render(worldMap));

        try {
            execute(renderedMap);
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
