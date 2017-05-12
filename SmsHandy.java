import java.util.ArrayList;
/**
 * Write a description of class SmsHandy here.
 * 
 * @author Nurlanova,Buchascheva
 * @version 1.0
 */
public class SmsHandy
{
    //номер абонента
    private String rufnummer;
    //обхект классса провайдер
    private Provider provider;
    //объект класса АррайЛист для хранения отправленных сообщений
    private ArrayList<Nachricht> gesendet;
    //объект класса АррайЛист для хранения полученных сообщений
    private ArrayList<Nachricht> empfangen;
    //объект класса Нахрихт
    Nachricht nachricht; 
    //значение объекта
    int value;
    //конструктор
    public SmsHandy(String rufnummer, Provider provider)
    {
        this.rufnummer=rufnummer;
        this.provider=provider;        
        gesendet=new ArrayList<Nachricht>();
        empfangen=new ArrayList<Nachricht>();
    }
    //метод проверки существованния абонента
    public boolean Exist(String abonent)
    {
        
        int index=0;
        boolean gefunden=false;
        while (index<provider.TeilnehmerSize() && !gefunden) 
        {
            if (abonent.contains(provider.teilnehmer1(index))) 
            {
                gefunden=true;
                value=index;
            }
            else 
            {
                index++;
            }
        }
        return gefunden;
    }
    //метод, который получает сообщение из Нахрихта
    public void empfangeSms(Nachricht sms)
    {        
        empfangen.add(sms);
    }
    //метод, который отправляет сообщение
    public void sendeSms(String empfaenger, String message)
    {        
        //SmsHandy smsHandy=new SmsHandy();
        if (empfaenger==rufnummer) 
        { 
            System.out.println ("Your number!");
        }
        else if (Exist(empfaenger)==false) 
        {
            System.out.println ("Error");
        }
        else if (Exist(empfaenger)==true)
        {            
           nachricht=new Nachricht (rufnummer, message, empfaenger);        
           gesendet.add(nachricht);
           provider.day(value).empfangeSms(nachricht);
        }       
    }
    //метод, который отправляет сообщение
    public void sendeSms(SmsHandy empfaenger, String message)
    {
        String SmsNummer=empfaenger.gibRufnummerZurueck();
        nachricht=new Nachricht (rufnummer,  message, SmsNummer);
        gesendet.add(nachricht);
        empfaenger.empfangeSms(nachricht);
    }
    //метод, который изменяет оператора
    public void wechselProvider(Provider operator)
    {
       provider=operator;
    }    
    //возвращает собственный номер
    public String gibRufnummerZurueck()
    {
       return rufnummer;
    }
    //показывает список полученных сообщений
    public void listeEmpfangeneSms()
    {
        System.out.println ("List of reciev messages :"+empfangen.size());
        for (int i=0;i<empfangen.size();i++)
        {
            System.out.println (empfangen.get(i));
        }  
    }
    //показывает список отправленных сообщений
    public void listeGesendeteSms()
    {
        System.out.println ("List of sent  :"+gesendet.size());
        for (int i=0;i<gesendet.size();i++)
        {
            System.out.println (gesendet.get(i));
        }        
    }
    //показывает список всех сообщений
    public void gebeNachrichtAus(Nachricht n)
    {
        System.out.println ("Poluchennye soobscheniya :"+empfangen.size());
        for (int i=0;i<empfangen.size();i++)
        {
            System.out.println (empfangen.get(i));
        }  
        System.out.println ("");
        System.out.println ("Otpravlennye soobscheniya :"+gesendet.size());
        for (int i=0;i<gesendet.size();i++)
        {
            System.out.println (gesendet.get(i));
        }     
    }
}
