package Food;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class CheckFood {
    @FXML
    private TableColumn<FoodClass, String> nameco;
    @FXML
    private TableColumn<FoodClass, String> categoryco;
    @FXML
    private TableColumn<FoodClass, String> inputco;
    @FXML
    private TableColumn<FoodClass, String> dateco;
    @FXML
    private TableView<FoodClass> viewfood;
    @FXML
    private TableColumn<FoodClass, String> caneatco;
    @FXML
    private String slot2;
    private int slotNumber2;
    private String fs = File.separator;
    private String dir = System.getProperty("user.dir")+fs+"informationData";
    private String fileName = dir+fs+"RefrigeratorData.csv";

    public void set(String slot2,int slotNumber2){
        this.slot2 = slot2;
        this.slotNumber2 = slotNumber2;
    }

    @FXML
    public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ObservableList<FoodClass> viewFile = FXCollections.observableArrayList();
                try{
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
                        FoodClass count;
                        if(slotNumber.equals(slotNumber2+"")&& slot.equals(slot2)){
                            if(slot.equals("Normal")){
                                count = new FoodClass(name, category, amount, slot, slotNumber, unit, input, date, image,"");
                            }
                            else{
                                count = new FreezeFoodClass(name, category, amount, slot, slotNumber, unit, input, date, image,"");

                            }
                            count.isItCanEat();
                            viewFile.add(count);
                        }


                    }



                    nameco.setCellValueFactory(new PropertyValueFactory<FoodClass, String>("name"));
                    categoryco.setCellValueFactory(new PropertyValueFactory<FoodClass, String>("category"));
                    inputco.setCellValueFactory(new PropertyValueFactory<FoodClass, String >("input"));
                    dateco.setCellValueFactory(new PropertyValueFactory<FoodClass, String>("date"));
                    caneatco.setCellValueFactory(new PropertyValueFactory<FoodClass, String>("canEat"));


                    viewfood.setItems(viewFile);








                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
