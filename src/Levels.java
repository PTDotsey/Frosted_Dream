import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public interface Levels
{
    String makeItem(int difficulty);//FACTORY PATTERN
    //above function implements factory pattern with Levels being the super class implemented as an interface.
    //factory pattern is used in the PlayLevel methods within Level1, Level2 and Level3 to generate new instances of the items used to build customer orders.
    //
    void description();
    int playLevel(int difficulty);
    /* Ice Cream Table
    1. Vanilla
    2. Chocolate
    3. Strawberry
    */


    default void makeOrder(String order, int difficulty)
    {
        System.out.print("Customer Order: " + order + "\n");
        String dish = "";
        while(!dish.equals(order))
        {
            for(int i = 0; i < difficulty; i++)
            {
                dish += iceCreamOptions();
            }
            if(dish.length() < order.length())
            {
                for(int i = 0; i < difficulty; i++)
                {
                    dish += syrupOptions();
                }
            }
            if(dish.length() < order.length())
            {
                for(int i = 0; i < difficulty; i++)
                {
                    dish += toppingsOptions();
                }
            }
            if(dish.equals(order))
            {
                System.out.print("Order correct!\n");
                return;
            }
            else
            {
                System.out.print("Dish is incorrect.\nMake again!\n");
                dish = "";
            }
        }
    }

    default char iceCreamOptions()
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.print("Which ice cream?\n");
            System.out.print("1. Vanilla\n");
            System.out.print("2. Chocolate\n");
            System.out.print("3. Strawberry\n");
            String choice = scan.nextLine();
            switch (choice)
            {
                case "1":
                    //vanilla
                    return '1';
                case "2":
                    //chocolate
                    return '2';
                case "3":
                    //strawberry
                    return '3';
                case "quit":
                    //exit
                    System.exit(0);
                default:
                    //invalid inputs
                    System.out.print("Please select '1' for vanilla, '2' for chocolate, or '3' for strawberry.\n");
            }
        }
    }

    default char syrupOptions()
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.print("Which syrup?\n");
            System.out.print("1. Caramel Syrup\n");
            System.out.print("2. Chocolate Syrup\n");
            System.out.print("3. Strawberry Syrup\n");
            System.out.print("4. Butterscotch Syrup\n");
            String choice = scan.nextLine();
            switch (choice)
            {
                case "1":
                    //caramel
                    return '1';
                case "2":
                    //chocolate
                    return '2';
                case "3":
                    //strawberry
                    return '3';
                case "4":
                    //butterscotch
                    return '4';
                case "quit":
                    //exit
                    System.exit(0);
                default:
                    //invalid inputs
                    System.out.print("Please select '1' for caramel, '2' for chocolate, '3' for strawberry, or '4' for butterscotch.\n");
            }
        }
    }

    default char toppingsOptions()
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.print("Which toppings?\n");
            System.out.print("1. Sprinkles\n");
            System.out.print("2. Nuts\n");
            System.out.print("3. Candy Pieces\n");
            System.out.print("4. Fruit\n");
            System.out.print("5. Cookie Chunks\n");
            String choice = scan.nextLine();
            switch (choice)
            {
                case "1":
                    //sprinkles
                    return '1';
                case "2":
                    //nuts
                    return '2';
                case "3":
                    //candy
                    return '3';
                case "4":
                    //fruit
                    return '4';
                case "5":
                    //cookie
                    return '5';
                case "quit":
                    //exit
                    System.exit(0);
                default:
                    //invalid inputs
                    System.out.print("Please select '1' for sprinkles, '2' for nuts, '3' for candy pieces, '4' for fruit, '5' for cookie chunks.\n");
            }
        }
    }

    default void continueQuit()
    {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hit enter to play the level or type 'quit' to quit\n");
        userInput = scanner.nextLine();
        if(userInput.toLowerCase().equals("quit"))
        {
            System.exit(0);
        }
        System.out.print("3\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("2\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("1\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Go\n");
    }
}

class Level1 implements Levels
{

    @Override
    public String makeItem(int difficulty) {
        return null;
    }

    @Override
    public void description()
    {
        System.out.print("The ice cream shop has just begun and only has different ice cream flavors to choose from.  ");
        System.out.print("Match the current customers order with the correct options.\n");
        continueQuit();
    }

    @Override
    public int playLevel(int difficulty)
    {
        description();
        long start = System.nanoTime();
        for(int i = 1; i <= 10; i++)
        {
            System.out.print("Order number: " + i + "\n");
            String task = "";
            task += new makeIceCream().makeItem(difficulty);//instantiation through factory pattern
            makeOrder(task, difficulty);
        }
        long end = System.nanoTime();
        return (int)((end-start)/100000000);
    }
}

class Level2 implements Levels
{

    @Override
    public String makeItem(int difficulty) {
        return null;
    }

    @Override
    public void description()
    {
        System.out.print("The ice cream shop can now afford syrups for the ice cream to give customers more customized experiences.\n");
        continueQuit();
    }

    @Override
    public int playLevel(int difficulty)
    {
        description();
        long start = System.nanoTime();
        for(int i = 1; i <= 10; i++)
        {
            System.out.print("Order number: " + i + "\n");
            String task = "";
            task += new makeIceCream().makeItem(difficulty); //instantiation through factory pattern
            task += new makeSyrup().makeItem(difficulty);
            makeOrder(task, difficulty);
        }
        long end = System.nanoTime();
        return (int)((end-start)/100000000);
    }
}

class Level3 implements Levels
{

    @Override
    public String makeItem(int difficulty) {
        return null;
    }

    @Override
    public void description()
    {
        System.out.print("The ice cream shop can now afford toppings to create specialty ice cream dishes.");
        continueQuit();
    }

    @Override
    public int playLevel(int difficulty)
    {
        description();
        long start = System.nanoTime();
        for(int i = 1; i <= 10; i++)
        {
            System.out.print("Order number: " + i + "\n");
            String task = "";
            task += new makeIceCream().makeItem(difficulty);//instantiation of items through factory pattern
            task += new makeSyrup().makeItem(difficulty);
            task += new makeToppings().makeItem(difficulty);
            makeOrder(task, difficulty);
        }
        long end = System.nanoTime();
        return (int)((end-start)/100000000);
    }
}