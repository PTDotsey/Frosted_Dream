
import java.util.Random;

public class makeToppings implements Levels{ // class associated with creation of ice cream items through factory pattern
     public String makeItem(int difficulty) {
        Random rand = new Random();
        String options = "";
        for (int i = 0; i < difficulty; i++) {
            options += rand.nextInt(5) + 1;
        }
        return options;
    }

    @Override
    public void description() {

    }

    @Override
    public int playLevel(int difficulty) {

        return difficulty;
    }
}