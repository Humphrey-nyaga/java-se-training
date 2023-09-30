package com.systechafrica.part3.collections;

import java.util.*;

public class WorkingWithMaps {
    public static void main(String[] args) {

        List<String> europeCountries = List.of("Germany","Italy","Switzerland","Poland","Netherlands");

        List<String> africaCountries = List.of("Kenya","South Africa","Morocco","Mauritius","Ghana");

        Map<String, List<String>> continentCountries = new HashMap<>();

        continentCountries.put("europe", europeCountries);
        continentCountries.put("africa", africaCountries);

        System.out.println("continentCountries = " + continentCountries);
        Set<Map.Entry<String, List<String>>> entrySet = continentCountries.entrySet();
        Set<String> keySet = continentCountries.keySet();
        Collection<List<String>> values = continentCountries.values();

        for (Map.Entry<String, List<String>> record : entrySet) {
            System.out.println(record.getKey() + " => " + record.getValue());
        }
        for (List<String> value : values) {
            System.out.println(value);
        }
        for (String key : keySet) {
            System.out.println(key);
        }
        System.out.println("Africa Countries: "+continentCountries.get("africa"));
        System.out.println("Contains Key europe: "+continentCountries.containsKey("europe"));
        System.out.println("Contains value africaCountries: "+continentCountries.containsValue(africaCountries));
        System.out.println("Europe Countries: "+continentCountries.get("africa"));
    }
}
