import models.Backpack;
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
            request.session().attribute("currentStore", store);
            List<Item> goods = store.goodsBank();
            data.put("allGoods", goods);
            return new ModelAndView(data, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //Backpack page displays current items, total weight, and total cost
        post("/backpack/:id", (request, response) -> {
            Map<String, Object> data = new HashMap<>();
            Backpack myBackpack = new Backpack();
            Distributor runningStore = request.session().attribute("currentStore");
            int quantity = Integer.parseInt(request.queryParams("good"));
            String goodID = request.params("id");

            Item foundItem = runningStore.findById(goodID);
            foundItem.setQuantity(quantity);
            myBackpack.setPacked(foundItem);
            List<Item> whatsPacked = myBackpack.getPacked();
            data.put("packedGoods", whatsPacked);
            data.put("backpack", myBackpack);
            return new ModelAndView(data, "backpack.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
