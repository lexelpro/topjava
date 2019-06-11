package ru.javawebinar.topjava.dao.impl;

import ru.javawebinar.topjava.dao.IMeal;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.stream.Collectors;

public class MealImpl implements IMeal {
    @Override
    public void save(Meal meal) {
        MealsUtil.meals.add(meal);
    }

    @Override
    public void delete(Long mealId) {
        MealsUtil.meals = MealsUtil.meals.stream().filter(meal -> !meal.getId().equals(mealId)).collect(Collectors.toList());
    }
}
