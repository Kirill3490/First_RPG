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
    protected int attack;
    protected int defense;

    public GameCharacter(String _charClass, String _name,  int _hp, int _attack, int _defense)
    {
        name = _name;
        charClass = _charClass;
        hp = _hp;
        attack = _attack;
        defense = _defense;
    }

    public void ShowInfo()
    {
        System.out.println("Имя: " + name + "\nЗдоровье " + hp);
    }

    public int MakeAttack ()
    {
       // int MinAttack = (int)(attack)
        System.out.println(name + " нанес " + attack + " едениц урона");
        return attack;
    }

    public void GetDamage (int _inputDamage)
    {
        System.out.println(name + " получил урон " + _inputDamage + " едениц урона");
        hp-= _inputDamage;
    }
}
