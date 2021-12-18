package Food;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FoodInFreeze {
    @FXML
    private Label nameslot,categoryslot,amountslot,unitslot,inputslot,dateslot,nameslot1,categoryslot1,amountslot1,unitslot1,inputslot1,dateslot1;
    @FXML
    private ImageView imageslot,imageslot1,back4;
    private Slot freezeList = new Slot();
    private Slot freezeList1 = new Slot();
    private String fs = File.separator;
    private String dir = System.getProperty("user.dir")+fs+"informationData";
    private String fileName = dir+fs+"RefrigeratorData.csv";
    public void initialize () {
        back4.setImage(new Image("/resources/back1.jpg"));
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(fileReader);

            String line = null;
            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                String category = data[1].trim();
                String amount = data[2].trim();
                String slot = data[3].trim();
                String slotNumber = data[4].trim();
                String unit = data[5].trim();
                String input = data[6].trim();
                String date = data[7].trim();
                String image = data[8].trim();
                FoodClass count = new FoodClass(name, category, amount, slot, slotNumber, unit, input, date, image);
                if(count.getSlot().equals("Freeze")){
                    if(count.getSlotNumber().equals("1")){
                        if(nameslot.getText().equals("ว่าง")){
                            freezeList.addfood(count);
                            amountslot.setText("จำนวนของในตู้เย็น "+freezeList.size()+"");
                            nameslot.setText(freezeList.get(0).getName());
                            categoryslot.setText(freezeList.get(0).getCategory());
                            unitslot.setText(freezeList.get(0).getUnit());
                            inputslot.setText(freezeList.get(0).getInput());
                            dateslot.setText(freezeList.get(0).getDate());
                            FileInputStream path = new FileInputStream(freezeList.get(0).getImage());
                            Image imgpath = new Image(path);
                            imageslot.setImage(imgpath);
                        }
                        if(LocalDate.parse(count.getDate()).isBefore(LocalDate.parse(dateslot.getText()))){

                            freezeList.addfood(count);
                            amountslot.setText("จำนวนของในตู้เย็น "+freezeList.size()+"");
                            nameslot.setText(count.getName());
                            categoryslot.setText(count.getCategory());
                            unitslot.setText(count.getUnit());
                            inputslot.setText(count.getInput());
                            dateslot.setText(count.getDate());
                            FileInputStream path = new FileInputStream(count.getImage());
                            Image imgpath = new Image(path);
                            imageslot.setImage(imgpath);
                        }
                    }

                    if(count.getSlotNumber().equals("2")){
                        if(nameslot1.getText().equals("ว่าง")){
                            freezeList1.addfood(count);
                            amountslot1.setText("จำนวนของในตู้เย็น "+freezeList1.size()+"");
                            nameslot1.setText(freezeList1.get(0).getName());
                            categoryslot1.setText(freezeList1.get(0).getCategory());
                            unitslot1.setText(freezeList1.get(0).getUnit());
                            inputslot1.setText(freezeList1.get(0).getInput());
                            dateslot1.setText(freezeList1.get(0).getDate());
                            FileInputStream path = new FileInputStream(freezeList1.get(0).getImage());
                            Image imgpath1 = new Image(path);
                            imageslot1.setImage(imgpath1);
                        }
                        if(LocalDate.parse(count.getDate()).isBefore(LocalDate.parse(dateslot1.getText()))){
                            freezeList1.addfood(count);
                            amountslot1.setText("จำนวนของในตู้เย็น "+freezeList1.size()+"");
                            nameslot1.setText(count.getName());
                            categoryslot1.setText(count.getCategory());
                            unitslot1.setText(count.getUnit());
                            inputslot1.setText(count.getInput());
                            dateslot1.setText(count.getDate());
                            FileInputStream path = new FileInputStream(count.getImage());
                            Image imgpath1 = new Image(path);
                            imageslot1.setImage(imgpath1);
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void checkfoodFreeze1(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/checkFood.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            CheckFood view = fxmlLoader.<CheckFood>getController();
            view.set("Freeze",1);
            Stage stage = new Stage();
            stage.setTitle("เช็คของ");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void checkfoodFreeze2(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/checkFood.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            CheckFood view = fxmlLoader.<CheckFood>getController();
            view.set("Freeze",2);
            Stage stage = new Stage();
            stage.setTitle("เช็คของ");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML private Button buttonbackfreeze;
    @FXML public void Onactionbackfreeze(ActionEvent event) {
        try {
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/TuYenCooling/addfoodFreeze.fxml"));
            Scene scene = new Scene(fxmlLoader);
            Stage stage = (Stage) buttonbackfreeze.getScene().getWindow();
            stage.setTitle("ช่องแช่เย็น");
            stage.setScene(scene);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
