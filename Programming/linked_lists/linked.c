#include <stdlib.h>
#include <stdio.h>
#include "linked.h"

int size(node_t * head) {
	int size = 0;
	node_t * node = head;

	if (head != NULL) {
		while (node->next != NULL) {
			node = node->next;
			size++;
		}
		size++; // for the first one that has been malloced;
	}
	return size;
	
}

node_t * get(node_t * head, int n) {
	node_t * node = head;

	// this way even if he wants 
	// the first it works
	while (n > 0 && node->next != NULL) {
		node = node->next;
	}

	return node;
}

void print(node_t * head) {
	node_t *node = head;

	while (node->next != NULL) {
		printf("%d ", node->number);
		node = node->next;
	}
	printf("%d\n", node->number);
}

void add(node_t * head, int position, int value) {
	if (position >= 0) {
		node_t * node = head;

		while (position > 0 && node->next != NULL) {
			node = node->next;
			position--;
		}

		// now that we have the correction position
		// there are two cases:
		// - it's the last one
		// - it's in the middle
		if (node->next == NULL) {
			// last one
			// -> easy
			node->next = malloc(sizeof(node_t));

			// we now instantiate the variables
			node->next->number = value;
			node->next->next = NULL;
		}
		else {
			node_t *newNode = malloc(sizeof(node_t));
			newNode->number = value;

			// it's next is the cursor's next one
			newNode->next = node->next;

			// we insert it inside the list
			node->next = newNode;
		}
	}
}

void removeNode(node_t * head, int n) {
	if (n > 0) {
		node_t * node = head;

		while (n > 0 && node->next->next != NULL) {
			node = node->next;
		}

		if (node->next == NULL) {
			free(node);
		}
		else {

		}
	}
	else if (n == 0) {
		clean(head);
	}
}

void clean(node_t * head) {
	node_t * temp;

	while (head->next != NULL) {
		temp = head;
		head = head->next;
		free(temp);
	}
	free(head);
}