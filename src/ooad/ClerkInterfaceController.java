package ooad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.*;
import java.time.LocalDate;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class ClerkInterfaceController implements Initializable {
@FXML
JFXTextField d;
@FXML
JFXTextField type,packBar,email,phone,amountReq;
@FXML
JFXTextField txt1;
@FXML
JFXTextField txt2;
Clerk c;
@FXML
JFXDatePicker date;
@FXML
AnchorPane roott;
@FXML
JFXComboBox<String> bt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = new Clerk();
                bt.getItems().add("A+");
bt.getItems().add("A-");
bt.getItems().add("AB+");
bt.getItems().add("AB-");
bt.getItems().add("B+");
bt.getItems().add("B-");
bt.getItems().add("O+");
bt.getItems().add("O-");
        donor.readDonors();
blood.readBlood();
bloodpack.readTrack();
    }    
    @FXML
    public void newDonor(){
     c.registerDonor(d.getText(),type.getText(),email.getText(),phone.getText());
        for(int i = 0 ; i < donor.donorList.size();i++){
            System.out.println(donor.donorList.get(i).ID);
        }
    }
    @FXML
    public void addBloodPack(){
        LabTechnician.readPacksToDo();
        int  x = 0;
         for(int i = 0 ; i < donor.donorList.size();i++){
            if(txt1.getText().equals(donor.donorList.get(i).ID)){
                 x = i;
                break;
            }
         }
            float a = Float.parseFloat(txt2.getText());
            LocalDate ld=date.getValue();
            Calendar cal=Calendar.getInstance();
            cal.set(ld.getYear(),ld.getMonthValue(),ld.getDayOfMonth());
            if(!c.sendPack(donor.donorList.get(x), a,ld,Integer.parseInt(packBar.getText())))
            {
                JFXSnackbar snackbar=new JFXSnackbar(roott);
                snackbar.show("Can't Donate", 2000);
            }
    }
    @FXML
    public void save(){
        donor.writeDonors();
        LabTechnician.writePacksToDo();
        bloodpack.writePacksTrack();
        blood.writeBlood();
        JFXSnackbar snackbar=new JFXSnackbar(roott);
                snackbar.show("SAVED!", 2000);
    }
    
    public void logout(ActionEvent even) throws Exception{
         Parent clerkRoot = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene clerkScene = new Scene(clerkRoot);
         String css=OOAD.class.getResource("main.css").toExternalForm();
        clerkScene.getStylesheets().add(css);
        Stage clerkStage=(Stage)((Node)even.getSource()).getScene().getWindow();
        clerkStage.setScene(clerkScene);
        clerkStage.show();
    }
    @FXML
    private void request(){
                LocalDate today = LocalDate.now();
        int n=blood.allBlood.get(bt.getSelectionModel().getSelectedIndex()).adjustAmount(-1*Integer.parseInt(amountReq.getText()),today);
        if(n==-1){
            JFXSnackbar snackbar=new JFXSnackbar(roott);
                snackbar.show("Can't afford your request", 3000);
        }
        else if(n==-2) {
            JFXSnackbar snackbar=new JFXSnackbar(roott);
                snackbar.show("Critical Blood Level!!!", 6000);
        }
    }
}
