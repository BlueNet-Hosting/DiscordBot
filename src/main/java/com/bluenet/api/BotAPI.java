package com.bluenet.api;

import com.bluenet.logger.LogSystem;
import com.bluenet.main.DiscordBot;
import com.bluenet.utils.security.Ciphers;

public class BotAPI {

    private static DiscordBot main = DiscordBot.getInstance();

    public Ciphers getSecurity() {
        try {
             return new Ciphers(main.getLogSystem().getLogger(), main.getSystemFiles().encryptionKey());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
