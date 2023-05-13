package com.bluenet.utils.configurations;

import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

public class BaseConfiguration {

    protected final JsonConfig config = new JsonConfig();
    private final File file;
    private final Logger logger;

    public BaseConfiguration(Logger logger, File dataFolder, String path) {
        this.file = new File(dataFolder, path);
        this.logger = logger;
    }

    public final void load(){
        try {
            config.load(file);
        } catch(Throwable throwable){
            logger.error(String.format("Failed to load file %s:\n%s", file.getName(), throwable));
        }
        try{
            onLoad();
        } catch(Throwable throwable) {
            logger.error(String.format("Failed to run onLoad of config file %s:\n%s", file.getName(), throwable));
        }
    }

    public final void save() {
        try{
            onSave();
        } catch(Throwable throwable) {
            logger.error(String.format("Failed to run onSave of config file %s:\n%s", file.getName(), throwable));
        }
        try {
            config.save(file);
        } catch(Throwable throwable){
            logger.error(String.format("Failed to save file %s:\n%s", file.getName(), throwable));
        }
    }

    public final void reload(){
        load();
        save();
    }

    protected void onLoad() throws Throwable {}

    protected void onSave() throws Throwable {}
}