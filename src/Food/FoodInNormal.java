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


public class FoodInNormal {
    @FXML
    private Label nameslot,categoryslot,amountslot,unitslot,inputslot,dateslot,nameslot1,categoryslot1,amountslot1,unitslot1,inputslot1,dateslot1,nameslot2,categoryslot2,amountslot2,unitslot2,inputslot2,dateslot2,nameslot3,categoryslot3,amountslot3,unitslot3,inputslot3,dateslot3,nameslot4,categoryslot4,amountslot4,unitslot4,inputslot4,dateslot4,nameslot5,categoryslot5,amountslot5,unitslot5,inputslot5,dateslot5;
    @FXML
    private ImageView imageslot,imageslot1,imageslot2,imageslot3,imageslot4,imageslot5,back3;
    private Slot arrayList1 = new Slot();
    private Slot arrayList2 = new Slot();
    private Slot arrayList3 = new Slot();
    private Slot arrayList4 = new Slot();
    private Slot arrayList5 = new Slot();
    private Slot arrayList6 = new Slot();
    private String fs = File.separator;
    private String dir = System.getProperty("user.dir")+fs+"informationData";
    private String fileName = dir+fs+"RefrigeratorData.csv";
    public void initialize () {
        back3.setImage(new Image("/resources/back1.jpg"));
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
                if(count.getSlot().equals("Normal")){
                    System.out.println("read");
                    if(count.getSlotNumber().equals("1")){
                        if(nameslot.getText().equals("ว่าง")){
                            arrayList1.addfood(count);
                            amountslot.setText("จำนวนของในตู้เย็น "+arrayList1.size()+"");
                            nameslot.setText(arrayList1.get(0).getName());
                            categoryslot.setText(arrayList1.get(0).getCategory());
                            unitslot.setText(arrayList1.get(0).getUnit());
                            inputslot.setText(arrayList1.get(0).getInput());
                            dateslot.setText(arrayList1.get(0).getDate());
                            FileInputStream path = new FileInputStream(arrayList1.get(0).getImage());
                            Image imgpath1 = new Image(path);
                            imageslot.setImage(imgpath1);
                        }
                        if(LocalDate.parse(count.getDate()).isBefore(LocalDate.parse(dateslot.getText()))){
                            arrayList1.addfood(count);
                            amountslot.setText("จำนวนของในตู้เย็น "+arrayList1.size()+"");
                            nameslot.setText(count.getName());
                            categoryslot.setText(count.getCategory());
                            unitslot.setText(count.getUnit());
                            inputslot.setText(count.getInput());
                            dateslot.setText(count.getDate());
                            FileInputStream path = new FileInputStream(count.getImage());
                            Image imgpath1 = new Image(path);
                            imageslot.setImage(imgpath1);
                        }
                    }
                    if(count.getSlotNumber().equals("2")){
                        if(nameslot1.getText().equals("ว่าง")){
                            arrayList2.addfood(count);
                            amountslot1.setText("จำนวนของในตู้เย็น "+arrayList2.size()+"");
                            nameslot1.setText(arrayList2.get(0).getName());
                            categoryslot1.setText(arrayList2.get(0).getCategory());
                            unitslot1.setText(arrayList2.get(0).getUnit());
                            inputslot1.setText(arrayList2.get(0).getInput());
                            dateslot1.setText(arrayList2.get(0).getDate());
                            FileInputStream path = new FileInputStream(arrayList2.get(0).getImage());
                            Image imgpath2 = new Image(path);
                            imageslot1.setImage(imgpath2);
                        }
                        if(LocalDate.parse(count.getDate()).isBefore(LocalDate.parse(dateslot1.getText()))){
                            arrayList2.addfood(count);
                            amountslot1.setText("จำนวนของในตู้เย็น "+arrayList2.size()+"");
                            nameslot1.setText(count.getName());
                            categoryslot1.setText(count.getCategory());
                            unitslot1.setText(count.getUnit());
                            inputslot1.setText(count.getInput());
                            dateslot1.setText(count.getDate());
                            FileInputStream path = new FileInputStream(count.getImage());
                            Image imgpath2 = new Image(path);
                            imageslot1.setImage(imgpath2);
                        }
                    }
                    if(count.getSlotNumber().equals("3")){
                        if(nameslot2.getText().equals("ว่าง")){
                            arrayList3.addfood(count);
                            amountslot2.setText("จำนวนของในตู้เย็น "+arrayList3.size()+"");
                            nameslot2.setText(arrayList3.get(0).getName());
                            categoryslot2.setText(arrayList3.get(0).getCategory());
                            unitslot2.setText(arrayList3.get(0).getUnit());
                            inputslot2.setText(arrayList3.get(0).getInput());
                            dateslot2.setText(arrayList3.get(0).getDate());
                            FileInputStream path = new FileInputStream(arrayList3.get(0).getImage());
                            Image imgpath3 = new Image(path);
                            imageslot2.setImage(imgpath3);
                        }
                        if(LocalDate.parse(count.getDate()).isBefore(LocalDate.parse(dateslot2.getText()))){
                            arrayList3.addfood(count);
                            amountslot2.setText("จำนวนของในตู้เย็น "+arrayList3.size()+"");
                            nameslot2.setText(count.getName());
                            categoryslot2.setText(count.getCategory());
                            unitslot2.setText(count.getUnit());
                            inputslot2.setText(count.getInput());
                            dateslot2.setText(count.getDate());
                            FileInputStream path = new FileInputStream(count.getImage());
                            Image imgpath3 = new Image(path);
                            imageslot2.setImage(imgpath3);
                        }
                    }
                    if(count.getSlotNumber().equals("4")){
                        if(nameslot3.getText().equals("ว่าง")){
                            arrayList4.addfood(count);
                            amountslot3.setText("จำนวนของในตู้เย็น "+arrayList4.size()+"");
                            nameslot3.setText(arrayList4.get(0).getName());
                            categoryslot3.setText(arrayList4.get(0).getCategory());
                            unitslot3.setText(arrayList4.get(0).getUnit());
                            inputslot3.setText(arrayList4.get(0).getInput());
                            dateslot3.setText(arrayList4.get(0).getDate());
                            FileInputStream path = new FileInputStream(arrayList4.get(0).getImage());
                            Image imgpath4 = new Image(path);
                            imageslot3.setImage(imgpath4);
                        }
                        if(LocalDate.parse(count.getDate()).isBefore(LocalDate.parse(dateslot3.getText()))){
                            arrayList4.addfood(count);
                            amountslot3.setText("จำนวนของในตู้เย็น "+arrayList4.size()+"");
                            nameslot3.setText(count.getName());
                            categoryslot3.setText(count.getCategory());
                            unitslot3.setText(count.getUnit());
                            inputslot3.setText(count.getInput());
                            dateslot3.setText(count.getDate());
                            FileInputStream path = new FileInputStream(count.getImage());
                            Image imgpath4 = new Image(path);
                            imageslot3.setImage(imgpath4);
                        }
                    }
                    if(count.getSlotNumber().equals("5")){
                        if(nameslot4.getText().equals("ว่าง")){
                            arrayList5.addfood(count);
                            amountslot4.setText("จำนวนของในตู้เย็น "+arrayList5.size()+"");
                            nameslot4.setText(arrayList5.get(0).getName());
                            categoryslot4.setText(arrayList5.get(0).getCategory());
                            unitslot4.setText(arrayList5.get(0).getUnit());
                            inputslot4.setText(arrayList5.get(0).getInput());
                            dateslot4.setText(arrayList5.get(0).getDate());
                            FileInputStream path = new FileInputStream(arrayList5.get(0).getImage());
                            Image imgpath5 = new Image(path);
                            imageslot4.setImage(imgpath5);
                        }
                        if(LocalDate.parse(count.getDate()).isBefore(LocalDate.parse(dateslot4.getText()))){
                            arrayList5.addfood(count);
                            amountslot4.setText("จำนวนของในตู้เย็น "+arrayList5.size()+"");
                            nameslot4.setText(count.getName());
                            categoryslot4.setText(count.getCategory());
                            unitslot4.setText(count.getUnit());
                            inputslot4.setText(count.getInput());
                            dateslot4.setText(count.getDate());
                            FileInputStream path = new FileInputStream(count.getImage());
                            Image imgpath5 = new Image(path);
                            imageslot4.setImage(imgpath5);
                        }
                    }
                    if(count.getSlotNumber().equals("6")) {
                        if(nameslot5.getText().equals("ว่าง")){
                            arrayList6.addfood(count);
                            amountslot5.setText("จำนวนของในตู้เย็น "+arrayList6.size()+"");
                            nameslot5.setText(arrayList6.get(0).getName());
                            categoryslot5.setText(arrayList6.get(0).getCategory());
                            unitslot5.setText(arrayList6.get(0).getUnit());
                            inputslot5.setText(arrayList6.get(0).getInput());
                            dateslot5.setText(arrayList6.get(0).getDate());
                            FileInputStream path = new FileInputStream(arrayList6.get(0).getImage());
                            Image imgpath6 = new Image(path);
                            imageslot5.setImage(imgpath6);
                        }
                        if(LocalDate.parse(count.getDate()).isBefore(LocalDate.parse(dateslot5.getText()))){
                            arrayList6.addfood(count);
                            amountslot5.setText("จำนวนของในตู้เย็น "+arrayList6.size()+"");
                            nameslot5.setText(count.getName());
                            categoryslot5.setText(count.getCategory());
                            unitslot5.setText(count.getUnit());
                            inputslot5.setText(count.getInput());
                            dateslot5.setText(count.getDate());
                            FileInputStream path = new FileInputStream(count.getImage());
                            Image imgpath6 = new Image(path);
                            imageslot5.setImage(imgpath6);
                        }
                    }

                }



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void checkfood10(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/checkFood.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            CheckFood view = fxmlLoader.<CheckFood>getController();
            view.set("Normal",1);
            Stage stage = new Stage();
            stage.setTitle("เช็คของ");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void checkfood11(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/checkFood.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            CheckFood view = fxmlLoader.<CheckFood>getController();
            view.set("Normal",2);
            Stage stage = new Stage();
            stage.setTitle("เช็คของ");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void checkfood12(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/checkFood.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            CheckFood view = fxmlLoader.<CheckFood>getController();
            view.set("Normal",3);
            Stage stage = new Stage();
            stage.setTitle("เช็คของ");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void checkfood13(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/checkFood.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            CheckFood view = fxmlLoader.<CheckFood>getController();
            view.set("Normal",4);
            Stage stage = new Stage();
            stage.setTitle("เช็คของ");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void checkfood14(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/checkFood.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            CheckFood view = fxmlLoader.<CheckFood>getController();
            view.set("Normal",5);
            Stage stage = new Stage();
            stage.setTitle("เช็คของ");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void checkfood15(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TuYenCooling/checkFood.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            CheckFood view = fxmlLoader.<CheckFood>getController();
            view.set("Normal",6);
            Stage stage = new Stage();
            stage.setTitle("เช็คของ");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML private Button buttonbacknormal;
    @FXML public void Onactionbacknormal(ActionEvent event) {
        try {
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/TuYenCooling/addfoodNormal.fxml"));
            Scene scene = new Scene(fxmlLoader);
            Stage stage = (Stage) buttonbacknormal.getScene().getWindow();
            stage.setTitle("ช่องแช่เย็น");
            stage.setScene(scene);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }


}
