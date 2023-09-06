package com.bluenet.internals;

import ch.qos.logback.classic.LoggerContext;
import com.bluenet.logger.Zip;
import com.bluenet.main.DiscordBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShutdownProcess {

    private Logger logger;

    public ShutdownProcess(Logger logger) {
        this.logger = logger;
    }

    public void initialize() {
        logger.info("System is shutting down...");
        try {
            DiscordBot.getInstance().getConsoleThread().interrupt();
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            context.getLogger(logger.getName()).getLoggerContext().stop();
            Zip.zipOldLogs();
            Files.delete(Paths.get("logs/latest.log"));
        } catch (IOException e) {
            logger.error("An error occurred while zipping old log files: ", e);
        }
    }
}
