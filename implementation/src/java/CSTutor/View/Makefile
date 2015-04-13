#
# Makefile for CSTutor prototype.
#
MODULES =	Overview \
		Progress \
		Quiz \
		Chat \
		Login \
		Manager \
		Tutorial

FILES =		*.java \
		Overview/*.java \
		Progress/*.java \
		Quiz/*.java \
		Chat/*.java \
		Login/*.java \
		Manager/*.java \
		Tutorial/*.java

all:		compile jar doc

compile:	$(FILES)
		javac -g -d .classes $(FILES)

jar:		$(FILES)
		cd .classes ; \
		jar cmf Manifest.mf CSTutor.jar *.class $(MODULES) ; \
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