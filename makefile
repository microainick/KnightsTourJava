build:
	javac Think.java
	javac Prompt.java
	javac Driver.java
	javac Show.java
	javac View.java
	javac LLnode.java
	clear

clean:
	rm *.class

run:
	java Driver
