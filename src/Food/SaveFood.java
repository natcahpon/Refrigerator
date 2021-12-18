package Food;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFood {
    String fs = File.separator;
    String dir = System.getProperty("user.dir")+fs+"informationData";
    String fileName = dir+fs+"RefrigeratorData.csv";
    ArrayList <FoodClass> Refrigerator;
    ArrayList <FoodClass> Freeze;

    public SaveFood() {
        Refrigerator = new ArrayList<>();
        Freeze = new ArrayList<>();
    }
    public void addRefrigeratorFood(FoodClass food){
        Refrigerator.add(food);
    }

    public void addFreezeFood(FoodClass food){
        Freeze.add(food);
    }

    public String getContentRefrigerator(){
        return Refrigerator.get(0).toString();
    }

    public String getContentFreeze(){
        return Freeze.get(0).toString();
    }

    public void saveFoodRefrigerator(){
        try {
            File file = new File(dir);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
            writer.write(getContentRefrigerator());
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFoodFreeze(){
        try {
            File file = new File(dir);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
            writer.write(getContentFreeze());
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}