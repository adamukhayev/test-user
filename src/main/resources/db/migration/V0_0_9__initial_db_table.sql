CREATE SCHEMA IF NOT EXISTS test;

CREATE TABLE IF NOT EXISTS test.user (
  id SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL
);