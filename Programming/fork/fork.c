#include <unistd.h>
#include <stdio.h>

int main() {

    pid_t childPID;

    childPID = fork();

    // successful case
    if (childPID >= 0) {
        if (childPID == 0) {
            printf("I'm %d, the child process. My father is NOT %d\n", getpid(), getppid()); // somehow incorrect
        }
        // if it's > 0, it's the father
        // and the stored value is the 
        // child process PID
        else {
            printf("I'm %d, the father process. My son is %d", getpid(), childPID);
        }
    }
    else {
        printf("fork failed");
    }
    return 0;
}
