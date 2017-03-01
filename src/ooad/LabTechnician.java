
package ooad;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.*;
public class LabTechnician {
private String ID,Password;
private static boolean newPacks=false;
public static ArrayList<bloodpack> packsToDo=new ArrayList();
public LabTechnician() {
        this.ID = "ahmed96";
        this.Password = "123456";
    }
private int find(String code){
    for (int i=0;i<packsToDo.size();i++) {
        if(packsToDo.get(i).getBarcode().equals(code))
            return i;
    }
    return -1;
}
public void extract(String code,int ind,boolean accepted){
    bloodpack bp=packsToDo.get(find(code));
    if(accepted){
    bp.setType(blood.allBlood.get(ind).getType());
    bp.setVerified(true);
    bloodpack.accepted++;
    int a=blood.allBlood.get(ind).adjustAmount(bp.getAmount(),bp.getDateExtracted());
    }
    else bloodpack.rejected++;
    packsToDo.remove(find(bp.getBarcode()));
    bp.add();
}
public boolean login(String ID,String Password){
    readPacksToDo();
    if(this.ID.equals(ID)&&this.Password.equals(Password)) {
        
        return true;
    }
    else return false;
}



    public static void setNewPacks(boolean newPacks) {
        LabTechnician.newPacks = newPacks;
    }
    public static boolean getNewPacks(){
        return newPacks;
    }
       public static void writePacksToDo(){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<bloodpack>>(){}.getType();
        String json=gson.toJson(packsToDo,type);
        try{
            FileWriter fw=new FileWriter("Packs to do.json");
            fw.write(json);
            fw.close();
            
            FileWriter fw2=new FileWriter("New Packs.txt");
            fw2.write(""+newPacks);
            fw2.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    public static void readPacksToDo(){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<bloodpack>>(){}.getType();
            try (BufferedReader br = new BufferedReader(new FileReader("Packs to do.json"))) {
                BufferedReader br2=new BufferedReader(new FileReader("new Packs.txt"));
                newPacks=Boolean.parseBoolean(br2.readLine());
                packsToDo=new ArrayList(gson.fromJson(br,type));
                br.close();
                br2.close();
            }
        catch(Exception e){
            e.getMessage();
        }
    }
 

}
