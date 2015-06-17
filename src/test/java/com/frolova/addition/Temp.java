package com.frolova.addition;

import java.util.Random;

/**
 * Created by Frolova.A on 4/28/15.
 */
public class Temp {
    public static String randomtxt(int n){
        char[] str = {'z','x','a','s','d','f','g','h','j','k','l','q','w','e','r','t','y','u','u','i','c','v','b','n','m','o','p'};
        StringBuilder sb = new StringBuilder();
        Random random = new Random(100);
        for(int x = 1; x < n; x++) {
            sb.append(str[random.nextInt(str.length)]);
        }
        return sb.toString();
    };
}
