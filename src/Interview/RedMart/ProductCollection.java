package Interview.RedMart;

import static Interview.RedMart.CustomerPrize.*;

class ProductCollection {
    String idList;
    int total_volume;
    int total_price;
    int total_weight;

    ProductCollection() {
    }

    public ProductCollection(String idList, int total_volume, int total_price, int total_weight) {
        this.idList = idList;
        this.total_volume = total_volume;
        this.total_price = total_price;
        this.total_weight = total_weight;
    }

    boolean isIndividualFit(Product product) {
        return product.getLength() <= MAX_LENGTH &&
                product.getHeight() <= MAX_HEIGHT &&
                product.getWidth() <= MAX_WIDTH;
    }

    boolean isFit(Product product) {
        int temp_volume = product.getVolume();
        return (temp_volume + total_volume) <= MAX_VOLUME;
    }


    void addNewProduct(Product product) {
        idList += "," + product.getProductID();
        total_volume += product.getVolume();
        total_price += product.getPrice();
        total_weight += product.getWeight();
    }

    void addFirstProduct(Product product) {
        this.idList = String.valueOf(product.getProductID());
        this.total_volume = product.getLength() * product.getHeight() * product.getWidth();
        this.total_price = product.getPrice();
        this.total_weight = product.getWeight();
    }

    static ProductCollection duplicate(ProductCollection collection) {
        ProductCollection nextCollection = new ProductCollection();
        nextCollection.idList = collection.idList;
        nextCollection.total_volume = collection.total_volume;
        nextCollection.total_price = collection.total_price;
        nextCollection.total_weight = collection.total_weight;
        return nextCollection;
    }

}