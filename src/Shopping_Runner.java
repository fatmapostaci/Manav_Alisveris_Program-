import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Shopping_Runner {
    /* TASK :
     * Basit bir 5 ürünlü manav alisveris programi yaziniz.
     *
     * 1. Adim : urun listesinden urun sectir ve kac kilo oldugunu sor.
     * 2. Adim : Baska bir urun almak isteyip istemedigini sor.
     * 			 istemiyorsa toplam miktari goster, istiyorsa tekrar urun sectir.
     * 			 Bu islemi alisverisi bitirmek isteyene kadar tekrarla.
     * 3. Adim : Musteri her urun sectiginde, aldigi urunun fiyatini toplam fiyata ekle.
     * 4. Adim : Alisveris bitince toplam odemesi gereken tutari goster.
     *
     * */
    static ArrayList<String> productsList;
    static ArrayList<Double> pricesList;


    /**
     *static block runs before main method, loads datas from txt files.
     *reads the product list from file and prints out
     */
    static {

        try {
            productsList = Grocery.evaluateProducts();
            System.out.println("productsList = " + productsList);
            pricesList = Grocery.evaluatePrices();
            System.out.println("pricesList =   " + pricesList);
            if (productsList.size() != pricesList.size()) {
                System.out.println("Product.txt ve Prices.txt dosyalarının verileri eşleşmiyor. " +
                        "Devam edebilmek için dosyları güncelleyin!");
                System.exit(0);
            }

        } catch (Exception e) {
            System.out.println("Dosyaları güncelleyin\n " + e.toString());
            System.exit(0);
        }

    }//static block ends

    public static void main(String[] args) {

        Product product = new Product();
        ArrayList<Product> objectList = new ArrayList<>();

        do {

            //Default constructor ile oluşan product objesinin (fields)özellikleri set edilir
            product.setProductName(Grocery.selectProduct(productsList));
            product.setProductIndex(productsList.indexOf(product.getProductName()));
            product.setProductAmount(Grocery.getProductAmount(product.getProductName()));
            product.setProductPrice(Grocery.getProductPrice(productsList, pricesList, product.getProductName()));
            product.setCost(Grocery.calculateShoppingCost(product.getProductAmount(), product.getProductPrice()));

            System.out.println(product);
            objectList.add(product);  //üretilen her bir product objesi ArrayListe eklenir

            System.out.println("Devam etmek istiyorsanız (E) Çıkış için (H) girin:");
            Scanner sc = new Scanner(System.in);
            boolean endSession = false;
            if (sc.next().substring(0, 1).equalsIgnoreCase("E")) {
                endSession = true;
                continue;
            } else break;
        } while (true);


        //  /rogram biterken verileri ekrana yazdırır ve yeni bir dosyaya ekler
        Grocery.sendTheValuesToFile(objectList);

    }
}