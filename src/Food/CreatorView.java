package Food;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CreatorView {
    @FXML
    private ImageView back;
    @FXML
    public void initialize(){
        back.setImage(new Image("/resources/back.jpg"));
    }

    @FXML private Button cv1;
    @FXML public void cvOnaction(ActionEvent event){
        try {
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/TuYenCooling/profile.fxml"));
            Scene scene = new Scene(fxmlLoader);
            Stage stage = (Stage) cv1.getScene().getWindow();
            stage.setTitle("ผู้จัดทำ");
            stage.setScene(scene);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
