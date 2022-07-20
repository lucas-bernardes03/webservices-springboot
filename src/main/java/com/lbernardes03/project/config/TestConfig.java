package com.lbernardes03.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lbernardes03.project.entities.Category;
import com.lbernardes03.project.entities.Order;
import com.lbernardes03.project.entities.User;
import com.lbernardes03.project.entities.enums.OrderStatus;
import com.lbernardes03.project.repositories.CategoryRepository;
import com.lbernardes03.project.repositories.OrderRepository;
import com.lbernardes03.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas", "lucas@gmail.com", "123456789", "12345");
        User u2 = new User(null, "Bob", "bob@gmail.com", "987654321", "54321");
        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2021-08-29T22:45:08Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2021-05-11T12:35:58Z"), OrderStatus.SHIPPED, u1);
        Order o3 = new Order(null, Instant.parse("2020-11-04T16:15:28Z"), OrderStatus.WAITING_PAYMENT, u2);
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        
        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Food");
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        
    }


}
