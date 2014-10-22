/*
 * First of all we have to implement the node structure
 */
#include <iostream>

using namespace std;

class Node {
private:
	Node * next;
	int value;
public:
	Node(Node*, int);
	Node* getNext();
	void setNext(Node*);
	int getValue();
	void setValue(int);
};

Node::Node(Node * next, int value) {
	this->setNext(next);
	this->setValue(value);
};

Node * Node::getNext() {
	return next;
};

void Node::setNext(Node * next) {
	this->next = next;
};

int Node::getValue() {
	return this->value;
};

void Node::setValue(int value) {
	this->value = value;
};

/*
 * Next we have to implement the algorithm. One way to solve this problem
 * is to iterate through each element of the list, and for each element,
 * iterate through the next elements, and remove the duplicated. I assume that
 * this will have a cost of O(N²) and O(1) in memory space.
 */

void removeNextNode(Node * node) {
	Node * deletedNode = node->getNext();

	if (deletedNode != 0) {
		node->setNext(node->getNext()->getNext());

		//Free memory
		delete deletedNode;
	} else {
		node->setNext(0);
	}
}

void removeDuplicates(Node * root) {
	/* We check that the root is not null */
	if (root != 0) {
		for (Node * it1 = root; it1 != 0; it1 = it1->getNext()) {
			for (Node * it2 = it1; it2->getNext() != 0; it2 = it2->getNext()) {
				if (it1->getValue() == it2->getNext()->getValue()) {
					removeNextNode(it2);
				}
				if(it2->getNext()==0){
					break;
				}
			}
		}
	}
}

/*
 * In this case we don't use any buffer or auxiliary structure, but we got an O(N²)
 * If we use a buffer(for example, suppose that the values are between 0 and 32)
 * we can use a boolean array to mark if a value was read.
 */

void removeDuplicates2(Node * root) {
	/* We check that the root is not null */
	if (root != 0) {
		bool readArray[32];

		for (int i = 0; i < 32; i++) {
			readArray[i] = false;
		}

		for (Node * it = root; it->getNext() != 0; it = it->getNext()) {
			if (!readArray[it->getNext()->getValue()]) {
				/* The element wasn't readed */
				readArray[it->getNext()->getValue()] = true;
			} else {
				/* The element was readed before */
				removeNextNode(it);

				if(it->getNext()==0){
					break;
				}
			}
		}
	}
}


int main(int argc, char * argv[]){
	Node * root = new Node(0,2);
	root = new Node(root,2);
	root = new Node(root,4);
	root = new Node(root,5);
	root = new Node(root,7);

	cout << "Original list:" << endl;
	for(Node * it = root;it!=0;it=it->getNext()){
				cout << it->getValue() << endl;
	}
	removeDuplicates2(root);

	cout << "Transformed list:" << endl;
	for(Node * it = root;it!=0;it=it->getNext()){
				cout << it->getValue() << endl;
	}
	return 0;
}
