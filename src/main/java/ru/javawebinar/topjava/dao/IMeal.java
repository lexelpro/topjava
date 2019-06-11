package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

public interface IMeal {
    void save(Meal meal);
    void delete (Long mealId);
}
