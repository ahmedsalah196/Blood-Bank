package ooad;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;
public class bloodpack {
    public static ArrayList<bloodpack> bloodpacks=new ArrayList();
    public static int accepted=0,rejected=0,bloodpacksId=1;
    boolean verified;
    private String BloodType=null;
    private String donorID;
    private String Barcode;
    private LocalDate dateExtracted;
    private float amount;
    public bloodpack(String id , String code , LocalDate c,float amount ){
        this.donorID = id;
        this.Barcode = code;
        this.dateExtracted = c;
        this.amount=amount;
    }

    public LocalDate getDateExtracted() {
        return dateExtracted;
    }

    public void setType(String type){
        this.BloodType=type;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
    

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    public void add(){
        bloodpacks.add(this);
    }

    public String getBarcode() {
        return Barcode;
    }
       public static void writePacksTrack(){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<bloodpack>>(){}.getType();
        String json=gson.toJson(bloodpacks,type);
        try{
            FileWriter fw=new FileWriter("Blood Packs.json");
            fw.write(json);
            fw.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    public static void readTrack(){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<bloodpack>>(){}.getType();
            try (BufferedReader br = new BufferedReader(new FileReader("Packs to do.json"))) {
                bloodpacks=new ArrayList(gson.fromJson(br,type));
            }catch(Exception e){
            e.getMessage();
        }
    }
 
}
