package lesson4;

public class Main {
    public static void main(String[] args) {
//        Cat catMurzik = new Cat("Мурзик");
//        catMurzik.run(2000);
//        catMurzik.swim(20);
//
//        Dog dogBobik = new Dog("Бобик");
//        dogBobik.run(2000);
//        dogBobik.swim(20);
//        dogBobik.run(200);
//        dogBobik.swim(2);
//
//        System.out.println("Всего создано животных: " + Animal.totalAnimals);
//        System.out.println("Собак: " + Dog.totalDogs);
//        System.out.println("Котов: " + Cat.totalCats);
//
//        Plate plate = new Plate(20);
//
//        Cat[] cats = {
//                new Cat("Мурзик"),
//                new Cat("Барсик"),
//                new Cat("Пушок"),
//                new Cat("Рыжик")
//        };
//        for (Cat cat : cats) {
//            cat.eat(plate,7);
//            System.out.println(plate.food);
//        }
//        for (Cat cat : cats) {
//            System.out.println(cat.name + " | " + (cat.isFull ? "Сыт" : "Голоден"));
//        }
//        for (Cat cat : cats) {
//            if (!cat.isFull){
//                plate.addFood(5);
//                System.out.println(plate.food);
//            }
//        }
//        for (Cat cat : cats) {
//            if(!cat.isFull) {
//                cat.eat(plate, 7);
//            }
//        }
//        for (Cat cat : cats) {
//            System.out.println(cat.name + " | " + (cat.isFull ? "Сыт" : "Голоден"));
//        }
//
        Circle circle = new Circle("red","blue",5);
        circle.printInfo();
        Triangle triangle = new Triangle("white","blue",5, 4,8);
        triangle.printInfo();
        Square square = new Square("orange","green",4);
        square.printInfo();
    }
}
