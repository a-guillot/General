package Observer2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WeatherStation implements WeatherSubject {

  Set<WeatherObserver> weatherObservers;
  int temperature;
  
  public WeatherStation(int temperature) {
    weatherObservers = new HashSet<WeatherObserver>();
    this.temperature = temperature;
  }

  @Override
  public void addObserver(WeatherObserver observer) {
    weatherObservers.add(observer);
    
  }

  @Override
  public void removeObserver(WeatherObserver observer) {
    weatherObservers.add(observer);
    
  }

  @Override
  public void doNotify() {
    Iterator<WeatherObserver> it = weatherObservers.iterator();
    while (it.hasNext()) {
      WeatherObserver observer = it.next();
      observer.doUpdate(temperature);
    }
  }

  public void setTemperature(int temperature) {
    this.temperature = temperature;
    System.out.println("weather station setting temperature to " + temperature);
    doNotify();
  }
}
