/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromastat18;

import com.pi4j.gpio.extension.mcp.MCP23017GpioProvider;
import com.pi4j.gpio.extension.mcp.MCP23017Pin;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * UI Class of Chromastat 18
 * @author WilliamKwok
 */
public class Chromastat18UI extends javax.swing.JFrame implements ActionListener {
    // Set up a timer for refreshing the graphics
    private final Timer timer = new Timer(16, this); // 16 in ms
    private int count = 0;
    
//    /* Uncomment/comment this portion for ACTUAL DEVICE */
    private RgbSensor colorRead;
    private LuxSensor luxSensor;
    private final MCP mcpProviderTwo;
      private PumpController pc = new PumpController();
      private boolean bubblerOn = false;
      private boolean laserOn = false;
      private GpioPinDigitalOutput bubbler;
      private GpioPinDigitalOutput laser;
      private int goalRed = -1;
      private int goalGreen = -1;
      private int goalBlue = -1;
      
    
    
    // Uncomment/comment this portion for TESTING
//    private DummyRgb colorRead = new DummyRgb();
//    private DummyLux luxSensor = new DummyLux();
//    private ArrayList<DummyPump> pumps = new ArrayList<>();
//    private DummyPumpController dpc = new DummyPumpController();
    ArrayList<JProgressBar> pumpBars = new ArrayList<>();
    ArrayList<JButton> pumpMinus = new ArrayList<>();
    ArrayList<JButton> pumpPlus = new ArrayList<>();
            
    /**
     * Creates the new GUI, and also invokes the timer to start refreshing.
     */
    public Chromastat18UI() throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        initComponents();
        
//        /* Uncomment/comment this portion for ACTUAL DEVICE */
        this.colorRead = new RgbSensor();
        this.luxSensor = new LuxSensor((byte)0x39);
        this.mcpProviderTwo = new MCP(0x21);
//        this.initPumps();
        this.initPumps();
        
        this.bubbler = this.mcpProviderTwo.output(MCP23017Pin.GPIO_B0, PinState.HIGH);
        this.laser = this.mcpProviderTwo.output(MCP23017Pin.GPIO_B1, PinState.HIGH);
        
        
        
        
        timer.start();
        pumpBars.add(pump1Bar);
        pumpBars.add(pump2Bar);
        pumpBars.add(pump3Bar);
        pumpMinus.add(pump1minus);
        pumpMinus.add(pump2minus);
        pumpMinus.add(pump3minus);
        pumpPlus.add(pump1plus);
        pumpPlus.add(pump2plus);
        pumpPlus.add(pump3plus);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jColorChooser1 = new javax.swing.JColorChooser();
        text1 = new javax.swing.JTextField();
        colorPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        huePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        colorStringLabel = new javax.swing.JLabel();
        pump1Bar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        pump2Bar = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        pump3Bar = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        calibrationButton = new javax.swing.JButton();
        pump1plus = new javax.swing.JButton();
        pump2plus = new javax.swing.JButton();
        pump3plus = new javax.swing.JButton();
        pump1minus = new javax.swing.JButton();
        pump2minus = new javax.swing.JButton();
        pump3minus = new javax.swing.JButton();
        whitePoint = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        redPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        yellowPanel = new javax.swing.JPanel();
        greenPanel = new javax.swing.JPanel();
        bluePanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jProgressBar2.setForeground(new java.awt.Color(51, 51, 255));
        jProgressBar2.setValue(50);

        jLabel5.setText("Pump 1");

        jProgressBar4.setForeground(new java.awt.Color(51, 51, 255));
        jProgressBar4.setValue(50);

