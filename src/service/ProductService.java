package service;

import dao.ProductDao;
import java.sql.SQLException;
import java.util.List;
import model.Product;

public class ProductService {

    ProductDao productDao = null;

    public ProductService() {
        productDao = new ProductDao();
    }

    public List<Product> getAllProduct() throws SQLException {
        return productDao.getAllProduct();
    }
}
