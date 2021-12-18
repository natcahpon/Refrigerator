package Food;

import java.util.ArrayList;

public class Slot {
    protected ArrayList<FoodClass> food1 = new ArrayList<>();


    public void addfood(FoodClass food){
            food1.add(food);
    }



    public int size(){
        return food1.size();
    }

    public FoodClass get(int x){
        return food1.get(x);
    }


}
