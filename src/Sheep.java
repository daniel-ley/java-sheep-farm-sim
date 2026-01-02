public class Sheep {
    String sheepName;
    String sheepColour;
    double sheepAge;
    double satietyLevel;
    double coatVolume;

    public Sheep(String name, String colour, double age) {
        this.sheepName = name;
        this.sheepColour = colour;
        this.sheepAge = age;
        this.satietyLevel = 1.0;
        this.coatVolume = 0;
    }

    public void bleat() {
        System.out.println(sheepName + " goes Baaa!");

    }

    public void eat() {
        satietyLevel = satietyLevel + 0.1;
    }

    public void grow() {
        coatVolume = coatVolume + 0.1;
        sheepAge = sheepAge + 0.1;
        satietyLevel = satietyLevel - 0.1;
    }

}
