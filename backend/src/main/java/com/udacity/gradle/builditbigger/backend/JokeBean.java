package com.udacity.gradle.builditbigger.backend;

import com.example.jokelibrary.Joker;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

    private String joke;
    public String getJokes (){
        return joke;
    }

    public void setJoke (String joke){
        this.joke = joke;
    }
}