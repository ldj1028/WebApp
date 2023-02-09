package kr.co.cywell.web.config;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class DBConfig {
    private boolean bDSName = false;
    public DBConfig() {
        bDSName = (System.getProperty("webapp.datasource.list") != null)?true:false;
    }

    public String connectionDB() throws SQLException{
        String msg = "";
        boolean bSuccess = false;
        if(bDSName){
            StringTokenizer st = new StringTokenizer(System.getProperty("webapp.datasource.list"),",");
            while (st.hasMoreTokens()){
                String dsName = st.nextToken();
                bSuccess = testDataSource(dsName);
                msg += dsName + " : " + bSuccess +"</br>";
            }
        }
        return msg;
    }

    private boolean testDataSource(String dsName) throws SQLException {
        Connection conn = null;
        boolean bSuccess = false;
        try{
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(dsName);
            conn = ds.getConnection();
            System.out.println("Successfully connected to '" + dsName + "'..!!!!!!!");
            conn.close();
            bSuccess = true;
        }catch(NamingException ne){
            System.out.println("Failed connect to '" + dsName + "'..!!!!!!! Because of '"+ dsName + "' Name not found.");
        }finally {
            if(conn != null ) conn.close();
        }
        return bSuccess;
    }

}
