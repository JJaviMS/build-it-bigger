package com.example.jokelibrary;

import java.util.Random;

public class Joker {
    private static String [] jokes = {
            "Some people, when confronted with a problem, think, 'I know, I'll use threads' - and then two they have problems.",
            "Knock knock.\n" +
                    "\n" +
                    "Race condition.\n" +
                    "\n" +
                    "Who's there?",
            "What's the best thing thing about UDP jokes?\n" +
                    "\n" +
                    "I don't care if you get them",
            "Java and C were telling jokes. It was C's turn, so he writes something on the wall, points to it and says \"Do you get the reference?\" But Java didn't."
    };

    public static String tellJoke (){
        Random random = new Random();
        return jokes[random.nextInt(jokes.length)];
    }
}
