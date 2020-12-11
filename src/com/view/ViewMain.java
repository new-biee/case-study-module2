package com.view;

import com.IO;
import com.model.Category;
import com.model.Product;
import com.service.ListCategory;
import com.service.ListProduct;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ViewMain {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewMain();
    }

    private static void viewMain() {
        View view = new View();
        ListProduct listProduct = new ListProduct();
        ListCategory listCategory = new ListCategory();
        ListProduct.setListProducts(IO.readDataToListProduct());
        ListCategory.setListCategory(IO.readDataToListCategory());
        while (true) {
            try {
                do {
                    System.out.println("-------Menu-------");
                    System.out.println("1. Add product");
                    System.out.println("2. Update product");
                    System.out.println("3. Show all product");
                    System.out.println("4. Delete product");
                    System.out.println("5. Find product by id");
                    System.out.println("6. Find product by name");
                    System.out.println("7. Sort by product name");
                    System.out.println("8. Add category");
                    System.out.println("9. Show all category");
                    System.out.println("10. Show list category by name");
                    System.out.println("11. Remove list category by name");
                    System.out.println("12. Exit");
                    System.out.println("Please choose number: ");
                    int number = Integer.parseInt(scanner.nextLine());
                    switch (number) {
                        case 1:
                            listProduct.addProduct(listProduct.formAddProduct());
                            view.showAllProducts();
                            break;

                        case 2:
                            int idUpdate = view.inputIdProduct();
                            String nameUpdate = view.inputNameProduct();
                            double priceUpdate = view.inputPrice();
                            int amountUpdate = view.inputAmount();
                            String manufacturerUpdate = view.inputManufacturer();
                            String dateUpdate = view.inputDateManufacture();
                            String expiryUpdate = view.inputExpiryDate();
                            String categoryName = view.inputNameCategory();
                            int categoryId = view.inputIdCategory();

                            Product p = new Product(idUpdate, nameUpdate, priceUpdate, amountUpdate, manufacturerUpdate, dateUpdate, expiryUpdate, categoryName, categoryId);
                            listProduct.updateProducts(p);
                            listProduct.updateListProduct();
                            break;
                        case 3:
                            view.showAllProducts();
                            break;
                        case 4:
                            int idRemove = view.inPutId();
                            listProduct.removeOneProduct(idRemove);
                            listProduct.updateListProduct();
                            break;
                        case 5:
                            int id = view.inPutId();
                            Product product = listProduct.findProductById(id);
                            view.showOneProduct(product);
                            break;
                        case 6:
                            String name = view.inputName();
                            List<Product> products = listProduct.findProductByName(name);
                            view.showProductList(products);
                            break;
                        case 7:
                            listProduct.sortByNameProduct();
                            view.showAllProducts();
                            break;
                        case 8:
                            listCategory.addCategory(listCategory.formAddCategory());
                            view.showAllCategories();
                            break;
                        case 9:
                            view.showAllCategories();
                            break;
                        case 10:
                            String nameCategory = view.inputName();
                            List<Category> categories = ListCategory.findCategoryByCategoryName(nameCategory);
                            view.showCategoryList(categories);
                            break;
                        case 11:
                            String nameRemoveCategory = view.inputName();
                            List<Product> productList = ListCategory.removeListProductByNameCategory(nameRemoveCategory);
                            view.showProductList(productList);
                            listProduct.updateListProduct();
                            break;
                        case 12:
                            System.out.println("Goodbye see you again!");
                            System.exit(0);
                        default:
                            System.out.println("Please choise number 1-12");
                            viewMain();
                    }
                } while (true);
            } catch (Exception e) {
                System.err.println(e);
                System.err.println("Please enter number");
            }
        }
    }
}