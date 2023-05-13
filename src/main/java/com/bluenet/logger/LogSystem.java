package com.bluenet.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogSystem {

    private final Logger logger;

    public LogSystem() {
        this.logger = LoggerFactory.getLogger("main");
    }

    public void load() {

    }

    public Logger getLogger() {
        return logger;
    }
}
