package lesson4;

public class Plate {
    public int food;
    public Plate(int food){
        this.food = food;
    }

    public int addFood(int amount) {
            this.food += amount;
            return food;
    }

    public boolean eatFood(int amount) {
        if (this.food >= amount) {
            this.food -= amount;
            return true;
        }
        return false;
    }
}
