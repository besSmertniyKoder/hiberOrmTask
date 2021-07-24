package hiber;
import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    private static Car car = new Car();
    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("TestUser", "u1", "m1");
        User user2 = new User("testUser2", "u2", "m2");
        User user3 = new User("testUser3", "u3", "m3");

//
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + car.getModel());
            System.out.println();
        }


        User userByCar = userService.getUserByCar("BMW", 666777);
        System.out.println("Владелец автомобиля: " + userByCar.getFirstName() + " " + userByCar.getLastName());

        context.close();
    }
}