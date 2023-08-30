package gb.java.intermediate_control_work.toy_shop;

public class Toy {
    private String id;
    private String name;
    private int frequency;

    public Toy(String id, String name, String frequency) {
        this.id = id;
        this.name = name;
        this.frequency = Integer.parseInt(frequency);
    }


    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

}
