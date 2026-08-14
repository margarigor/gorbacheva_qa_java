package lesson4;

public class Animal {
    String name;
    public static int totalAnimals = 0;

    public Animal(){
    }
    public Animal (String name){
        this.name = name;
        totalAnimals++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м");
    }
    public void swim (int distance) {
        System.out.println(name +" проплыл " + distance + " м");
    }
}
