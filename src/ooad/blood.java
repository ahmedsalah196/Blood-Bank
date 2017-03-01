
package ooad;
import com.google.gson.Gson;
import com.google.gson.reflect.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import java.time.LocalDate;


public class blood {
    public final String blood_type;
    public float blood_amount=0;
    private final float critical_point;
    public ArrayList<DateAndAmount> history =new ArrayList();
    public static ArrayList<blood> allBlood=new ArrayList();
    public blood(String blood_type, float blood_amount, float critical_point) {
        this.blood_type = blood_type;
        this.blood_amount = blood_amount;
        this.critical_point = critical_point;
        LocalDate today = LocalDate.now();
        history.add(new DateAndAmount(today, blood_amount));
    }
    public int requestBlood(LocalDate cal){
        history.add(new DateAndAmount(cal, blood_amount));
        return -2;
    }
    public int adjustAmount(float n,LocalDate cal){
            if(blood_amount+n<0)return -1;
            blood_amount+=n;
        if (blood_amount<=critical_point) return requestBlood(cal);
        
        history.add(new DateAndAmount(cal, blood_amount));
        return (int) blood_amount;
    }
    public String getType(){
         return blood_type;
    }

    public static void readBlood(){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<blood>>(){}.getType();
        try{
            BufferedReader br=new BufferedReader(new FileReader("Blood.json"));
            allBlood=new ArrayList(gson.fromJson(br,type));            
            br.close();
        }
        catch(Exception e){
        allBlood.add(new Apos());
        allBlood.add(new Aneg());    
        allBlood.add(new ABpos());   
        allBlood.add(new ABneg());   
        allBlood.add(new Bpos()); 
        allBlood.add(new Bneg());  
        allBlood.add(new Opos());  
        allBlood.add(new Oneg());
        }
    }
    public static void writeBlood(){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<blood>>(){}.getType();
        String json=gson.toJson(allBlood,type);
            try (FileWriter fw = new FileWriter("Blood.json")) {
                fw.write(json);
            }
        catch(Exception e){
            e.getMessage();
        }
    }
}
class DateAndAmount{
  public LocalDate cal;
  public float amount;

    public DateAndAmount(LocalDate c, float amount) {
        cal = c;
        this.amount = amount;
    }
  
}