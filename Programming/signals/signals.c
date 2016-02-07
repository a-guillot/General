#include <unistd.h>
#include <stdio.h>
#include <signal.h>

void signal_callback_handler(int signum) {
	printf("I've received signal number %d\n", signum);
}

int pidSon;

int main() {
    int pid;
    pid = fork();

    if(pid == 0){       /*child*/
    	signal(SIGKILL, signal_callback_handler);
        printf("I'm ready to receive signals.\n");
        pidSon = getpid();
        while (1){}
    }
    else if(pid > 0){  /*parent*/
        sleep(2);
        kill(pidSon, 9);
        printf("I killed my son\n");
    }

    printf("done!\n");

    return 0;
}
