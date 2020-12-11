package com.service;


import com.IO;
import com.SortByNameProduct;
import com.model.Category;
import com.model.Product;
import com.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListProduct {
    static ArrayList<Product> listProduct = new ArrayList<>();
    static View view = new View();

    boolean check = false;
    String regexDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
            "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
            "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
            "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";


    public static void setListProducts(ArrayList<Product> listProduct) {
        ListProduct.listProduct = listProduct;
    }

    public static ArrayList<Product> getListProducts() {
        return listProduct;
    }

    public Product formAddProduct() {
        Product product = new Product();
        product.setIdProduct();
        product.setNameProduct(view.inputNameProduct());
        product.setPrice(view.inputPrice());
        product.setAmount(view.inputAmount());
        product.setManufacturer(view.inputManufacturer());
        product.setDateOfManufacture(view.inputDateManufacture());
        product.setExpiryDate(view.inputExpiryDate());
        product.getCategory().setName(view.inputNameCategory());
        product.getCategory().setId(view.inputIdCategory());

        return product;
    }


//    public Product formUpdateProduct(){
//        Product p= new Product();
//        p.setNameProduct(view.inputNameProduct());
//        p.setPrice(view.inputPrice());
//        p.setAmount(view.inputAmount());
//        p.setManufacturer(view.inputManufacturer());
//        p.setDateOfManufacture(view.inputDateManufacture());
//        p.setExpiryDate(view.inputExpiryDate());
//        return p;
//    }


    public void addProduct(Product product) {
        listProduct.add(product);
        IO.csvWriterProduct("product.csv", product);
    }

    public void updateListProduct() {
        IO.csvWriterProductUpdate("product.csv", ListProduct.getListProducts());
    }

    public void updateProducts(Product product) {
        for (Product p : ListProduct.getListProducts()) {
            if (p.getIdProduct() == product.getIdProduct()) {
                p.setNameProduct(product.getNameProduct());
                p.setPrice(product.getPrice());
                p.setAmount(product.getAmount());
                p.setManufacturer(product.getManufacturer());
                p.setDateOfManufacture(product.getDateOfManufacture());
                p.setExpiryDate(product.getExpiryDate());
                p.setCategory(product.getCategory());
            }
        }
    }

    public void sortByNameProduct() {
        Collections.sort(ListProduct.getListProducts(), new SortByNameProduct());
        System.out.println("");
    }

    public Product findProductById(int id) {
        for (Product p : listProduct) {
            if (p.getIdProduct() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Product> findProductByName(String name) {
        List<Product> resultList = new ArrayList<>();
        for (Product p : listProduct) {
            if (p.getNameProduct().equals(name)) {
                resultList.add(p);
            }
        }
        return resultList;
    }

    public ArrayList<Product> removeOneProduct(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (id == listProduct.get(i).getIdProduct()) {
                listProduct.remove(i);
            }
        }
        return listProduct;
    }


//    public void updateProducts(ArrayList<Product> removeOneProduct) {
//    }
}