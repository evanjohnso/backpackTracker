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
            //Create homepage for user and their backpack and items to be distributed
            Distributor store = new Distributor();
            Backpack myBackpack = new Backpack();

            //save these for later use
            request.session().attribute("currentStore", store);
            request.session().attribute("userBackpack", myBackpack);

            //display items from store on the page
            List<Item> goods = store.goodsBank();
            data.put("allGoods", goods);

            return new ModelAndView(data, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //Backpack page displays current items, total weight, and total cost
        post("/backpack/:id", (request, response) -> {
            Map<String, Object> data = new HashMap<>();
            //Grab backpack and items from server
            Backpack userBackpack = request.session().attribute("userBackpack");
            Distributor runningStore = request.session().attribute("currentStore");

            //Find item by ID in the store and return it
            int quantity = Integer.parseInt(request.queryParams("good"));
            String goodID = request.params("id");
            Item foundItem = runningStore.findById(goodID);

            //throw the item and it's quantity into the backpack
            userBackpack.setPacked(foundItem, quantity);

            //look through the user's backpack and display each one on the html page
            List<Item> whatsPacked = userBackpack.getPacked();
            data.put("packedGoods", whatsPacked);
            data.put("backpack", userBackpack);


            return new ModelAndView(data, "backpack.hbs");
        }, new HandlebarsTemplateEngine());

        get("/backpack", (request, response) -> {
            Map<String, Object> data = new HashMap<>();
            Backpack userBackpack = request.session().attribute("userBackpack");
            List<Item> whatsPacked = userBackpack.getPacked();
            data.put("packedGoods", whatsPacked);
            data.put("backpack", userBackpack);
            return new ModelAndView(data, "backpack.hbs");
        }, new HandlebarsTemplateEngine());

        get("/home", (request, response) -> {
            Map<String, Object> data = new HashMap<>();
            //grab specific user's information
            Backpack userBackpack = request.session().attribute("userBackpack");
            Distributor runningStore = request.session().attribute("currentStore");

            List<Item> goods = runningStore.goodsBank();
            data.put("allGoods", goods);

            return new ModelAndView(data, "index.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
