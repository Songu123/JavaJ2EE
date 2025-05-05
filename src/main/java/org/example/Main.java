package org.example;

import com.shop.model.*;
import com.shop.util.DataGenerator;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Faker faker = new Faker();
//        Random random = new Random();
//
//        List<User> userList = new ArrayList<>();
//
//        // Danh sách các role có sẵn
//        String[] roles = {"ADMIN", "USER", "MODERATOR"};
//
//        // Tạo 100 user
//        for (int i = 0; i < 100; i++) {
//            String email = faker.internet().emailAddress();
//            String password = faker.internet().password(8, 12); // Password 8-12 ký tự
//            String role = roles[random.nextInt(roles.length)]; // Chọn random 1 role
//
//            User user = new User(email, password, role);
//            UserDaoImpl hello = new UserDaoImpl();
//            hello.insert(user);
//        }

        List<User> users = DataGenerator.generateUsers(5);
        List<Category> categories = DataGenerator.generateCategories(3);
        List<Product> products = DataGenerator.generateProducts(10, categories);
        List<Order> orders = DataGenerator.generateOrders(7, users);
        List<OrderItem> orderItems = DataGenerator.generateOrderItems(15, orders, products);

        users.forEach(System.out::println);
        categories.forEach(System.out::println);
        products.forEach(System.out::println);
        orders.forEach(System.out::println);
        orderItems.forEach(System.out::println);
    }
}