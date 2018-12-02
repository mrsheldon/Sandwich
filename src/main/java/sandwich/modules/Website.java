/**
 * @author MrSheldon
 */

package sandwich.modules;

import sandwich.utils.SandwichModule;
import static spark.Spark.*;

public class Website extends SandwichModule {
    public Website() {
        this.name = "Website";
    }

    public static void build() {
        port(80);
        router();
    }
    public static void router() {
        get("/", (req, res) -> "<code>{\"online\"}</code>");
    }
}
