package lesson4;

public class Dog extends Animal{
    public static int totalDogs = 0;

    public Dog (String name){
        super(name);
        totalDogs++;
    }

    public void run(int distance) {
        if (distance > 500) {
            System.out.println(name + " пробежал 500 м и все, дальше бежите сами");
        } else {
            super.run(distance);
        }
    }
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(name + " больше 10 м не проплывет");
        } else {
            super.swim(distance);
        }
    }
}
