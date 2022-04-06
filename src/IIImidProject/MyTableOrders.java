package IIImidProject;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class MyTableOrders extends AbstractTableModel {
    public static PreparedStatement pstmt;
    private static ResultSet res;
    static int page;
    static int rpp =30;
    static int start;
    static int maxPage;
    private static String sql = "select * from ORDERS";
    private static Properties prop = new Properties();

    public MyTableOrders() {
        getDBData();
    }
    
    public static int getMaxPage() {
    	int rowCount = -1;
    	prop.put("user", "root");
        prop.put("password", "");
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/northwind", prop)){
        	pstmt = conn.prepareStatement(
        			sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        	res = pstmt.executeQuery();
            res.last();//游標放到最後
            rowCount = res.getRow();
        }catch(Exception e) {
        	System.out.println(e);
        }
        if(rowCount%rpp==0) {return rowCount/rpp;}
    	return rowCount/rpp+1;
    }

    public static Object[][] getDBData() {
        Object[][] dataList = new Object[0][];
        prop.put("user", "root");
        prop.put("password", "");
        page = NorthwindBackOffice.getPageOD();
        start = (page -1) * rpp;
        String presql = sql +" LIMIT %d ,%d";
		String sql1 = String.format(presql, start, rpp);
		String sql2 = sql+" WHERE OrderDate BETWEEN ? AND ?";
		String sql3 = sql+" WHERE OrderID = ?";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/northwind", prop)){

            String A = NorthwindBackOffice.jtfDS.getText();
            String B = NorthwindBackOffice.jtfDN.getText();
            String C = NorthwindBackOffice.jtfODID.getText();

            if (A.equals("")&&B.equals("")&&C.equals("")) {
                pstmt = conn.prepareStatement(
                        sql1,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
            } else if(!(A.equals("")) || !(B.equals(""))){
                pstmt = conn.prepareStatement(
                        sql2,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, A);
                pstmt.setString(2, B);
            } else if(!(C.equals(""))){
                pstmt = conn.prepareStatement(
                        sql3,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, C);
            }
            res = pstmt.executeQuery();
            ResultSetMetaData rsmd = res.getMetaData();
            int columnCount = rsmd.getColumnCount();
            res.last();
            int rowCount = res.getRow();
            res.beforeFirst();
            dataList = new Object[rowCount][];
            for (var i = 0; res.next(); i++) {
                String[] columns = new String[columnCount];
                for(var k = 0; k<columnCount; k++){
                    String oneRowColumn = res.getString(k+1);
                    columns[k] = oneRowColumn;
                }
                dataList[i] = columns;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dataList;
    }

    private static String[] getColumnsName() {
        prop.put("user", "root");
        prop.put("password", "");
        String[] columns = new String[0];
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/northwind", prop)){
            pstmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            res = pstmt.executeQuery();
            ResultSetMetaData rsmd = res.getMetaData();
            int count = rsmd.getColumnCount();
            columns = new String[count];
            for (int x = 0; x < count; x++) {
                columns[x] = rsmd.getColumnName(x + 1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return columns;
    }

    public static String[] columnNames = getColumnsName();

    private final Object[][] data = getDBData();

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
}