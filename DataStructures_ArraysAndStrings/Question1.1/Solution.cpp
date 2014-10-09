/*
 * Solution.cpp
 *
 *  Created on: Oct 8, 2014
 *      Author: clomagno
 */

/*
If we see the string as an array of characters(where each character can be seen as a number between 0 and 255)
at first we can check if the size of the string is higher than 255. If it is, then the string have to have repeated
characters.
*/

#include <iostream>

using namespace std;

void copyArray(char * strA, int from, int to, char * strB){
	for(int i=from;i<to;i++){
		strB[i] = strA[i];
	}
}

void merge(char * input, int begin, int middle, int end, char * output){
	int j0=begin;
	int j1=middle;

	for(int i=begin;i<end;i++){
	 	if(j0<middle&&(j1>=end||input[j0]<=input[j1])){
	 		output[i]=input[j0];
	 		j0++;
	 	} else {
	 		output[i]=input[j1];
	 		j1++;
	 	}
	 }
}

void mergeSort(char * strA, int begin, int end, char * strB){
	if(end-begin < 2){ //CMP
		// The strings strA and strB are sorted
		return;
	} else {
		int middle = begin + (end - begin) / 2; //RST + DIV

		mergeSort(strA, begin, middle, strB);
		mergeSort(strA, middle, end, strB);
		merge(strA, begin, middle, end, strB);

		copyArray(strB, begin, end, strA);
	}
}

/*
Another better implementation is with the bottom-up merge sort
*/

void bottomUpMergeSort(char * strA, char * strB, int size){
	for(int width=1;width<size;width=width*2){
		for(int i=0;i<size;i+=2*width){
			merge(strA, i, min(i+width, size), min(i+2*width, size), strB);
		}

		copyArray(strB,0,size,strA);
	}
}

char * sort(char * str, int size){
	char * output = new char[size];

	copyArray(str,0,size,output);
	bottomUpMergeSort(str,output, size);

	cout << "Sorted: '" << output << "'" << endl;

	return output;
}

bool hasAllUnique1(char * str, int size){
	if(size>255){
		return false;
	} else {
		/* If it has less characters, then we can double iterate with a cost of O(n²) through all the elements */
		//(SUM*N + CMP*N)*(SUM*N + CMP*N)*CMP
		//(SUM*N)² + 2*CMP*N + (CMP*N)²
		//CMP*(SUM*N)² + 2*CMP²*N + CMP³*N²
		for(int i=0;i<size;i++){ // SUM + CMP
			for(int j=i+1;j<size;j++){ // SUM + CMP
				if(str[i]==str[j]){ // CMP
					return false;
				}
			}
		}

		return true;
	}
}

/* Maybe a better solution is, instead of iterate with a double "for", we can sort the elements with cost of O(n*log(n)) and then
 * iterate through the elements looking for str[i]==str[i+1] */

 bool hasAllUnique2(char * str, int size){
 	if(size > 255){
 		return false;
 	} else {
 		char * sortedStr = sort(str,size);

 		for(int i=0;i+1<size;i++){
 			if(sortedStr[i]==sortedStr[i+1]){
 				return false;
 			}
 		}

 		return true;
 	}
 }

 int main(int argc, char * argv[]){
 	char str[] = "dcbadtre";

 	cout << "Initializing" << endl;

 	if(hasAllUnique2(str,8)){
 		cout << "All unique" << endl;
 	}

 	cout << "Ending" << endl;

 	return 0;
 }
