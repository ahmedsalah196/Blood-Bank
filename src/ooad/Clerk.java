
package ooad;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import javax.mail.*;


public class Clerk {
   private String ID,Password;
   
   public Clerk(){
       this.ID = "loay96";
       this.Password = "ahlawy";
   }
   
public boolean sendPack(donor d1,float amount,LocalDate c,int n){
    if(d1.checkLastDonation(c)){
    LabTechnician.packsToDo.add(new bloodpack(d1.ID,""+n,c,amount));
    LabTechnician.setNewPacks(true);
    String a = d1.getEmail();
    EmailSender.sendEmail(a, "Pack Submitted", "This is an automated message please don't reply.\nYour blood pack has been submitted sucessfully at "+d1.getLastDon().getDayOfMonth()+"/"+d1.getLastDon().getMonth()+"/"+d1.getLastDon().getYear()+"\nUnfortunately you can't donate again before "+d1.getNextDon().getDayOfMonth()+"\\"+d1.getNextDon().getMonth()+"\\"+d1.getNextDon().getYear()+".\nTHANK YOU!");
    return true;
    }
    
    else return false;
}
   
   
   public boolean login(String ID,String Password){
    if(this.ID.equals(ID)&&this.Password.equals(Password)) return true;
    else return false;
}
   
   public void registerDonor(String ID,String name,String email,String phone){
       donor d1=new donor(ID,name,email,phone);
       donor.donorList.add(d1);
       String a = d1.getEmail();
        EmailSender.sendEmail(a, "Donor Registration", "This is an automated message please don't reply.\nYou have been registerd as a donor to the Blood Bank");
   }
       
}
