package edu.ske13.ui.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static javax.swing.SwingUtilities.invokeLater;

public class MainView extends JFrame {
    private static MainView view = null;
    
    private JTextField ip1;
    private JTextField ip2;
    private JLabel dot1;
    private JTextField ip3;
    private JLabel dot2;
    private JTextField ip4;
    private JLabel SH_text;
    private JTextField sh;
    private JTable table;
    private JTable table_1;
    private JTable table_2;
    
    
    public MainView() {
        initialize();
    }
    
    public static MainView getView() {
        if (view == null) view = new MainView();
        return view;
    }
    
    public static Dimension getPageSize() {
        return MainView.getView().getSize();
    }
    
    void setText() {
        System.out.println("set");
    }
    
    private void compile(Point point) {
        // FIXME: layout should not fix size [1]
        // pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        if (point != null) setLocation(point);
        System.out.println(getLocation());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void run(Point point) {
        invokeLater(() -> MainView.getView().compile(point));
    }
    
    private void setTable() {
        
    }
    
    /**
     * Initialize the contents of the
     */
    private void initialize() {
        setLayout(null);
        // FIXME: layout should not fix size [2]
        setSize(500, 300);
        
        JLabel lblIp = new JLabel("IP: ");
        lblIp.setBounds(35, 28, 46, 14);
        getContentPane().add(lblIp);
        
        ip1 = new JTextField();
        ip1.setBounds(91, 25, 53, 20);
        getContentPane().add(ip1);
        ip1.setColumns(10);
        
        JLabel label = new JLabel(".");
        label.setBounds(154, 28, 11, 14);
        getContentPane().add(label);
        
        ip2 = new JTextField();
        ip2.setColumns(10);
        ip2.setBounds(164, 25, 53, 20);
        getContentPane().add(ip2);
        
        dot1 = new JLabel(".");
        dot1.setBounds(224, 28, 11, 14);
        getContentPane().add(dot1);
        
        ip3 = new JTextField();
        ip3.setColumns(10);
        ip3.setBounds(237, 25, 53, 20);
        getContentPane().add(ip3);
        
        dot2 = new JLabel(".");
        dot2.setBounds(300, 28, 11, 14);
        getContentPane().add(dot2);
        
        ip4 = new JTextField();
        ip4.setColumns(10);
        ip4.setBounds(310, 25, 53, 20);
        getContentPane().add(ip4);
        
        SH_text = new JLabel("Subnet/Host: ");
        SH_text.setBounds(10, 76, 81, 14);
        getContentPane().add(SH_text);
        
        sh = new JTextField();
        sh.setBounds(92, 73, 271, 20);
        getContentPane().add(sh);
        sh.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 101, 427, 149);
        getContentPane().add(scrollPane);
        
        table_2 = new JTable();
        table_2.setModel(new DefaultTableModel(new Object[][]{
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
        scrollPane.setViewportView(table_2);
    }
}
