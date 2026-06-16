
package UI;

import UTIL.DbBean;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class FrmContratoPorFechas extends javax.swing.JInternalFrame{

    public FrmContratoPorFechas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_fecha_inicio_contratoxfechas = new javax.swing.JTextField();
        txt_fecha_fin_contratoxfechas = new javax.swing.JTextField();
        btn_reporte_contratoxfechas = new javax.swing.JButton();
        btn_salircontratoxfechas = new javax.swing.JButton();
        btn_fecha_ini_contratoxfechas = new javax.swing.JButton();
        btn_fecha_fin_contratoxfechas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CONTRATO DE RANGO POR FECHAS");

        jLabel2.setText("Fechas: año - mes - dia");

        jLabel3.setText("FECHA INICIO");

        jLabel4.setText("FECHA FIN");

        txt_fecha_inicio_contratoxfechas.setEditable(false);

        txt_fecha_fin_contratoxfechas.setEditable(false);

        btn_reporte_contratoxfechas.setText("Producir Reporte");
        btn_reporte_contratoxfechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reporte_contratoxfechasActionPerformed(evt);
            }
        });

        btn_salircontratoxfechas.setText("SALIR");
        btn_salircontratoxfechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salircontratoxfechasActionPerformed(evt);
            }
        });

        btn_fecha_ini_contratoxfechas.setText("FECHA");
        btn_fecha_ini_contratoxfechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fecha_ini_contratoxfechasActionPerformed(evt);
            }
        });

        btn_fecha_fin_contratoxfechas.setText("FECHA");
        btn_fecha_fin_contratoxfechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fecha_fin_contratoxfechasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_reporte_contratoxfechas)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_salircontratoxfechas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_fecha_inicio_contratoxfechas)
                                            .addComponent(txt_fecha_fin_contratoxfechas, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_fecha_ini_contratoxfechas)
                                            .addComponent(btn_fecha_fin_contratoxfechas)))
                                    .addComponent(jLabel2))
                                .addContainerGap(105, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_fecha_inicio_contratoxfechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_fecha_ini_contratoxfechas))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_fecha_fin_contratoxfechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_fecha_fin_contratoxfechas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_salircontratoxfechas, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btn_reporte_contratoxfechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_reporte_contratoxfechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reporte_contratoxfechasActionPerformed
    String fechaIni = txt_fecha_inicio_contratoxfechas.getText().trim();
    String fechaFin = txt_fecha_fin_contratoxfechas.getText().trim();
    
    // Validar que las fechas no estén vacías
    if (fechaIni.isEmpty() || fechaFin.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar ambas fechas.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    HashMap<String, Object> map = new HashMap<>();
    map.put("FECHAINICIO", fechaIni);
    map.put("FECHAFIN", fechaFin);

    try {
        String reportePath = "C:\\ProyectoRestaurant\\ProyectoRestaurant\\ProyRestaurant\\src\\main\\java\\REPORTES\\repContratoPorFechas.jasper";
        DbBean db = new DbBean();
        db.connectRep(reportePath, map, true);

        // Si todo se ejecutó correctamente, cerramos la ventana
        this.dispose();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (JRException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_reporte_contratoxfechasActionPerformed

    private void btn_salircontratoxfechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salircontratoxfechasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salircontratoxfechasActionPerformed

    private void btn_fecha_ini_contratoxfechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fecha_ini_contratoxfechasActionPerformed
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd"); // Formato de visualización en JDateChooser

        // Mostrarlo dentro de un JOptionPane
        int opcion = JOptionPane.showConfirmDialog(null, dateChooser, "Seleccione una Fecha", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            Date fechaSeleccionada = dateChooser.getDate();
            if (fechaSeleccionada != null) {
                // Formatear la fecha antes de mostrarla en el JTextField
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateadaINI = sdf.format(fechaSeleccionada);
                this.txt_fecha_inicio_contratoxfechas.setText(fechaFormateadaINI);
                
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ninguna fecha.");
            }
        }
    }//GEN-LAST:event_btn_fecha_ini_contratoxfechasActionPerformed

    private void btn_fecha_fin_contratoxfechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fecha_fin_contratoxfechasActionPerformed
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd"); // Formato de visualización en JDateChooser

        // Mostrarlo dentro de un JOptionPane
        int opcion = JOptionPane.showConfirmDialog(null, dateChooser, "Seleccione una Fecha", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            Date fechaSeleccionada = dateChooser.getDate();
            if (fechaSeleccionada != null) {
                // Formatear la fecha antes de mostrarla en el JTextField
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateadaFin = sdf.format(fechaSeleccionada);
                String fechaInicioTexto = this.txt_fecha_inicio_contratoxfechas.getText();
                 try {
                    Date fechaInicio = sdf.parse(fechaInicioTexto);

                    if (fechaSeleccionada.compareTo(fechaInicio) >= 0) {
                        this.txt_fecha_fin_contratoxfechas.setText(fechaFormateadaFin);
                    } else {
                        JOptionPane.showMessageDialog(null, "La fecha de fin debe ser igual o posterior a la fecha de inicio.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al convertir la fecha de inicio.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ninguna fecha.");
            }
        }
    }//GEN-LAST:event_btn_fecha_fin_contratoxfechasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_fecha_fin_contratoxfechas;
    private javax.swing.JButton btn_fecha_ini_contratoxfechas;
    private javax.swing.JButton btn_reporte_contratoxfechas;
    private javax.swing.JButton btn_salircontratoxfechas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_fecha_fin_contratoxfechas;
    private javax.swing.JTextField txt_fecha_inicio_contratoxfechas;
    // End of variables declaration//GEN-END:variables
}
