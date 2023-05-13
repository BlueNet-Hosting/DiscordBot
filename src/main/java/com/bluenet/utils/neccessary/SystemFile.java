package com.bluenet.utils.neccessary;

import org.slf4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemFile {

    private final Logger logger;
    private final File file;
    private Properties properties;


    public SystemFile(Logger logger, File file) throws IOException {
        this.logger = logger;
        this.file = file;

        if(!(file.exists())) {
            logger.error("File does not exist! Please check whether system.properties or redownload the file: https://github.com/BlueNet-Hosting/DiscordBot/releases");
            return;
        }

        InputStream inputStream = new FileInputStream(getFile());
        this.properties = new Properties();
        this.properties.load(inputStream);
    }

    public String version() {
        return getProperties().getProperty("version");
    }

    public boolean isAutostart() {
        return Boolean.getBoolean(getProperties().getProperty("autostart"));
    }

    public String encryptionKey() {
        return getProperties().getProperty("encryptionKey");
    }

    public File workingDirectory() {
        return new File(getProperties().getProperty("workingDirectory"));
    }

    public File dataDirectory() {
        return new File(getProperties().getProperty("saveDirectory").replace("$workingDir", workingDirectory().getPath()));
    }

    public File logDirectory() {
        return new File(getProperties().getProperty("logFiles").replace("$workingDir", workingDirectory().getPath()));
    }

    public File getFile() {
        return file;
    }

    public Properties getProperties() {
        if(properties == null) {
            logger.error("Properties are null, please check file: system.properties!");
            return null;
        }
        return properties;
    }
}
