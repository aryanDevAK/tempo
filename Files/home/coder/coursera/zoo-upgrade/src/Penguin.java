import java.io.Serializable;

/**
 * TODO 1.b: Implement serializable interface for class Penguin
 */
public class Penguin extends Animal implements Walk, Swim, Serializable {

    boolean isSwimming;
    int walkSpeed;
    int swimSpeed;

    public Penguin() {
        super("Penguin");
    }

    public boolean isSwimming() {
        return isSwimming;
    }

    public void setSwimming(boolean swimming) {
        isSwimming = swimming;
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void eatingFood() {
        System.out.println("Penguin: I am eating delicious fish.");
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Penguin: I have eaten fish.");
    }

    @Override
    public void swimming() {
        System.out.println("Penguin: I am swimming at the speed " + swimSpeed + " nautical miles per hour");
    }

    @Override
    public void walking() {
        System.out.println("Penguin: I am walking at the speed " + walkSpeed + " mph");
    }

    /**
     * TODO 2.b: Override the toString method display the deserialized content
     */
    @Override
    public String toString() {
        return "Penguin{" +
                "name='" + getName() + '\'' +
                ", isSwimming=" + isSwimming +
                ", walkSpeed=" + walkSpeed +
                ", swimSpeed=" + swimSpeed +
                '}';
    }
}
