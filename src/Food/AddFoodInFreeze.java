package Food;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

public class AddFoodInFreeze {
    @FXML
    private Button select;
    @FXML
    private ImageView picture,back2;
    private Path target;
    @FXML
    private ComboBox slot,category;
    @FXML
    private Button addfood;
    @FXML
    private TextField nametextfield,amounttextfield,unittextfield;
    @FXML
    private DatePicker inputdatepicker,outdatepickker;
    private SaveFood saveTuyen = new SaveFood();
    @FXML
    public void handle(ActionEvent event) {
        FileChooser chooser = new FileChooser();

        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));

        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("images PNG JPG", "*.png", "*.jpg"));

        File file = chooser.showOpenDialog(select.getScene().getWindow());
        if (file != null){
            try {

                File destDir = new File("images");
                destDir.mkdirs();

                String[] fileSplit = file.getName().split("\\.");
                String filename = LocalDate.now()+"_"+System.currentTimeMillis()+"."+fileSplit[fileSplit.length - 1];
                target = FileSystems.getDefault().getPath(destDir.getAbsolutePath()+System.getProperty("file.separator")+filename);

                Files.copy(file.toPath(), target, StandardCopyOption.REPLACE_EXISTING );

                picture.setImage(new Image(target.toUri().toString()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void initialize(){
        slot.getItems().addAll("1","2");
        category.getItems().addAll("ไอศครีม","อาหารแช่แข็ง","เนื้อสด","อาหารสด","อาหารสำเร็จรูป","เครื่องดื่ม");
        back2.setImage(new Image("/resources/back1.jpg"));



    }

    @FXML
    public void handleAddButton(ActionEvent event){
        if(!checkdate()){
            FoodClass food = new FreezeFoodClass(nametextfield.getText(),category.getValue().toString(),amounttextfield.getText(),"Freeze",slot.getValue().toString(),unittextfield.getText(),inputdatepicker.getValue().toString(),outdatepickker.getValue().toString(),target.toString());
            saveTuyen.addFreezeFood(food);
            saveTuyen.saveFoodFreeze();
            System.out.println("if");
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("หมดอายุแล้วจ้า");

            alert.showAndWait();
        }
    }


    @FXML private Button buttonkongfreeze;
    @FXML public void kongFreeze(ActionEvent event){
        try {
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/TuYenCooling/konginFreeze.fxml"));
            Scene scene = new Scene(fxmlLoader);
            Stage stage = (Stage) buttonkongfreeze.getScene().getWindow();
            stage.setTitle("ของในตู็แช่แข็ง");
            stage.setScene(scene);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void handleRemoveFoodFreeze(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/removeFoodFreeze.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("เอาอาหารออกจากช่องแช่แข็ง");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean checkdate(){
        return LocalDate.now().isAfter(LocalDate.parse(outdatepickker.getValue().toString()));
    }
}
