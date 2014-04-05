package hivehandlers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiveHandler {
    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
    private static final String IP = "130.206.80.46";
    private static final String PORT = "10000";

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            return DriverManager.getConnection("jdbc:hive://" + IP + ":" + PORT
                    + "/default?user=cristeam&password=puntoCORREO92");
        } catch (SQLException ex) {
            Logger.getLogger(HiveHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Statement getStatement(Connection connection){
        try {
            Statement statement = connection.createStatement();
            return statement;
        } catch (SQLException ex) {
            Logger.getLogger(HiveHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List launchQuery(String query){
        Statement statement = getStatement(getConnection());
        try {
            return ResultSetToList(statement.executeQuery(query));
        } catch (SQLException ex) {
            Logger.getLogger(HiveHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List ResultSetToList(ResultSet set) {
        try {
            List list = new ArrayList();
            int colLimit = set.getMetaData().getColumnCount();
            while (set.next())
                for (int i = 1; i < colLimit+1; i++)
                    list.add(String.valueOf(set.getObject(i)));
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(HiveHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List launchInsert(String query){
        Statement statement = getStatement(getConnection());
        try {
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            return ResultSetToList(statement.getGeneratedKeys());
        } catch (SQLException ex) {
            Logger.getLogger(HiveHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

