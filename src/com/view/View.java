package com.view;

import com.IO;
import com.model.Category;
import com.model.Product;
import com.service.ListCategory;
import com.service.ListProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {
    static Scanner scanner = new Scanner(System.in);
    static boolean check = false;
    static String regexDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
            "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
            "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
            "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";



//    public ArrayList<Product> formUpdate() {
//
//
//        int idUpdate = Integer.parseInt(scanner.nextLine());
//        int flag = 0;
//        for (int i = 0; i < ListProduct.getListProducts().size(); i++) {
//            if (idUpdate == ListProduct.getListProducts().get(i).getIdProduct()) {
//                System.out.println("Enter name ");
//                String nameUpdate = scanner.nextLine();
//                System.out.println("Enter price");
//                double priceUpdate = Double.parseDouble(scanner.nextLine());
//                System.out.println("Enter amount");
//                int amount = Integer.parseInt(scanner.nextLine());
//                System.out.println("Enter manufacturer");
//                String manufacturer = scanner.nextLine();
//
//                do {
//                    System.out.println("Enter product dateOfManufacture (dd/mm/yyyy)");
//                    String regex = regexDate;
//                    String inputDateOfManufacture = scanner.nextLine();
//                    Pattern patternDate = Pattern.compile(regex);
//                    Matcher matcherDate = patternDate.matcher(inputDateOfManufacture);
//                    if (matcherDate.find()) {
//                        check = true;
//                        ListProduct.getListProducts().get(i).setDateOfManufacture(inputDateOfManufacture);
//                    } else {
//                        System.out.println("Please enter the correct format");
//                    }
//                } while (!check);
//
//                do {
//                    System.out.println("Enter product expiryDate (dd/mm/yyyy)");
//                    String regex = regexDate;
//                    String inputDateOfExpiryDate = scanner.nextLine();
//                    Pattern patternDate = Pattern.compile(regex);
//                    Matcher matcherDate = patternDate.matcher(inputDateOfExpiryDate);
//                    if (matcherDate.find()) {
//                        check = true;
//                        ListProduct.getListProducts().get(i).setExpiryDate(inputDateOfExpiryDate);
//                    } else {
//                        System.out.println("Please enter the correct format");
//                    }
//                } while (!check);
//
//                ListProduct.getListProducts().get(i).setNameProduct(nameUpdate);
//                ListProduct.getListProducts().get(i).setPrice(priceUpdate);
//                ListProduct.getListProducts().get(i).setAmount(amount);
//                ListProduct.getListProducts().get(i).setManufacturer(manufacturer);
//                flag++;
//            }
//        }
//        if (flag == 0) {
//            System.out.println("Not product");
//        }
//        return ListProduct.getListProducts();
//    }

    public ArrayList<Product> formRemove() {
        int count = 0;
        System.out.println("Enter id product want remote");
        int idRemote = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < ListProduct.getListProducts().size(); i++) {
            if (idRemote == ListProduct.getListProducts().get(i).getIdProduct()) {
                ListProduct.getListProducts().remove(ListProduct.getListProducts().get(i));
                count++;
            }
        }
        if (count <= 0) {
            System.out.println("Not product");
        }
        IO.csvWriterProductUpdate("product.csv", ListProduct.getListProducts());
        return ListProduct.getListProducts();
    }

    //region INPUT
    public int inPutId() {
        System.out.println("Enter id product want find");
        int idFind = Integer.parseInt(scanner.nextLine());
        return idFind;
    }


    public int inputIdProduct() {
        System.out.println("Enter id product want update");
        int idFind = Integer.parseInt(scanner.nextLine());
        return idFind;
    }

    public String inputName() {
        System.out.println("Please input name to search:");
        return scanner.nextLine();
    }

    public String inputNameProduct() {
        System.out.println("Enter name:");
        return scanner.nextLine();
    }

    public Double inputPrice() {
        System.out.println("Enter price: ");
        double priceProduct = Double.parseDouble(scanner.nextLine());
        return priceProduct;
    }

    public Integer inputAmount() {
        System.out.println("Enter amount: ");
        int amountProduct = Integer.parseInt(scanner.nextLine());
        return amountProduct;
    }

    public String inputManufacturer() {
        System.out.println("Enter manufacturer");
        String manufacturerProduct = scanner.nextLine();
        return manufacturerProduct;
    }

    public String inputDateManufacture() {
        while (true) {
            System.out.println("Enter product dateOfManufacture (dd/mm/yyyy)");
            String regex = regexDate;
            String inputDateOfManufacture = scanner.nextLine();
            Pattern patternDate = Pattern.compile(regex);
            Matcher matcherDate = patternDate.matcher(inputDateOfManufacture);
            try {
                if (matcherDate.find()) {
                    check = true;
                    return inputDateOfManufacture;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter again!");
            }
        }
    }

    public String inputExpiryDate() {
        while (true) {
            System.out.println("Enter product expiryDate (dd/mm/yyyy)");
            String regex = regexDate;
            String inputDateOfManufacture = scanner.nextLine();
            Pattern patternDate = Pattern.compile(regex);
            Matcher matcherDate = patternDate.matcher(inputDateOfManufacture);
            try {
                if (matcherDate.find()) {
                    check = true;
                    return inputDateOfManufacture;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter again!");
            }
        }
    }

    public int inputIdCategory() {
        System.out.println("Enter id category");
        int idFind = Integer.parseInt(scanner.nextLine());
        return idFind;
    }

    public String inputNameCategory(){
        System.out.println("Enter name category");
        String nameCategory = scanner.nextLine();
        return nameCategory;
    }

    //endregion

    //region SHOW
    public void showAllProducts() {
        showFormattedTemplate();
        for (Product p : ListProduct.getListProducts()) {
            showFormattedProduct(p);
        }
        System.out.println();
    }

    public void showAllCategories(){
        showFormattedTemplateCategory();
        for (Category c : ListCategory.getListCategories()){
            showFormattedCategory(c);
        }
        System.out.println();
    }

    public void showOneProduct(Product product) {
        showFormattedTemplate();
        if (product == null) {
            System.out.println("404 Product Not Found");
        } else {
            showFormattedProduct(product);
        }
    }

    public void showProductList(List<Product> products) {
        showFormattedTemplate();
        if (products.isEmpty()) {
            System.out.println("404 Product Not Found");
        } else {
            for (Product p : products) {
                showFormattedProduct(p);
            }
        }
    }

    public void showCategoryList(List<Category> categories){
        showFormattedTemplateCategory();
        if (categories.isEmpty()){
            System.out.println("404 Product Not Found");
        }else {
            for (Category p: categories){
                showFormattedCategory(p);
            }
        }
    }

    //endregion

    //region TEMPLATE
    private void showFormattedTemplate() {
        System.out.printf("%10s |", "ProductID");
        System.out.printf("%15s |", "ProductName");
        System.out.printf("%10s |", "Price");
        System.out.printf("%10s |", "Amount");
        System.out.printf("%15s |", "Manufacturer");
        System.out.printf("%21s |", "DateOfManufacture");
        System.out.printf("%15s |", "ExpiryDate");
        System.out.printf("%15s |", "CategoryName");
        System.out.printf("%12s |", "CategoryId");
        System.out.println();
    }

    private void showFormattedProduct(Product product) {
        System.out.printf("%10d |", product.getIdProduct());
        System.out.printf("%15s |", product.getNameProduct());
        System.out.printf("%10.2f |", product.getPrice());
        System.out.printf("%10d |", product.getAmount());
        System.out.printf("%15s |", product.getManufacturer());
        System.out.printf("%21s |", product.getDateOfManufacture());
        System.out.printf("%15s |", product.getExpiryDate());
        System.out.printf("%15s |", product.getCategory().getName());
        System.out.printf("%12d |%n", product.getCategory().getId());

    }

    private void showFormattedTemplateCategory(){
        System.out.printf("%15s |", "CategoryId");
        System.out.printf("%15s |%n", "CategoryName");
    }

    public void showFormattedCategory(Category category){
        System.out.printf("%15d |", category.getId());
        System.out.printf("%15s |%n", category.getName());
    }
    //endregion


}
