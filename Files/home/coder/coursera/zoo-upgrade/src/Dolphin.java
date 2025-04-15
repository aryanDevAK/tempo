import java.io.Serializable;

/**
 * TODO 1.c: Implement serializable interface for class Dolphin
 */
public class Dolphin extends Animal implements Swim, Serializable {

    String color;
    int swimmingSpeed;

    public Dolphin() {
        super("Dolphin");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public void eatingFood() {
        System.out.println("Dolphin: I am eating delicious fish.");
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Dolphin: I have eaten fish.");
    }

    @Override
    public void swimming() {
        System.out.println("Dolphin: I am swimming at the speed " + swimmingSpeed);
    }

    /**
     * TODO 2.c: Override the toString method display the deserialized content
     */
    @Override
    public String toString() {
        return "Dolphin{" +
                "name='" + getName() + '\'' +
                ", color='" + color + '\'' +
                ", swimmingSpeed=" + swimmingSpeed +
                '}';
    }
}
