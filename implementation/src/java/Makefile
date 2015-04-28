#
# Makefile for CSTutor prototype.
#
MODULES =	CSTutor/View/Progress \
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

JAVA =		CSTutor/View/*.java \
		CSTutor/View/Progress/*.java \
		CSTutor/View/Quiz/*.java \
		CSTutor/View/Chat/*.java \
		CSTutor/View/User/*.java \
		CSTutor/View/Manager/*.java \
		CSTutor/View/Tutorial/*.java \
		CSTutor/Model/Chat/*.java \
		CSTutor/Model/Database/*.java \
		CSTutor/Model/Manager/*.java \
		CSTutor/Model/Progress/*.java \
		CSTutor/Model/Quiz/*.java \
		CSTutor/Model/Tutorial/*.java \
		CSTutor/Model/User/*.java

CLASS =		CSTutor/View/*.class \
		CSTutor/View/Progress/*.class \
		CSTutor/View/Quiz/*.class \
		CSTutor/View/Chat/*.class \
		CSTutor/View/User/*.class \
		CSTutor/View/Manager/*.class \
		CSTutor/View/Tutorial/*.class \
		CSTutor/Model/Chat/*.class \
		CSTutor/Model/Database/*.class \
		CSTutor/Model/Manager/*.class \
		CSTutor/Model/Progress/*.class \
		CSTutor/Model/Quiz/*.class \
		CSTutor/Model/Tutorial/*.class \
		CSTutor/Model/User/*.class

all:		dir compile jar clean

compile:	$(FILE)
		javac -cp CSTutor/Model/User/*:CSTutor/Model/Database/*:. -g -d .classes $(JAVA)

jar:		$(FILE)
		cd .classes ; \
		jar cmf Manifest.txt ../CSTutor.jar $(CLASS) ; \
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
		rm -rf .classes/* .javadoc/*

run:
		java -jar CSTutor.jar