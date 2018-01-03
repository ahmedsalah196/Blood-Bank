/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.scene.chart.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmedsalah
 */
public class LineChartController implements Initializable {

    @FXML
    private LineChart<Date,Number> line;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Locale locale=Locale.getDefault();
        for (int i=0;i<8;i++) {
            XYChart.Series series= new XYChart.Series();
            series.getData().clear();
            series.setName(blood.allBlood.get(i).getType());                     
            for (DateAndAmount dat : blood.allBlood.get(i).history) {//dat.cal.getDisplayName(Calendar.MONTH,Calendar.LONG,locale)
                String a=(""+dat.cal.getDayOfMonth()+"/"+dat.cal.getMonth()+"/"+dat.cal.getYear());
                System.out.println(a);
                series.getData().add(new XYChart.Data(a,dat.amount));
            }
            line.getData().add(series);
        }
}    
    public void back(ActionEvent even) throws Exception{
         Parent clerkRoot = FXMLLoader.load(getClass().getResource("LabTech.fxml"));
        
        Scene clerkScene = new Scene(clerkRoot);
         String css=OOAD.class.getResource("main.css").toExternalForm();
        clerkScene.getStylesheets().add(css);
        Stage clerkStage=(Stage)((Node)even.getSource()).getScene().getWindow();
        clerkStage.setScene(clerkScene);
        clerkStage.show();
        
    }
}
