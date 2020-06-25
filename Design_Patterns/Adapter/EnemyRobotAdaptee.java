package Adapter;

public class EnemyRobotAdaptee {

  public void smashWithHands() {

    System.out.println("Enemy Robot does 10 damages with his hands");

  }

  public void walkForward() {

    System.out.println("Enemy robot walks 10 spaces");

  }

  public void reactToHuman(String driverName) {

    System.out.println("Enemy robot tramps on " + driverName);
  }
}