        jLabel7.setText("Pump 2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text1.setText("0");

        colorPanel.setBackground(new java.awt.Color(0, 0, 0));
        colorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        colorPanel.setToolTipText("");

        javax.swing.GroupLayout colorPanelLayout = new javax.swing.GroupLayout(colorPanel);
        colorPanel.setLayout(colorPanelLayout);
        colorPanelLayout.setHorizontalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        colorPanelLayout.setVerticalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jLabel1.setText("Color");

        huePanel.setBackground(new java.awt.Color(0, 0, 0));
        huePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        huePanel.setToolTipText("");

        javax.swing.GroupLayout huePanelLayout = new javax.swing.GroupLayout(huePanel);
        huePanel.setLayout(huePanelLayout);
        huePanelLayout.setHorizontalGroup(
            huePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        huePanelLayout.setVerticalGroup(
            huePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jLabel2.setText("Hue");

        colorStringLabel.setText("colorstring");

        pump1Bar.setForeground(new java.awt.Color(51, 51, 255));
        pump1Bar.setMaximum(1000);
        pump1Bar.setValue(500);
        pump1Bar.setAlignmentY(0.0F);

        jLabel4.setText("Pump 1");

        pump2Bar.setForeground(new java.awt.Color(51, 51, 255));
        pump2Bar.setMaximum(1000);
        pump2Bar.setValue(500);

        jLabel6.setText("Pump 2");

        pump3Bar.setForeground(new java.awt.Color(51, 51, 255));
        pump3Bar.setMaximum(1000);
        pump3Bar.setValue(500);

        jLabel8.setText("Pump 3");

        calibrationButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        calibrationButton.setText("Calibrate pumps");
        calibrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calibratePump(evt);
            }
        });

