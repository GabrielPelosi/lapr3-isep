# include <stdio.h>
# include <stdlib.h>
# include <string.h>
# include <unistd.h>
# include "asm.h"

#define RECFILE "lock.data"
#define DATAFILE "estimate_28_02_2021.data"
#define FLAGFILE "estimate_28_02_2021.data.flag"

int main (){
	
	//read file into array
	FILE *myFile;
    myFile = fopen(RECFILE, "r");

    int numberArray[4];
    int i;
	for (i = 0; i < 4; i++){
        fscanf(myFile, "%d", &numberArray[i]);
    }
	
	//initiate variables
	int nscooters = 1, result;
	char email1[]= "lapr3.g37.020.021@gmail.com";
	
	//allocate memory with calloc for pointer to structure
	Scooter *scooter = (Scooter *) calloc(nscooters, sizeof(Scooter));
	scooter[0].email= (char*)calloc(20,sizeof(char));
	
	//fill structure with data from array that read from file
	scooter[0].bat_capacity = numberArray[0];
	scooter[0].max_capacity=numberArray[1];
	scooter[0].actual_capacity=numberArray[2];
	scooter[0].charge_current=numberArray[3];
	strcpy(scooter[0].email, email1);
	
	//checks if vehicle is wrongly parked
	if(scooter[0].bat_capacity == 0 || scooter[0].max_capacity == 0 || scooter[0].actual_capacity == 0 || scooter[0].charge_current == 0){
		
		//open file or creates one if non existent with writting permitions only
		FILE * pFile;
		pFile = fopen (DATAFILE,"w");
		
		//writes values in file
		fprintf (pFile,"Your vehicle is wrongly parked\n");
		fprintf (pFile, "%s \n",scooter[0].email);
	
	} else{
	
		//call assembly function to calculate, pointer to structure is sent
		//as a parameter
		result= calcTime(scooter);
		
		//adjusts value received from assembly function to its propper decimals
		float result_final = (float) result / 10;
		
		//print final result
		printf("result_final = %0.1f\n", result_final);
		
		//call function to write result and courier's email in file .data
		writeFile(result_final, scooter);
	}
	
  return 0;
}

int writeFile(float result_final, Scooter *scooter){
	
	//open file or creates one if non existent with writting permitions only
	FILE *pFile, *pFlag;
	pFile = fopen (DATAFILE,"w");
	pFlag = fopen (FLAGFILE,"w");
	
	//writes values in file .data
	fprintf (pFile, "%0.2f \n",result_final);
	fprintf (pFile, "%s \n",scooter[0].email);
	
	//closes file
	fclose (pFile);
	fclose (pFlag);
	
	return 0;
}
