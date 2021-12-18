package Food;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ProfileController {
    @FXML
        public void freezing(ActionEvent event) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/addfoodFreeze.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("ช่องแข่แช็ง");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
    }

    @FXML
    public void normal(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/addfoodNormal.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ช่องแช่เย็น");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @FXML private Button buttoncreator;
    @FXML public void creator(ActionEvent event){
        try {
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/TuYenCooling/creatorView.fxml"));
            Scene scene = new Scene(fxmlLoader);
            Stage stage = (Stage) buttoncreator.getScene().getWindow();
            stage.setTitle("ผู้จัดทำ");
            stage.setScene(scene);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void initialize(){
        String fs = File.separator;
        String dir = System.getProperty("user.dir")+fs+"informationData";
        String fileName = dir+fs+"RefrigeratorData.csv";
        File file = new File(dir);
        try{
            if(!file.exists()){
                file.mkdirs();
                File dataFile = new File(fileName);
                dataFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

