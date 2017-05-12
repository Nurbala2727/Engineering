import java.util.Date;
/**
 * Write a description of class Nachricht here.
 * 
 * @author Nurlanova, Buchaschevav
 * @version 1.0
 */
public class Nachricht
{
    //отправитель
    private String absender;
    //получатель
    private String empfaenger;
    //обьект класса Дате
    private Date sendeDatum;
    //содержание СМС
    private String inhalt;    
    // конструктор, который принимает значения отправителя, содержание письма и получателя
    public Nachricht(String sender, String inhalt, String bekommer)
    {        
        absender=sender;
        this.inhalt=inhalt;
        empfaenger=bekommer;
        setzeAktuellesSendeDatum();
    }
    /*//второй конструктор, который принимает отправителя и содержание письма
    public Nachricht(String empfaenger, String inhalt)
    {
        this.absender=absender;
        this.inhalt=inhalt;
        this.empfaenger=empfaenger;
        setzeAktuellesSendeDatum();
    }*/
    //метод, который записывает актуальное время
    public void setzeAktuellesSendeDatum()
    {
         sendeDatum=new Date();
         //System.out.println(sendeDatum);
    }
    //изменение содержание письма
    public void setzeInhalt(String inhalt)
    {
        this.inhalt=inhalt;
    }
    //метод, который изменияет получателя
    public void setzeEmpfaenger(String empfaenger)
    {
        this.empfaenger=empfaenger;
    }
    //метод, который возвращает значение получателя
    public String gibEmpfaengerZurueck()
    {
        return empfaenger;
    }
    //
    public String getInhalt()
    {
        return inhalt;
    }
    //метод, который возвращает время, отправителя, содержание письма и получателя
    public String toString()
    {
        
        return sendeDatum+"\n reciever1: "+empfaenger+"\n sender: "+absender+"\n text: "+inhalt+"\n";
    }
}
