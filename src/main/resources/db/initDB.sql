DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS restaurants CASCADE;
DROP TABLE IF EXISTS restaurant_menu CASCADE;
DROP TABLE IF EXISTS menu_dish CASCADE;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq_restaurant START WITH 100000;
CREATE SEQUENCE global_seq_user START WITH 100000;

CREATE TABLE restaurants
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq_restaurant'),
    name        VARCHAR NOT NULL
);

CREATE TABLE restaurant_menu
(
    id            INTEGER   PRIMARY KEY DEFAULT nextval('global_seq_restaurant'),
    restaurant_id INTEGER   NOT NULL,
    votes         INTEGER   NOT NULL,
    create_time   TIMESTAMP NOT NULL,
    CONSTRAINT restaurant_menu_idx UNIQUE (restaurant_id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE menu_dish
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq_restaurant'),
    menu_id     INTEGER NOT NULL,
    description VARCHAR NOT NULL,
    calories    INTEGER NOT NULL
);

CREATE TABLE users
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq_user'),
    vote_id         INTEGER,
    password        VARCHAR                     NOT NULL,
    email           VARCHAR                     NOT NULL,
    vote_time       TIMESTAMP
);
CREATE UNIQUE INDEX users_unique_email_idx ON users(email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);