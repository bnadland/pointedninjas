package controllers;

import com.google.inject.Singleton;
import com.google.inject.Inject;
import ninja.BasicAuthFilter;
import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;
import ninja.validation.JSR303Validation;
import ninja.validation.Validation;
import models.UserData;
import models.UserService;

@Singleton
@FilterWith(BasicAuthFilter.class)
public class UserController {

	@Inject
	UserService user;

	public Result getUser(@PathParam("id") String id) {
        return Results.json().render(user.get(id));
    }

    public Result newUser(@JSR303Validation UserData u, Validation validation) {
		if(validation.hasBeanViolations()) {
			return Results.json().status(400).render(validation.getBeanViolations());
		}
		user.set(u.name, u.description);
		return Results.json().render(u);
	}

}
