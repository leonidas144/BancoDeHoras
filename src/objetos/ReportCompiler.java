/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import net.sf.jasperreports.engine.JasperCompileManager;

/**
 *
 * @author leo_a
 */
public class ReportCompiler {
    public static void main(String[] args) {
    try {
      String jrxmlFile = "C:\\Users\\leo_a\\Documents\\NetBeansProjects\\Banco de Horas\\src\\MyReports\\Horas_1.jrxml";
      String jasperFile = "C:\\Users\\leo_a\\Documents\\NetBeansProjects\\Banco de Horas\\src\\MyReports\\Horas_1.jasper";
      JasperCompileManager.compileReportToFile(jrxmlFile, jasperFile);
      System.out.println("Successfully compiled report.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
