package com.systechafrica.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestaurantTest {

    @BeforeEach
    void setup() {
        List<Meal> mealsList = new ArrayList<>();
        mealsList.add(new Meal(1, "CHAI", 15));
        mealsList.add(new Meal(2, "ANDAZI", 10));
        mealsList.add(new Meal(3, "TOSTI", 12));
        mealsList.add(new Meal(4, "NDENGU AND ACCOMPLISHMENTS", 70));
        mealsList.add(new Meal(5, "BEANS AND ACCOMPLISHMENTS", 70));
        mealsList.add(new Meal(6, "PILAU VEG", 90));
    }

    @Test
    void billing() {
        Restaurant restaurant = new Restaurant();
        List<Integer> orderedMealsIDsList = new ArrayList<>();
        orderedMealsIDsList.add(1);
        orderedMealsIDsList.add(2);
        orderedMealsIDsList.add(3);
        double totalBill = restaurant.billing(orderedMealsIDsList);
        assertEquals(37, totalBill);
    }

 @Test
 void billingWithNoMeals() {
     Restaurant restaurant = new Restaurant();
     List<Integer> orderedMealsIDsList = new ArrayList<>();
     double totalBill = restaurant.billing(orderedMealsIDsList);
     assertEquals(0, totalBill);
 }


}
