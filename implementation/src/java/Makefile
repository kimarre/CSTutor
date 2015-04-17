#
# Makefile for CSTutor prototype.
#
MODULES =	CSTutor/View/Overview \
		CSTutor/View/Progress \
		CSTutor/View/Quiz \
		CSTutor/View/Chat \
		CSTutor/View/Login \
		CSTutor/View/Manager \
		CSTutor/View/Tutorial \
		CSTutor/Model/Chat \
		CSTutor/Model/Database \
		CSTutor/Model/Manager \
		CSTutor/Model/Progress \
		CSTutor/Model/Quiz \
		CSTutor/Model/Tutorial \
		CSTutor/Model/Tutorial/AuthorTutorial \
		CSTutor/Model/Tutorial/StudentTutorial \
		CSTutor/Model/User

FILES =		CSTutor/View/Overview/*.java \
		CSTutor/View/Progress/*.java \
		CSTutor/View/Quiz/*.java \
		CSTutor/View/Chat/*.java \
		CSTutor/View/Login/*.java \
		CSTutor/View/Manager/*.java \
		CSTutor/View/Tutorial/*.java \
		CSTutor/Model/Chat/*.java \
		CSTutor/Model/Database/*.java \
		CSTutor/Model/Manager/*.java \
		CSTutor/Model/Progress/*.java \
		CSTutor/Model/Quiz/*.java \
		CSTutor/Model/Tutorial/*.java \
		CSTutor/Model/Tutorial/AuthorTutorial/*.java \
		CSTutor/Model/Tutorial/StudentTutorial/*.java \
		CSTutor/Model/User/*.java

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