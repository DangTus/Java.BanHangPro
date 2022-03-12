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

    public List<Product> getProductByBrand(String categori) throws SQLException {
        return productDao.getProductByBrand(categori);
    }

    public List<String> getAllBrand() throws SQLException {
        return productDao.getAllBrand();
    }
    
    public Product getProductById(int id_product) throws SQLException {
        return productDao.getProductById(id_product);
    }
    
    public String getNameBrand(int id_brand) throws SQLException {
        return productDao.getNameBrand(id_brand);
    }
}
