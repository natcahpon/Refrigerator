package Food;

import java.time.LocalDate;

public class FoodClass {
    private String name;
    private String category;
    private String amount;
    private String slot;
    private String slotNumber;
    private String unit;
    private String input;
    protected String date;
    private String image;
    protected String canEat;

    public FoodClass(String name, String category, String amount, String slot, String slotNumber, String unit, String input, String date, String image) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.slot = slot;
        this.slotNumber = slotNumber;
        this.unit = unit;
        this.input = input;
        this.date = date;
        this.image = image;
    }

    public FoodClass(String name, String category, String amount, String slot, String slotNumber, String unit, String input, String date, String image, String canEat) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.slot = slot;
        this.slotNumber = slotNumber;
        this.unit = unit;
        this.input = input;
        this.date = date;
        this.image = image;
        this.canEat = canEat;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getAmount() {
        return amount;
    }

    public String getSlot() {
        return slot;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public String getUnit() {
        return unit;
    }

    public String getInput() {
        return input;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public String getCanEat() { return canEat; }

    @Override
    public String toString() {
        return name + "," + category + "," + amount + "," + slot + "," + slotNumber + "," + unit + "," + input + "," + date + "," + image ;
    }

    public void datePlus(long x) {
        this.date = LocalDate.parse(this.date).plusDays(x).toString();
    }

    public void isItCanEat(){
        if(LocalDate.now().isAfter(LocalDate.parse(this.date))){
            this.canEat = "หมดอายุแล้ว ไม่ควรกิน";
        }
        else{
            this.canEat = "สามารถกินได้";
        }
    }







}

