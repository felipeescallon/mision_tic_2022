/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.*;
import Controller.ctlPet;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.jfree.chart.plot.PlotOrientation;


/**
 *
 * @author USUARIO
 */
public class frmPet extends javax.swing.JFrame {

    ctlPet ctlPet;
    //LinkedList<clsPet> dogObjectList = new LinkedList<>();
    //LinkedList<clsPet> catObjectList = new LinkedList<>();
 
    LinkedList<clsPet> dogObjectList = new LinkedList<>();//esta es una lista vacia a la cual se le va a ir agregando(.add()) objetos de tipo clsDog
    LinkedList<clsPet> catObjectList = new LinkedList<>();//esta es una lista vacia a la cual se le va a ir agregando(.add()) objetos de tipo clsCat
    //LinkedList<clsPet> petObjectList = new LinkedList<>();//esta es una lista vacia a la cual se le va a ir agregando(.add()) objetos de tipo clsPet

    /**
     * Creates new form frmPet
     */
    
    public frmPet() {
        initComponents();
        this.setLocationRelativeTo(null);//to place the GUI in the center of the screen
        this.ctlPet = new ctlPet();//puente entre vista y controlador
        this.dogObjectList = ctlPet.ListPet("Dog");
        this.FillDogJlist();
        this.catObjectList = ctlPet.ListPet("Cat");
        this.FillCatJlist();
        this.FillJlist();
        this.RefreshReportByHealthStatus();
        this.RefreshDogReport();
        this.RefreshCatReport();
        
    }
    
       private void RefreshReportByHealthStatus() {
        /*
        LinkedList<clsReportByHealthStatus> report = ctlPet.ListPetByHealthStatus();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (clsReportByHealthStatus record : report) {
            dataset.setValue(record.getHealthStatus(), record.getAmountOfPetsByHealthStatus());
        }
        JFreeChart chart = ChartFactory.createPieChart("Pets Classification By health status", dataset, true, true, true);
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        jpReportByHealthStatus.setLayout(new java.awt.BorderLayout());
        jpReportByHealthStatus.add(panel, BorderLayout.CENTER);
        jpReportByHealthStatus.validate();
        JOptionPane.showMessageDialog(this, "The report has been updated");
        */
        LinkedList<clsReportByHealthStatus> report = ctlPet.ListPetByHealthStatus();
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for (clsReportByHealthStatus record : report) {
            dataset.setValue(record.getHealthStatus(), record.getAmountOfPetsByHealthStatus());
        }
        
        JFreeChart chart = ChartFactory.createPieChart3D("Pets Classification By health status", dataset, true, true, true);
        jpReportByHealthStatus.removeAll();//Solo es hacer el removeAll antes de graficar para que se quite lo que hay en la actualidad, y luego cuando se genera la nueva se hace el repaint para repintar la nueva
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        jpReportByHealthStatus.setLayout(new java.awt.BorderLayout());
        jpReportByHealthStatus.add(panel, BorderLayout.CENTER);
        //jpReportByHealthStatus.validate();//ya no es necesaria
        jpReportByHealthStatus.repaint();//Solo es hacer el removeAll antes de graficar para que se quite lo que hay en la actualidad, y luego cuando se genera la nueva se hace el repaint para repintar la nueva
        JOptionPane.showMessageDialog(this, "The report has been updated");
    }
       
    private void RefreshDogReport() {        
        LinkedList<clsReportByHealthStatus> report = ctlPet.ListDogByHealthStatus();
        //DefaultPieDataset dataset = new DefaultPieDataset();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (clsReportByHealthStatus record : report) {
            //dataset.setValue(record.getHealthStatus(), record.getAmountOfPetsByHealthStatus());
            dataset.addValue(record.getAmountOfPetsByHealthStatus(), record.getHealthStatus(), "");
            //dataset.addValue(record.getStock(), record.getName(), "");
        }
        
