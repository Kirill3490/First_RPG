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
    private int monsterID = 0;

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
        currentMonster = (Monster)monsterPattern[monsterID].clone();

        do
        {
            System.out.println("Раунд " + currentRound + " Fight!!");
            mainHero.ShowInfo();
            currentMonster.ShowInfo();
            System.out.println("Ход игрока");
            System.out.println("1. Атака 2. Защита 3. Пропустить ход 9. Завершить игру");
            mainHero.makeNewRound();   //Сбрасываются действия предыдущего раунда и героя
            inpInt = sc.nextInt();
            if (inpInt == 1)
            {
                currentMonster.GetDamage(mainHero.MakeAttack());
            }
            if (inpInt == 2)
            {
                mainHero.setBlockStance();
            }
            if (inpInt == 9) break;
            currentMonster.makeNewRound();
            mainHero.GetDamage(currentMonster.MakeAttack());
            currentRound++;
            if (!currentMonster.isAlive)
            {
                System.out.println(currentMonster.getName() + "");
                mainHero.expGain(currentMonster.getHpMax() * 5);
                monsterID++;
                if (monsterID < monsterPattern.length)
                {
                    currentMonster = (Monster)monsterPattern[monsterID].clone();
                    System.out.println("На поле боя выходит " + currentMonster.getName());
                }
                else
                    break;
            }
            if (!mainHero.isAlive){
                break;
            }
        }
        while (true);
        if (!currentMonster.isAlive) System.out.println("Победил " + mainHero.getName());
        if (!mainHero.isAlive) System.out.println("Победил " + currentMonster.getName());

        System.out.println("Game Over");

    }

    public void initGame()
    {
        heroPattern[0] = new Hero("Knight", "Sir Mander", 200, 20, 20);
        heroPattern[1] = new Hero("Warrior", "Jon Len", 150, 40, 10);
        heroPattern[2] = new Hero("Mage", "Loren", 120, 60, 0);

        monsterPattern[0] = new Monster("Humanoid", "Goblin", 50, 5, 1);
        monsterPattern[1] = new Monster("Humanoid", "Orc", 80, 15, 2);
        monsterPattern[2] = new Monster("Humanoid", "Troll", 100, 20, 3);

        currentRound = 1;

    }
}
