#
# Define the path to the implementation source files.
#
TEST_SRC_DIR = ../../../testing/implementation/src/java/CSTutor/Model

#
# Makefile for CSTutor prototype.
#
MODULES = CSTutor/View/Progress \
		CSTutor/View/Quiz \
		CSTutor/View/Chat \
		CSTutor/View/User \
		CSTutor/View/Manager \
		CSTutor/View/Tutorial \
		CSTutor/View \
		CSTutor/Model/Chat \
		CSTutor/Model/Database \
		CSTutor/Model/Manager \
		CSTutor/Model/Progress \
		CSTutor/Model/Quiz \
		CSTutor/Model/Tutorial \
		CSTutor/Model/User

JAVA = CSTutor/View/*.java \
		CSTutor/View/Progress/*.java \
		CSTutor/View/Quiz/*.java \
		CSTutor/View/Chat/*.java \
		CSTutor/View/User/*.java \
		CSTutor/View/Manager/*.java \
		CSTutor/View/Tutorial/*.java \
		CSTutor/Model/Chat/*.java \
		CSTutor/Model/Chat/Client/*.java \
		CSTutor/Model/Chat/Server/*.java \
		CSTutor/Model/Database/*.java \
		CSTutor/Model/Manager/*.java \
		CSTutor/Model/Progress/*.java \
		CSTutor/Model/Quiz/*.java \
		CSTutor/Model/Tutorial/*.java \
		CSTutor/Model/User/*.java

CLASS = CSTutor/View/*.class \
		CSTutor/View/Progress/*.class \
		CSTutor/View/Quiz/*.class \
		CSTutor/View/Chat/*.class \
		CSTutor/View/User/*.class \
		CSTutor/View/Manager/*.class \
		CSTutor/View/Tutorial/*.class \
		CSTutor/Model/Chat/*.class \
		CSTutor/Model/Chat/Client/*.java \
		CSTutor/Model/Chat/Server/*.java \
		CSTutor/Model/Database/*.class \
		CSTutor/Model/Manager/*.class \
		CSTutor/Model/Progress/*.class \
		CSTutor/Model/Quiz/*.class \
		CSTutor/Model/Tutorial/*.class \
		CSTutor/Model/User/*.class

TESTS = $(TEST_SRC_DIR)/User/*.java \
		$(TEST_SRC_DIR)/Tutorial/*.java \
		$(TEST_SRC_DIR)/Progress/*.java \
		$(TEST_SRC_DIR)/Database/*.java \
		$(TEST_SRC_DIR)/Manager/*.java 

TEST_CLASS = CSTutor.Model.User.PasswordTest \
		CSTutor.Model.User.RegisterTest \
		CSTutor.Model.User.UserTest \
		CSTutor.Model.Tutorial.TutorialDataTest \
		CSTutor.Model.Tutorial.TutorialEditorTest \
		CSTutor.Model.Progress.ClassListModelTest \
		CSTutor.Model.Progress.ClassTest \
		CSTutor.Model.Progress.StudentListModelTest \
		CSTutor.Model.Progress.StudentTest \
		CSTutor.Model.Progress.TutorialDataTest \
		CSTutor.Model.Progress.TutorialListModelTest \
		CSTutor.Model.Database.TutorDBTest \
		CSTutor.Model.Manager.ManagerTest \



all:		dir compile jar clean

compile:	$(FILE)
		javac -cp CSTutor/Model/User/commons-validator-1.4.1.jar:CSTutor/Model/User/jbcrypt.jar:CSTutor/Model/Database/*:CSTutor/View/*:. -g -d .classes $(JAVA)

jar:		$(FILE)
		cd .classes ; \
		cp ../CSTutor/Model/Database/tutordb.sql CSTutor/Model/Database/tutordb.sql ; \
		jar cmf Manifest.txt ../CSTutor.jar CSTutor/Model/Database/tutordb.sql $(CLASS) ; \
		cd ../ \
		chmod a+x CSTutor.jar ; 

doc:		
		javadoc -Xdoclint:none -private -d .javadoc -doctitle "CSTutor Prototype" -windowtitle "CSTutor Prototype" -overview CSTutor/View/overview.html $(JAVA)
		rm -rf ../../../design/javadoc
		mv .javadoc ../../../design/javadoc

doc7:		
		javadoc -private -d .javadoc -doctitle "CSTutor Prototype" -windowtitle "CSTutor Prototype" -overview CSTutor/View/overview.html $(JAVA)
		rm -rf ../../../design/javadoc
		mv .javadoc ../../../design/javadoc

dir:	
		mkdir -p .classes
		cp Manifest.txt .classes/Manifest.txt
		ls -a

clean:
		rm -rf .classes/ .javadoc/

run:
		java -cp CSTutor.jar:CSTutor/Model/User/commons-validator-1.4.1.jar:CSTutor/Model/User/jbcrypt.jar:CSTutor/View/weblaf-complete-1.28.jar:CSTutor/View/AbsoluteLayout.jar:CSTutor/Model/Database/sqlite-jdbc-3.8.7.jar CSTutor.View.Overview

TestDir:	
		mkdir -p .TestClasses

test_comp:
		javac -cp .:CSTutor.jar:junit-4.7.jar:CSTutor/Model/User/commons-validator-1.4.1.jar:CSTutor/Model/User/jbcrypt.jar -g -d .TestClasses $(TESTS)

test_run:
		cd .TestClasses ; \
		java -cp .:../CSTutor.jar:../junit-4.7.jar:../CSTutor/Model/Database/*:../CSTutor/Model/User/commons-validator-1.4.1.jar:../CSTutor/Model/User/jbcrypt.jar org.junit.runner.JUnitCore $(TEST_CLASS)

test_clean:
		cd ../; \
		rm -rf .TestClasses/

test:	TestDir all test_comp test_run test_clean

test7:	TestDir test_comp test_run test_clean