        //JFreeChart chart = ChartFactory.createPieChart("Dogs Classification By health status", dataset, true, true, true);
        JFreeChart chart = ChartFactory.createBarChart3D("Dogs Classification By health status", "Health Status", "Amount of Dogs", dataset, PlotOrientation.VERTICAL, true, true, true);        
        //JFreeChart chart = ChartFactory.createBarChart3D("Facturacion Ventas", "Productos Vendidos", "Cantidad Vendida", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        jpDogReport.removeAll();//Solo es hacer el removeAll antes de graficar para que se quite lo que hay en la actualidad, y luego cuando se genera la nueva se hace el repaint para repintar la nueva
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        jpDogReport.setLayout(new java.awt.BorderLayout());
        jpDogReport.add(panel, BorderLayout.CENTER);
        //jpReportByHealthStatus.validate();//ya no es necesaria
        //pack();        
        jpDogReport.repaint();//Solo es hacer el removeAll antes de graficar para que se quite lo que hay en la actualidad, y luego cuando se genera la nueva se hace el repaint para repintar la nueva
        JOptionPane.showMessageDialog(this, "The dog report has been updated");
    }
        
   private void RefreshCatReport() {        
        LinkedList<clsReportByHealthStatus> report = ctlPet.ListCatByHealthStatus();
       //DefaultPieDataset dataset = new DefaultPieDataset();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (clsReportByHealthStatus record : report) {
            //dataset.setValue(record.getHealthStatus(), record.getAmountOfPetsByHealthStatus());
            dataset.addValue(record.getAmountOfPetsByHealthStatus(), record.getHealthStatus(), "");
            //dataset.addValue(record.getStock(), record.getName(), "");
        }
        
        //JFreeChart chart = ChartFactory.createPieChart("Dogs Classification By health status", dataset, true, true, true);
        JFreeChart chart = ChartFactory.createBarChart3D("Cats Classification By health status", "Health Status", "Amount Of Cats", dataset, PlotOrientation.HORIZONTAL, true, true, true);        
        //JFreeChart chart = ChartFactory.createBarChart3D("Facturacion Ventas", "Productos Vendidos", "Cantidad Vendida", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        jpCatReport.removeAll();//Solo es hacer el removeAll antes de graficar para que se quite lo que hay en la actualidad, y luego cuando se genera la nueva se hace el repaint para repintar la nueva
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        jpCatReport.setLayout(new java.awt.BorderLayout());
        jpCatReport.add(panel, BorderLayout.CENTER);
        //jpReportByHealthStatus.validate();//ya no es necesaria
        //pack();
        jpCatReport.repaint();//Solo es hacer el removeAll antes de graficar para que se quite lo que hay en la actualidad, y luego cuando se genera la nueva se hace el repaint para repintar la nueva
        JOptionPane.showMessageDialog(this, "The cat report has been updated");
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        petList = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        txtCodeDog = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBornYearDog = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNameDog = new javax.swing.JTextField();
        txtColorDog = new javax.swing.JTextField();
        cbHealthStatusDog = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbBreedDog = new javax.swing.JComboBox<>();
        btnCrearDog = new javax.swing.JButton();
        btnBuscarDog = new javax.swing.JButton();
        btnEditarDog = new javax.swing.JButton();
        btnEliminarDog = new javax.swing.JButton();
        cbPedigree = new javax.swing.JCheckBox();
        txtPetId = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDogId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodeCat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNameCat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBornYearCat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtColorCat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbBreedCat = new javax.swing.JComboBox<>();
        cbHealthStatusCat = new javax.swing.JComboBox<>();
        btnCrearCat = new javax.swing.JButton();
        btnBuscarCat = new javax.swing.JButton();
        btnEditarCat = new javax.swing.JButton();
        btnEliminarCat = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtPetId2 = new javax.swing.JTextField();
        txtCatId = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        dogList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        catList = new javax.swing.JList<>();
        jpReportByHealthStatus = new javax.swing.JTabbedPane();
        jpDogReport = new javax.swing.JTabbedPane();
        jpCatReport = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        btnExportarDogList = new javax.swing.JButton();
        btnExportarCatList = new javax.swing.JButton();
        btnExportarPetList = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        petList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Pet 1", "Pet 2", "Pet 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(petList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Pet List", jPanel1);

        jLabel8.setText("Code");

        jLabel9.setText("Born year");

        jLabel10.setText("Color");

        jLabel11.setText("Name");

        cbHealthStatusDog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sick", "Healthy", "In Surgery" }));

        jLabel12.setText("Helath Status");

        jLabel13.setText("Breed");

        cbBreedDog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Criollo", "Schnauzer", "German shepherd", "Pincher" }));

        btnCrearDog.setText("Save");
        btnCrearDog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearDogActionPerformed(evt);
            }
        });

        btnBuscarDog.setText("Search");
        btnBuscarDog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDogActionPerformed(evt);
            }
        });

        btnEditarDog.setText("Edit");
        btnEditarDog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDogActionPerformed(evt);
            }
        });

        btnEliminarDog.setText("Delete");
        btnEliminarDog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDogActionPerformed(evt);
            }
        });

        cbPedigree.setText("Pedigree");

        txtPetId.setEditable(false);

        jLabel14.setText("petId");

        txtDogId.setEditable(false);

        jLabel15.setText("dogId");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodeDog, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBornYearDog, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtPetId, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbHealthStatusDog, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtColorDog)
                            .addComponent(txtNameDog)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtDogId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbBreedDog, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 474, Short.MAX_VALUE)
                                .addComponent(cbPedigree)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(460, Short.MAX_VALUE)
                .addComponent(btnCrearDog)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarDog)
                .addGap(18, 18, 18)
                .addComponent(btnEditarDog)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarDog)
                .addGap(113, 113, 113))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodeDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtNameDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBornYearDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtColorDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(cbBreedDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHealthStatusDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPedigree))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPetId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtDogId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearDog)
                    .addComponent(btnBuscarDog)
                    .addComponent(btnEditarDog)
                    .addComponent(btnEliminarDog))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dog Manager", jPanel4);

        jLabel2.setText("Code");

        jLabel3.setText("Name");

        jLabel4.setText("Born year");

        jLabel5.setText("Color");

        jLabel6.setText("Helath Status");

        jLabel7.setText("Breed");

        cbBreedCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Birman", "British", "Bombay", "Abyssinian" }));

        cbHealthStatusCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sick", "Healthy", "In Surgery" }));

        btnCrearCat.setText("Save");
        btnCrearCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCatActionPerformed(evt);
            }
        });

        btnBuscarCat.setText("Search");
        btnBuscarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCatActionPerformed(evt);
            }
        });

        btnEditarCat.setText("Edit");
        btnEditarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCatActionPerformed(evt);
            }
        });

        btnEliminarCat.setText("Delete");
        btnEliminarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCatActionPerformed(evt);
            }
        });

        jLabel16.setText("petId2");

        jLabel17.setText("catId");

        txtPetId2.setEditable(false);
        txtPetId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPetId2ActionPerformed(evt);
            }
        });

        txtCatId.setEditable(false);
        txtCatId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCatIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodeCat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBornYearCat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbHealthStatusCat, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPetId2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5))
                    .addComponent(jLabel7)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtColorCat)
                    .addComponent(txtNameCat)
                    .addComponent(cbBreedCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCatId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(469, Short.MAX_VALUE)
                .addComponent(btnCrearCat)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarCat)
                .addGap(18, 18, 18)
                .addComponent(btnEditarCat)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarCat)
                .addGap(104, 104, 104))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodeCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNameCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBornYearCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtColorCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(cbBreedCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHealthStatusCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtPetId2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCatId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearCat)
                    .addComponent(btnBuscarCat)
                    .addComponent(btnEditarCat)
                    .addComponent(btnEliminarCat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cat Manager", jPanel2);

        dogList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Dog 1", "Dog 2", "Dog 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(dogList);
        dogList.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Dog List", jScrollPane3);

        catList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Cat 1", "Cat 2", "Cat 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(catList);

        jTabbedPane1.addTab("Cat List", jScrollPane4);
        jTabbedPane1.addTab("Report By Health Status", jpReportByHealthStatus);
        jTabbedPane1.addTab("Dog Report", jpDogReport);
        jTabbedPane1.addTab("Cat Report", jpCatReport);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Pet Manager");

        btnExportarDogList.setText("Export Dog List");
        btnExportarDogList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarDogListActionPerformed(evt);
            }
        });

        btnExportarCatList.setText("Export Cat List");
        btnExportarCatList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarCatListActionPerformed(evt);
            }
        });

        btnExportarPetList.setText("Export Pet List");
        btnExportarPetList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarPetListActionPerformed(evt);
            }
        });

        btnRestart.setText("Restart");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(329, 329, 329)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnExportarPetList)
                                .addGap(34, 34, 34)
                                .addComponent(btnExportarDogList)
                                .addGap(36, 36, 36)
                                .addComponent(btnExportarCatList)
                                .addGap(33, 33, 33)
                                .addComponent(btnRestart)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportarDogList)
                    .addComponent(btnExportarCatList)
                    .addComponent(btnExportarPetList)
                    .addComponent(btnRestart))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CRUD:
    private void btnCrearDogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearDogActionPerformed
        // JOptionPane.showMessageDialog(this, "Esto es una prueba desde crear perro");
        try {
            String code = txtCodeDog.getText();
            String name = txtNameDog.getText();
            String color = txtColorDog.getText();
            int bornYear = Integer.parseInt(txtBornYearDog.getText());
            String breed = cbBreedDog.getSelectedItem().toString();
            String healthStatus = cbHealthStatusDog.getSelectedItem().toString();
            boolean pedigree = cbPedigree.isSelected();

            if (code.equals("") || name.equals("") || color.equals("")) {
                JOptionPane.showMessageDialog(this, "Fill all fields");
            } else {
                clsDog dog = new clsDog(0, breed, pedigree, 0, code, name, bornYear, color, healthStatus);
                ctlPet.CreatePet(dog);
                //dogObjectList.add(dog);//esto era la lista temporal de la semana3
                this.dogObjectList = ctlPet.ListPet("Dog");
                this.FillDogJlist();
                this.FillJlist();
                this.clearDogFields();
                //this.RefreshReportByHealthStatus();
                JOptionPane.showMessageDialog(this, "The record has been saved");                
                this.RefreshReportByHealthStatus();
                this.RefreshDogReport();
            }
            //frmPet frmpet = new frmPet();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please add a valid born year");
        }
    }//GEN-LAST:event_btnCrearDogActionPerformed

    private void btnBuscarDogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDogActionPerformed
        String code = txtCodeDog.getText();
        clsDog dog = (clsDog) ctlPet.SearchPet(code, "Dog");
        if (dog == null) {
            JOptionPane.showMessageDialog(this, "Code not found");
        } else {
            txtPetId.setText(dog.getPetId() + "");
            txtDogId.setText(dog.getDogId() + "");
            txtNameDog.setText(dog.getName());
            txtColorDog.setText(dog.getColor());
            txtBornYearDog.setText(dog.getBorn_year() + "");
            cbHealthStatusDog.setSelectedItem(dog.getHealth_status());
            cbBreedDog.setSelectedItem(dog.getBreed());
            cbPedigree.setSelected(dog.isPedigree());
        }
    }//GEN-LAST:event_btnBuscarDogActionPerformed

    private void btnEditarDogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDogActionPerformed
        String petId = txtPetId.getText();
        String dogId = txtDogId.getText();
        if (petId.equals("") || dogId.equals("")) {
            JOptionPane.showMessageDialog(this, "You have not searched a dog yet");
        } else {
        
        try {
        String code = txtCodeDog.getText();
        String name = txtNameDog.getText();
        String color = txtColorDog.getText();
        int bornYear = Integer.parseInt(txtBornYearDog.getText());
        String breed = cbBreedDog.getSelectedItem().toString();
        String healthStatus = cbHealthStatusDog.getSelectedItem().toString();
        boolean pedigree = cbPedigree.isSelected();
        
            int petIdInt = Integer.parseInt(petId);
            int dogIdInt = Integer.parseInt(dogId);
            clsDog dog = new clsDog(dogIdInt, breed, pedigree, petIdInt, code, name, bornYear, color, healthStatus);
            boolean response = ctlPet.EditPet(dog);
            if(response){
                //this.clearDogFields();
                this.FillDogJlist();
                this.FillJlist();                
                this.clearDogFields();
                //this.RefreshReportByHealthStatus();
                JOptionPane.showMessageDialog(this, "Record updated");
                this.RefreshReportByHealthStatus();
                this.RefreshDogReport();
            }else{
                JOptionPane.showMessageDialog(this, "Error updating the record");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "You have to search the record to update");
        }
      }  
    }//GEN-LAST:event_btnEditarDogActionPerformed

    private void btnEliminarDogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDogActionPerformed
                
        String petId = txtPetId.getText();
        String dogId = txtDogId.getText();
        if (petId.equals("") || dogId.equals("")) {
            JOptionPane.showMessageDialog(this, "You have not searched a dog yet");
        } else {
            try {
                int petIdInt = Integer.parseInt(petId);
                int dogIdInt = Integer.parseInt(dogId);
                clsDog dog = new clsDog(petIdInt, dogIdInt);
                boolean removed = ctlPet.DeletePet(dog);
                if (removed) {
                    this.dogObjectList = ctlPet.ListPet("Dog");
                    this.FillDogJlist();
                    this.FillJlist();
                    this.clearDogFields();
                    //this.RefreshReportByHealthStatus();
                    JOptionPane.showMessageDialog(this, "The dog has been deleted (removed) successfuly!");
                    this.RefreshReportByHealthStatus();
                    this.RefreshDogReport();
                } else {
                    JOptionPane.showMessageDialog(this, "An error has occurred during the dog deletion.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Please, search a dog (by code) that you want to delete and try again...");
            }
        }                                
        
    }//GEN-LAST:event_btnEliminarDogActionPerformed

    private void btnEliminarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCatActionPerformed
        String petId = txtPetId2.getText();
        String catId = txtCatId.getText();
        if (petId.equals("") || catId.equals("")) {
            JOptionPane.showMessageDialog(this, "You have not searched a cat yet");
        } else {
            try {
                int petIdInt = Integer.parseInt(petId);
                int catIdInt = Integer.parseInt(catId);
                clsCat cat = new clsCat(petIdInt, catIdInt);
                boolean removed = ctlPet.DeletePet(cat);
                if (removed) {
                    this.catObjectList = ctlPet.ListPet("Cat");
                    this.FillCatJlist();
                    this.FillJlist();
                    this.clearCatFields();
                    //this.RefreshReportByHealthStatus();
                    JOptionPane.showMessageDialog(this, "The cat has been deleted (removed) successfuly!");
                    this.RefreshReportByHealthStatus();
                    this.RefreshCatReport();
                } else {
                    JOptionPane.showMessageDialog(this, "An error has occurred during the cat deletion.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Please, search a cat (by code) that you want to delete and try again...");
            }
        }
    }//GEN-LAST:event_btnEliminarCatActionPerformed

    private void btnEditarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCatActionPerformed
        // TODO add your handling code here:
        String code = txtCodeCat.getText();
        String name = txtNameCat.getText();
        String color = txtColorCat.getText();
        int bornYear = Integer.parseInt(txtBornYearCat.getText());
        String breed = cbBreedCat.getSelectedItem().toString();
        String healthStatus = cbHealthStatusCat.getSelectedItem().toString();

        try {
            int petId = Integer.parseInt(txtPetId2.getText());
            int catId = Integer.parseInt(txtCatId.getText());
            clsCat cat = new clsCat(catId, breed, petId, code, name, bornYear, color, healthStatus);
            boolean response = ctlPet.EditPet(cat);
            if(response){
                //this.clearCatFields();
                this.FillCatJlist();
                this.FillJlist();                
                this.clearCatFields();
                //this.RefreshReportByHealthStatus();
                JOptionPane.showMessageDialog(this, "Record updated");
                this.RefreshReportByHealthStatus();
                this.RefreshCatReport();
            }else{
                JOptionPane.showMessageDialog(this, "Error updating the record");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "You have to search the record to update");
        }
    }//GEN-LAST:event_btnEditarCatActionPerformed

    private void btnBuscarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCatActionPerformed
        // TODO add your handling code here:
        String code = txtCodeCat.getText();
        clsCat cat = (clsCat) ctlPet.SearchPet(code, "Cat");
        if (cat == null) {
            JOptionPane.showMessageDialog(this, "Code not found");
        } else {            
            txtPetId2.setText(cat.getPetId() + "");
            txtCatId.setText(cat.getCatId() + "");
            txtNameCat.setText(cat.getName());
            txtColorCat.setText(cat.getColor());
            txtBornYearCat.setText(cat.getBorn_year() + "");
            cbHealthStatusCat.setSelectedItem(cat.getHealth_status());
            cbBreedCat.setSelectedItem(cat.getBreed());
        }
    }//GEN-LAST:event_btnBuscarCatActionPerformed

    private void btnCrearCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCatActionPerformed
        // TODO add your handling code here:
        try {
            String code = txtCodeCat.getText();
            String name = txtNameCat.getText();
            String color = txtColorCat.getText();
            int bornYear = Integer.parseInt(txtBornYearCat.getText());
            String breed = cbBreedCat.getSelectedItem().toString();
            String healthStatus = cbHealthStatusCat.getSelectedItem().toString();

            if (code.equals("") || name.equals("") || color.equals("")) {
                JOptionPane.showMessageDialog(this, "Fill all fields");
            } else {
                clsCat cat = new clsCat(0, breed, 0, code, name, bornYear, color, healthStatus);
                ctlPet.CreatePet(cat);
                //catObjectList.add(cat);
                this.catObjectList = ctlPet.ListPet("Cat");
                this.FillCatJlist();
                this.FillJlist();                
                this.clearCatFields();
                //this.RefreshReportByHealthStatus();
                JOptionPane.showMessageDialog(this, "The record has been saved");
                this.RefreshReportByHealthStatus();
                this.RefreshCatReport();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please add a valid born year");
        }
    }//GEN-LAST:event_btnCrearCatActionPerformed

    private void txtCatIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCatIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCatIdActionPerformed

    private void txtPetId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPetId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPetId2ActionPerformed

    private void btnExportarPetListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPetListActionPerformed
        // TODO add your handling code here:
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        //book.setSheetName(0, "Dogs");
        //book.setSheetName(0, "Cats");
        book.setSheetName(0, "Pets");

        String[] headers = new String[]{
            "AnimalType",//mascota(Dog/Cat)
            "Code",//mascota
            "Name",//mascota
            "Color",//mascota
            "Health Status",//mascota
            "Breed",//común para gato y perro
            "Pedigree" //solo para perros
        };

        CellStyle headerCellStyle = book.createCellStyle();
        HSSFFont font = book.createFont();
        font.setBold(true);
        headerCellStyle.setFont(font);

        HSSFRow headersRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];
            HSSFCell cell = headersRow.createCell(i);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(header);
        }
        
        int index_dog = 0;

        for (int i = 0; i < dogObjectList.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            String animalType = dogObjectList.get(i).getAnimalType();
            String code = dogObjectList.get(i).getCode();
            String name = dogObjectList.get(i).getName();
            String color = dogObjectList.get(i).getColor();
            String healthStatus = dogObjectList.get(i).getHealth_status();
            String breed = ((clsDog) dogObjectList.get(i)).getBreed();            
            boolean pedigree = ((clsDog) dogObjectList.get(i)).isPedigree();
            String pedigreeString = pedigree ? "Yes" : "No";
            
            row.createCell(0).setCellValue(animalType);
            row.createCell(1).setCellValue(code);
            row.createCell(2).setCellValue(name);
            row.createCell(3).setCellValue(color);
            row.createCell(4).setCellValue(healthStatus);
            row.createCell(5).setCellValue(breed);
            row.createCell(6).setCellValue(pedigreeString);
            index_dog++;
        }
        int index_cat = index_dog;
        
          for (int i = 0; i < catObjectList.size(); i++) {
            HSSFRow row = sheet.createRow(i + index_cat + 1);
            String animalType = catObjectList.get(i).getAnimalType();
            String code = catObjectList.get(i).getCode();
            String name = catObjectList.get(i).getName();
            String color = catObjectList.get(i).getColor();
            String healthStatus = catObjectList.get(i).getHealth_status();
            String breed = ((clsCat) catObjectList.get(i)).getBreed();            
            
            //String animalType = catObjectList.get(i).getAnimalType();
            row.createCell(0).setCellValue(animalType);
            row.createCell(1).setCellValue(code);
            row.createCell(2).setCellValue(name);
            row.createCell(3).setCellValue(color);
            row.createCell(4).setCellValue(healthStatus);
            row.createCell(5).setCellValue(breed);
            //row.createCell(4).setCellValue(pedigreeString);
        }
          
        try {
            //FileOutputStream file = new FileOutputStream("pet_list_report.xls");
            //FileOutputStream file = new FileOutputStream("dog_list_report.xls");
            //FileOutputStream file = new FileOutputStream("cat_list_report.xls");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd HH-mm-ss");
            FileOutputStream file = new FileOutputStream("pet_list_report_date_"+dtf.format(LocalDateTime.now()).toString()+"-time.xls");
            book.write(file);
            file.close();
            JOptionPane.showMessageDialog(this, "The file has been exported successfully");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmPet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmPet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarPetListActionPerformed

    private void btnExportarDogListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarDogListActionPerformed
        // TODO add your handling code here:
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        book.setSheetName(0, "Dogs");
        //book.setSheetName(0, "Cats");
        //book.setSheetName(0, "Pets");

        String[] headers = new String[]{
            "AnimalType",//mascota(Dog/Cat)
            "Code",//mascota
            "Name",//mascota
            "Color",//mascota
            "Health Status",//mascota
            "Breed",//común para gato y perro
            "Pedigree" //solo para perros
        };

        CellStyle headerCellStyle = book.createCellStyle();
        HSSFFont font = book.createFont();
        font.setBold(true);
        headerCellStyle.setFont(font);

        HSSFRow headersRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];
            HSSFCell cell = headersRow.createCell(i);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(header);
        }
        
        //int index_dog = 0;

        for (int i = 0; i < dogObjectList.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            String animalType = dogObjectList.get(i).getAnimalType();
            String code = dogObjectList.get(i).getCode();
            String name = dogObjectList.get(i).getName();
            String color = dogObjectList.get(i).getColor();
            String healthStatus = dogObjectList.get(i).getHealth_status();
            String breed = ((clsDog) dogObjectList.get(i)).getBreed();            
            boolean pedigree = ((clsDog) dogObjectList.get(i)).isPedigree();
            String pedigreeString = pedigree ? "Yes" : "No";
            
            row.createCell(0).setCellValue(animalType);
            row.createCell(1).setCellValue(code);
            row.createCell(2).setCellValue(name);
            row.createCell(3).setCellValue(color);
            row.createCell(4).setCellValue(healthStatus);
            row.createCell(5).setCellValue(breed);
            row.createCell(6).setCellValue(pedigreeString);
            //index_dog++;
        }
        /*
        int index_cat = index_dog;
        
          for (int i = 0; i < catObjectList.size(); i++) {
            HSSFRow row = sheet.createRow(i + index_cat + 1);
            String code = catObjectList.get(i).getCode();
            String name = catObjectList.get(i).getName();
            String color = catObjectList.get(i).getColor();
            String healthStatus = catObjectList.get(i).getHealth_status();
            String breed = ((clsCat) catObjectList.get(i)).getBreed();            
            
            row.createCell(0).setCellValue(code);
            row.createCell(1).setCellValue(name);
            row.createCell(2).setCellValue(color);
            row.createCell(3).setCellValue(healthStatus);
            row.createCell(4).setCellValue(breed);
            //row.createCell(4).setCellValue(pedigreeString);
        }
        */
          
        try {
            //FileOutputStream file = new FileOutputStream("pet_list_report.xls");
            //FileOutputStream file = new FileOutputStream("dog_list_report.xls");
            //FileOutputStream file = new FileOutputStream("cat_list_report.xls");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd HH-mm-ss");
            FileOutputStream file = new FileOutputStream("dog_list_report_date_"+dtf.format(LocalDateTime.now()).toString()+"-time.xls");
            book.write(file);
            file.close();
            JOptionPane.showMessageDialog(this, "The file has been exported successfully");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmPet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmPet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarDogListActionPerformed

    private void btnExportarCatListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarCatListActionPerformed
        // TODO add your handling code here:
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        //book.setSheetName(0, "Dogs");
        book.setSheetName(0, "Cats");
        //book.setSheetName(0, "Pets");

        String[] headers = new String[]{
            "AnimalType",//mascota(Dog/Cat)
            "Code",//mascota
            "Name",//mascota
            "Color",//mascota
            "Health Status",//mascota
            "Breed",//común para gato y perro
            //"Pedigree" //solo para perros
        };

        CellStyle headerCellStyle = book.createCellStyle();
        HSSFFont font = book.createFont();
        font.setBold(true);
        headerCellStyle.setFont(font);

        HSSFRow headersRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];
            HSSFCell cell = headersRow.createCell(i);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(header);
        }
        /*
        int index_dog = 0;

        for (int i = 0; i < dogObjectList.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            String code = dogObjectList.get(i).getCode();
            String name = dogObjectList.get(i).getName();
            String color = dogObjectList.get(i).getColor();
            String healthStatus = dogObjectList.get(i).getHealth_status();
            String breed = ((clsDog) dogObjectList.get(i)).getBreed();            
            //boolean pedigree = ((clsDog) dogObjectList.get(i)).isPedigree();
            //String pedigreeString = pedigree ? "SI" : "NO";
            row.createCell(0).setCellValue(code);
            row.createCell(1).setCellValue(name);
            row.createCell(2).setCellValue(color);
            row.createCell(3).setCellValue(healthStatus);
            row.createCell(4).setCellValue(breed);
            //row.createCell(4).setCellValue(pedigreeString);
            index_dog++;
        }
        */
        //int index_cat = index_dog;        
        
          for (int i = 0; i < catObjectList.size(); i++) {
            //HSSFRow row = sheet.createRow(i + index_cat + 1);
            HSSFRow row = sheet.createRow(i + 1);
            String animalType = catObjectList.get(i).getAnimalType();
            String code = catObjectList.get(i).getCode();
            String name = catObjectList.get(i).getName();
            String color = catObjectList.get(i).getColor();
            String healthStatus = catObjectList.get(i).getHealth_status();
            String breed = ((clsCat) catObjectList.get(i)).getBreed();            
            
            
            row.createCell(0).setCellValue(animalType);
            row.createCell(1).setCellValue(code);
            row.createCell(2).setCellValue(name);
            row.createCell(3).setCellValue(color);
            row.createCell(4).setCellValue(healthStatus);
            row.createCell(5).setCellValue(breed);
            //row.createCell(4).setCellValue(pedigreeString);
        }
          
        try {
            //FileOutputStream file = new FileOutputStream("pet_list_report.xls");
            //FileOutputStream file = new FileOutputStream("dog_list_report.xls");            
            //FileOutputStream file = new FileOutputStream("cat_list_report.xls");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd HH-mm-ss");
            FileOutputStream file = new FileOutputStream("cat_list_report_date_"+dtf.format(LocalDateTime.now()).toString()+"-time.xls");
            book.write(file);
            file.close();
            JOptionPane.showMessageDialog(this, "The file has been exported successfully");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmPet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmPet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarCatListActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // TODO add your handling code here:
        frmPet frmPet = new frmPet();//para volver a llamar al mismo formulario en lugar de estar cerrándolo y volviéndolo a abrir! (se podría apuntar a otro formulario también)
        this.setVisible(false);
        frmPet.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRestartActionPerformed

    private void clearDogFields() {
        txtCodeDog.setText("");
        txtNameDog.setText("");
        txtColorDog.setText("");
        txtBornYearDog.setText("");
        txtPetId.setText("");
        txtDogId.setText("");
        cbBreedDog.setSelectedIndex(0);
        cbHealthStatusDog.setSelectedIndex(0);
        cbPedigree.setSelected(false);
    }

    private void clearCatFields() {
        txtCodeCat.setText("");
        txtNameCat.setText("");
        txtColorCat.setText("");
        txtBornYearCat.setText("");
        txtPetId2.setText("");
        txtCatId.setText("");
        cbBreedCat.setSelectedIndex(0);
        cbHealthStatusCat.setSelectedIndex(0);
    }
   
          

    private void FillJlist() {
        DefaultListModel model = new DefaultListModel();
        int index = 0;
        for (clsPet dog : dogObjectList) {
            String data = dog.getName() + " - " +dog.getCode() + " - " +dog.getAnimalType();
            model.add(index, data);
            index++;
        }
        int index2=index;
        for (clsPet cat : catObjectList) {
            String data = cat.getName() + " - " +cat.getCode() + " - " +cat.getAnimalType();
            model.add(index, data);
            index2++;
        }
        
        petList.setModel(model);
    }
    
    private void FillDogJlist() {
        DefaultListModel model = new DefaultListModel();
        int index = 0;
        for (clsPet dog : dogObjectList) {
            String data = dog.getName() + " - " +dog.getCode() + " - " +dog.getAnimalType();
            model.add(index, data);
            index++;
        }
        dogList.setModel(model);
    }
    
    private void FillCatJlist() {
        DefaultListModel model = new DefaultListModel();
        int index = 0;
        for (clsPet cat : catObjectList) {
            String data = cat.getName() + " - " +cat.getCode() + " - " +cat.getAnimalType();
            model.add(index, data);
            index++;
        }
        catList.setModel(model);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCat;
    private javax.swing.JButton btnBuscarDog;
    private javax.swing.JButton btnCrearCat;
    private javax.swing.JButton btnCrearDog;
    private javax.swing.JButton btnEditarCat;
    private javax.swing.JButton btnEditarDog;
    private javax.swing.JButton btnEliminarCat;
    private javax.swing.JButton btnEliminarDog;
    private javax.swing.JButton btnExportarCatList;
    private javax.swing.JButton btnExportarDogList;
    private javax.swing.JButton btnExportarPetList;
    private javax.swing.JButton btnRestart;
    private javax.swing.JList<String> catList;
    private javax.swing.JComboBox<String> cbBreedCat;
    private javax.swing.JComboBox<String> cbBreedDog;
    private javax.swing.JComboBox<String> cbHealthStatusCat;
    private javax.swing.JComboBox<String> cbHealthStatusDog;
    private javax.swing.JCheckBox cbPedigree;
    private javax.swing.JList<String> dogList;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jpCatReport;
    private javax.swing.JTabbedPane jpDogReport;
    private javax.swing.JTabbedPane jpReportByHealthStatus;
    private javax.swing.JList<String> petList;
    private javax.swing.JTextField txtBornYearCat;
    private javax.swing.JTextField txtBornYearDog;
    private javax.swing.JTextField txtCatId;
    private javax.swing.JTextField txtCodeCat;
    private javax.swing.JTextField txtCodeDog;
    private javax.swing.JTextField txtColorCat;
    private javax.swing.JTextField txtColorDog;
    private javax.swing.JTextField txtDogId;
    private javax.swing.JTextField txtNameCat;
    private javax.swing.JTextField txtNameDog;
    private javax.swing.JTextField txtPetId;
    private javax.swing.JTextField txtPetId2;
    // End of variables declaration//GEN-END:variables
}
