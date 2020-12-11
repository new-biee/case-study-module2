package com;

import com.model.Category;
import com.model.Product;

import java.io.*;
import java.util.ArrayList;

public class IO {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void csvWriterProduct(String path, Product product) {
        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            if (!file.exists()) {
                System.out.println("File not exits");
                file.createNewFile();
            }

            fileWriter = new FileWriter(file, true);
            fileWriter.append(String.valueOf(product.getIdProduct()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(product.getNameProduct());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(product.getPrice()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(product.getAmount()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(product.getManufacturer());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(product.getDateOfManufacture());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(product.getExpiryDate());
            fileWriter.write(COMMA_DELIMITER);
            fileWriter.write(product.getCategory().getName());
            fileWriter.write(COMMA_DELIMITER);
            fileWriter.write(String.valueOf(product.getCategory().getId()));
            fileWriter.append(NEW_LINE_SEPARATOR);

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    System.out.println("Write success!");
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void csvWriterProductUpdate(String path, ArrayList<Product> product) {
        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            if (!file.exists()) {
                System.out.println("File not exits");
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);

            for (int i = 0; i < product.size(); i++) {
                fileWriter.write(String.valueOf(product.get(i).getIdProduct()));
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(product.get(i).getNameProduct());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(String.valueOf(product.get(i).getPrice()));
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(String.valueOf(product.get(i).getAmount()));
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(product.get(i).getManufacturer());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(product.get(i).getDateOfManufacture());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(product.get(i).getExpiryDate());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(product.get(i).getCategory().getName());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(String.valueOf(product.get(i).getCategory().getId()));
                fileWriter.write(NEW_LINE_SEPARATOR);
                fileWriter.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    System.out.println("Write success!");
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }


    public static ArrayList<Product> readDataToListProduct() {
        ArrayList<Product> listProduct = new ArrayList<>();
        String fileIn = "product.csv";
        String line = null;
        File file = new File(fileIn);
        FileReader fileReader = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (true) {
                try {
                    if (!((line = bufferedReader.readLine()) != null)) break;
                } catch (IOException exception) {
                    System.out.println(exception);
                }
                String[] temp = line.split(COMMA_DELIMITER);

                int idProduct = Integer.parseInt(temp[0]);
                String productName = temp[1];
                double price = Double.parseDouble(temp[2]);
                int amount = Integer.parseInt(temp[3]);
                String manufacturer = temp[4];
                String manufacturerDate = temp[5];
                String expiryDate = temp[6];
                String categoryName = temp[7];
                int categoryId = Integer.parseInt(temp[8]);
                listProduct.add(new Product(idProduct, productName, price, amount, manufacturer, manufacturerDate, expiryDate, categoryName, categoryId));
            }
            try {
                bufferedReader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
                return null;
            }
        }
        return listProduct;
    }


    //region READDATAERROR
    public static ArrayList<Product> readDataToArrayList(String path) {
        ArrayList<Product> listProduct = new ArrayList<>();
        String fileIn = path;
        String line = null;
        FileReader fileReader = null;

        if (fileIn == null) {
            return null;
        } else {
            try {
                fileReader = new FileReader(fileIn);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (true) {
                try {
                    if (!((line = bufferedReader.readLine()) != null)) break;
                } catch (IOException exception) {
                    System.out.println(exception);
                }
                String[] temp = line.split(",");
                int idProduct = Integer.parseInt(temp[0]);
                String productName = temp[1];
                double price = Double.parseDouble(temp[2]);
                int amount = Integer.parseInt(temp[3]);
                String manufacturer = temp[4];
                String manufacturerDate = temp[5];
                String expiryDate = temp[6];
                String categoryName = temp[7];
                int categoryId = Integer.parseInt(temp[8]);
                listProduct.add(new Product(idProduct, productName, price, amount, manufacturer, manufacturerDate, expiryDate, categoryName, categoryId));
            }
            try {
                bufferedReader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
                return null;
            }
            return listProduct;
        }
    }

    //endregion

    public static void csvWriterCategory(String path, Category category) {
        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            if (!file.exists()) {
                System.out.println("File not exits");
                file.createNewFile();
            }

            fileWriter = new FileWriter(file, true);
            fileWriter.write(String.valueOf(category.getId()));
            fileWriter.write(COMMA_DELIMITER);
            fileWriter.write(category.getName());
            fileWriter.append(NEW_LINE_SEPARATOR);

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    System.out.println("Write success!");
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static ArrayList<Category> readDataToListCategory() {
        ArrayList<Category> listCategory = new ArrayList<>();
        String fileIn = "category.csv";
        String line = null;
        File file = new File(fileIn);
        FileReader fileReader = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (true) {
                try {
                    if (!((line = bufferedReader.readLine()) != null)) break;
                } catch (IOException exception) {
                    System.out.println(exception);
                }
                String[] temp = line.split(COMMA_DELIMITER);

                int categoryId = Integer.parseInt(temp[0]);
                String categoryName = temp[1];
                listCategory.add(new Category(categoryId, categoryName));
            }
            try {
                bufferedReader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
                return null;
            }
        }
        return listCategory;
    }
}
