package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;
import java.util.List;

public interface MealService {
    Collection<Meal> getAll(int userId);

    Meal get(int id);

    Meal save(Meal meal);

    void delete(int id);
}