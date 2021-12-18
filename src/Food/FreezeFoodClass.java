package Food;

import java.time.LocalDate;

public class FreezeFoodClass extends FoodClass {
    public FreezeFoodClass(String name, String category, String amount, String slot, String slotNumber, String unit, String input, String date, String image) {
        super(name, category, amount, slot, slotNumber, unit, input, date, image);
    }

    public FreezeFoodClass(String name, String category, String amount, String slot, String slotNumber, String unit, String input, String date, String image, String canEat) {
        super(name, category, amount, slot, slotNumber, unit, input, date, image, canEat);
    }



    @Override
    public void isItCanEat(){
        if(LocalDate.now().isAfter(LocalDate.parse(this.date))){
            if(LocalDate.now().isAfter(LocalDate.parse(this.date).plusDays(5L))){
                super.canEat = "หมดอายุแล้ว ไม่สามารถกินได้";
            }
            else {
                super.canEat = "หมดอายุแล้ว สามารถกินได้";
            }
        }
        else{
            super.canEat = "สามารถกินได้";
        }
    }


}
