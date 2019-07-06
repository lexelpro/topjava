DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM user_meals;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (description, calories) values ('breakfast', 1000), ('dinner', 500);

insert into user_meals (user_id, meal_id) VALUES (100000, 100002), (100000, 100003);