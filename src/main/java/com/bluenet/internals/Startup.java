package com.bluenet.internals;

import com.bluenet.main.DiscordBot;
import com.bluenet.utils.neccessary.SystemFile;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Startup {

    private static DiscordBot discordBot = DiscordBot.getInstance();
    private static Logger logger = discordBot.getLogSystem().getLogger();
    private static boolean accepted;
    private static boolean firstBoot = false;

    public static void start() throws IOException {
        logger.info("Fetching information...");
        if(!(discordBot.getVersionChecker().isUpToDate())) {
            if(discordBot.getSystemFiles().isAutoUpdate()) {
                DiscordBot.getInstance().getUpdateService().accept();
                return;
            }
            logger.error("The version is not up to date, want to update it?");
            if(isAccepted()) {
                discordBot.getUpdateService().accept();
                return;
            }
            discordBot.getConsoleThread().interrupt();
            return;
        }

        logger.info("""
                  _____  _                       _ ____        _  \s
                 |  __ \\(_)                     | |  _ \\      | | \s
                 | |  | |_ ___  ___ ___  _ __ __| | |_) | ___ | |_\s
                 | |  | | / __|/ __/ _ \\| '__/ _` |  _ < / _ \\| __|
                 | |__| | \\__ \\ (_| (_) | | | (_| | |_) | (_) | |_\s
                 |_____/|_|___/\\___\\___/|_|  \\__,_|____/ \\___/ \\__|
                                                                  \s
                              by BlueNet-Hosting.com              \s
                """);
        logger.info("Service is running on version %s ".formatted(discordBot.getSystemFiles().version()));
        logger.info("");

        if(!(new File(DiscordBot.getInstance().getSystemFiles().configurationDirectory(), "config.json").exists())) {
            setFirstBoot(true);
        }
    }

    public static DiscordBot getDiscordBot() {
        return discordBot;
    }

    public static void setFirstBoot(boolean firstBoot) {
        Startup.firstBoot = firstBoot;
    }

    public static boolean isAccepted() {
        return accepted;
    }

    public static boolean isFirstBoot() {
        return firstBoot;
    }

    public static void setAccepted(boolean accepted) {
        Startup.accepted = accepted;
    }
}
