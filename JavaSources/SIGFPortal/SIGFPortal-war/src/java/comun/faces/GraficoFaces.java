/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comun.faces;


import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author w8
 */
@ManagedBean
@ViewScoped
public class GraficoFaces implements Serializable{
    
   private PieChartModel pieModel1;
   private BarChartModel barModel;
 
    @PostConstruct
    public void init() {
        createPieModel1();
        createBarModel();
    }
 
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Cono Sur", 540);
        pieModel1.set("Cono Oeste", 325);
        pieModel1.set("Cono Norte", 702);
        pieModel1.set("Cono Este", 421);
         
        pieModel1.setTitle("Ventas Lima Metropolitana");
        pieModel1.setLegendPosition("w");
    }
   
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Importe de Ventas");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Años");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Importe (Miles de Soles)");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
   
     private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Factura");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Boletas");
        girls.set("2010", 52);
        girls.set("2011", 60);
        girls.set("2012", 110);
        girls.set("2013", 135);
        girls.set("2014", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
     
     
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    
}
