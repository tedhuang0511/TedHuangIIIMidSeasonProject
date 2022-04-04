package IIImidProject;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class NewPanel extends JPanel {
        public NewPanel() {
        setLayout(new BorderLayout());
    }

    public void customers() {
        removeAll(); NorthwindBackOffice.right.removeAll();
        add(buildPanel(new NewPanel()));
        revalidate();

        JTable table = new JTable(new MyTableCustomers());
        table.setFillsViewportHeight(false);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);

        JButton btn = new JButton("下載XLSX檔案");
        JButton btn2 = new JButton("下載CSV檔案");
        btn.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableCustomers.getDBData();
                    ExcelUtil.saveTable(path, list,MyTableCustomers.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        btn2.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableCustomers.getDBData();
                    CSVUtil.saveTable(path, list,MyTableCustomers.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        NorthwindBackOffice.right.add(btn); NorthwindBackOffice.right.add(btn2);
    }
    public void employees() {
        removeAll(); NorthwindBackOffice.right.removeAll();
        add(buildPanel(new NewPanel()));
        revalidate();

        JTable table = new JTable(new MyTableEmployees());
        table.addColumn(new TableColumn(17,75,new ButtonRenderer(),new ButtonEditor()));
        table.setFillsViewportHeight(false);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);

        JButton btn = new JButton("下載XLSX檔案");JButton btn2 = new JButton("下載CSV檔案");
        btn.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableEmployees.getDBData();
                    ExcelUtil.saveTable(path, list,MyTableEmployees.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        btn2.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableEmployees.getDBData();
                    CSVUtil.saveTable(path, list,MyTableEmployees.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        NorthwindBackOffice.right.add(btn);NorthwindBackOffice.right.add(btn2);
    }
    public void orders() {
        removeAll(); NorthwindBackOffice.right.removeAll();
        add(buildPanel(new NewPanel()));
        revalidate();

        JTable table = new JTable(new MyTableOrders());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(false);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);

        JButton btn = new JButton("下載XLSX檔案");JButton btn2 = new JButton("下載CSV檔案");
        btn.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableOrders.getDBData();
                    ExcelUtil.saveTable(path, list, MyTableOrders.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        btn2.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableOrders.getDBData();
                    CSVUtil.saveTable(path, list,MyTableOrders.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        NorthwindBackOffice.right.add(btn);NorthwindBackOffice.right.add(btn2);
    }
    public void orderDetail() {
        removeAll(); NorthwindBackOffice.right.removeAll();
        add(buildPanel(new NewPanel()));
        revalidate();

        JTable table = new JTable(new MyTableOrderDET());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(false);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);

        JButton btn = new JButton("下載XLSX檔案");JButton btn2 = new JButton("下載CSV檔案");
        btn.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableOrderDET.getDBData();
                    ExcelUtil.saveTable(path, list, MyTableOrderDET.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        btn2.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableOrderDET.getDBData();
                    CSVUtil.saveTable(path, list,MyTableOrderDET.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        NorthwindBackOffice.right.add(btn);NorthwindBackOffice.right.add(btn2);
    }
    public void products() {
        removeAll(); NorthwindBackOffice.right.removeAll();
        add(buildPanel(new NewPanel()));
        revalidate();

        JTable table = new JTable(new MyTableProducts());
//        table.setPreferredScrollableViewportSize(new Dimension(500, 70));          todo 可有可無的兩行?
//        table.setFillsViewportHeight(false);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);

        JButton btn = new JButton("下載XLSX檔案");JButton btn2 = new JButton("下載CSV檔案");
        btn.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableProducts.getDBData();
                    ExcelUtil.saveTable(path, list, MyTableProducts.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        btn2.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Object[][] list = MyTableProducts.getDBData();
                    CSVUtil.saveTable(path, list,MyTableProducts.columnNames);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                }catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "存檔失敗");
                }
            }
        });
        NorthwindBackOffice.right.add(btn);NorthwindBackOffice.right.add(btn2);
    }

    private class ButtonRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            button.setText("SHOW"); //$NON-NLS-1$
            return button;
        }
    }
    private class ButtonEditor extends DefaultCellEditor {
        public ButtonEditor() {
            super(new JTextField());
            this.setClickCountToStart(1);
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            JButton button = (JButton)value;
            button.setText("SHOW"); //$NON-NLS-1$
            return button;
        }
    }

    public static JPanel buildPanel(Component c){  //專門刷新panel
        JPanel panel = new NewPanel();
        return panel;
    }
}