package com.bluenet.internals;

import com.bluenet.logger.Zip;
import com.bluenet.main.DiscordBot;
import org.slf4j.Logger;

import java.io.IOException;

public class ShutdownProcess {

    private Logger logger;

    public ShutdownProcess(Logger logger) {
        this.logger = logger;
    }

    public void initialize() {
        logger.info("System is shutting down...");
        try {
            DiscordBot.getInstance().getConsoleThread().interrupt();
            Zip.zipOldLogs();
        } catch (IOException e) {
            logger.error("An error occurred while zipping old log files: ", e);
        }
    }
}
