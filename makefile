build:
	#javac Node.java
	javac Prompt.java
	javac Driver.java
	#javac Show.java
	javac View.java
	javac LLnodeInt.java
	clear

clean:
	rm *.class

run:
	java Driver
