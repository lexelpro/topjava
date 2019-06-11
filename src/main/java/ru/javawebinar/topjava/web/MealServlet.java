package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       LOG.debug("Meal Servlet");
        List<MealTo> mealToList = MealsUtil.getFilteredWithExcess(MealsUtil.meals, LocalTime.of(0, 0), LocalTime.of(23, 0), 2000);
        req.setCharacterEncoding("utf-8");
        req.setAttribute("meals", mealToList);
        if (req.getParameterMap().containsKey("id")) {
            String idString = req.getParameterMap().get("id")[0];
            Long id = Long.parseLong(idString);
            if (id != null) {
                LOG.debug("id = " + id);
            }
            Optional<Meal> optionalMeal = MealsUtil.meals.stream().filter(meal -> meal.getId().equals(id)).findAny();
            if (optionalMeal.isPresent()) {
                req.setAttribute("editMeal", optionalMeal.get());
                req.getRequestDispatcher("editMeal.jsp").forward(req, resp);
            }

        }
//        resp.sendRedirect("meals.jsp");
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        LOG.debug("Meal Servlet doPost ", req.getParameterMap());
        Long id = Long.valueOf(req.getParameter("id"));
        String description = req.getParameter("description");
        int calories = Integer.parseInt(req.getParameter("calories"));
        LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("dateTime"));
        Meal meal = new Meal(id, dateTime, description, calories);

        MealsUtil.meals = MealsUtil.meals.stream().map(m -> {
            if(m.getId().equals(meal.getId())) {
                return meal;
            } else {
                return m;
            }

        }).collect(Collectors.toList());
        List<MealTo> mealToList = MealsUtil.getFilteredWithExcess(MealsUtil.meals, LocalTime.of(0, 0), LocalTime.of(23, 0), 2000);
        req.setAttribute("meals", mealToList);
        req.getRequestDispatcher("meals.jsp").forward(req, resp);


    }
}
