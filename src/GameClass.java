import java.util.Random;
import java.util.Scanner;

/**
 * Created by yan19 on 23.02.2017.
 */
public class GameClass {
    public static Random rand = new Random();

    private Hero[] heroPattern = new Hero[3];
    private Monster[] monsterPattern = new Monster[3];

    private Hero mainHero;
    private Monster currentMonster;
    private int currentRound;

    public GameClass()
    {
        initGame();
    }

    public void mainGameLoop()
    {
        Scanner sc = new Scanner(System.in);
        int inpInt = 0;
        System.out.println("Игра началась");
        System.out.println("Выберите героя");
        for (int i = 0; i < 3; i++)
            System.out.println((i+1) + ". " + heroPattern[i].getName());
        inpInt = sc.nextInt();
        mainHero = (Hero)heroPattern[inpInt - 1].clone();
        System.out.println("Вы выбрали " + mainHero.getName());
        currentMonster = (Monster)monsterPattern[0].clone();

        do
        {
            System.out.println("Раунд " + currentRound + " Fight!!");
            mainHero.ShowInfo();
            currentMonster.ShowInfo();
            System.out.println("Ход игрока");
            System.out.println("1. Атака 2. Защита 3. Пропустить ход 9. Завершить игру");
            if (inpInt == 1)
            {
                currentMonster.GetDamage(mainHero.MakeAttack());
            }
            mainHero.GetDamage(currentMonster.MakeAttack());
            inpInt = sc.nextInt();
            if (inpInt == 9) break;
            currentRound++;
        }
        while (true);

    }

    public void initGame()
    {
        heroPattern[0] = new Hero("Knight", "Sir Mander", 200, 20, 20);
        heroPattern[1] = new Hero("Warrior", "Jon Len", 150, 40, 10);
        heroPattern[2] = new Hero("Mage", "Loren", 120, 60, 0);

        monsterPattern[0] = new Monster("Humanoid", "Goblin", 50, 5, 1);
        monsterPattern[1] = new Monster("Humanoid", "Orc", 80, 8, 2);
        monsterPattern[2] = new Monster("Humanoid", "Troll", 100, 10, 3);

        currentRound = 1;

    }
}
