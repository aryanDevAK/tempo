import java.io.Serializable;

/**
 * TODO 1.a: Implement serializable interface for class Tiger
 */
public class Tiger extends Animal implements Walk, Serializable {

    int numberOfStripes;
    int speed;
    int soundLevel;

    public Tiger() {
        super("Tiger");
    }

    public int getNumberOfStripes() {
        return numberOfStripes;
    }

    public void setNumberOfStripes(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(int soundLevel) {
        this.soundLevel = soundLevel;
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Tiger: I have eaten meat.");
    }

    @Override
    public void walking() {
        System.out.println("Tiger: I am moving at the speed " + speed);
    }

    /**
     * TODO 2.a: Override the toString method display the deserialized content
     */
    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + getName() + '\'' +
                ", numberOfStripes=" + numberOfStripes +
                ", speed=" + speed +
                ", soundLevel=" + soundLevel +
                '}';
    }

    @Override
    public void eatingFood() {
        System.out.println("Tiger: I am eating meat.");
    }
}
