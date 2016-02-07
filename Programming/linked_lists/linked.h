
typedef struct node
{
	int number;
	struct node * next;
} node_t;

int size(node_t * head);
node_t * get(node_t * head, int n);
void print(node_t * head);
void add(node_t * head, int position, int value);
void removeNode(node_t * head, int n);
void clean(node_t * head);