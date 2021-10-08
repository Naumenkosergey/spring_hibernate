package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("BMW", 525);
        Car car2 = new Car("Pegiot", 408);
        Car car3 = new Car("alfaRomeo", 159);
        Car car4 = new Car("RangeRover", 145);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        userService.add(user4.setCarFromUser(car1).setUserFromCar(user4));
        userService.add(user3.setCarFromUser(car2).setUserFromCar(user3));
        userService.add(user2.setCarFromUser(car3).setUserFromCar(user2));
        userService.add(user1.setCarFromUser(car4).setUserFromCar(user1));

        List<User> users = userService.listUsers();

        users.forEach(System.out::println);
        System.out.println();
        String model = "alfaRomeo";
        int series = 159;
        User user = userService.getUserByCar(model, series);
        System.out.print("автомобиль " + model + " " + series);
        System.out.println(user != null ? " принадмежит " + user : " не имеет хозяина");
        System.out.println();
        context.close();
    }
}
