package com.LiZhihui.dao;

import com.LiZhihui.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        int max=0;
        String sql1 = "select isnull(max(ProductId),0) max from Product";
        PreparedStatement preparedStatement = con.prepareStatement(sql1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            max = resultSet.getInt("max")+1;
        }
        String sql = "insert into product(ProductId,ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,max);
        pt.setString(2, product.getProductName());
        pt.setString(3, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(4, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(5, product.getPrice());
        pt.setInt(6, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) {
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) {
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) {
        Product product = null;
        try {
            String queryString = "select * from product where productId=?";
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            product = new Product();
            while (resultSet.next()) {
                product.setProductId(resultSet.getInt("ProductId"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setProductDescription(resultSet.getString("ProductDescription"));
                product.setPrice(resultSet.getDouble("Price"));
                product.setCategoryId(resultSet.getInt("CategoryId"));
            }
            System.out.printf("successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {

        List<Product> list = new ArrayList<Product>();
        try {
            String queryString = "select * from product where categoryId=?";
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("ProductId"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setProductDescription(resultSet.getString("ProductDescription"));
                product.setPrice(resultSet.getDouble("Price"));
                product.setCategoryId(resultSet.getInt("CategoryId"));
                list.add(product);
            }
            System.out.printf("successful");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        try {
            String queryString = "select * from product";
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("ProductId"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setProductDescription(resultSet.getString("ProductDescription"));
                product.setPrice(resultSet.getDouble("Price"));
                product.setCategoryId(resultSet.getInt("CategoryId"));
                list.add(product);
            }
            System.out.printf("successful");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
    public byte[] getPictureById(Integer productId, Connection con) throws SQLException {
        byte[] imgByte = null;
        String sql = "select picture from product where productId=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,productId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Blob blob = resultSet.getBlob("picture");
            imgByte = blob.getBytes(1, (int) blob.length());
        }
        return imgByte;
    }
}
