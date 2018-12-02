/**
 * @author MrSheldon
 */

package sandwich.commands.fun;

import net.dv8tion.jda.core.EmbedBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import sandwich.utils.SandwichCommand;
import com.jagrosh.jdautilities.command.CommandEvent;
import java.io.IOException;

public class CatCommand extends SandwichCommand {
    public CatCommand() {
        this.name = "cat";
        this.help = "Send a random cat image";
        this.usage = "cat";
        this.category = new Category("Fun");
        this.guildOnly = true;
        this.ID = 45;
    }

    protected void execute(CommandEvent event) {
        String ENDPOINT = "https://nekos.life/api/v2/img/meow";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ENDPOINT)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String resStr = response.body().string();
            JSONObject res = new JSONObject(resStr);
            String url = res.getString("url");
            EmbedBuilder embed = new EmbedBuilder().setImage(url);
            event.getChannel().sendMessage(embed.build()).queue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
