CREATE TABLE IF NOT EXISTS Classes (
   name TEXT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Sections (
   className TEXT,
   sectionNum INTEGER,
   FOREIGN KEY(className) REFERENCES Classes(name),
   PRIMARY KEY(className, sectionNum)
);

CREATE TABLE IF NOT EXISTS Units (
   name TEXT,
   className TEXT,
   sectionNum INTEGER,
   FOREIGN KEY(className, sectionNum) REFERENCES Sections(className, sectionNum)
   PRIMARY KEY(name, className, sectionNum)
);

CREATE TABLE IF NOT EXISTS Quizzes (
   id INTEGER AUTO_INCREMENT PRIMARY KEY,
   name TEXT NOT NULL,
   permissions TEXT NOT NULL,
   owner TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Users (
   username TEXT PRIMARY KEY,
   hash TEXT,
   firstname TEXT,
   lastname TEXT,
   instructor BOOLEAN
);

REPLACE INTO classes(name) VALUES
   ("CSC 101"),
   ("CSC 102"),
   ("CSC 103"),
   ("CSC 121"),
   ("CSC 225"),
   ("CSC 300"),
   ("CSC 305"),
   ("CSC 307"),
   ("CSC 308"),
   ("CSC 309"),
   ("CSC 349"),
   ("CSC 357"),
   ("CSC 365"),
   ("CSC 378");

REPLACE INTO sections(className, sectionNum) VALUES
   ("CSC 101", 1),
   ("CSC 101", 2),
   ("CSC 101", 3),
   ("CSC 101", 4),
   ("CSC 101", 5),
   ("CSC 102", 1),
   ("CSC 102", 2),
   ("CSC 102", 3),
   ("CSC 102", 4),
   ("CSC 102", 5),
   ("CSC 103", 1),
   ("CSC 103", 2),
   ("CSC 103", 3),
   ("CSC 103", 4),
   ("CSC 103", 5),
   ("CSC 121", 1),
   ("CSC 121", 2),
   ("CSC 121", 3),
   ("CSC 121", 4),
   ("CSC 121", 5),
   ("CSC 225", 1),
   ("CSC 225", 2),
   ("CSC 225", 3),
   ("CSC 225", 4),
   ("CSC 225", 5),
   ("CSC 300", 1),
   ("CSC 300", 2),
   ("CSC 300", 3),
   ("CSC 300", 4),
   ("CSC 300", 5);