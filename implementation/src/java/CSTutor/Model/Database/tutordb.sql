CREATE TABLE IF NOT EXISTS Classes (
   className TEXT PRIMARY KEY,
   accessLevel TEXT
);

CREATE TABLE IF NOT EXISTS Sections (
   sectionName TEXT,
   className TEXT,
   professor TEXT,
   FOREIGN KEY(className) REFERENCES Classes(className),
   FOREIGN KEY(professor) REFERENCES Users(username),
   PRIMARY KEY(sectionNum, className)
);

CREATE TABLE IF NOT EXISTS Units (
   unitName TEXT,
   sectionName TEXT,
   className TEXT,
   FOREIGN KEY(sectionName, className) REFERENCES Sections(sectionName, className),
   PRIMARY KEY(name, sectionName, className)
);

CREATE TABLE IF NOT EXISTS Tutorials (
   tutorialName TEXT,
   unitName TEXT,
   sectionName TEXT,
   className TEXT,
   FOREIGN KEY(unitName, sectionName, className) REFERENCES Units(unitName, sectionName, className),
   PRIMARY KEY(name, unitName, sectionName, className)
);

CREATE TABLE IF NOT Exists Pages (
   pageName TEXT,
   tutorialName TEXT,
   unitName TEXT,
   sectionName TEXT,
   className TEXT,
   FOREIGN KEY(tutorialName, unitName, sectionName, className) REFERENCES Tutorials(tutorialName, unitName, sectionName, className),
   PRIMARY KEY(name, tutorialName, unitName, className, sectionName)
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
   permissions TEXT
);

CREATE TABLE IF NOT EXISTS TutorialData (
   id INTEGER PRIMARY KEY,
   title TEXT,
   description TEXT,
   syntax TEXT,
   exampleCode TEXT,
   exampleOutput TEXT,
   tryItYourself TEXT,
   hasSeen TEXT
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
