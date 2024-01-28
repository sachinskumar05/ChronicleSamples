package com.sachin.chronicle.sample.core.map;

import net.openhft.chronicle.map.*;

import java.io.File;
import java.io.IOException;

public class ChronicleMapExample {
    public static void main(String[] args) {
        try (ChronicleMap<String, Integer> map = ChronicleMap
                .of(String.class, Integer.class)
                .averageKey("defaultKey")
                .averageValue(0)
                .entries(1000)
                .createOrRecoverPersistedTo(new File("./chronicle/map.dat"))) {

            map.put("key1", 42);

            int value = map.get("key1");
            System.out.println("Value: " + value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
