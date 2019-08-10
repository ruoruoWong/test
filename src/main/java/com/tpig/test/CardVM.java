package com.tpig.test;

import java.util.LinkedHashMap;

/**
 * @author Wang Ruoruo
 * @date 2019/8/10
 * @time 11:34
 **/
public class CardVM {

  private IconVM iconVM;

  private MetricsVM metricsVM;

  private RequestVM requestVM;

  private LinkedHashMap<String, String> results;

  public IconVM getIconVM() {
    return iconVM;
  }

  public MetricsVM getMetricsVM() {
    return metricsVM;
  }

  public void setMetricsVM(MetricsVM metricsVM) {
    this.metricsVM = metricsVM;
  }

  public RequestVM getRequestVM() {
    return requestVM;
  }

  public void setRequestVM(RequestVM requestVM) {
    this.requestVM = requestVM;
  }

  public void setIconVM(IconVM iconVM) {
    this.iconVM = iconVM;
  }

  public LinkedHashMap<String, String> getResults() {
    return results;
  }

  public void setResults(LinkedHashMap<String, String> results) {
    this.results = results;
  }
}
