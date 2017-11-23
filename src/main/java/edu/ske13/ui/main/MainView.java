package edu.ske13.ui.main;

import edu.ske13.annotations.Nullable;
import edu.ske13.exception.NotImplementedException;
import edu.ske13.utils.ui.Display;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static javax.swing.SwingUtilities.invokeLater;

public class MainView extends JFrame {
    private static MainView view = null;
    
    private JTextField ip1;
    private JTextField ip2;
    private JTextField ip3;
    private JTextField ip4;
    private JTextField sh;
    private JTable table;
    
    private String ip;
    private int sh_number;
    
    
    public MainView() {
        initialize();
    }
    
    private void compile(Point point) {
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        if (point != null) setLocation(point);
        else setLocation(Display.getDefaultPoint);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    static MainView getView() {
        if (view == null) view = new MainView();
        return view;
    }
    
    static Dimension getPageSize() {
        return MainView.getView().getSize();
    }
    
    /**
     * run this view with given point, or default if point is null
     *
     * @param point
     *         given {@link Point} to show, or {@link edu.ske13.utils.ui.Display#getDefaultPoint} if point is {@code null}
     */
    static void run(@Nullable Point point) {
        invokeLater(() -> MainView.getView().compile(point));
    }
    
    /**
     * run this view in center of screen
     */
    static void run() {
        invokeLater(() -> MainView.getView().compile(Display.getCenterLocation(MainView.getPageSize())));
    }
    
    /**
     * close current view, only
     */
    static void end() {
        MainView.getView().dispose();
    }
    
    /**
     * exit the program
     */
    static void exit() {
        System.exit(0);
    }
    
    /**************** controller usage method ****************/
    
    String getIP() {
        String value = ip1.getText();
        String value2 = ip2.getText();
        String value3 = ip3.getText();
        String value4 = ip4.getText();
        this.ip = String.format("%s.%s.%s.%s", value, value2, value3, value4);
        return ip;
    }
    
    Integer getHostOrSubnetNumber() {
        String value = sh.getText();
        this.sh_number = Integer.parseInt(value);
        return sh_number;
    }
    
    void setIP(String ip) {
        this.ip = ip;
    }
    
    void setHostOrSubnetNumber(Integer number) {
        this.sh_number = number;
    }
    
    void appendTable(String[][] data) {
        // row number 0 contains texts(which are header of each column)
        for (int i = 1; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt(data[i - 1][j], i, j);
            }
        }
    }
    
    void clearTable() {
        for (int i = 1; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("", i, j);
            }
        }
    }
    
    /* *************** ui helper / validation *************** */
    
    private boolean checkIP() {
        throw new NotImplementedException();
    }
    
    private void nextIPInput() {
        throw new NotImplementedException();
    }
    
    /**
     * Initialize the contents of the
     */
    private void initialize() {
        
        // this.setBounds(200, 200, 550, 550);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(400, 350));
        this.getContentPane().setLayout(new GridLayout());
        
        Container containerMain = new Container();
        BoxLayout layout = new BoxLayout(containerMain, BoxLayout.Y_AXIS);
        containerMain.setLayout(layout);
        this.getContentPane().add(containerMain);
        
        Container containerA = new Container();
        containerMain.add(containerA);
        FlowLayout layout1 = new FlowLayout();
        containerA.setLayout(layout1);
        
        Container containerB = new Container();
        containerMain.add(containerB);
        FlowLayout layout2 = new FlowLayout();
        containerB.setLayout(layout2);
        
        Container containerC = new Container();
        containerMain.add(containerC);
        FlowLayout layout3 = new FlowLayout();
        containerC.setLayout(layout3);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{
                {"Subnet", "Subnet ID", "1st Add", "Last Add", "Broadcast"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
        }, new String[]{
                "Subnet", "Subnet ID", "1st Add", "Last Add", "Broadcast"
        }));
        containerC.add(table);
        
        JLabel lblIp = new JLabel("IP: ");
        lblIp.setBounds(35, 28, 46, 14);
        containerA.add(lblIp);
        
        ip1 = new JTextField();
        ip1.setBounds(91, 25, 53, 20);
        containerA.add(ip1);
        ip1.setColumns(10);
        
        JLabel label = new JLabel(".");
        label.setBounds(154, 28, 11, 14);
        containerA.add(label);
        
        ip2 = new JTextField();
        ip2.setColumns(10);
        ip2.setBounds(164, 25, 53, 20);
        containerA.add(ip2);
        
        JLabel dot1 = new JLabel(".");
        dot1.setBounds(224, 28, 11, 14);
        containerA.add(dot1);
        
        ip3 = new JTextField();
        ip3.setColumns(10);
        ip3.setBounds(237, 25, 53, 20);
        containerA.add(ip3);
        
        JLabel dot2 = new JLabel(".");
        dot2.setBounds(300, 28, 11, 14);
        containerA.add(dot2);
        
        ip4 = new JTextField();
        ip4.setColumns(10);
        ip4.setBounds(310, 25, 53, 20);
        containerA.add(ip4);
        
        
        JLabel SH_text = new JLabel("Subnet/Host: ");
        SH_text.setBounds(10, 76, 81, 14);
        containerB.add(SH_text);
        
        sh = new JTextField();
        sh.setBounds(92, 73, 271, 20);
        containerB.add(sh);
        sh.setColumns(10);
    }
}
