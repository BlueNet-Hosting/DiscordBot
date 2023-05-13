package com.bluenet.config;

import com.bluenet.utils.configurations.BaseConfiguration;
import org.slf4j.Logger;

import java.io.File;

public class SQLConfiguration extends BaseConfiguration {

    public SQLConfiguration(Logger logger, File dataFolder, String path) {
        super(logger, dataFolder, path);
    }

    @Override
    protected void onLoad() throws Throwable {
    }

    @Override
    protected void onSave() throws Throwable {
    }
}
