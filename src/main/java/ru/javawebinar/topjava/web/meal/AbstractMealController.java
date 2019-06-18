package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.Collection;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class AbstractMealController {

    private static final Logger LOG = getLogger(AbstractMealController.class);

    @Autowired
    private MealService mealService;

    public Collection<Meal> getAll(int userId){
        LOG.info("getAll");
        return mealService.getAll(userId);
    }


    public Meal get(int id) {
        LOG.info("get {}", id);
        return mealService.get(id);
    }

    public Meal save(Meal meal) {
        LOG.info("save {}", meal);
        return mealService.save(meal);
    }

    public void delete(int id) {
        LOG.info("delete {}", id);
        mealService.delete(id);
    }

}
