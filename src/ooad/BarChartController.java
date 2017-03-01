/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad;

import java.net.URL;

//import java.util.Locale.Category;
import javafx.scene.chart.CategoryAxis;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amr Ayman
 */
public class BarChartController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
    @FXML
    private BarChart<?,?> bar;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series series1 = new XYChart.Series();
               series1.setName("+");  
                series1.getData().add(new XYChart.Data("A", blood.allBlood.get(0).blood_amount));
                series1.getData().add(new XYChart.Data("AB", blood.allBlood.get(2).blood_amount));
                series1.getData().add(new XYChart.Data("B", blood.allBlood.get(4).blood_amount));
                series1.getData().add(new XYChart.Data("O", blood.allBlood.get(6).blood_amount));
                   XYChart.Series series2 = new XYChart.Series();
                series2.setName("-");  
                series2.getData().add(new XYChart.Data("A", blood.allBlood.get(1).blood_amount));
                series2.getData().add(new XYChart.Data("AB", blood.allBlood.get(3).blood_amount));
                series2.getData().add(new XYChart.Data("B", blood.allBlood.get(5).blood_amount));
                series2.getData().add(new XYChart.Data("O", blood.allBlood.get(5).blood_amount));
                bar.getData().addAll(series1,series2);
    }    
    
    
        public void logout(ActionEvent even) throws Exception{
         Parent clerkRoot = FXMLLoader.load(getClass().getResource("LabTech.fxml"));
        
        Scene clerkScene = new Scene(clerkRoot);
         String css=OOAD.class.getResource("main.css").toExternalForm();
        clerkScene.getStylesheets().add(css);
        Stage clerkStage=(Stage)((Node)even.getSource()).getScene().getWindow();
        clerkStage.setScene(clerkScene);
        clerkStage.show();
        
    }
}
