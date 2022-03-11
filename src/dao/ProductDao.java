package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDao {

    public List<Product> getProductByCategori(String categori) throws SQLException {
        List<Product> products = new ArrayList<Product>();
        Connection con = Connect.getJDBCConnection();
        Statement stm = con.createStatement();
        String sql = "SELECT * FROM product";
        if (getIdCategori(categori) != 0) {
            sql += " WHERE id_categori = " + getIdCategori(categori);
        }

        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            Product prd = new Product(rs.getInt("id_product"), rs.getString("name_product"), rs.getInt("price"),
                     rs.getInt("amount"), rs.getInt("id_categori"), rs.getString("about"), rs.getInt("status"));
            products.add(prd);
        }
        return products;
    }

    public int getIdCategori(String categori) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "SELECT * FROM categori WHERE name_categori = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, categori);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_categori");
        } else {
            return 0;
        }
    }

    public List<String> getAllCategori() throws SQLException {
        List<String> categories = new ArrayList<String>();
        Connection con = Connect.getJDBCConnection();
        String sql = "SELECT * FROM categori";
        PreparedStatement preparedStatement = con.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String categori = rs.getString("name_categori");
            categories.add(categori);
        }
        return categories;
    }
}
