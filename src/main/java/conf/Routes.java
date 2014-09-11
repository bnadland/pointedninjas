package conf;

import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;
import controllers.UserController;

public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {  
		// index
        router.GET().route("/").with(ApplicationController.class, "index");
		// user
		router.GET().route("/user").with(UserController.class, "getUser");
		// assets
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");
    }
}
