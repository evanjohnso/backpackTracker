import models.Distributor;
import models.Item;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.staticFileLocation;
import static spark.Spark.*;

/**
 * Created by Guest on 8/9/17.
 */
public class App {
    public static void main(String[] args) {
    staticFileLocation("/public");

    //Homepage displays coded items
        get("/", (request, response) -> {
            Map<String, Object> data = new HashMap<>();
            Distributor store = new Distributor();
            List<Item> goods = store.goodsBank();
            data.put("allGoods", goods);
            return new ModelAndView(data, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //Backpack page displays current items, total weight, and total cost
        post("/backpack", (request, response) -> {
            Map<String, Object> data = new HashMap<>();

            return new ModelAndView(data, "backpack.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
