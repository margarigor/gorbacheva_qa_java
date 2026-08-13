package lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",

                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone SE", "01.06.2025",

                "Apple", "USA", 9599, true);
        productsArray[2] = new Product("iPhone 16 Pro", "01.05.2023",

                "Apple", "USA", 10509, false);
        productsArray[3] = new Product("Samsung S26", "01.02.2024",

                "Samsung Corp.", "Korea", 8999, false);
        productsArray[4] = new Product("Samsung A25", "01.02.2021",

                "Samsung Corp.", "Korea", 2599, true);

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].info();
        }
        Park.Attraction att1 = new Park("Победа").new Attraction("Ромашка", "с 8 до 17", 250);
        System.out.println(att1);

    }

    }
