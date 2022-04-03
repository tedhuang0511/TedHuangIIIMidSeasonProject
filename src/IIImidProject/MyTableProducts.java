package IIImidProject;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Properties;

public class MyTableProducts extends AbstractTableModel {
    public static PreparedStatement pstmt;
    private static ResultSet res;

    public MyTableProducts() {
        getDBData();
    }

    public static Object[][] getDBData() {
        Object[][] dataList = new Object[0][];
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "");
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/northwind", prop)){

            String A = NorthwindBackOffice.jtfPID.getText();
            String B = NorthwindBackOffice.jtfPN.getText();
            String C = NorthwindBackOffice.jtfSPID.getText();

            if (A.equals("")&&B.equals("")&&C.equals("")) {
                pstmt = conn.prepareStatement(
                        "SELECT * FROM products",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
            } else if(!(A.equals(""))){
                pstmt = conn.prepareStatement(
                        "SELECT * FROM products WHERE PRODUCTID = ?",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, A);
            } else if(!(B.equals(""))){
                pstmt = conn.prepareStatement(
                        "SELECT * FROM products WHERE PRODUCTNAME LIKE ?",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, "%" + B + "%");
            } else{
                pstmt = conn.prepareStatement(
                        "SELECT * FROM products WHERE SUPPLIERID = ?",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, C);
            }

            res = pstmt.executeQuery();

            res.last();
            int rowCount = res.getRow();
            res.beforeFirst();
            dataList = new Object[rowCount][];
            for (var i = 0; res.next(); i++) {
                String b = res.getString(1);
                String c = res.getString(2);
                String d = res.getString(3);
                String e = res.getString(4);
                String f = res.getString(5);
                String g = res.getString(6);
                String h = res.getString(7);
                String O = res.getString(8);
                String j = res.getString(9);
                String k = res.getString(10);
                String[] rowConcate = {b, c, d, e, f, g, h, O, j, k};
                dataList[i] = rowConcate;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dataList;
    }

    private static String[] getColumnsName() {
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "");
        String[] columns = new String[10]; //欄位數量
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/northwind", prop)){
            pstmt = conn.prepareStatement(
                    "SELECT * FROM PRODUCTS",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            res = pstmt.executeQuery();
            ResultSetMetaData rsmd = res.getMetaData();
            int count = rsmd.getColumnCount();

            for (int x = 0; x < count; x++) {
                columns[x] = rsmd.getColumnName(x + 1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return columns;
    }

    public static String[] columnNames = getColumnsName();

    private Object[][] data = getDBData();

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