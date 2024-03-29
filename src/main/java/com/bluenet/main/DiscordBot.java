package com.bluenet.main;

import com.bluenet.internals.ConsoleThread;
import com.bluenet.internals.Setup;
import com.bluenet.internals.Startup;
import com.bluenet.internals.UpdateService;
import com.bluenet.logger.LogSystem;
import com.bluenet.utils.neccessary.SystemFile;
import com.bluenet.utils.neccessary.VersionChecker;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

@Getter
public class DiscordBot {

    @Getter
    private static DiscordBot instance;
    private LogSystem logSystem;
    private SystemFile systemFiles;
    private VersionChecker versionChecker;
    private ConsoleThread consoleThread;
    private UpdateService updateService;

    public static void main(String[] args) {
        instance = new DiscordBot();
        try {
            getInstance().logSystem = new LogSystem();
            getInstance().systemFiles = new SystemFile(getInstance().getLogSystem().getLogger(), new File("system.properties"));
            getInstance().versionChecker = new VersionChecker(getInstance().getLogSystem().getLogger(), getInstance().getSystemFiles());
            getInstance().updateService = new UpdateService();
            Startup.start();
            if(!Startup.isFirstBoot()) {
                getInstance().consoleThread = new ConsoleThread(getInstance().getLogSystem().getLogger());
                getInstance().consoleThread.start();
            }
        } catch (IOException e) {
            System.exit(0);
            throw new RuntimeException(e);
        }
    }

    public static void setupFinish() {
        if(Startup.isFirstBoot()) {
            getInstance().consoleThread = new ConsoleThread(getInstance().getLogSystem().getLogger());
            getInstance().consoleThread.start();
            return;
        }
        getInstance().getLogSystem().getLogger().error("There is no setup to finish!");
    }

}
