/**
 * Created by yan19 on 23.02.2017.
 */
public class Hero extends GameCharacter implements Cloneable  {

    private int currentExp;
    private int expToNextLevel;

    public Hero(String _charClass, String _name, int _hp, int _attack, int _defence)
    {

        super(_charClass, _name, _hp, _attack, _defence);
        initHero();

    }

    private void initHero()
    {
        currentExp = 0;
        expToNextLevel = 1000;
    }

    public void expGain(int _exp)
    {
        currentExp += _exp;
        System.out.println(name + " получил " + _exp + " ед опыта.");
        if(currentExp > expToNextLevel)
        {
            currentExp -= expToNextLevel;
            expToNextLevel *= 2;
            attack +=5;
            defense +=2;
            hpMax += 50;
            level++;
            System.out.println(name + " повысил уровень до " + level);
            System.out.println("Атака героя повысилась до " + attack + " ед. урона");
            System.out.println("Защита героя повысилась до " + defense + " едениц");
            System.out.println("Здоровье повысилось до " + hpMax);

            hp = hpMax;

        }
    }

    public void showFullInfo()
    {

    }

    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println("Клонирование невозможно");
            return this;
        }
    }
}
