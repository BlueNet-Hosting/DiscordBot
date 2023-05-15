package com.bluenet.internals;

import com.bluenet.config.FileSystem;
import com.bluenet.main.DiscordBot;

import java.io.File;

public class Setup {

    public Setup() {
        throw new UnsupportedOperationException("No class");
    }

    public static void configurate() {
        new FileSystem(DiscordBot.getInstance().getLogSystem().getLogger()).createAll();





        DiscordBot.setupFinish();
        Startup.setFirstBoot(false);
    }
}
