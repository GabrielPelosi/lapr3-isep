main: main.o asm.o
	gcc -Wall -g main.o asm.o -o result
	
main.o: main.c asm.h
	gcc -Wall -g -c main.c
	
asm.o: asm.s
	gcc -Wall -g -c asm.s
	
run: result
	./result
	
clean:
	rm *.o result
	
debug:
	gdb -tui result
