package Observer2;

public interface WeatherSubject {

  public void addObserver(WeatherObserver observer);
  public void removeObserver(WeatherObserver observer);
  public void doNotify();
}
