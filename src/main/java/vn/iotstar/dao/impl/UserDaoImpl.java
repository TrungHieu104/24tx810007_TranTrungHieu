package vn.iotstar.dao.impl;

import vn.iotstar.dao.UserDao;
import vn.iotstar.model.User;
import vn.iotstar.util.DBConnection;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPassWord(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createddate"));
                return user;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO users(email, username, fullname, password, avatar, roleid, phone, createddate) "
                   + "VALUES (?,?,?,?,?,?,?,NOW())";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getPassWord());
            ps.setString(5, user.getAvatar());
            ps.setInt(6, user.getRoleid());
            ps.setString(7, user.getPhone());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Insert user failed", e);
        }
    }



    @Override
    public boolean checkExistEmail(String email) {
        String query = "SELECT 1 FROM users WHERE email = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) { return false; }
    }

    @Override
    public boolean checkExistUsername(String username) {
        String query = "SELECT 1 FROM users WHERE username = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) { return false; }
    }

    @Override
    public boolean checkExistPhone(String phone) {
        String query = "SELECT 1 FROM users WHERE phone = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) { return false; }
    }
}
