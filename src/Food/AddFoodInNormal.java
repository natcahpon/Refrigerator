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

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddFoodInNormal {
    @FXML
    private Button select;
    @FXML
    private ImageView picture,back1;
    private Path target;
    @FXML
    private ComboBox slot,category;
    @FXML
    private Button addfood;
    @FXML
    private Button removefood;
    @FXML
    private TextField nametextfield,amounttextfield,unittextfield;
    @FXML
    private DatePicker inputdatepicker,outdatepickker;
    private SaveFood saveTuyen = new SaveFood();
    private String fs = File.separator;
    private String dir = System.getProperty("user.dir")+fs+"informationData";
    private String fileName = dir+fs+"RefrigeratorData.csv";
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
        slot.getItems().addAll("1","2","3","4","5","6");
        category.getItems().addAll("อาหารสด","เนื้อสด","ขนม","ของหวาน","อาหารสำเร็จรูป","เครื่องดื่ม","ผักผลไม้");
        back1.setImage(new Image("/resources/back1.jpg"));



    }



    @FXML
    public void handleAddButton(ActionEvent event){
        if(!checkdate()){
            FoodClass food = new FoodClass(nametextfield.getText(),category.getValue().toString(),amounttextfield.getText(),"Normal",slot.getValue().toString(),unittextfield.getText(),inputdatepicker.getValue().toString(),outdatepickker.getValue().toString(),target.toString());
            saveTuyen.addRefrigeratorFood(food);
            saveTuyen.saveFoodRefrigerator();
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


    @FXML private Button buttonkongtuyen;
    @FXML public void kongTuyen(ActionEvent event){
        try {
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/TuYenCooling/konginNormal.fxml"));
            Scene scene = new Scene(fxmlLoader);
            Stage stage = (Stage) buttonkongtuyen.getScene().getWindow();
            stage.setTitle("ของในตู้เย็น");
            stage.setScene(scene);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void handleRemoveFood(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/removeFoodNormal.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("เอาอาหารออกจากช่องแช่เย็น");
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
