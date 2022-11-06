package ru.blodge.tzfgame.configuration;

import java.util.Arrays;
import java.util.List;

public class TelegramBotConfig {
    public static final String TELEGRAM_BOT_TOKEN = System.getenv("TELEGRAM_BOT_TOKEN");
    public static final String TELEGRAM_BOT_USERNAME = System.getenv("TELEGRAM_BOT_USERNAME");

    private TelegramBotConfig() {}

}
