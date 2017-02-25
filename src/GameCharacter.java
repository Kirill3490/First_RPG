/**
 * Created by yan19 on 23.02.2017.
 */
public class GameCharacter {

    protected String name;
    public String getName()
    {
        return name;
    }

    protected String charClass;
    protected int hp;
    protected int hpMax;
    public int getHpMax()
    {
        return hpMax;
    }
    protected int attack;
    protected int defense;
    protected int critChance;
    protected boolean blockStance;
    public boolean isAlive;
    protected int level;

    public GameCharacter(String _charClass, String _name,  int _hp, int _attack, int _defense)
    {
        name = _name;
        charClass = _charClass;
        hpMax = _hp;
        hp = hpMax;
        attack = _attack;
        defense = _defense;
        critChance = 10;
        level = 1;
        isAlive = true;
        blockStance = false;
    }

    public void ShowInfo()
    {
        System.out.println("Имя: " + name + " Здоровье " + hp + "/" + hpMax);
    }

    public void setBlockStance()
    {
        blockStance = true;
        System.out.println(name + " стал в защитную стойку");
    }

    public void makeNewRound()
    {
        blockStance = false;
    }

    public int MakeAttack ()
    {

        int minAttack = (int)(attack * 0.8f);
        int deltaAttack = (int)(attack * 0.4f);
        int currentAttack = minAttack + GameClass.rand.nextInt(deltaAttack);   //Random Attack
        if (GameClass.rand.nextInt(100) < critChance)
        {
            currentAttack *= 2;
            System.out.println(name + " нанес критический урон в размере " + currentAttack + " едениц урона");
        }
        System.out.println(name + " нанес " + currentAttack + " едениц урона");
        return currentAttack;
    }

    public void GetDamage (int _inputDamage)
    {
        _inputDamage -=defense;
        if (blockStance == true)
        {
            System.out.println(name + "Встал в защитную стойку. Было дополнительно заблокировано " + defense + " ед. урона" );
            _inputDamage -= defense;
        }
        if (_inputDamage < defense) _inputDamage = 0;
        System.out.println(name + " получил урон " + _inputDamage + " едениц урона");
        hp-= _inputDamage;
        if (hp < 1)
            isAlive = false;
    }
}
