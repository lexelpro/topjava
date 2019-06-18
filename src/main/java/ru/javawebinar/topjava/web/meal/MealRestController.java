package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

@Controller
public class MealRestController extends AbstractMealController {

    @Override
    public Meal get(int id) {
        return super.get(id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        return super.getAll(userId);
    }

    @Override
    public Meal save(Meal meal) {
        return super.save(meal);
    }
}