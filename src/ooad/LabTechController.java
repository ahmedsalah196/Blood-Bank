/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad;

import com.jfoenix.controls.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amr Ayman
 */
public class LabTechController implements Initializable {

 @FXML
JFXTextField ID;
@FXML
JFXComboBox<String> type;
@FXML
JFXCheckBox acc;
@FXML
AnchorPane roott;
JFXSnackbar snackbar;
LabTechnician lt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.getItems().add("A+");
type.getItems().add("A-");
type.getItems().add("AB+");
type.getItems().add("AB-");
type.getItems().add("B+");
type.getItems().add("B-");
type.getItems().add("O+");
type.getItems().add("O-");
        LabTechnician.readPacksToDo();
        blood.readBlood();
        lt=new LabTechnician();
        if(LabTechnician.getNewPacks()){
            snackbar=new JFXSnackbar(roott);
            snackbar.show("New Packs to be done ", 6000);
            LabTechnician.setNewPacks(false);
        }
                blood.readBlood();
                bloodpack.readTrack();

    }    
    @FXML
    public void update(){
                lt.extract(ID.getText(), type.getSelectionModel().getSelectedIndex(), acc.isSelected());
    }
    @FXML
    private void save(){
        blood.writeBlood();
        bloodpack.writePacksTrack();
        LabTechnician.writePacksToDo();
        snackbar=new JFXSnackbar(roott);
        snackbar.show("SAVED!", 3000);
    }
    
    public void drawBarChart(ActionEvent even) throws Exception{
        new bar().draw(even);
    }
    @FXML
    private void drawLines(ActionEvent even) throws Exception{
        new line().draw(even);
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
    
    
}
