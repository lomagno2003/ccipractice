/*
 * Solution.cpp
 *
 *  Created on: Oct 9, 2014
 *      Author: clomagno
 */

#include <iostream>

using namespace std;

/*
 * The first way that came to my mind to solve this, is just compare
 * the last item, with the first, and so on...
 */

 //TOTAL = 2AS + DIV + RST + (2*CMP+3*SUM+AS+RST)*N/2

 bool isPermutation(char * strA, char * strB, int sizeA, int sizeB){
  	if(sizeA!=sizeB){
 		return false;
 	} else {
	 	//AS + DIV
	 	int middle = sizeA/2;
	 	//AS + RST
	 	int lastIndex = sizeA-1;

	 	//SUBTOTAL = (2*CMP+3*SUM+AS+RST)*N/2
	 	for(int i=0; i<middle;i++){
	 		//CMP + AS + SUM
	 		if(strA[i]!=strB[lastIndex-i]){
	 			//CMP + RST + 2*SUM
	 			return false;
	 		}
	 	}

	 	return true;
	 }
 }

 /*
  * Suppose that we want to do the same, but using pointers.. so
 */

 //TOTAL = 2*AS + SUM + RST + (2*CMP + 2*AS + SUM + RST)N/2
 bool isPermutation2(char * strA, char * strB, int sizeA, int sizeB){
 	if(sizeA!=sizeB){
 		return false;
 	} else {
	 	//AS
	 	char * leftPointer = strA;
	 	//AS + SUM + RST
	 	char * rightPointer = strB + sizeA-1;

	 	//SUBTOTAL = (2*CMP + 2*AS + SUM + RST)N/2
	 	while(leftPointer<=rightPointer){
	 		//CMP
	 		if(*leftPointer!=*rightPointer){
	 			//CMP
	 			return false;
	 		}

	 		//AS + SUM
	 		leftPointer++;
	 		//AS - RST
	 		rightPointer--;
	 	}

	 	return true;
	 }
 }

 /*
  * If we compare both costs:
  * SOLUTION1 = AS + DIV + RST + (2*CMP+3*SUM+AS+RST)*N/2
  * SOLUTION2 = 2*AS + SUM + RST + (2*CMP + 2*AS + SUM + RST)N/2
  *
 */
 int main1_3(int argc, char * argv[]){
	 char strA[]="abcd";
	 char strB[]="dcba";

	 if(isPermutation(strA,strB,4,4)){
		 cout << "is a permutation" << endl;
	 }
	 return 0;
 }

