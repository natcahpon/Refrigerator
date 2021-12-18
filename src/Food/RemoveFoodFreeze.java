package Food;

import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.*;
import java.util.ArrayList;

public class RemoveFoodFreeze {
    @FXML
    private ComboBox removefood2;
    @FXML
    private Button btnrm1;
    @FXML
    private ImageView back6;
    private ArrayList<FoodClass> allfood1 = new ArrayList<>();
    private ArrayList<FoodClass> removefreeze = new ArrayList<>();
    private ArrayList<String> removefreeze1 = new ArrayList<>();
    private String fs = File.separator;
    private String dir = System.getProperty("user.dir")+fs+"informationData";
    private String fileName = dir+fs+"RefrigeratorData.csv";
    public void initialize(){
        back6.setImage(new Image("/resources/back1.jpg"));
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
                    allfood1.add(count);
                }
                if(count.getSlot().equals("Freeze")){
                    removefreeze.add(count);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(FoodClass v:removefreeze){
            removefreeze1.add(v.getName());
        }

        for(int i = 0 ; i < removefreeze1.size(); i++){
            removefood2.getItems().addAll(removefreeze1.get(i));
        }

        System.out.println(removefreeze1);
    }

    @FXML
    public void RemoveOnAction1(javafx.event.ActionEvent event) throws IOException{
        for(int i = 0; i < removefreeze.size();i++){
            if(removefreeze.get(i).getName().equals(removefood2.getValue().toString())){
                removefreeze.remove(i);
            }

        }
        FileWriter fileWriter = null;
        try {
            String fs = File.separator;
            String dir = System.getProperty("user.dir")+fs+"informationData";
            String fileName = dir+fs+"RefrigeratorData.csv";
            fileWriter = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fileWriter);
            for(FoodClass u : allfood1){
                out.write(u.toString());
                out.newLine();
            }
            for(FoodClass v : removefreeze){
                out.write(v.toString());
                out.newLine();
            }
            out.flush();
        } catch (IOException e) {
            System.err.println("Error reading file");
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                System.err.println("Error closing file");
            }
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
