package com.example.rupizza.interfaces;

import com.example.rupizza.Pizza;

public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}
