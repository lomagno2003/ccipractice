#define M 4
#define N 4
#include <iostream>

using namespace std;
/*
 * The first solution that comes to my mind is to have 2 boolean arrays,
 * one to mark the zeros columns, and other to mark the zeros rows. So the algorithm
 * will be
 */

//O(M*N)
void algorithm(int matrix[M][N]) {
	bool zeroColumns[M];
	bool zeroRows[N];

	//O(M)
	for (int i = 0; i < M; i++) {
		zeroColumns[i] = false;
	}

	//O(N)
	for (int i = 0; i < N; i++) {
		zeroRows[i] = false;
	}

	//O(N*M)
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < M; j++) {
			if (matrix[i][j] == 0) {
				zeroColumns[i] = true;
				zeroRows[j] = true;
			}
		}
	}

	//O(M*N)
	for (int i = 0; i < M; i++) {
		if (zeroColumns[i]) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	//O(N*M)
	for (int j = 0; j < N; j++) {
		if (zeroRows[j]) {
			for (int i = 0; i < N; i++) {
				matrix[i][j] = 0;
			}
		}
	}
}

/* If we implement a most basic algorithm, the result is gonna be */

//O(M*N*max(N,M))
void algorithmBasic(int matrix[M][N]) {
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < M; j++) {
			if (matrix[i][j] == 0) {
				for (int z = 0; z < M; z++) {
					matrix[z][j] = 0;
				}

				for (int z = 0; z < N; z++) {
					matrix[i][z] = 0;
				}
			}
		}
	}
}

int main(int argc, char * argv[]) {
	int matrix[M][N];
	matrix[0][0] = 1;
	matrix[1][0] = 1;
	matrix[2][0] = 1;
	matrix[3][0] = 1;

	matrix[0][1] = 1;
	matrix[1][1] = 1;
	matrix[2][1] = 0;
	matrix[3][1] = 1;

	matrix[0][2] = 1;
	matrix[1][2] = 1;
	matrix[2][2] = 1;
	matrix[3][2] = 1;

	matrix[0][3] = 1;
	matrix[1][3] = 1;
	matrix[2][3] = 1;
	matrix[3][3] = 1;

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			cout << matrix[i][j] << ",";
		}
		cout << endl;
	}

	cout << endl;

	algorithm(matrix);

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			cout << matrix[i][j] << ",";
		}
		cout << endl;
	}

	return 0;
}
