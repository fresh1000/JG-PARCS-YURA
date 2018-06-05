all: run

clean:
	rm -f src/*.class out/JG.jar

JG.jar: out/parcs.jar src/*.java
	@javac -cp out/parcs.jar src/*.java
	@jar cf out/JG.jar -C src .
	@rm -f src/*.class

run: JG.jar
	@cd out && java -cp 'parcs.jar:JG.jar' JG
