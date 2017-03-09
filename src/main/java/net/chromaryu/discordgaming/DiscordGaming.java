package net.chromaryu.discordgaming;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.chromaryu.discordgaming.abs.listeners.onMessage;
import net.chromaryu.discordgaming.abs.listeners.onReady;
import net.chromaryu.discordgaming.config.ConfigLoader;
import net.chromaryu.discordgaming.config.LangLoader;
import net.chromaryu.discordgaming.config.Player;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by midgard on 17/03/05.
 */
public class DiscordGaming {
    // Static thing
    public static String COMMAND_PREFIX = ".dm";
    public static HashMap<String,Player> logined = new HashMap<>();
    public static HashMap<String,LangLoader> languages = new HashMap<>();
    static ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException {
        ObjectMapper objectMapper = new ObjectMapper();
        ConfigLoader configLoader = null;
        try {
            configLoader = objectMapper.readValue(new File("cred.json"),ConfigLoader.class);
            //en_JS only because... yeah I gonna update later on.
            languages.put("en_US",objectMapper.readValue(classloader.getResource("i18n/en_US.json"),LangLoader.class));

        } catch (IOException e) {
            e.printStackTrace();
        }
        JDA jda = new JDABuilder(AccountType.BOT).setToken(configLoader.getToken())
                .addListener(new onMessage(),new onReady())
                .setGame(Game.of(".dm help"))
                .setAudioEnabled(false)
                .setStatus(OnlineStatus.ONLINE)
                .setIdle(false)
                .buildBlocking();
    }
}
