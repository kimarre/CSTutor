CREATE TABLE IF NOT EXISTS users (
   username TEXT PRIMARY KEY,
   first TEXT NOT NULL,
   last TEXT NOT NULL,
   permissions TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS quizzes (
   id INTEGER AUTO_INCREMENT PRIMARY KEY,
   name TEXT NOT NULL,
   permissions TEXT NOT NULL,
   owner TEXT NOT NULL
);