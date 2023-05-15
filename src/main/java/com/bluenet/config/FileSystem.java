package com.bluenet.config;

import com.bluenet.main.DiscordBot;
import com.bluenet.utils.neccessary.SystemFile;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

public class FileSystem {

    private Logger logger;
    private File configuration;
    private File mysql;

    public FileSystem(Logger logger) {
        this.logger = logger;
        this.configuration = new File(DiscordBot.getInstance().getSystemFiles().configurationDirectory().getPath(), "config.json");
        this.mysql = new File(DiscordBot.getInstance().getSystemFiles().configurationDirectory().getPath(), "mysql.json");
    }

    public void createAll() {
        if(!configuration.exists()) {
            try {
                configuration.createNewFile();
            } catch (IOException e) {
                logger.error("An error occurred while creating the config.json file: ", e);
            }
        }

        if(!mysql.exists()) {
            try {
                mysql.createNewFile();
            } catch (IOException e) {
                logger.error("An error occurred while creating the mysql.json file: ", e);
            }
        }
    }
}
