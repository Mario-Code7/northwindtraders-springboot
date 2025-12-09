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
                    Product product = new Product(
                            resultSet.getInt("ProductID"),
                            resultSet.getString("ProductName"),
                            resultSet.getInt("CategoryID"),
                            resultSet.getDouble("UnitPrice")
                    );
                    products.add(product);
                }
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

            } catch (SQLException e) {
                System.out.println("There was an error retrieving the data. Please try again.");
                e.printStackTrace();
            }
        }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public List<Product> searchByProduct(String keyword) {
        return List.of();
    }
}
