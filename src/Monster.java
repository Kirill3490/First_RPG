/**
 * Created by yan19 on 23.02.2017.
 */
public class Monster extends GameCharacter {

    public Monster(String _charClass, String _name, int _hp, int _attack, int _defence)
    {
        super(_charClass, _name, _hp, _attack, _defence);
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
