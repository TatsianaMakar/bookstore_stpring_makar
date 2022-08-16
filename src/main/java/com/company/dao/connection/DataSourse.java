package com.company.dao.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourse {
    private static final Logger log = LogManager.getLogger(DataSourse.class);
    private static final String URL = "jdbc:postgresql://localhost:5432/bookstore_bh";
    private static final String URL1 = "jdbc:postgresql://hattie.db.elephantsql.com:5432/jdptrbdw";
    private static final String USER = "postgres";
    private static final String USER1 = "jdptrbdw";
    private static final String PASSWORD = "root";
    private static final String PASSWORD1 = "hn72bsHRBP-qi_JQrjeAGlRHjB3xEcok";
    private Connection connection;
    public static final DataSourse INSTANCE=new DataSourse();

    private DataSourse() {
    }

       public Connection getConnection() {
           try {
               Class.forName("org.postgresql.Driver");
           } catch (ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
           if (connection == null) {
            try {

                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                log.info("Connection completed");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }

    public void close() throws SQLException {
        connection.close();
    }
}
