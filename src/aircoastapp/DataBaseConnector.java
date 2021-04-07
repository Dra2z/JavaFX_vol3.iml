package aircoastapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DataBaseConnector extends Configs {
        Connection dbConnection;

        public Connection getDbConnection() throws ClassNotFoundException, SQLException {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

            Class.forName("com.mysql.jdbc.Driver");

            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

            return dbConnection;
        }

        public void signUpUser (Users users) {
            String insert = "INSERT IN" + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + Const.USER_LASTNAME + Const.USER_LOGIN +
                    Const.USER_PASSWORD + Const.USER_EMAIL + ")" + "VALUES(?,?,?,?,?)";



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


}



