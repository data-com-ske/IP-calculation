package edu.ske13.ui.main;

import edu.ske13.annotations.Nullable;
import edu.ske13.exception.Error;
import edu.ske13.exception.IPException;
import edu.ske13.exception.NotImplementedException;
import edu.ske13.utils.ui.Display;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

import static javax.swing.SwingUtilities.invokeLater;

public class MainView extends JFrame {
    private static MainView view = null;
    
    public enum InputType {
        SUBNET,
        HOST;
        
        public static InputType other(InputType t) {
            switch (t) {
                case HOST:
                    return SUBNET;
                case SUBNET:
                    return HOST;
            }
            return null;
        }
        
        @Override
        public String toString() {
            return name().toLowerCase(Locale.ENGLISH);
        }
    }
    
    private JTextField ip1;
    private JTextField ip2;
    private JTextField ip3;
    private JTextField ip4;
    private JTextField sh;
    
    private DefaultTableModel tm;
    private JTable table;
    
    private JComboBox<InputType> comboBox;
    
    private JButton enterBtn;
    
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
    
    void addEnterButtonListener(ActionListener a) {
        enterBtn.addActionListener(a);
    }
    
    InputType getInputType() {
        return (InputType) comboBox.getSelectedItem();
    }
    
    String getIP() {
        String value = ip1.getText();
        String value2 = ip2.getText();
        String value3 = ip3.getText();
        String value4 = ip4.getText();
        this.ip = String.format("%s.%s.%s.%s", value, value2, value3, value4);
        return ip;
    }
    
    Integer getHostOrSubnetNumber() throws IPException {
        String value = sh.getText();
        if (value.equals("")) return 0;
        try {
            this.sh_number = Integer.parseInt(value);
            
        } catch (NumberFormatException e) {
            throw new IPException(Error.InvalidInput, e);
        }
        return sh_number;
    }
    
    void setIP(String ip) {
        this.ip = ip;
    }
    
    void setHostOrSubnetNumber(Integer number) {
        this.sh_number = number;
    }
    
    void appendAll(ArrayList<ArrayList<String>> data) {
        // row number 0 contains texts(which are header of each column)
        for (ArrayList<String> aData : data) {
            tm.addRow(aData.toArray());
        }
    }
    
    void appendTable(String subnetID, String firstIP, String lastIP, String broadcast) {
        tm.addRow(new String[]{String.valueOf(tm.getRowCount()), subnetID, firstIP, lastIP, broadcast});
    }
    
    void clearTable() {
        int rowCount = tm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tm.removeRow(i);
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
        tm = new DefaultTableModel(new Object[]{
                "Subnet", "Subnet ID", "1st Add", "Last Add", "Broadcast"
        }, 0);
        table.setModel(tm);
        containerC.add(new JScrollPane(table));
        
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
        
        JLabel SH_text = new JLabel("Type: ");
        containerB.add(SH_text);
        
        comboBox = new JComboBox<>(InputType.values());
        containerB.add(comboBox);
        
        sh = new JTextField();
        sh.setBounds(92, 73, 271, 20);
        containerB.add(sh);
        sh.setColumns(10);
        
        enterBtn = new JButton("Enter!!");
        containerB.add(enterBtn);
    }
}
