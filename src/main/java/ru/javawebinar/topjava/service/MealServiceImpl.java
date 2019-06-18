package ru.javawebinar.topjava.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.Collection;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class MealServiceImpl implements MealService {
    private static final Logger LOG = getLogger(MealServiceImpl.class);

    @Autowired
    private MealRepository repository;

    @Override
    public Collection<Meal> getAll(int userId) {
        LOG.info("getAll {}", userId);
        return repository.getAll(userId);
    }

    @Override
    public Meal get(int id) {
        LOG.info("get {}", id);
        return repository.get(id);
    }

    @Override
    public Meal save(Meal meal) {
        LOG.info("save {}", meal);
        return repository.save(meal);
    }


    @Override
    public void delete(int id) {
        LOG.info("delete {}", id);
        repository.delete(id);
    }
}