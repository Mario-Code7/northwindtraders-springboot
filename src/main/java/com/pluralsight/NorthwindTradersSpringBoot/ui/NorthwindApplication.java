package com.pluralsight.NorthwindTradersSpringBoot.ui;

import com.pluralsight.NorthwindTradersSpringBoot.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    }

    private void addProduct(Scanner scanner) {
        System.out.print("ProductID: ");
        int id = Integer.parseInt(scanner.nextLine());
    }

    private void updateProduct(Scanner scanner) {
        System.out.println();
    }

    private void deleteProduct(Scanner scanner) {
    }

    private void searchByProduct(Scanner scanner) {
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
