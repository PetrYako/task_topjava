DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS restaurants CASCADE;
DROP TABLE IF EXISTS restaurant_dishes;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE restaurants
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR NOT NULL,
    vote_amount INTEGER DEFAULT 0 NOT NULL
);

CREATE TABLE restaurant_dishes
(
    dishe_id     INTEGER NOT NULL,
    description  VARCHAR NOT NULL,
    calories     INTEGER NOT NULL,
    FOREIGN KEY (dishe_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE users
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    vote_time       TIMESTAMP                   NOT NULL,
    vote_id         INTEGER                     NOT NULL,
    FOREIGN KEY (vote_id) REFERENCES restaurants (id)
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);