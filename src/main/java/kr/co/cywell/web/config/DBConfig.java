package kr.co.cywell.web.config;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConfig {
    private boolean bOracle = false;
    private boolean bMaria = false;
    private boolean bMSSQL = false;
    private boolean bMySQL = false;
    public DBConfig() {
        bOracle = (System.getProperty("webapp.datasource.oracle") != null)?true:false;
        bMaria = (System.getProperty("webapp.datasource.maria") != null)?true:false;
        bMSSQL = (System.getProperty("webapp.datasource.mssql") != null)?true:false;
        bMySQL = (System.getProperty("webapp.datasource.mysql") != null)?true:false;
    }

    public String connectionDB() throws SQLException{
        String msg = "";
        boolean bSuccess = false;
        if(bOracle){
            bSuccess = connOracle();
            msg += "Oracle DB Connection : " + bSuccess +"</br>";
        }
        if(bMaria){
            bSuccess = connMaria();
            msg += "Maria DB Connection : " + bSuccess +"</br>";
        }
        if(bMSSQL){
            bSuccess = connMSSQL();
            msg += "MSSQL DB Connection : " + bSuccess +"</br>";
        }
        if(bMySQL){
            bSuccess = connMySQL();
            msg += "MySQL DB Connection : " + bSuccess +"</br>";
        }
        return msg;
    }
    private boolean connOracle() throws SQLException {
        String dsName = System.getProperty("webapp.datasource.oracle");
        Connection conn = null;
        boolean bSuccess = false;
        try{
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(dsName);
            conn = ds.getConnection();
            System.out.println("Oracle DB Connection Successful!!!");
            System.out.println("Conn : " + conn);
            conn.close();
            bSuccess = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(conn != null ) conn.close();
        }
        return bSuccess;
    }

    private boolean connMaria() throws SQLException{
        String dsName = System.getProperty("webapp.datasource.maria");
        Connection conn = null;
        boolean bSuccess = false;
        try{
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(dsName);
            conn = ds.getConnection();
            System.out.println("Maria DB Connection Successful!!!");
            System.out.println("Conn : " + conn);
            conn.close();
            bSuccess = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(conn != null ) conn.close();
        }
        return bSuccess;
    }

    private boolean connMSSQL() throws SQLException{
        String dsName = System.getProperty("webapp.datasource.mssql");
        Connection conn = null;
        boolean bSuccess = false;
        try{
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(dsName);
            conn = ds.getConnection();
            System.out.println("MSSQL DB Connection Successful!!!");
            System.out.println("Conn : " + conn);
            conn.close();
            bSuccess = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(conn != null ) conn.close();
        }
        return bSuccess;
    }

    private boolean connMySQL() throws SQLException{
        String dsName = System.getProperty("webapp.datasource.mysql");
        Connection conn = null;
        boolean bSuccess = false;
        try{
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(dsName);
            conn = ds.getConnection();
            System.out.println("MySQL DB Connection Successful!!!");
            System.out.println("Conn : " + conn);
            conn.close();
            bSuccess = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(conn != null ) conn.close();
        }
        return bSuccess;
    }
}
