JFLAGS = -cp
JC = javac
JARFILE = '.:sqlite-jdbc-3.8.7.jar'
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $(JARFILE) $*.java

CLASSES = \
        SQLiteJDBC.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class
run:
        java $(JFLAGS) $(JARFILE) $(CLASSES:.java= )