package Adapter;

public class program {

  public static void main(String[] args) {

    IEnemyAttacker tank = new EnemyTank();
    EnemyRobotAdaptee robot = new EnemyRobotAdaptee();

    IEnemyAttacker robotAdapter = new EnemyRobotAdapter(robot);

    System.out.println("the tank = normal");

    tank.assignDriver("azerty");
    tank.driveForward();
    tank.fireWeapon();

    System.out.println("The robot without adapter");

    robot.reactToHuman("azerty");
    robot.walkForward();
    robot.smashWithHands();

    System.out.println("The robot with adapter");

    robotAdapter.assignDriver("azerty");
    robotAdapter.driveForward();
    robotAdapter.fireWeapon();

  }
}
