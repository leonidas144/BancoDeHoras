/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexoes;


import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author leo_a
 */
public class GerarRelatorio {
    private String relatorio;
    MySQL conectar = new MySQL();
    
    
    public void ficha(String relatorio) throws JRException, Exception{
        
        this.relatorio = relatorio;
        this.conectar.conectaBanco();
        
        this.conectar.executarSQL(" SELECT * FROM papamike ");
        
        
        JRResultSetDataSource jrRS = new JRResultSetDataSource( this.conectar.getResultSet());
                
        Map parameters = new HashMap();
        
        JasperPrint jp = JasperFillManager.fillReport(relatorio, null, jrRS);
        
        JasperViewer.viewReport(jp, false);

    }
}
