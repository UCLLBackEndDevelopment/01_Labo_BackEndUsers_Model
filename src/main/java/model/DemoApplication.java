package model;
// import java.util.ArrayList;
// import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		User elke = new User("Elke", 44);
		System.out.println(elke.getAge());
		User miyo = new User("Miyo", 14);
		System.out.println(miyo);
		User yuki = new User("Yuki", 12);
		System.out.println("User with name " + yuki.name + " is " + yuki.getAge() + " years old");
		User eric = new User("Eric", 65);
		System.out.println(eric.name);

		// User oldest = elke;
		// if (oldest.getAge() < eric.getAge()) oldest = eric;
		// if (oldest.getAge() < miyo.getAge()) oldest = miyo;
		// if (oldest.getAge() < yuki.getAge()) oldest = yuki;	
		// System.out.println(oldest.getAge());

		// List<User> users = new ArrayList<User>();
		// users.add(elke);
		// users.add(miyo);
		// users.add(yuki);
		// users.add(eric);

		// User oldest = null;
        // if (users.size()>0) {
        //     oldest = users.get(0);
        //     for (User user : users) {
        //         if (user.getAge() > oldest.getAge())
        //             oldest = user;
        //     }
        // }
		// System.out.println(oldest.getAge());

		UserService service = new UserService();
		service.add(new User("Elke", 44));
		service.add(new User("Eric", 65));
		service.add(new User("Miyo", 15));
		service.add(new User("Yuki", 13));

		System.out.println(service.getAll().size());
		System.out.println(service.getOldestUser().getAge());
		SpringApplication.run(DemoApplication.class, args);
	}

}