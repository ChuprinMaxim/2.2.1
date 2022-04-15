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

      userService.add(new User("Andrei", "Lanamec", "AL@email.ru"));
      userService.add(new User("Genadii", "Golovkin", "777@ggg.ru"));
      userService.add(new User("Petr", "Pervii", "P1@moscow.ru", new Car("MMS", 1)));
      userService.add(new User("Zhukov", "Zhukovskii", "zhuk@inbox.ru", new Car("Lexus", 5)));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = "+user.getCar());
//         System.out.println();
//      }

//      userService.listUsers();
//      System.out.println(userService.getUserCar("MMS", 1));
      context.close();
   }
}
