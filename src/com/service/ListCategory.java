package com.service;

import com.IO;
import com.model.Category;
import com.model.Product;
import com.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListCategory {

    static ArrayList<Product> list = ListProduct.getListProducts();
    static ArrayList<Category> listCategory = new ArrayList<>();
    View view = new View();

    public static void setListCategory(ArrayList<Category> listCategory) {
        ListCategory.listCategory = listCategory;
    }

    public static ArrayList<Category> getListCategories() {
        return listCategory;
    }

    public static List<Product> findProductByCategoryName(String name) {
        List<Product> resultList = new ArrayList<>();
        for (Product p : list) {
            if (p.getCategory().getName().equals(name)) {
                resultList.add(p);
            }
        }
        return resultList;
    }

    public static ArrayList<Product> removeListProductByNameCategory(String name) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getCategory().getName().equals(name)) {
                list.remove(i);
            }
        }
        return list;
    }

    public Category formAddCategory() {
        Category category = new Category();
        category.setId(view.inputIdCategory());
        category.setName(view.inputNameCategory());
        return category;
    }

    public void addCategory(Category category) {
        listCategory.add(category);
        IO.csvWriterCategory("category.csv", category);
    }

    public static List<Category> findCategoryByCategoryName(String nameCategory) {
        List<Category> resultList = new ArrayList<>();
        for (Category p : listCategory) {
            if (p.getName().equals(nameCategory)) {
                resultList.add(p);
            }
        }
        return resultList;
    }
}
