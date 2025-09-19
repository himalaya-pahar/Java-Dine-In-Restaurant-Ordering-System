import java.util.HashMap;
import java.util.Scanner;

class Item{
    public int number;
    public String name;
    public double price;
    public  Item(int number,String s,double p){
        this.number=number;
        this.name=s;
        this.price=p;
    }
    public void printAdded(int q){
        System.out.println("Added " +name+ " x "+ q+" to your cart.\n");
    }
}
class ViewOrder {
    public double bill;
    public HashMap<String, Integer> itemCount;
    public HashMap<String, Double> itemPrice;

    public ViewOrder() {
        bill = 0;
        itemCount = new HashMap<String, Integer>();
        itemPrice = new HashMap<String, Double>();
    }

    public void add(Item item, int qnt) {
        itemCount.put(item.name, itemCount.getOrDefault(item.name, 0) + qnt);
        itemPrice.put(item.name, item.price);
        bill += (item.price * qnt);
    }
    public void remove(Item item) {
        try {
            if(itemCount.get(item.name)!=0){
                itemCount.put(item.name, itemCount.getOrDefault(item.name, 0) -1);
                itemPrice.put(item.name, item.price);
                bill -= (item.price);
                System.out.println("Removed one "+item.name+" from your cart.");
            }
        }
        catch (Exception exception){
            System.out.println("No such item was added.");
        }
    }


    public void viewOrder() {
        int idx = 1;
        for (String name : itemCount.keySet()) {
            if(itemCount.get(name)==0)
                continue;
            int qnt = itemCount.get(name);
            double price = itemPrice.get(name);
            double total = qnt * price;
            System.out.println(idx + ". " + name + " x " + qnt + " - $" + String.format("%.2f", total));
            idx++;
        }
        if(idx==1){
            System.out.println("Your cart is Empty. Please order something.");
        }
    }

}

public class Main {

    public static void printMenu(){
        System.out.println("\n--- Menu ---\n" +
                "\n" +
                "[Starters]\n" +
                "1. Chicken Wings - $5.00\n" +
                "2. Veg Spring Roll - $4.00\n" +
                "\n" +
                "[Main Course]\n" +
                "3. Grilled Chicken - $8.50\n" +
                "4. Veg Biryani - $7.00\n" +
                "\n" +
                "[Desserts]\n" +
                "5. Ice Cream - $3.00\n" +
                "6. Brownie - $4.50\n\n");
    }
    public static void main(String[] args){
        ViewOrder viewOrder=new ViewOrder();
        Item item1=new Item(1,"Chicken Wings",5.00);
        Item item2=new Item(2,"Veg Spring Roll",4.00);
        Item item3=new Item(3,"Grilled Chicken",8.50);
        Item item4=new Item(4,"Veg Biryani",7.00);
        Item item5=new Item(5,"Ice Cream",3.00);
        Item item6=new Item(6,"Brownie",4.50);
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("\n--- Welcome to Java Dine-In Restaurant ---\n" +
                    "1. View Menu\n" +
                    "2. Add Item to Cart\n" +
                    "3. Remove Item from Cart\n" +
                    "4. View Order\n" +
                    "5. Checkout\n" +
                    "6. Exit\n" +
                    "Choose an option: ");
            int n=scanner.nextInt();
            if(n==1){
                printMenu();
            }
            if(n==2){
                System.out.println("Enter item number to add: ");
                int num=scanner.nextInt();
                System.out.println("Enter quantity: ");
                int q=scanner.nextInt();
                if(num==1) {
                    item1.printAdded(q);
                    viewOrder.add(item1,q);
                }
                else if(num==2) {
                    item2.printAdded(q);
                    viewOrder.add(item2,q);
                }
                else if(num==3) {
                    item3.printAdded(q);
                    viewOrder.add(item3,q);
                }
                else if(num==4) {
                    item4.printAdded(q);
                    viewOrder.add(item4,q);
                }
                else if(num==5) {
                    item5.printAdded(q);
                    viewOrder.add(item5,q);
                }
                else if(num==6) {
                    item6.printAdded(q);
                    viewOrder.add(item6,q);
                }
                else {
                    System.out.println("Invalid number");
                    continue;
                }
            }
            if(n==3){
                System.out.println("Enter item number to remove: ");
                int r=scanner.nextInt();
                if(r==1){
                    viewOrder.remove(item1);
                }
                else if(r==2){
                    viewOrder.remove(item2);
                }
                else if(r==3){
                    viewOrder.remove(item3);
                }
                else if(r==4){
                    viewOrder.remove(item4);
                }
                else if(r==5){
                    viewOrder.remove(item5);
                }
                else if(r==6){
                    viewOrder.remove(item6);
                }
                else{
                    System.out.println("Invalid number");
                    continue;
                }
            }
            if(n==4){
                viewOrder.viewOrder();
            }
            if(n==5){
                if(viewOrder.bill==0) {
                    System.out.println("Your cart is Empty. Please order something.\n");
                    continue;
                }
                viewOrder.viewOrder();
                System.out.println("----------------------------");
                System.out.println("Total = "+viewOrder.bill);
                System.out.println("Thanks for ordering.");
                break;
            }
            if(n==6){
                System.out.println("Thanks for visiting Java Dine-In Restaurant. See you again!");
                break;
            }
        }
    }
}