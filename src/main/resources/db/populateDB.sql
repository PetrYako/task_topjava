DELETE FROM restaurants;
DELETE FROM restaurant_menu;
DELETE FROM menu_dish;
DELETE FROM user_roles;
DELETE FROM users;

ALTER SEQUENCE global_seq_restaurant RESTART WITH 100000;
ALTER SEQUENCE global_seq_user RESTART WITH 100000;

INSERT INTO restaurants(name) VALUES
    ('Burmen'),
    ('Shev');

INSERT INTO restaurant_menu(restaurant_id, votes, create_time) VALUES
    (100000, 2, '2020-01-27 15:00:00'),
    (100001, 1, '2020-01-27 15:00:00');

INSERT INTO menu_dish(menu_id, description, calories) VALUES
    (100000, 'Breakfast', 120),
    (100000, 'Lunch', 200),
    (100000, 'Dinner', 170),
    (100001, 'Food', 500);


INSERT INTO users(vote_id, password, email, vote_time) VALUES
(100000,'user', 'user@yandex.ru', '2020-01-27 16:00:00'),
(100000,'user2', 'user2@mail.ru', '2020-01-27 16:20:00'),
(100001, 'user3', 'user3@mail.ru', '2020-01-27 15:00:00'),
(null, 'admin', 'admin@yandex.ru', null);

INSERT INTO user_roles(role, user_id) VALUES
('ROLE_USER', 100000),
('ROLE_USER', 100001),
('ROLE_USER', 100002),
('ROLE_ADMIN', 100003);
