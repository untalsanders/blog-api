DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
  id INTEGER PRIMARY KEY,
  title VARCHAR(512) NOT NULL,
  content TEXT NOT NULL,
  author CHARACTER(100) NOT NULL
);

CREATE INDEX posts_title ON posts (title);
