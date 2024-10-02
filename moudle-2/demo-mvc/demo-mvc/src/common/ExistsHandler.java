package common;

import model.Product;

import java.util.List;

public class ExistsHandler {

    public static int checkExistsId(List<Product> productList) {
        int id = ExceptionHandler.checkParseInteger();
        while (isExists(productList, id)) {
            System.out.print("Id trùng lặp, nhập lại: ");
            id = ExceptionHandler.checkParseInteger();
        }
        return id;
    }

    private static Boolean isExists(List<Product> productList, int id) {
        for (Product product: productList) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
