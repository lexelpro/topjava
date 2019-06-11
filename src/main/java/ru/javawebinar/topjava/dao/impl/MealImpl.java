package ru.javawebinar.topjava.dao.impl;

import ru.javawebinar.topjava.dao.IMeal;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.stream.Collectors;

public class MealImpl implements IMeal {
    @Override
    public void save(Meal meal) {
        if (meal.getId() == null) {
            MealsUtil.meals.add(meal);
        } else {
            MealsUtil.meals = MealsUtil.meals.stream().map(m -> {
                if(m.getId().equals(meal.getId())) {
                    return meal;
                } else {
                    return m;
                }

            }).collect(Collectors.toList());
        }

    }

    @Override
    public void delete(Long mealId) {
        MealsUtil.meals = MealsUtil.meals.stream().filter(meal -> !meal.getId().equals(mealId)).collect(Collectors.toList());
    }
}
