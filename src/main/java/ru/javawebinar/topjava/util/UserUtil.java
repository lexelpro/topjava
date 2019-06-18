package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UserUtil {

    public static final List<User> USERS = Arrays.asList(
            new User(null, "Varij", "varij@mail.com", "12345", Role.ROLE_USER),
            new User(null, "Dominic", "dominic@mail.com", "12345", Role.ROLE_USER),
            new User(null, "Alex", "alex@mail.com", "12345", Role.ROLE_ADMIN)

    );

}
