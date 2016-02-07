package Adapter;

public class EnemyRobotAdapter implements IEnemyAttacker {

  // class to be adapted to IEnemyAttacker interface
  EnemyRobotAdaptee theRobot;

  public EnemyRobotAdapter(EnemyRobotAdaptee newRobot) {

    theRobot = newRobot;

  }

  @Override
  public void fireWeapon() {

    theRobot.smashWithHands();

  }

  @Override
  public void driveForward() {

    theRobot.walkForward();

  }

  @Override
  public void assignDriver(String driverName) {

    theRobot.reactToHuman(driverName);

  }

}
