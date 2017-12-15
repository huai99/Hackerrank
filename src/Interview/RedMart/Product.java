package Interview.RedMart;

public class Product {

    private int productID, price, length, width, height, weight;

    public Product(int productID, int price, int length, int width, int height, int weight) {
        this.productID = productID;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVolume() {
        return width * length * height;
    }
}
