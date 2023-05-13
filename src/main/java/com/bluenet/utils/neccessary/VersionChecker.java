package com.bluenet.utils.neccessary;

import org.slf4j.Logger;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class VersionChecker {

    private final Logger logger;
    private final SystemFile systemFile;

    public VersionChecker(Logger logger, SystemFile system) {
        this.logger = logger;
        this.systemFile = system;
    }

    public boolean isUpToDate() throws IOException {
        String fileVersion = systemFile.version();
        String path = "/src/main/resources/system.properties";
        String githubProperties = "https://raw.githubusercontent.com/BlueNet-Hosting/DiscordBot/main";
        URL url = new URL(githubProperties + path);
        InputStream inputStream = url.openStream();
        Properties properties = new Properties();
        properties.load(inputStream);
        String latest = properties.getProperty("version");
        if (fileVersion.equals(latest)) {
            return true;
        }
        return false;
    }
}
