package Adapter;

public class EnemyTank implements IEnemyAttacker {

  @Override
  public void fireWeapon() {

    System.out.println("Enemy tank does 10 damage");

  }

  @Override
  public void driveForward() {

    System.out.println("Enemy tank moves 10 spaces");

  }

  @Override
  public void assignDriver(String driverName) {

    System.out.println(driverName + "is driving the tank");

  }


}
