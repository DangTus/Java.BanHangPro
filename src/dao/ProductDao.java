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

    public List<Product> getProductByBrand(String brand) throws SQLException {
        List<Product> products = new ArrayList<Product>();
        Connection con = Connect.getJDBCConnection();
        Statement stm = con.createStatement();
        String sql = "SELECT * FROM product";
        if (getIdBrand(brand) != 0) {
            sql += " WHERE id_brand = " + getIdBrand(brand);
        }

        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            Product prd = new Product(rs.getInt("id_product"), rs.getString("name_product"), rs.getInt("price"),
                    rs.getInt("amount"), rs.getInt("id_brand"), rs.getString("about"), rs.getInt("status"));
            products.add(prd);
        }
        return products;
    }

    public int getIdBrand(String brand) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "SELECT * FROM brand WHERE name_brand = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, brand);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_brand");
        } else {
            return 0;
        }
    }

    public String getNameBrand(int id_brand) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "SELECT * FROM brand WHERE id_brand = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id_brand);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getString("name_brand");
        } else {
            return "";
        }
    }

    public List<String> getAllBrand() throws SQLException {
        List<String> brands = new ArrayList<String>();
        Connection con = Connect.getJDBCConnection();
        String sql = "SELECT * FROM brand";
        PreparedStatement preparedStatement = con.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String brand = rs.getString("name_brand");
            brands.add(brand);
        }
        return brands;
    }

    public Product getProductById(int id_product) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "SELECT * FROM product WHERE id_product = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, id_product);

        ResultSet rs = pstm.executeQuery();

        rs.next();

        Product product = new Product(id_product, rs.getString("name_product"), rs.getInt("price"),
                rs.getInt("amount"), rs.getInt("id_brand"), rs.getString("about"),
                rs.getInt("status"));

        return product;
    }

    public int editProductById(Product product) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "UPDATE product "
                + "SET name_product = ?, price = ?, amount = ?, id_brand = ?, about = ?, status = ? "
                + "WHERE id_product = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setInt(2, product.getPrice());
        pstm.setInt(3, product.getAmount());
        pstm.setInt(4, product.getIdBrand());
        pstm.setString(5, product.getAbout());
        pstm.setInt(6, product.getStatus());
        pstm.setInt(7, product.getId());

        int rs = pstm.executeUpdate();

        return rs;
    }

    public int addProduct(Product product) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "INSERT INTO product(name_product, price, amount, id_brand, about) "
                + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setInt(2, product.getPrice());
        pstm.setInt(3, product.getAmount());
        pstm.setInt(4, product.getIdBrand());
        pstm.setString(5, product.getAbout());

        int rs = pstm.executeUpdate();

        return rs;
    }

    public void deleteProduct(int id_product) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "DELETE FROM product WHERE id_product = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, id_product);

        pstm.executeUpdate();
    }
}
