package Food;

import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.*;
import java.util.ArrayList;

public class RemoveFoodNormal {
    @FXML
    private ComboBox removefood1;
    @FXML
    private Button btnrm;
    @FXML
    private ImageView back5;
    private ArrayList<FoodClass> addfood = new ArrayList<>();
    private ArrayList<FoodClass> remove1 = new ArrayList<>();
    private ArrayList<String> remove2 = new ArrayList<>();
    private String fs = File.separator;
    private String dir = System.getProperty("user.dir")+fs+"informationData";
    private String fileName = dir+fs+"RefrigeratorData.csv";
    public void initialize(){
        back5.setImage(new Image("/resources/back1.jpg"));
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
                    addfood.add(count);
                }
                if(count.getSlot().equals("Normal")){
                    remove1.add(count);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(FoodClass v:remove1){
            remove2.add(v.getName());
        }

        for(int i = 0 ; i < remove2.size(); i++){
            removefood1.getItems().addAll(remove2.get(i));
        }

        System.out.println(remove2);
    }

    @FXML
    public void RemoveOnAction(javafx.event.ActionEvent event) throws IOException{
        for(int i = 0; i < remove1.size();i++){
            if(remove1.get(i).getName().equals(removefood1.getValue().toString())){
                remove1.remove(i);
            }

        }
        FileWriter fileWriter = null;
                try {
                    String fs = File.separator;
                    String dir = System.getProperty("user.dir")+fs+"informationData";
                    String fileName = dir+fs+"RefrigeratorData.csv";
                    fileWriter = new FileWriter(fileName);
                    BufferedWriter out = new BufferedWriter(fileWriter);
                    for(FoodClass v : remove1){
                        out.write(v.toString());
                        out.newLine();
                    }
                    for(FoodClass u : addfood){
                        out.write(u.toString());
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

