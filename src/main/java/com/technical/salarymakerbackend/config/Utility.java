package com.technical.salarymakerbackend.config;

import java.util.Random;

public class Utility {
    public static int getRandomId()
    {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        return n;
    }
}
