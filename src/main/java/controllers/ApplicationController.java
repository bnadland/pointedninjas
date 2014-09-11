package controllers;

import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;

@Singleton
public class ApplicationController {
    public Result index() {
        return Results.html();
    }
}
