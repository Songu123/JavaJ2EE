package com.shop.util;

import com.github.javafaker.Faker;
import com.shop.model.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private static Faker faker = new Faker();
    private static Random random = new Random();

    public static User generateUser() {
        return new User(
                0, // ID sẽ tự động tăng trong DB
                faker.internet().emailAddress(),
                faker.internet().password(),
                random.nextBoolean() ? "USER" : "ADMIN"
        );
    }

    public static Category generateCategory() {
        return new Category(
                0,
                faker.commerce().department(),
                faker.lorem().sentence()
        );
    }

    public static Product generateProduct(int categoryId) {
        return new Product(
                0,
                faker.commerce().productName(),
                faker.lorem().paragraph(),
                faker.internet().image(), // hoặc link ảnh random
                Double.parseDouble(faker.commerce().price()),
                random.nextInt(100) + 1,
                categoryId,
                new Timestamp(System.currentTimeMillis())
        );
    }

    public static Order generateOrder(int userId) {
        return new Order(
                0,
                "ORD" + faker.number().digits(6),
                random.nextBoolean() ? "PENDING" : "COMPLETED",
                userId
        );
    }

    public static OrderItem generateOrderItem(int orderId, int productId) {
        int quantity = random.nextInt(5) + 1;
        double price = Double.parseDouble(faker.commerce().price());
        return new OrderItem(
                0,
                orderId,
                productId,
                quantity,
                price,
                new Timestamp(System.currentTimeMillis())
        );
    }

    // Hàm tạo danh sách users mẫu
    public static List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(generateUser());
        }
        return users;
    }

    public static List<Category> generateCategories(int count) {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            categories.add(generateCategory());
        }
        return categories;
    }

    public static List<Product> generateProducts(int count, List<Category> categories) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomCategoryId = categories.get(random.nextInt(categories.size())).getId();
            products.add(generateProduct(randomCategoryId));
        }
        return products;
    }

    public static List<Order> generateOrders(int count, List<User> users) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomUserId = users.get(random.nextInt(users.size())).getId();
            orders.add(generateOrder(randomUserId));
        }
        return orders;
    }

    public static List<OrderItem> generateOrderItems(int count, List<Order> orders, List<Product> products) {
        List<OrderItem> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomOrderId = orders.get(random.nextInt(orders.size())).getId();
            int randomProductId = products.get(random.nextInt(products.size())).getId();
            items.add(generateOrderItem(randomOrderId, randomProductId));
        }
        return items;
    }
}
