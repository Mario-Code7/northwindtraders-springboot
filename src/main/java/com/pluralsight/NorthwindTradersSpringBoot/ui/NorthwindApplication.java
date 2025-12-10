package com.pluralsight.NorthwindTradersSpringBoot.ui;

import com.pluralsight.NorthwindTradersSpringBoot.data.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {
    @Autowired
    private ProductDao productDao;

    @Override
    public void run(String... args) throws Exception {
        Scanner myScanner = new Scanner(System.in);


        while(true) {
            System.out.println("\n==== Northwind Product Console ====");
            System.out.println("1 ~ List Products");
            System.out.println("2 ~ Add Product");
            System.out.println("3 ~ Update Product");
            System.out.println("4 ~ Delete Product");
            System.out.println("5 ~ Search by Product");
            System.out.println("0 ~ Exit");
            System.out.print("Please Select: ");

            int option = Integer.parseInt(myScanner.nextLine());

            switch(option) {
                case 1:
                    listProducts();
                    break;

                case 2:
                    addProduct(myScanner);
                    break;

                case 3:
                    updateProduct(myScanner);
                    break;

                case 4:
                    deleteProduct(myScanner);
                    break;

                case 5:
                    searchByProduct(myScanner);

                case 0:
                    System.out.println("See ya!");
                    return;

                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    private void listProducts() {
        List<Product> products = productDao.getAll();
        products.forEach(System.out::println);
    }

    private void addProduct(Scanner scanner) {
        System.out.print("ProductID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Product Name: ");
        String name = scanner.nextLine();

        System.out.println("Category ID: ");
        int categoryId = Integer.parseInt(scanner.nextLine());

        System.out.println("Unit Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        productDao.add(new Product(id,name,categoryId,price));

        System.out.println("Product added!");
    }

    private void updateProduct(Scanner scanner) {
        System.out.println("Enter Product ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("New Product Name: ");
        String name = scanner.nextLine();

        System.out.println("New Category ID: ");
        int categoryId = Integer.parseInt(scanner.nextLine());

        System.out.println("New Unit Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        productDao.update(new Product(id,name,categoryId,price));

        System.out.println("Product updated!");
    }

    private void deleteProduct(Scanner scanner) {
        System.out.println("Enter Product ID to Delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        productDao.delete(id);

        System.out.println("Product deleted!");
    }

    private void searchByProduct(Scanner scanner) {
        System.out.println("Enter a Keyword: ");
        String keyword = scanner.nextLine();

        List<Product> results = productDao.searchByName(keyword);

        if(results.isEmpty()) {
            System.out.println("Product not found!");
        }
        else {
            results.forEach(System.out::println);
        }


    }


//    @Autowired
//    private ShipperDao shipperDao;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Running userInterface");
//        List<Shipper> shippers = shipperDao.getAll();
//        for (Shipper shipper : shippers) {
//            System.out.println(shipper);
//        }
//    }
}
