package Interview.RedMart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CustomerPrize {

    static int MAX_LENGTH = 45;
    static int MAX_WIDTH = 30;
    static int MAX_HEIGHT = 35;
    static int MAX_VOLUME = MAX_LENGTH * MAX_WIDTH * MAX_HEIGHT;
    private static ArrayList<Product> productList;

    public static void main(String[] args) {
        String fileName = "src/Interview/RedMart/data/products.csv";
        productList = getData(fileName);
        productList.sort((o1, o2) -> {
            if (o1.getVolume() - o2.getVolume() != 0) {
                return o1.getVolume() - o2.getVolume();
            }
            return o1.getPrice() - o2.getPrice();
        });
        productList = findShortList(productList);
        ArrayList<Product> basketList = solve();
        basketList.sort(Comparator.comparingInt(Product::getProductID));
        for (Product prd : basketList) {
            System.out.print(prd.getProductID() + ",");
        }
        System.out.println();
        System.out.println(computeIdTotal(basketList));
        System.out.println(computePriceTotal(basketList));
    }

    private static int computeIdTotal(ArrayList<Product> basketList) {
        int totalId = 0;
        for (Product product : basketList) {
            totalId += product.getProductID();
        }
        return totalId;
    }

    private static int computePriceTotal(ArrayList<Product> basketList) {
        int totalPrice = 0;
        for (Product product : basketList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }


    private static ArrayList<Product> findShortList(ArrayList<Product> products) {
        int minVolume = products.get(0).getVolume();
        int maxItemNumber = MAX_VOLUME / minVolume;
        ArrayList<Product> shortList = new ArrayList<>();
        for (Product prod : products) {
            if (prod.getWidth() > MAX_WIDTH ||
                    prod.getHeight() > MAX_HEIGHT ||
                    prod.getLength() > MAX_LENGTH) {
                continue;
            }
            int count = 0;
            for (Product shortProd : shortList) {
                if (shortProd.getPrice() > prod.getPrice()) count++;
            }

            if (count <= maxItemNumber) shortList.add(prod);
        }
        return shortList;
    }

    private static ArrayList<Product> solve() {
        int rowNumber = productList.size();
        int columnNumber = MAX_VOLUME;
        /*Typical 0-1 knapsack problem but with an extra twist to store the weight
         */
        int[][][] DP = new int[rowNumber][columnNumber][2];
        DP = fillInTheFirstRow(DP);
        for (int i = 1; i < productList.size(); i++) {
            for (int j = 1; j < MAX_VOLUME; j++) {
                Product product = productList.get(i);
                if (product.getVolume() > j) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    int price1 = DP[i - 1][j][0];
                    int price2 = product.getPrice() + DP[i - 1][j - product.getVolume()][0];
                    if (price1 > price2) {
                        DP[i][j] = DP[i - 1][j];
                    } else {
                        DP[i][j][0] = price2;
                        DP[i][j][1] = product.getWeight();
                    }
                }
            }
        }
        return addItemIntoList(DP);
    }

    private static int[][][] fillInTheFirstRow(int[][][] DP) {
        for (int j = 1; j < MAX_VOLUME; j++) {
            DP[0][j][1] = productList.get(0).getWeight();
            if (productList.get(0).getVolume() > j) {
                DP[0][j][0] = 0;
            } else {
                DP[0][j][0] = productList.get(0).getPrice();
            }
        }
        return DP;
    }

    private static ArrayList<Product> addItemIntoList(int[][][] DP) {
        ArrayList<Product> basketList = new ArrayList<>();
        int trackX = productList.size() - 1, trackY = MAX_VOLUME - 1;
        while (trackX > 0 && trackY >= 0) {
            if (Arrays.equals(DP[trackX][trackY], DP[trackX - 1][trackY])) {
                trackX--;
            } else {
                if (DP[trackX][trackY][0] == DP[trackX - 1][trackY][0]) {
                    //If this item is heavier, then exclude this one and go further up
                    if (DP[trackX][trackY][1] > DP[trackX - 1][trackY][1]) {
                        trackX--;
                        continue;
                    }
                }
                Product product = productList.get(trackX);
                basketList.add(product);
                trackX--;
                trackY -= product.getVolume();
            }
        }
        if (DP[trackX][trackY][0] != 0) {
            basketList.add(productList.get(trackX));
        }
        return basketList;
    }

    private static ArrayList<Product> getData(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        ArrayList<Product> tempList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                String[] raw = text.split(",");
                int id = Integer.parseInt(raw[0]);
                int price = Integer.parseInt(raw[1]);
                int length = Integer.parseInt(raw[2]);
                int width = Integer.parseInt(raw[3]);
                int height = Integer.parseInt(raw[4]);
                int weight = Integer.parseInt(raw[5]);
                Product product = new Product(id, price, length, width, height, weight);
                tempList.add(product);
            }
            return tempList;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ignored) {
            }
        }
        return tempList;
    }

}
