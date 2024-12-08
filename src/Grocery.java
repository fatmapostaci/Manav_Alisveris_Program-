import java.util.ArrayList;
import java.util.Scanner;

public class Grocery {
    static String productPath = "C:\\Users\\fatma\\IdeaProjects\\Manav_Alisveris_Program\\src\\Products.txt";
    static String pricePath = "C:\\Users\\fatma\\IdeaProjects\\Manav_Alisveris_Program\\src\\Prices.txt";
    static String shoppingListPath = "C:\\Users\\fatma\\IdeaProjects\\Manav_Alisveris_Program\\src\\ShoppingList.txt";
    /**
     * calls ProductFile.readFile() (the static method  of ProductFile class)
     * gets product list from product.txt file
     *
     * @return products List as an  ArrayList<String>  type
     */
    public static ArrayList<String> evaluateProducts() {

        return FileClass.readFile(productPath);
    }

    public static ArrayList<Double> evaluatePrices() {
        ArrayList <String> newList = FileClass.readFile(pricePath);
        ArrayList <Double> pricesList = new ArrayList<>();
        for (String s : newList){
            pricesList.add(Double.parseDouble(s));
        }
        return pricesList;
    }

    /**
     * @param productsList
     * @return
     */
    public static String selectProduct(ArrayList<String> productsList) {

        System.out.print("Manav ürün listesinden almak istediğiniz ürün adını girin: ");
        Scanner sc = new Scanner(System.in);
        String selectedProduct = null;
        boolean isValid = false;
        do {
            selectedProduct = sc.nextLine();
            if (productsList.contains(selectedProduct)) {
                isValid = true;
            } else {
                System.out.println("hatalı girdi");
                System.out.print("Manav ürün listesinden almak istediğiniz ürün adını girin: ");
                continue;
            }

        } while (!isValid);

        return selectedProduct;
    }

    public static double calculateShoppingCost(double amount,double price) {

        return amount*price;
    }

    public static double getProductPrice(ArrayList<String> productList, ArrayList<Double> priceList,String productName) {

        int indexOfProduct = productList.indexOf(productName);
        return priceList.get(indexOfProduct);

    }

    public static double getProductAmount(String selectedProduct ) {
        System.out.printf("Kaç kilo %s almak istersiz: ", selectedProduct);
        Scanner sc = new Scanner(System.in);
        double amount=0.0;
        boolean isValid = false;
        do {
            if (sc.hasNextDouble()) {
                amount = sc.nextDouble();
                isValid = true;

            } else {
                System.out.println("Hatalı girdi!");
                System.out.printf("Kaç kilo %s almak istersiz: ", selectedProduct);
                continue;
            }
        } while (!isValid);

        return amount;
    }

    public static  void sendTheValuesToFile(ArrayList<Product> objectList ){
         FileClass.createFile(shoppingListPath);
         double totalCost = 0;
         for (Product p : objectList) {
             System.out.println(p);
             totalCost+=p.getCost();
             FileClass.writeFile(shoppingListPath, String.valueOf(p));
         }

        System.out.println("Manava ödeyeceğiniz toplam tutar = " + totalCost + " TL dir.");
    }

}
