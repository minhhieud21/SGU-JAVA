
package DHLmoto.GUI;
import java.awt.Color;
import javax.swing.JFrame;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler.ChartTheme;


public class ThongKez implements ExampleChart<PieChart>{
    public static long tongthu;
    public static long tongchi;

    public void main(){
        ExampleChart<PieChart> exampleChart=new ThongKez();
        PieChart chart=exampleChart.getChart();
        JFrame frame = new SwingWrapper<>(chart).displayChart();
        javax.swing.SwingUtilities.invokeLater(
                ()->frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        );

    }

    public void setThu(long thu){
        this.tongthu=thu;
    }

    public void setChi(long chi){
        this.tongchi=chi;
    }

    public long getThu(){
        return tongthu;
    }

    public long getChi(){
        return tongchi;
    }

    @Override
    public PieChart getChart(){
        // Create Chart
        PieChart chart=new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

        // Customize Chart
        Color[] sliceColors=new Color[]{new Color(12,91,160),new Color(97,112,129)};
        chart.getStyler().setSeriesColors(sliceColors);;
        // Series
        chart.addSeries("Số xe đã nhập ",getThu());
        chart.addSeries("Số đã đã bán",getChi());
        return chart;
    }

    @Override
    public String getExampleChartName(){
        throw new UnsupportedOperationException("Not supported yet.");
    }}