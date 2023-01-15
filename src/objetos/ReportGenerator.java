/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.HashMap;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author leo_a
 */
public class ReportGenerator {
    public static void main(String[] args) {
    try {
      String jasperFile = "C:\\Users\\leo_a\\Documents\\NetBeansProjects\\Banco de Horas\\src\\MyReports\\Horas_1.jasper";
      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile, new HashMap<>(), new JREmptyDataSource());
      JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\leo_a\\Documents\\NetBeansProjects\\Banco de Horas\\src\\MyReports\\Horas_1.pdf");
      System.out.println("Successfully generated report.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
