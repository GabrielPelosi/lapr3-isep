# ifndef ASM_H 
# define ASM_H

int readFile();
int checkFileFlag();

typedef struct{
        int bat_capacity;
        int max_capacity;
        int actual_capacity;
        int charge_current;
        char *email;
    }Scooter;

int calcTime(Scooter *scooter);
int writeFile(float result_final, Scooter *scooter);

# endif
