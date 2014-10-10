#include <iostream>

using namespace std;

/*
 * One posibility is to count the amount of spaces in the text(with a cost of O(n))
 * so we can calculate the new size of the string.
 * Then we can start iterating from the m-th element, where m is the last
 * "true" character of the string, and start adding them in from the new size
 */

 int calculateNewSize(char * str, int trueSize){
 	int spaces = 0;
 	char * ptr = str;
 	char * endPtr = str + trueSize -1;
 	//O(n)
 	while(ptr!=endPtr){
 		if(*ptr==' '){
 			spaces++;
 		}
 		ptr++;
 	}

 	return trueSize + (spaces * 2);
 }

 //Cost of O(n + n) = O(2*n) = O(n) where n is the trueSize
 void transform(char * str, int trueSize){
 	int newSize = calculateNewSize(str,trueSize);

 	char * rightPtr = str + trueSize-1;
 	char * newRightPtr = str + newSize-1;

 	//Cost of O(n)
 	while(rightPtr!=str){
 		if(*rightPtr!=' '){
 			*newRightPtr = *rightPtr;
 			newRightPtr--;
 		} else {
 			*newRightPtr = '0';
 			newRightPtr--;
 			*newRightPtr = '2';
 			newRightPtr--;
 			*newRightPtr = '%';
 			newRightPtr--;
 		}
 		rightPtr--;
 	}
 }

int main4(int argc, char * argv[]){
	char str[] = "Mr John Smith               ";
	int size = 13;

	transform(str,size);

	cout << str << endl;

	return 0;
}
