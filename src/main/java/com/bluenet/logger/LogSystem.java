package com.bluenet.logger;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class LogSystem {

    private final Logger logger;

    public LogSystem() {
        this.logger = LoggerFactory.getLogger("main");
    }

}
