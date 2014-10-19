/*
 * One way to solve this is to really rotate the matrix, and the other
 * is to modify the way the items of the matrix are accessed.
 * In the first case just switching the (x,y) with the (y,x) will do the trick,
 * for example if we got a 3x3 matrix:
 * [00,10,20,30]
 * [01,11,21,31]
 * [02,12,22,32]
 * [03,13,23,33]
 * the rotated matrix should be:
 * [02,01,00]
 * [12,11,10]
 * [22,21,20]
 * y=x
 * x=mod(y+N-1)
 * 00->20
 * 10->21
 * 20->22
 * 01->10
 * 11->11
 * 21->12
 * 02->00
 * 12->01
 * 22->02

 *
 * If we use an auxiliary matrix NxN of booleans, we can iterate through each element
 * and for each non rotated element, rotate it recursiviously remplacing the target
 * position with the rotated element, and then rotate the target, until a hit with
 * an already rotated element occurs
 */

/* [00,10]
 * [01,11]

 * {00,10}
 * [00,00]
 * [01,11]

 * {11,10}
 * [00,00]
 * [01,10]

 * {11,01}
 * [00,00]
 * [11,10]

 * {00,01}
 * [01,00]
 * [11,10]
 */

#include <iostream>
#define N 3

using namespace std;

void rotateElement(int matrix[N][N], int i, int j) {
	int x = i;
	int y = j;

	int lastValues[2];
	int readedIndex = 0;
	int saveIndex = 1;

	lastValues[readedIndex] = matrix[x][y];
	for (int p = 0; p < 4; p++) {
		int aux = x;
		x = N - y - 1;
		y = aux;
		lastValues[saveIndex] = matrix[x][y];
		matrix[x][y] = lastValues[readedIndex];

		/* Switch indexes */
		if (readedIndex == 0) {
			readedIndex = 1;
			saveIndex = 0;
		} else {
			readedIndex = 0;
			saveIndex = 1;
		}
	}
}

void rotate(int matrix[N][N]) {
	for (int i = 0; i < (N+1) / 2; i++) {
		for (int j = 0; j < (N+1) / 2; j++) {
			cout << "test" << endl;
			rotateElement(matrix, i, j);
		}
	}
}

int main(int argc, char * argv[]) {
	int matrix[N][N];
	matrix[0][0] = 00;
	matrix[1][0] = 10;
	matrix[2][0] = 20;
	matrix[0][1] = 01;
	matrix[1][1] = 11;
	matrix[2][1] = 21;
	matrix[0][2] = 02;
	matrix[1][2] = 12;
	matrix[2][2] = 22;

	cout << "Before:" << endl;
	cout << "[" << matrix[0][0] << "," << matrix[1][0] << "," << matrix[2][0] << "]" << endl;
	cout << "[" << matrix[0][1] << "," << matrix[1][1] << "," << matrix[2][1] << "]" << endl;
	cout << "[" << matrix[0][2] << "," << matrix[1][2] << "," << matrix[2][2] << "]" << endl;

	rotate(matrix);

	cout << "After:" << endl;
	cout << "[" << matrix[0][0] << "," << matrix[1][0] << "," << matrix[2][0] << "]" << endl;
	cout << "[" << matrix[0][1] << "," << matrix[1][1] << "," << matrix[2][1] << "]" << endl;
	cout << "[" << matrix[0][2] << "," << matrix[1][2] << "," << matrix[2][2] << "]" << endl;

	return 0;
}

