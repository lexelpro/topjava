package ru.javawebinar.topjava.service;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

@ContextConfiguration({
    "classpath:spring/spring-app.xml",
    "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

  static {
    // Only for postgres driver logging
    // It uses java.util.logging and logged via jul-to-slf4j bridge
    SLF4JBridgeHandler.install();
  }

  @Autowired
  private MealService mealService;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void get() {
    Meal meal = mealService.get(100002, 100000);
    assertEquals(100002, meal.getId().intValue());
  }

  @Test(expected = NotFoundException.class)
  public void getNotOwnMeal() {
    Meal meal = mealService.get(100002, 100001);
  }

  @Test
  public void delete() {
    mealService.delete(100002, 100000);
    assertEquals(1, mealService.getAll(100000).size());
  }

  @Test(expected = NotFoundException.class)
  public void deleteNotOwnMeal() {
    mealService.delete(100002, 100001);
    assertEquals(1, mealService.getAll(100000).size());
  }

  @Test
  public void getBetweenDates() {
  }

  @Test
  public void getBetweenDateTimes() {
  }

  @Test
  public void getAll() {
    List<Meal> meals = mealService.getAll(100000);
    assertEquals(2, meals.size());
  }

  @Test
  public void update() {
    Meal meal = mealService.get(100002, 100000);
    meal.setCalories(235);
    mealService.update(meal, 100000);
    Meal updatedMeal = mealService.get(100002, 100000);
    assertEquals(235, updatedMeal.getCalories());
  }


  @Test(expected = NotFoundException.class)
  public void updateNotOwn() {
    Meal meal = mealService.get(100002, 100001);
    meal.setCalories(235);
    mealService.update(meal, 100001);
  }

  @Test
  public void create() {
  }
}