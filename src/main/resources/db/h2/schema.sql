DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
    id INTEGER PRIMARY KEY,
    title CHARACTER(100) NOT NULL,
    content CHARACTER NOT NULL
);

CREATE INDEX posts_title ON posts (title);
