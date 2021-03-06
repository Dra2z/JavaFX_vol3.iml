package aircoastapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DataBaseConnector extends Configs {
        Connection dbConnection;

        public Connection getDbConnection() throws ClassNotFoundException, SQLException {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

            Class.forName("com.mysql.cj.jdbc.Driver");

            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

            return dbConnection;
        }

        public void signUpUser (Users users) {

            //String insert = "INSERT INTO " + Const.USER_TABLE + " (" + Const.USER_FIRSTNAME + Const.USER_LASTNAME + Const.USER_LOGIN +
              //      Const.USER_PASSWORD + Const.USER_EMAIL + ") " + "VALUES(?,?,?,?,?)";
            String insert = "INSERT INTO  usersaircoast (firstName, lastName, loginName, passwordUser, emailUser) VALUES (?, ?, ?, ?, ?)";



            try {
                PreparedStatement prStatement = getDbConnection().prepareStatement(insert);
                prStatement.setString(1, users.getFirstName());
                prStatement.setString(2, users.getLastName());
                prStatement.setString(3, users.getLoginName());
                prStatement.setString(4, users.getPasswordUser());
                prStatement.setString(5, users.getEmailUser());
                prStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public ResultSet getUsers (Users users) {
            ResultSet rSet = null;

            String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=? AND " +
                    Const.USER_PASSWORD + "=?";

            try {
                PreparedStatement prStatement = getDbConnection().prepareStatement(select);
                prStatement.setString(1, users.getLoginName());
                prStatement.setString(2, users.getPasswordUser());

                rSet = prStatement.executeQuery();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return rSet;

        }

}



