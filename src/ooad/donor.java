package ooad;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class donor {
public String ID;
public String Name;
private String email,phone;
public LocalDate nextDon,lastDon;
public static ArrayList<donor> donorList = new ArrayList<donor>();

public donor(String i , String Name,String e ,String ph){
    this.ID = i;
    this.Name = Name;
    email=e;
    phone=ph;
}
public void generateNext(){
    if(this.lastDon!=null){
    this.nextDon=this.lastDon.plusMonths(3);
    }
}
public Boolean checkLastDonation(LocalDate c){
    if(this.lastDon!=null){
if(c.compareTo(nextDon)>=0) {
    this.lastDon=c;
        generateNext();
    return true;
}
else return false;
    }
    else {
    this.lastDon=c;
    generateNext();
    return true;
    }
}
  public static void writeDonors(){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<donor>>(){}.getType();
        String json=gson.toJson(donorList,type);
        try{
            FileWriter fw=new FileWriter("Donors.json");
            fw.write(json);
            fw.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    public static void readDonors(){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<donor>>(){}.getType();
        try{
            BufferedReader br=new BufferedReader(new FileReader("Donors.json"));
            donorList=new ArrayList(gson.fromJson(br,type));
            br.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getLastDon() {
        return lastDon;
    }

    public LocalDate getNextDon() {
        return nextDon;
    }
    
}