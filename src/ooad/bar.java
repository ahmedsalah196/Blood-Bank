
package ooad;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class bar extends Statistics_Module{

    @Override
    public void draw(ActionEvent even) throws Exception {
        Parent clerkRoot = FXMLLoader.load(getClass().getResource("BarChart.fxml"));
        
        Scene clerkScene = new Scene(clerkRoot);
         String css=OOAD.class.getResource("main.css").toExternalForm();
        clerkScene.getStylesheets().add(css);
        Stage clerkStage=(Stage)((Node)even.getSource()).getScene().getWindow();
        clerkStage.setScene(clerkScene);
        clerkStage.show();   
    }
    
}
