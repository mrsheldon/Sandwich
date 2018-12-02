/**
 * @author MrSheldon
 */

package sandwich.utils;

public class Config {
    public static final boolean isBeta = true;
    public static final String VERSION = "1.0.0";
    public static final String BETA_PREFIX = "!";
    public static final String NORMAL_PREFIX = "s!";
    public static final String TOKEN = "NDc5MDQ5Nzc2ODE0MzU4NTMx.DpuWpA.7Dnk9DHdN-PIRmFE3-yemlByCck";
    public static final String BOTID = "479049776814358531";
    public static final String OWNERID = "231733082804322304";
    public static final String SERVERINVITE = "https://discord.gg/76PAmCv";
    public static final String INVITE = "https://discordapp.com/api/oauth2/authorize?client_id=" + BOTID + "&permissions=8&scope=bot";
    public static final String GAME = getPrefix() + "help";
    public synchronized static String getPrefix() {
        if(!Config.isBeta) {
            return NORMAL_PREFIX;
        } else {
            return BETA_PREFIX;
        }
    }
}