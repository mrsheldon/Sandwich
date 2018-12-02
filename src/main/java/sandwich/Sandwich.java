/**
 * @author MrSheldon
 */

package sandwich;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import sandwich.commands.moderation.*;
import sandwich.commands.information.*;
import sandwich.commands.general.*;
import sandwich.commands.fun.*;
import sandwich.commands.*;
import sandwich.utils.Config;
import sandwich.modules.Website;

public class Sandwich {
    public static void main(String[] args) throws Exception {
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setGame(Game.playing(Config.GAME));
        builder.setPrefix(Config.getPrefix());
        builder.setAlternativePrefix("<@" + Config.BOTID + "> ");
        builder.setOwnerId(Config.OWNERID);
        builder.setServerInvite(Config.SERVERINVITE);
        builder.addCommands(
                // General Commands
                new PingCommand(),
                new BotinfoCommand(),
                // Information Commands
                new ServerinfoCommand(),
                new UserinfoCommand(),
                new AvatarCommand(),
                // Moderation Commands
                new KickCommand(),
                new BanCommand(),
                new MuteCommand(),
                new UnmuteCommand(),
                // Fun Commands
                new ChooseCommand(),
                new RollCommand(),
                new RandomCommand(),
                new SayCommand(),
                new EightballCommand(),
                new CatCommand()
        );
        builder.setHelpConsumer(new HelpCommand());
        CommandClient client = builder.build();
        JDABuilder bot = new JDABuilder(AccountType.BOT);
        bot.setToken(Config.TOKEN);
        bot.addEventListener(client);
        bot.build();
        Website.build();
    }
}