package com.bluenet.internals;

import com.bluenet.main.DiscordBot;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleThread extends Thread {

    private final Logger logger;
    private boolean running;

    public ConsoleThread(Logger logger) {
        this.logger = logger;
        this.running = true;
    }


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (isRunning()) {
            String scan = scanner.nextLine();
            String[] strings = scan.split(" ");
            switch (strings[0].toLowerCase()) {
                case "shutdown", "exit" -> {
                    new ShutdownProcess(logger).initialize();
                }
                case "start" -> {
                    if(DiscordBot.getInstance().getSystemFiles().isAutostart()) {
                        logger.error("Autostart is enabled!");
                        return;
                    }
                    /*
                     if(instance.bot() != null) {
                        logger.error("Discord is already started");
                        return;
                    }
                     */
                    logger.info("DiscordBot is starting...");
                }
                case "yes", "ja", "j", "y" -> {
                    try {
                        if(DiscordBot.getInstance().getVersionChecker().isUpToDate()) {
                            logger.warn("There is no update found to accept!");
                            return;
                        }

                        Startup.setAccepted(true);
                    } catch (IOException e) {
                        logger.error("An error occurred while fetching the version: ", e);
                    }
                }
                case "clear" -> {
                    logger.info("Clearing the console...");
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
                default -> {
                    logger.warn("No command!");
                }
            }
        }
    }

    @Override
    public void interrupt() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }
}
