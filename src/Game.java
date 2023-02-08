public class Game
{
    int difficulty;
    String storeName;
    String playerName;

    public Game(int diff, String store, String player)
    {
        difficulty = diff;
        storeName = store;
        playerName = player;
    }

    public void runGame()
    {
        FileHandler leaderboard = new FileHandler();
        int score = 0;
        score += new Level1().playLevel(difficulty);
        score += new Level2().playLevel(difficulty);
        score += new Level3().playLevel(difficulty);
        System.out.print("Score: " + score + "\n");
        if(difficulty == 2)
        {
            score = score / 2;
        }
        if(difficulty == 3)
        {
            score = score / 5;
        }
        leaderboard.update(playerName, score);
    }

}