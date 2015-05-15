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
   PRIMARY KEY(sectionName, className)
);

CREATE TABLE IF NOT EXISTS Units (
   unitName TEXT,
   sectionName TEXT,
   className TEXT,
   FOREIGN KEY(sectionName, className) REFERENCES Sections(sectionName, className),
   PRIMARY KEY(unitName, sectionName, className)
);

CREATE TABLE IF NOT EXISTS Tutorials (
   tutorialName TEXT,
   unitName TEXT,
   sectionName TEXT,
   className TEXT,
   FOREIGN KEY(unitName, sectionName, className) REFERENCES Units(unitName, sectionName, className),
   PRIMARY KEY(tutorialName, unitName, sectionName, className)
);

CREATE TABLE IF NOT Exists Pages (
   pageName TEXT,
   tutorialName TEXT,
   unitName TEXT,
   sectionName TEXT,
   className TEXT,
   FOREIGN KEY(tutorialName, unitName, sectionName, className) REFERENCES Tutorials(tutorialName, unitName, sectionName, className),
   PRIMARY KEY(pageName, tutorialName, unitName, className, sectionName)
);

CREATE TABLE IF NOT EXISTS Quizzes (
   id INTEGER AUTO_INCREMENT PRIMARY KEY,
   name TEXT NOT NULL,
   accessLevel TEXT NOT NULL,
   owner TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Users (
   username TEXT PRIMARY KEY,
   hash TEXT,
   firstname TEXT,
   lastname TEXT,
   accessLevel TEXT
);

CREATE TABLE IF NOT EXISTS TutorialData (
   id INTEGER PRIMARY KEY,
   title TEXT,
   description TEXT,
   syntax TEXT,
   exampleCode TEXT,
   exampleOutput TEXT,
   tryItYourself TEXT
);

CREATE TABLE IF NOT EXISTS Authorizations (
   username TEXT,
   sectionName TEXT,
   className TEXT,
   FOREIGN KEY(username) REFERENCES Users(username),
   PRIMARY KEY(username, sectionName, className)
);

REPLACE INTO Classes(className, accessLevel) VALUES
   ("CSC 101", "Guest"),
   ("CSC 102", "Guest"),
   ("CSC 103", "Guest"),
   ("CSC 121", "Guest"),
   ("CSC 225", "Guest"),
   ("CSC 300", "Guest"),
   ("CSC 305", "Guest"),
   ("CSC 307", "Guest"),
   ("CSC 308", "Guest"),
   ("CSC 309", "Guest"),
   ("CSC 349", "Guest"),
   ("CSC 357", "Guest"),
   ("CSC 365", "Guest"),
   ("CSC 378", "Guest"),
   ("CSC 453", "Guest");

REPLACE INTO Sections(sectionName, className, professor) VALUES
   ("Section1", "CSC 101", ""),
   ("Section2", "CSC 101", ""),
   ("Section3", "CSC 101", ""),
   ("Section1", "CSC 102", ""),
   ("Section2", "CSC 102", ""),
   ("Section3", "CSC 102", ""),
   ("Section1", "CSC 103", ""),
   ("Section2", "CSC 103", ""),
   ("Section3", "CSC 103", "");

REPLACE INTO Units(unitName, sectionName, className) VALUES
   ("Unit1", "Section1", "CSC 101"),
   ("Unit1", "Section2", "CSC 101"),
   ("Unit1", "Section3", "CSC 101"),
   ("Unit1", "Section1", "CSC 102"),
   ("Unit1", "Section2", "CSC 102"),
   ("Unit1", "Section3", "CSC 102"),
   ("Unit1", "Section1", "CSC 103"),
   ("Unit1", "Section2", "CSC 103"),
   ("Unit1", "Section3", "CSC 103");

REPLACE INTO Tutorials(tutorialName, unitName, sectionName, className) VALUES
   ("Tutorial", "Unit1", "Section1", "CSC 101"),
   ("Tutorial", "Unit1", "Section2", "CSC 101"),
   ("Tutorial", "Unit1", "Section3", "CSC 101"),
   ("Tutorial", "Unit1", "Section1", "CSC 102"),
   ("Tutorial", "Unit1", "Section2", "CSC 102"),
   ("Tutorial", "Unit1", "Section3", "CSC 102"),
   ("Tutorial", "Unit1", "Section1", "CSC 103"),
   ("Tutorial", "Unit1", "Section2", "CSC 103"),
   ("Tutorial", "Unit1", "Section3", "CSC 103");

REPLACE INTO Pages(pageName, tutorialName, unitName, sectionName, className) VALUES
   ("Page1", "Tutorial", "Unit1", "Section1", "CSC 101"),
   ("Page2", "Tutorial", "Unit1", "Section1", "CSC 101"),
   ("Page3", "Tutorial", "Unit1", "Section1", "CSC 101"),
   ("Page1", "Tutorial", "Unit1", "Section2", "CSC 101"),
   ("Page2", "Tutorial", "Unit1", "Section2", "CSC 101"),
   ("Page3", "Tutorial", "Unit1", "Section2", "CSC 101"),
   ("Page1", "Tutorial", "Unit1", "Section3", "CSC 101"),
   ("Page2", "Tutorial", "Unit1", "Section3", "CSC 101"),
   ("Page3", "Tutorial", "Unit1", "Section3", "CSC 101"),
   ("Page1", "Tutorial", "Unit1", "Section1", "CSC 102"),
   ("Page2", "Tutorial", "Unit1", "Section1", "CSC 102"),
   ("Page3", "Tutorial", "Unit1", "Section1", "CSC 102"),
   ("Page1", "Tutorial", "Unit1", "Section2", "CSC 102"),
   ("Page2", "Tutorial", "Unit1", "Section2", "CSC 102"),
   ("Page3", "Tutorial", "Unit1", "Section2", "CSC 102"),
   ("Page1", "Tutorial", "Unit1", "Section3", "CSC 102"),
   ("Page2", "Tutorial", "Unit1", "Section3", "CSC 102"),
   ("Page3", "Tutorial", "Unit1", "Section3", "CSC 102"),
   ("Page1", "Tutorial", "Unit1", "Section1", "CSC 103"),
   ("Page2", "Tutorial", "Unit1", "Section3", "CSC 102"),
   ("Page3", "Tutorial", "Unit1", "Section3", "CSC 102"),
   ("Page1", "Tutorial", "Unit1", "Section2", "CSC 103"),
   ("Page2", "Tutorial", "Unit1", "Section3", "CSC 102"),
   ("Page3", "Tutorial", "Unit1", "Section3", "CSC 102"),
   ("Page1", "Tutorial", "Unit1", "Section3", "CSC 103"),
   ("Page2", "Tutorial", "Unit1", "Section3", "CSC 103"),
   ("Page3", "Tutorial", "Unit1", "Section3", "CSC 103");
