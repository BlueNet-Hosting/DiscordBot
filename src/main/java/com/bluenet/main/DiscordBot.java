package com.bluenet.main;

import com.bluenet.boot.ConsoleThread;
import com.bluenet.logger.LogSystem;
import com.bluenet.utils.neccessary.SystemFile;
import com.bluenet.utils.neccessary.VersionChecker;

import java.io.File;
import java.io.IOException;

public class DiscordBot {

    private static DiscordBot instance;
    private LogSystem logSystem;
    private SystemFile systemFiles;
    private VersionChecker versionChecker;
    private ConsoleThread consoleThread;

    public static void main(String[] args) {
        instance = new DiscordBot();
        try {
            getInstance().logSystem = new LogSystem();
            getInstance().systemFiles = new SystemFile(getInstance().getLogSystem().getLogger(), new File("system.properties"));
            getInstance().versionChecker = new VersionChecker(getInstance().getLogSystem().getLogger(), getInstance().getSystemFiles());
            getInstance().consoleThread = new ConsoleThread();
            getInstance().consoleThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static DiscordBot getInstance() { return instance; }

    public LogSystem getLogSystem() {
        return logSystem;
    }

    public SystemFile getSystemFiles() {
        return systemFiles;
    }

    public VersionChecker getVersionChecker() {
        return versionChecker;
    }

    public ConsoleThread getConsoleThread() {
        return consoleThread;
    }
}
