package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDao {
    public List<Product> getAllProduct() throws SQLException {
        List<Product> products = new ArrayList<Product>();
        Connection con = Connect.getJDBCConnection();
        String sql = "SELECT * FROM product";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()) {
            Product prd = new Product(rs.getInt("id_product"), rs.getString("name_product"), rs.getInt("price")
                    , rs.getInt("amount"), rs.getInt("id_categori"), rs.getString("about"), rs.getInt("status"));
            products.add(prd);
        }
        return products;
    }
}
