JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	MergeInsertionSort.java \
	MergeSort.java \
	AlgorithmInterface.java \
	InsertionSort.java \
	main.java 

default: classes
	java main

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