        pump1plus.setText("+");
        pump1plus.setAlignmentY(0.0F);
        pump1plus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pump1plusMouseClicked(evt);
            }
        });

        pump2plus.setText("+");
        pump2plus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pump2plusMouseClicked(evt);
            }
        });

        pump3plus.setText("+");
        pump3plus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pump3plusMouseClicked(evt);
            }
        });

        pump1minus.setText("-");
        pump1minus.setAlignmentY(0.0F);
        pump1minus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pump1minusMouseClicked(evt);
            }
        });

        pump2minus.setText("-");
        pump2minus.setAlignmentY(0.0F);
        pump2minus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pump2minusMouseClicked(evt);
            }
        });

        pump3minus.setText("-");
        pump3minus.setAlignmentY(0.0F);
        pump3minus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pump3minusMouseClicked(evt);
            }
        });

        whitePoint.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whitePoint.setText("Set white point");
        whitePoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whitePointcalibratePump(evt);
            }
        });

        jToggleButton1.setText("Toggle Bubbler");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubblerToggle(evt);
            }
        });

        jToggleButton2.setText("Toggle Laser");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laserToggle(evt);
            }
        });

        redPanel.setBackground(new java.awt.Color(204, 51, 0));
        redPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        redPanel.setToolTipText("");

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jLabel9.setText("Select a target color");

        yellowPanel.setBackground(new java.awt.Color(153, 153, 0));
        yellowPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        yellowPanel.setToolTipText("");

        javax.swing.GroupLayout yellowPanelLayout = new javax.swing.GroupLayout(yellowPanel);
        yellowPanel.setLayout(yellowPanelLayout);
        yellowPanelLayout.setHorizontalGroup(
            yellowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        yellowPanelLayout.setVerticalGroup(
            yellowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        greenPanel.setBackground(new java.awt.Color(0, 153, 0));
        greenPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        greenPanel.setToolTipText("");

        javax.swing.GroupLayout greenPanelLayout = new javax.swing.GroupLayout(greenPanel);
        greenPanel.setLayout(greenPanelLayout);
        greenPanelLayout.setHorizontalGroup(
            greenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        greenPanelLayout.setVerticalGroup(
            greenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        bluePanel.setBackground(new java.awt.Color(0, 102, 102));
        bluePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bluePanel.setToolTipText("");

        javax.swing.GroupLayout bluePanelLayout = new javax.swing.GroupLayout(bluePanel);
        bluePanel.setLayout(bluePanelLayout);
        bluePanelLayout.setHorizontalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bluePanelLayout.setVerticalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jButton1.setText("debug");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(whitePoint, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(huePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(colorStringLabel)
                                    .addComponent(jLabel9))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(redPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yellowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(greenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(pump1minus, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                    .addComponent(pump2minus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(pump3minus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(pump1Bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addComponent(pump2Bar, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addComponent(pump3Bar, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pump2plus)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(pump1plus)
                                        .addContainerGap()))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(pump3plus)
                                    .addContainerGap())))
                        .addComponent(calibrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(pump1plus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pump1Bar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pump1minus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(pump2Bar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pump2plus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pump2minus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(pump3minus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pump3Bar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pump3plus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calibrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(huePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorStringLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(whitePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(greenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yellowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(redPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calibratePump(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calibratePump
        if(!pc.isCalibrated()) {
                calibrationButton.setText("Calibrating...");
                calibrationButton.setEnabled(false);
                pc.start();
        } else {
            pc.recalibrate();
        }
    }//GEN-LAST:event_calibratePump

    private void pump1minusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pump1minusMouseClicked
        manualMove(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_pump1minusMouseClicked

    private void pump2minusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pump2minusMouseClicked
        manualMove(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_pump2minusMouseClicked

    private void pump3minusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pump3minusMouseClicked
        manualMove(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_pump3minusMouseClicked

    private void pump1plusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pump1plusMouseClicked
        manualMove(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_pump1plusMouseClicked

    private void pump2plusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pump2plusMouseClicked
        manualMove(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_pump2plusMouseClicked

    private void pump3plusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pump3plusMouseClicked
        manualMove(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_pump3plusMouseClicked

    private void whitePointcalibratePump(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whitePointcalibratePump
        try {
            colorRead.setWhitePoint();
        } catch (Exception ex) {
            Logger.getLogger(Chromastat18UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_whitePointcalibratePump

    private void bubblerToggle(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubblerToggle
        this.bubblerOn = !this.bubblerOn;
        if(this.bubblerOn) {
            this.bubbler.low();
        } else {
            this.bubbler.high();
        }
    }//GEN-LAST:event_bubblerToggle

    private void laserToggle(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laserToggle
        this.laserOn = !this.laserOn;
        if(this.laserOn) {
            this.laser.low();
        } else {
            this.laser.high();
        }
    }//GEN-LAST:event_laserToggle

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            pc.getPump(0).getState();
        } catch (InterruptedException ex) {
            Logger.getLogger(Chromastat18UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void manualMove(java.awt.event.MouseEvent evt) {
        int count = 0;
        for(JButton button : pumpMinus) {
            if(button == evt.getComponent()) {
                pc.setNewGoal(count, -100);
            } else {
                count++;
            }
        }
        count = 0;
        for(JButton button : pumpPlus) {
            if(button == evt.getComponent()) {
                pc.setNewGoal(count, 100);
            } else {
                count++;
            }
        }
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
            java.util.logging.Logger.getLogger(Chromastat18UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chromastat18UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chromastat18UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chromastat18UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Chromastat18UI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Chromastat18UI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (I2CFactory.UnsupportedBusNumberException ex) {
                    Logger.getLogger(Chromastat18UI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Chromastat18UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void initPumps() {
//        Map<String, Pin> inarg1 = new HashMap<String, Pin>();
//        Map<String, Pin> inarg2 = new HashMap<String, Pin>();
//        Map<String, Pin> inarg3 = new HashMap<String, Pin>();
//        String[] keys = {"dirPin", "stepPin", "enablePin", "minPin", "maxPin"};
//        Pin[] pins1 = {MCP23017Pin.GPIO_A7, MCP23017Pin.GPIO_A6, MCP23017Pin.GPIO_A5, MCP23017Pin.GPIO_B5, MCP23017Pin.GPIO_B1};
//        Pin[] pins2 = {MCP23017Pin.GPIO_B0, MCP23017Pin.GPIO_B1, MCP23017Pin.GPIO_B7, MCP23017Pin.GPIO_B4, MCP23017Pin.GPIO_B2};
//        Pin[] pins3 = {MCP23017Pin.GPIO_A4, MCP23017Pin.GPIO_A3, MCP23017Pin.GPIO_A2, MCP23017Pin.GPIO_B6, MCP23017Pin.GPIO_B3};
//        SyringePump pump1;
//        SyringePump pump2;
//        SyringePump pump3;
//    
//    
//        for(int i = 0; i < keys.length; i++) {
//            inarg1.put(keys[i], pins1[i]);
//            inarg2.put(keys[i], pins2[i]);
//            inarg3.put(keys[i], pins3[i]);
//        }
//        
//        pump1 = new SyringePump(inarg1, mcpProviderOne, mcpProviderTwo);
//        pump2 = new SyringePump(inarg2, mcpProviderOne, mcpProviderTwo);
//        pump3 = new SyringePump(inarg3, mcpProviderOne, mcpProviderTwo);
//        pumps.add(pump1);
//        pumps.add(pump2);
//        pumps.add(pump3);
//        for(int i = 0; i < 3; i++) {
//            pumps.add(new DummyPump());
//        }

    }
   
    
    /**
     * This method is called every few milliseconds, dependent on the
     * timer parameter. 
     * @param e No need to worry about this, the timer calls it automatically. 
     */
    public void actionPerformed(ActionEvent e) {
        try {
             pc.getPump(0).getState();
            // Count for framerate
            this.count = this.count+1;
            this.text1.setText(String.valueOf(Integer.parseInt(this.text1.getText())+1));
            
            
            
            // grab pumpMovingValue;
            int pumpVal = pc.pumpMoving();
            
            // If the pump is moving, log out that it's moving.
            if(Integer.parseInt(this.text1.getText()) % 20 == 0 && pumpVal != -1) {
                System.out.println("pump #" + pc.pumpMoving() + " moving. Position: " + pc.getPumpPos(pumpVal));
            }
            
            if(pumpVal != -1) {
                for(JButton pumpM : pumpMinus) {
                    pumpM.setEnabled(false);
                }
                for(JButton pumpM : pumpPlus) {
                    pumpM.setEnabled(false);
                }
            } else {
                for(JButton pumpM : pumpMinus) {
                    pumpM.setEnabled(true);
                }
                for(JButton pumpM : pumpPlus) {
                    pumpM.setEnabled(true);
                }
            }
            
            if(pc.isCalibrated()) {
                calibrationButton.setText("Re-calibrate");
                calibrationButton.setEnabled(true);
            }
            
            if(pumpVal != -1) {
                pumpBars.get(pumpVal).setValue((int)(pc.getPumpPos(pumpVal)*pumpBars.get(pumpVal).getMaximum()));
            }
            
            // Get the color's normalized reading from the sensor
            // Change DummyRgb to SensorRgb for actual device
            //DummyRgb.ColorReading color;  
            RgbSensor.ColorReading color;
            color = colorRead.getNormalizedReading();           // CHANGE
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            int c = color.getClear();
            
            // run whatever is in here every 2000ms (2 seconds)
            // worry about this later
            //if(this.count % 2000 == 0) {
                //take a reading
                //dep on color, select a pump to move. 
                // if the pump isn't moving, set new goal to be a calculated number
                // if it is moving, do nothing.
                // have pumpcontroller have an internal timer that forces a pause after movement.
            //}
            
            // ACID IN PUMP 1, BASE IN PUMP 2!
            if(this.count % 2000 == 0) {
                if(this.goalRed != -1 && this.goalGreen != -1 && this.goalBlue != -1 && pumpVal == -1) {
                    
                }
            }
            
            // Set color of color panel and colorStringLabel to rgb string
            Color colorPanelBackground = new Color(r,g,b);
            colorPanel.setBackground(colorPanelBackground);
            colorStringLabel.setText(r + "," + g + "," + b);
            
            // Set hue panel color
            huePanel.setBackground(colorRead.readingToHue(color));
            
            
          
        } catch (Exception ex) {
            Logger.getLogger(Chromastat18UI.class.getName()).log(Level.SEVERE,null,ex);
        }
   
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bluePanel;
    private javax.swing.JPanel brightnessPanel1;
    private javax.swing.JPanel brightnessPanel2;
    private javax.swing.JPanel brightnessPanel3;
    private javax.swing.JPanel brightnessPanel5;
    private javax.swing.JPanel brightnessPanel6;
    private javax.swing.JButton calibrationButton;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JLabel colorStringLabel;
    private javax.swing.JPanel greenPanel;
    private javax.swing.JPanel huePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JProgressBar pump1Bar;
    private javax.swing.JButton pump1minus;
    private javax.swing.JButton pump1plus;
    private javax.swing.JProgressBar pump2Bar;
    private javax.swing.JButton pump2minus;
    private javax.swing.JButton pump2plus;
    private javax.swing.JProgressBar pump3Bar;
    private javax.swing.JButton pump3minus;
    private javax.swing.JButton pump3plus;
    private javax.swing.JPanel redPanel;
    private javax.swing.JTextField text1;
    private javax.swing.JButton whitePoint;
    private javax.swing.JPanel yellowPanel;
    // End of variables declaration//GEN-END:variables
}
