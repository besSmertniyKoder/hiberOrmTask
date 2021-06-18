package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(Car car);
//    void addCar(Car car);
    List<User> listUsers();
}
