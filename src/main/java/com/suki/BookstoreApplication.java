package com.suki;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.suki.model.Book;
import com.suki.model.BookRepository;
import com.suki.model.User;
import com.suki.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return (args) -> {
			repository.save(new Book(1, "Harry Potter and Stuff", "J.K.Rowling", 2017, "12345", 20));
			repository.save(new Book(2, "Harry Potter and Things", "J.K.Rowling", 2015, "67891", 20));
		};
	}
	
	@Bean
	public CommandLineRunner userDemo(UserRepository urepository) {
		return (args) -> {
			// Create users: admin/admin user/user
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.com", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.com", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
			};
		}
}
