package controllers;

import java.util.Map;

import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import services.UserService;

@Singleton
public class UserController {

	@Inject
	UserService user;

	public Result getUser() {
        return Results.json().render(user.get("bnadland"));
    }

    public Result newUser() {
		return Results.TODO();
	}

}
