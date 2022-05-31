package com.bridgelabz;

import java.util.HashMap;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

public class UserID {
    public static HashMap<String, List<Ride>> Account =  new HashMap<>();
    private static String key;
    private static List<Ride> inputRides;

    public static void AddRide(String key,List<Ride> inputRides)
    {
        UserID.key = key;
        UserID.inputRides = inputRides;
        try {
            if (key.isEmpty()) {
                throw new IllegalArgumentException(key);
            }
            if (inputRides.isEmpty()) {
                throw new IllegalArgumentException((Throwable) inputRides);
            }
            if (Account.containsKey(key)) {
                Account.put(key, inputRides);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
