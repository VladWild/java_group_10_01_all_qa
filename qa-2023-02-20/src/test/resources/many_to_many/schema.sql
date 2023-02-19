CREATE TABLE IF NOT EXISTS book (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS author (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS book_author (
    book_id int,
    author_id int,
    CONSTRAINT book_author_pkey PRIMARY KEY (book_id, author_id)
);