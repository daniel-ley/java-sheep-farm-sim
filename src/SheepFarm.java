import java.util.ArrayList;

public class SheepFarm {
    public static void main(String[] args) {

        ArrayList<Sheep> flock = new ArrayList<>();

        flock.add(new Sheep("Flossy", "white", 1));
        flock.add(new Sheep("Dolly", "black", 1));
        flock.add(new Sheep("Blossom", "white", 1));

        
        for (Sheep sheep : flock) {
            sheep.bleat();
        }

    }
}