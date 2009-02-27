package org.pentaho.chart.model.util;

import org.pentaho.chart.model.ChartModel;
import org.pentaho.chart.model.Graph;
import org.pentaho.chart.model.ChartModel.ChartTheme;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class ChartSerializer {
  private static XStream xstreamWriter = new XStream(new JettisonMappedXmlDriver());
  private static XStream xstreamReader = new XStream(new JettisonMappedXmlDriver());
  static{
    xstreamWriter.alias("ChartModel", ChartModel.class);
    xstreamReader.alias("ChartModel", ChartModel.class);
    xstreamWriter.setMode(XStream.NO_REFERENCES);
    xstreamReader.setMode(XStream.NO_REFERENCES);
    xstreamWriter.useAttributeFor(Graph.class, "categoryAxisLabel");
    
  }
  public static String serialize(ChartModel model){
    return xstreamWriter.toXML(model);
  }
  
  public static ChartModel deSerialize(String input){
    return (ChartModel) xstreamReader.fromXML(input);
  }
  
}
