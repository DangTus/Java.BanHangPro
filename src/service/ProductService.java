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

    public List<Product> getProductByCategori(String categori) throws SQLException {
        return productDao.getProductByCategori(categori);
    }

    public List<String> getAllCategori() throws SQLException {
        return productDao.getAllCategori();
    }
}
