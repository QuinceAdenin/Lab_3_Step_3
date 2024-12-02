package Lab3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Comparator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Создание списка объектов Product
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 1200.0, 3),
                new Product("Smartphone", "Electronics", 800.0, 10),
                new Product("Book", "Books", 20.0, 50),
                new Product("Headphones", "Electronics", 150.0, 1),
                new Product("Shirt", "Clothing", 30.0, 15),
                new Product("Shoes", "Clothing", 50.0, 8),
                new Product("Tablet", "Electronics", 500.0, 5),
                new Product("Jacket", "Clothing", 100.0, 7),
                new Product("Keyboard", "Electronics", 80.0, 12),
                new Product("Backpack", "Accessories", 40.0, 20),
                new Product("Watch", "Accessories", 200.0, 6)
        );

        // Отфильтровать продукты, количество которых на складе меньше 5
        List<Product> lowStockProducts = products.stream()
                .filter(p -> p.getStock() < 5)
                .toList();
        System.out.println("Products with stock < 5: " + lowStockProducts);

        // Получить список уникальных категорий продуктов
        List<String> uniqueCategories = products.stream()
                .map(Product::getCategory)
                .distinct()
                .toList();
        System.out.println("Unique categories: " + uniqueCategories);

        // Найти самый дешевый продукт в категории "Electronics"
        Optional<Product> cheapestElectronics = products.stream()
                .filter(p -> "Electronics".equals(p.getCategory()))
                .min(Comparator.comparingDouble(Product::getPrice));
        cheapestElectronics.ifPresent(product -> System.out.println("Cheapest Electronics: " + product));

        // Подсчитать общее количество продуктов на складе
        int totalStock = products.stream()
                .mapToInt(Product::getStock)
                .sum();
        System.out.println("Total stock: " + totalStock);

        // Отсортировать продукты по названию
        List<Product> sortedByName = products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .toList();
        System.out.println("Sorted by name: " + sortedByName);

        // Проверить, есть ли продукты с ценой выше 10 000
        boolean hasExpensiveProducts = products.stream()
                .anyMatch(p -> p.getPrice() > 10000);
        System.out.println("Has products with price > 10000: " + hasExpensiveProducts);

        // Сгруппировать продукты по категориям и подсчитать количество продуктов в каждой категории
        Map<String, Long> categoryCount = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("Products by category: " + categoryCount);

        // Обработка строки с использованием CharacterSpliterator
        CharacterStreamProcessor.processString("Hello, World! This is a test string.");
    }
}
//