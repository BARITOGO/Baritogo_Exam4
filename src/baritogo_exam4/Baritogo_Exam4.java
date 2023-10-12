/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baritogo_exam4;

import java.util.Scanner;
import java.util.Stack;

class Product {
    private String pangalan;
    private int halaga;

    public Product(String name, int quantity) {
        this.pangalan = name;
        this.halaga = quantity;
    }
    public String getName() {
        return pangalan;
    }
    public int getQuantity() {
        return halaga;
    }
    public void setQuantity(int quantity) {
        this.halaga = quantity;
    }
}

    public class Baritogo_Exam4 {
    private Stack<Product> Tovipanget;

    public Baritogo_Exam4() {
        Tovipanget = new Stack<>();
    }
    public void addProduct(String productName, int quantity) {
        Product product = new Product(productName, quantity);
        Tovipanget.push(product);
    }
    public void sellProduct(String productName, int quantity) {
        Product product = Tovipanget.pop();
        if (product != null && product.getName().equals(productName)) {
            product.setQuantity(product.getQuantity() - quantity);
            if (product.getQuantity() > 0) {
                Tovipanget.push(product);
            }
        } else {
            throw new IllegalArgumentException("Wala na uy naunsa ka!? " + productName);
        }
    }
    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : Tovipanget) {
            System.out.println(product.getName() + ": " + product.getQuantity());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Baritogo_Exam4 tobibipanget = new Baritogo_Exam4();
         boolean start=true;
     while(start){
        System.out.println("--------------------");
        System.out.println("  Tovi's Store!");
        System.out.println("--------------------");
        System.out.println("1. Add product");
        System.out.println("2. Sell product");
        System.out.println("3. Display Inventory");
        System.out.println("4. Uli! ");
        System.out.println("--------------------");
        
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("================================");
                System.out.println("Name of the product to add: ");
                System.out.println("================================");
                String productName = scanner.next();
                System.out.println("================================");
                System.out.println("Quantity of the product to add: "); 
                System.out.println("================================");
                int quantity = scanner.nextInt();
                tobibipanget.addProduct(productName, quantity);
                break;
            case 2: 
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("Name of the product to sell: ");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                productName = scanner.next();
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("Quantity of the product to sell: ");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                quantity = scanner.nextInt();
                tobibipanget.sellProduct(productName, quantity);
                break;
            case 3:            
                tobibipanget.displayInventory();
                break;
            case 4:
                System.out.println("Salamat sa tanan!!");
                start=false;
                break;
            default:
                System.out.println("xxxxxxxxxxxxxxxxxx");
                System.out.println("Pasagad ralagi ba!");
                System.out.println("xxxxxxxxxxxxxxxxxx");
            }
        }
    }
}
