DELETE FROM restaurants;
DELETE FROM restaurant_dishes;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;
ALTER SEQUENCE global_seq_user RESTART WITH 100000;

INSERT INTO restaurants(name, vote_amount) VALUES
    ('Restaurant1', 2),
    ('Restaurant2', 1),
    ('Restaurant3', 0);

INSERT INTO restaurant_dishes(dishe_id, description, calories) VALUES
    (100000, 'Fish', 100),
    (100001, 'Chicken', 150),
    (100001, 'Soup', 100),
    (100002, 'Food', 200);

INSERT INTO users(vote_time, vote_id) VALUES
    ('2020-01-06 9:00:00', 100000),
    ('2020-01-06 9:20:00', 100000),
    ('2020-01-06 8:00:00', 100001);

INSERT INTO user_roles(role, user_id) VALUES
    ('ROLE_USER', 100000),
    ('ROLE_USER', 100001),
    ('ROLE_USER', 100002),
    ('ROLE_ADMIN', 100002);
