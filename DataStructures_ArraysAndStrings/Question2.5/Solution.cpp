/*
 * If the lists are inverse ordered, the solution is quite simple. Just iterate
 * through each list doing the sum of the digits and creating the result digit
 * of the return list, and saving the carry.
 * Of course we have to take in count if the lists are of different sizes, so
 * if one of the iterators became to the end of the list, then the rest of the digits are
 * the rest of the other list(suming the carry ofcourse)
 */

class Node {
public:
	Node * next;
	int value;
	Node(Node*, int);
};

Node::Node(Node * next, int value) {
	this->next = next;
	this->value = value;
}

Node * sum(Node * rootA, Node * rootB) {
	/* If the first operand is null, return just the second */
	if (rootA == 0) {
		return rootB;
	}

	/* If the second operand is null, return just the first */
	if (rootB == 0) {
		return rootA;
	}

	Node * ptrA = rootA;
	Node * ptrB = rootB;
	Node * result = 0;
	Node * topResult = result;

	int value;
	int carry = 0;
	Node * newNode;
	while (ptrA != 0 || ptrB != 0) {
		value = carry;
		carry = 0;

		if (ptrA != 0) {
			value += ptrA->value;
			ptrA = ptrA->next;
		}

		if (ptrB != 0) {
			value += ptrB->value;
			ptrB = ptrB->next;
		}

		if (value >= 10) {
			carry = 1;
			value = value - 10;
		}

		newNode = new Node(0, value);
		/* Check if is the first element */
		if (result == 0) {
			result = newNode;
		} else {
			topResult->next = newNode;
		}
		topResult = newNode;
	}

	/* Check if is some carry */
	if (carry > 0) {
		topResult->next = new Node(0, carry);
	}

	return result;
}

/*
 * If the list is double linked list, first i will find the last element
 * of both lists, and then do the same as above.
 * If it is just single linked list, i will calculate the size of both lists,
 * then i will do a recursive add though the lists and start making the sums
 * with the recursion, and returning the carry
 */

int sumRec(Node * ptrA, int depthA, Node * ptrB, int depthB,
		Node * returnNode) {
	if (depthA == 0 && depthB == 0) {
		return 0;
	} else {
		int carry;
		Node * actualNode;

		if (depthA > depthB) {
			actualNode = new Node(0, 0);
			carry = sumRec(ptrA->next, depthA - 1, ptrB, depthB, actualNode);
			actualNode->value = ptrA->value + carry;
			returnNode->next = actualNode;

			if (actualNode->value > 10) {
				actualNode->value -= 10;
				return 1;
			}

			return 0;
		} else if (depthA < depthB) {
			actualNode = new Node(0, 0);
			carry = sumRec(ptrA, depthA, ptrB->next, depthB - 1, actualNode);
			actualNode->value = ptrB->value + carry;
			returnNode->next = actualNode;

			if (actualNode->value > 10) {
				actualNode->value -= 10;
				return 1;
			}

			return 0;
		} else {
			actualNode = new Node(0, 0);
			carry = sumRec(ptrA->next, depthA - 1, ptrB->next, depthB - 1,
					actualNode);
			actualNode->value = ptrA->value + ptrB->value + carry;
			returnNode->next = actualNode;

			if (actualNode->value > 10) {
				actualNode->value -= 10;
				return 1;
			}

			return 0;
		}
	}
}

/* Now we just have to find the size of each list, and call the recursive algorithm */
Node * sum2(Node * rootA, Node * rootB) {
	int sizeA = 0;
	int sizeB = 0;

	for (Node * it = rootA; it != 0; it = it->next) {
		sizeA++;
	}

	for (Node * it = rootB; it != 0; it = it->next) {
		sizeB++;
	}

	Node * result = new Node(0, 0);

	result->value =sumRec(rootA, sizeA, rootB, sizeB, result);

	return result;
}

#include <iostream>

using namespace std;

int main(int argc, char * argv[]){
	Node * rootA = new Node(0,6);
	rootA = new Node(rootA,1);
	rootA = new Node(rootA,7);

	Node * rootB = new Node(0,2);
	rootB = new Node(rootB,9);
	rootB = new Node(rootB,5);

	cout <<"first case" << endl;
	Node * result = sum(rootA, rootB);

	for(Node * it = result;it!=0;it=it->next){
		cout << it->value << endl;
	}

	rootA = new Node(0,7);
	rootA = new Node(rootA,1);
	rootA = new Node(rootA,6);

	rootB = new Node(0,5);
	rootB = new Node(rootB,9);
	rootB = new Node(rootB,2);

	cout <<"second case" << endl;
	result = sum2(rootA, rootB);

	for(Node * it = result;it!=0;it=it->next){
		cout << it->value << endl;
	}

	return 0;
}
