package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcMealRepositoryImpl implements MealRepository {

    private static final BeanPropertyRowMapper<Meal> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Meal.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insert;

    private final SimpleJdbcInsert insertUserMeal;

    @Autowired
    public JdbcMealRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("meals").usingGeneratedKeyColumns("id");
        this.insertUserMeal = new SimpleJdbcInsert(jdbcTemplate).withTableName("user_meals");
    }

    @Override
    public Meal save(Meal meal, int userId) {
        MapSqlParameterSource mapMeal = new MapSqlParameterSource()
            .addValue("id", meal.getId())
            .addValue("dateTime", meal.getDateTime())
            .addValue("description", meal.getDescription())
            .addValue("calories", meal.getCalories());

        if (meal.isNew()) {
            Number key = insert.executeAndReturnKey(mapMeal);
            meal.setId(key.intValue());

            MapSqlParameterSource mapUserMeal = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("mealId", meal.getId());
            insertUserMeal.execute(mapUserMeal);
        } else if (namedParameterJdbcTemplate.update(
            "UPDATE meals set date_time=:dateTime, description=:description, calories=:calories where id=:id", mapMeal
        ) == 0 ) {
            return null;
        }

        return meal;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    String sql = "SELECT * FROM topjava.public.meals mls INNER JOIN topjava.public.user_meals um on um.meal_id = mls.id";

    @Override
    public Meal get(int id, int userId) {
        return jdbcTemplate.query(sql + " where mls.id=? and um.user_id=?", ROW_MAPPER, id, userId).get(0);
    }

    @Override
    public List<Meal> getAll(int userId) {
        return jdbcTemplate
            .query(sql + "  WHERE um.user_id=?", ROW_MAPPER,
                userId);
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}
