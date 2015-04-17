#
# Makefile for CSTutor prototype.
#
MODULES =	View/Overview \
		View/Progress \
		View/Quiz \
		View/Chat \
		View/Login \
		View/Manager \
		View/Tutorial \
		Model/Chat \
		Model/Database \
		Model/Manager \
		Model/Progress \
		Model/Quiz \
		Model/Tutorial \
		Model/Tutorial/AuthorTutorial \
		Model/Tutorial/StudentTutorial \
		Model/User

FILES =		View/Overview/*.java \
		View/Progress/*.java \
		View/Quiz/*.java \
		View/Chat/*.java \
		View/Login/*.java \
		View/Manager/*.java \
		View/Tutorial/*.java \
		Model/Chat/*.java \
		Model/Database/*.java \
		Model/Manager/*.java \
		Model/Progress/*.java \
		Model/Quiz/*.java \
		Model/Tutorial/*.java \
		Model/Tutorial/AuthorTutorial/*.java \
		Model/Tutorial/StudentTutorial/*.java \
		Model/User/*.java

all:		compile jar doc

compile:	$(FILES)
		javac -g -d .classes $(FILES)

jar:		$(FILES)
		cd .classes ; \
		jar cmf Manifest.txt CSTutor.jar *.class $(MODULES) ; \
		chmod a+x CSTutor.jar ; 
doc:
	javadoc \
	    -private \
	    -d .javadoc \
	    -doctitle "CSTutor Prototype" \
	    -windowtitle "CSTutor Prototype" \
	    -overview overview.html \
	    $(MODULES)

clean:
	rm -rf .classes/* .javadoc/*