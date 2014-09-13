package controllers;

import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;
import com.google.inject.Singleton;
import com.google.inject.Inject;
import services.UserService;

@Singleton
public class UserController {

	@Inject
	UserService user;

	public Result getUser(@PathParam("id") String id) {
        return Results.json().render(user.get(id));
    }

	public Result updateUser() {
		return Results.TODO();
	}

    public Result newUser() {
		return Results.TODO();
	}

}
