#include <stdlib.h>
#include <stdio.h>
#include "linked.h"


int main() {
	printf("ayy lmao\n");

	node_t * start = malloc(sizeof(node_t));
	start->number = 0;
	
	/*	TEST SIZE
	int res = size(start);
	printf("supposed to be 1: %d\n", res);

	start->next = malloc(sizeof(node_t));
	res = size(start);
	printf("supposed to be 2: %d\n", res);
	*/

	add(start, 0, 1);
	add(start, 0, 2);

	/* TEST ADD
		printf("0: %d, 2: %d, 1: %d\n", 
			start->number, 
			start->next->number,
			start->next->next->number);
	*/
	print(start);

	clean(start);
	free(start);

	return 0;
}