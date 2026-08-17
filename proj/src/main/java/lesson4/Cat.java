package lesson4;

public class Cat extends Animal{
    public static int totalCats = 0;
    public boolean isFull = false;

    public Cat (String name){
        super(name);
        totalCats++;
    }

    public void run(int distance) {
        if (distance > 200) {
            System.out.println(name + " пробежал 200 м и больше не хочет");
        } else {
            super.run(distance);
        }
    }
    public void swim (int distance){
        System.out.println("Кошки не плавают");

    }
    public void eat(Plate plate, int hunger){
        if (plate.eatFood(hunger)) {
            this.isFull = true;
            System.out.println(name + " покушал");
        } else {
            System.out.println("В миске мало корма, котик голодный");
        }
    }
    }
