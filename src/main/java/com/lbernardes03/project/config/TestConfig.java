package com.lbernardes03.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lbernardes03.project.entities.Category;
import com.lbernardes03.project.entities.Order;
import com.lbernardes03.project.entities.Product;
import com.lbernardes03.project.entities.User;
import com.lbernardes03.project.entities.enums.OrderStatus;
import com.lbernardes03.project.repositories.CategoryRepository;
import com.lbernardes03.project.repositories.OrderRepository;
import com.lbernardes03.project.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

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
        Category cat2 = new Category(null, "Computers");
        Category cat3 = new Category(null, "Drinks");
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        
        Product p1 = new Product(null, "Smart TV", "A tv", 2000.50, "");
        Product p2 = new Product(null, "Ipad", "An ipad", 450.00, "");
        Product p3 = new Product(null, "Monster", "A monster 750ml", 1.50, "");
        Product p4 = new Product(null, "Keyboard", "A keyboard", 20.99, "");
        Product p5 = new Product(null, "Long Island Tes", "A screwdriver", 2.50, "");
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat1);
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat1);
        p4.getCategories().add(cat2);
        p5.getCategories().add(cat3);
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }


}
