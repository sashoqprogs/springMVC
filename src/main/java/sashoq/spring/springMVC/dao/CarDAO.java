package sashoq.spring.springMVC.dao;

import org.springframework.stereotype.Component;
import sashoq.spring.springMVC.models.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarDAO {
    private static int CAR_ID;
    private List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car(++CAR_ID,"Toyota",2005,"Japan"));
        cars.add(new Car(++CAR_ID,"Mazda",2002,"Japan"));
        cars.add(new Car(++CAR_ID,"Nissan",1999,"Japan"));
        cars.add(new Car(++CAR_ID,"Lexus",2022,"Japan"));
    }
    public List<Car> index(){
        return cars;
    }
    public Car show(int id){
        return cars.stream().filter(car->car.getId()==id).findAny().orElse(null);
    }
    public void save(Car car){
        car.setId(++CAR_ID);
        cars.add(car);
    }
    public void update(Car editcar,int id){
        Car carToBeUpdated = show(id);
        carToBeUpdated.setName(editcar.getName());
        carToBeUpdated.setCountry(editcar.getCountry());
        carToBeUpdated.setYear(editcar.getYear());

    }
    public void delete(int id){
        cars.removeIf(p ->p.getId()==id);
    }
}
