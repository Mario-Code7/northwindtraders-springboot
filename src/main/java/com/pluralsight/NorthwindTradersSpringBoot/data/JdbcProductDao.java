package com.pluralsight.NorthwindTradersSpringBoot.data;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao{

    private final DataSource dataSource;


    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String query = """
                select ProductID, ProductName, CategoryID, UnitPrice
                from products
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    products.add(new Product(
                            resultSet.getInt("ProductID"),
                            resultSet.getString("ProductName"),
                            resultSet.getInt("CategoryID"),
                            resultSet.getDouble("UnitPrice")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void add(Product product) {
            String query =  """
            INSERT INTO ProductID, ProductName, SupplierID, CategoryID, UnitPrice
            VALUES (?, ?, ?, ?)
            """;
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setInt(1, product.getProductId());
                statement.setString(2, product.getProductName());
                statement.setInt(3, product.getCategoryId());
                statement.setDouble(4, product.getUnitPrice());

                statement.executeUpdate();

            } catch (SQLException e) {
                System.out.println("There was an error inserting data. Please try again.");
                e.printStackTrace();
            }
        }

    @Override
    public void update(Product product) {
        String query =  """
            UPDATE products
            SET ProductID = ?, ProductName = ?, CategoryID = ?, UnitPrice = ?
            """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, product.getCategoryId());
            preparedStatement.setDouble(4, product.getUnitPrice());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating product!", e);
        }
    }

    @Override
    public void delete(int productId) {
        String query =  """
            DELETE FROM products
            WHERE ProductID = ?;
            """;
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating product!", e);
        }
    }

    @Override
    public List<Product> searchByName(String keyword) {
        String query = """
                select ProductID, ProductName, CategoryID, UnitPrice
                from products
                WHERE ProductName = ?
                """;

        List<Product> results = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, keyword);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    results.add(new Product(
                            resultSet.getInt("ProductID"),
                            resultSet.getString("Product Name"),
                            resultSet.getInt("CategoryID"),
                            resultSet.getDouble("Unit Price")
                    ));
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error searching for product!", e);
        }
        return results;
    }
}
