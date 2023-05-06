// 
// 
// 

package com.util;

import java.util.Random;

public class CheckCode
{
    public String getCheckCode() {
        final Random random = new Random();
        String sRand = "";
        for (int i = 0; i < 4; ++i) {
            final String rand = String.valueOf(random.nextInt(10));
            sRand = String.valueOf(sRand) + rand;
        }
        return sRand;
    }
}
