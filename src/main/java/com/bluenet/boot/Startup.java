package com.bluenet.boot;

import com.bluenet.main.DiscordBot;
import org.slf4j.Logger;

import java.io.IOException;

public class Startup {

    private static DiscordBot discordBot = DiscordBot.getInstance();
    private static Logger logger = discordBot.getLogSystem().getLogger();

    public static void start() throws IOException {
        logger.info("Fetching information...");
        if(!(discordBot.getVersionChecker().isUpToDate())) {
            logger.error("The version is not up to date, want to update it?");
            discordBot.getConsoleThread().interrupt();
            return;
        }
    }
}
