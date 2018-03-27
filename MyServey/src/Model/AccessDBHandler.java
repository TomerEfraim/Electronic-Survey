/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author Tomer Efraim
 */
public class AccessDBHandler {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public AccessDBHandler(String url) {
        loadJDBC();
        connect(url);
    }

    private void loadJDBC() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("problem loading or registering MS Access JDBC driver");
            ex.printStackTrace();
        }
    }

    private void connect(String url) {
        String dburl = "jdbc:ucanaccess://" + url;
        try {
            connection = DriverManager.getConnection(dburl);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return resultSet;
    }

    public void execute(String query) {
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (null != connection) {
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
