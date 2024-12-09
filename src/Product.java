public class Product {

    private String productName;
    private double productAmount;
    private double productPrice;
    private double cost;
    private int productIndex;

    @Override
    public String toString() {
        return "" +
                "Ürün adı ='" + productName + '\'' +
                ", Ürün Kodu=" + productIndex +
                ", Tartılan Miktar =" + productAmount + " kg "+
                ", Kilo Fiyatı=" + productPrice +
                ", Ödenecek Ürün Tutarı =" + cost + " TL ";
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductIndex() {
        return productIndex;
    }

    public void setProductIndex(int productIndex) {
        this.productIndex = productIndex+100;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
