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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 *
 * @author ahmedsalah
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private JFXTextField loginID;
    @FXML
    private JFXPasswordField loginPassword;
    @FXML
    private void TechnicianHandler(ActionEvent event) throws Exception{
//        if(new LabTechnician().login(loginID.getText(),loginPassword.getText())){
            Parent techRoot = FXMLLoader.load(getClass().getResource("LabTech.fxml"));
        
        Scene techScene = new Scene(techRoot);
         String css=OOAD.class.getResource("main.css").toExternalForm();
        techScene.getStylesheets().add(css);
        Stage techStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        techStage.setScene(techScene);
        techStage.show();
//        }
//        else System.out.println("not verified");
    }
    @FXML
    private void ClerkHandler(ActionEvent even) throws Exception{
        
//        if(new Clerk().login(loginID.getText(),loginPassword.getText())){
        Parent clerkRoot = FXMLLoader.load(getClass().getResource("clerkInterface.fxml"));
        
        Scene clerkScene = new Scene(clerkRoot);
         String css=OOAD.class.getResource("main.css").toExternalForm();
        clerkScene.getStylesheets().add(css);
        Stage clerkStage=(Stage)((Node)even.getSource()).getScene().getWindow();
        clerkStage.setScene(clerkScene);
        clerkStage.show();

//        }
//        else 
//        System.out.println("not verified");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
