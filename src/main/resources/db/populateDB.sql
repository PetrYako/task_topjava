DELETE FROM restaurants;
DELETE FROM restaurant_dishes;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users(password, email, vote_time) VALUES
    ('user', 'user@yandex.ru', '2020-01-06 9:00:00'),
    ('user2', 'user2@mail.ru', '2020-01-06 9:20:00'),
    ('admin', 'admin@yandex.ru', '2020-01-06 8:00:00');

INSERT INTO user_roles(role, user_id) VALUES
    ('ROLE_USER', 100000),
    ('ROLE_USER', 100001),
    ('ROLE_ADMIN', 100002);

INSERT INTO restaurants(name, vote_amount) VALUES
    ('Restaurant1', 2),
    ('Restaurant2', 1),
    ('Restaurant3', 0);

INSERT INTO restaurant_dishes(restaurant_id, description, calories) VALUES
    (100003, 'Fish', 100),
    (100004, 'Chicken', 150),
    (100004, 'Soup', 100),
    (100005, 'Food', 200);
