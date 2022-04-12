package com.LiZhihui.dao;

import com.LiZhihui.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String gender = user.getGender();
        java.sql.Date  birthdate= user.getBirthdate();
        String sql = "INSERT INTO usertable(id,username,password,email,gender,birthday) VALUES(?,?,?,?,?,?)";
        int id = 0;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("min");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement M = con.prepareStatement(sql);
        M.setInt(1,id);
        M.setString(2,username);
        M.setString(3,password);
        M.setString(4,email);
        M.setString(5, gender);
        M.setDate(6, birthdate);
        if(M.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from usertable where username=? and password=?";
        PreparedStatement N = con.prepareStatement(sql);
        N.setString(1,username);
        N.setString(2,password);
        ResultSet rs = N.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(Long.parseLong(rs.getString("id")));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
