JC = javac
JFLAGS = -cp
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) '\:sqlite-jdbc-3.8.7.jar' $*.java

CLASSES = CstDAO.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
run:
	java $(JFLAGS) ':sqlite-jdbc-3.8.7.jar' CstDAO