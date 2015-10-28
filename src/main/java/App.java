import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vsl";

        get("/", (request, response) -> {
            HashMap model = new HashMap();
            model.put("template", "templates/hello.vsl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/favorite_photos", (request, response) -> {
            HashMap model = new HashMap();
            model.put("template", "templates/favorite_photos.vsl");

            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
