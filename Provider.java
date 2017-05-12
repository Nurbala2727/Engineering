import java.util.ArrayList;
/**
 * Write a description of class Provider here.
 * 
 * @author Nurlanova,Buchascheva  
 * @version 1.0
 */
public class Provider
{
    //имя оператора
    private String name;
    //объект класса АррайЛист для хранения списка абонентов 
    private ArrayList<SmsHandy> teilnehmer;
    //
    Nachricht nachricht;
    //конструктор
    public Provider(String name)
    {        
        teilnehmer=new ArrayList<SmsHandy>(); 
        this.name=name;
    }
    
    //регистрация абонента
    public void anmelden(SmsHandy abonent)
    {        
        teilnehmer.add(abonent);
        sendeAnmeldenNachricht(abonent);
        String SmsNummer=abonent.gibRufnummerZurueck();
        nachricht=new Nachricht(name, "You, "+abonent.gibRufnummerZurueck()+" ,are succesfull registrated "+name+" !", SmsNummer);
        abonent.empfangeSms(nachricht);
    }
    //удаление абонента
    public void abmelden(SmsHandy abonent)
    {
       teilnehmer.remove(abonent);
       sendeAbmeldenNachricht(abonent);
       String SmsNummer=abonent.gibRufnummerZurueck();
       nachricht=new Nachricht(name, "You, "+abonent.gibRufnummerZurueck()+" ,are seccesfull delayed' "+name+" !", SmsNummer);
       abonent.empfangeSms(nachricht);
    }
    //сообщение, которое выводится после регистрации
    public void sendeAnmeldenNachricht(SmsHandy abonent)
    {
       System.out.println ("You, "+abonent.gibRufnummerZurueck()+" are registrated "+name+" !");
    }
    //сообщение, которое выводится после удаления
    public void sendeAbmeldenNachricht(SmsHandy abonent)
    {
       System.out.println ("You are,  "+abonent.gibRufnummerZurueck()+" ,delayed "+name+" !");
    }
    //метод, который возвращает значение по индексу
    public String teilnehmer1(int i)
    {        
        return teilnehmer.get(i).gibRufnummerZurueck();
    }
    //метод, который возвращает объект из АррайЛиста
    public SmsHandy day(int a)
    {
        return teilnehmer.get(a);
    }
    //возвращает количество элементов в АррайЛисте
    public int TeilnehmerSize()
    {
        return teilnehmer.size();
    }
}
