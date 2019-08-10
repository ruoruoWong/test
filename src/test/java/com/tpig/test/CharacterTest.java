package com.tpig.test;

import java.util.Date;
import java.util.LinkedHashMap;
import org.junit.Test;

/**
 * @author Wang Ruoruo
 * @date 2019/8/10
 * @time 11:29
 **/
public class CharacterTest {

  @Test
  public void test() {
    CardVM cardVM = new CardVM();
    IconVM iconVM = new IconVM();
    RequestVM requestVM = new RequestVM();
    MetricsVM metricsVM = new MetricsVM();
    metricsVM.setStartedTime(new Date());
    metricsVM.setEndedTime(new Date());
    metricsVM.setDuration(1L);

    requestVM.setRequestTime(new Date());
    requestVM.setRequestUser("eXXXX");
    requestVM.setRequestContent("#echo [xxxxxxx]");

    LinkedHashMap<String, String> results = new LinkedHashMap<>();
    results.put("result1",
        "echo88888888888888888888888888888888888888777777777777777777777777999999999999999999999999999999999999");
    results.put("result2", "echo");

    cardVM.setIconVM(iconVM);
    cardVM.setMetricsVM(metricsVM);
    cardVM.setRequestVM(requestVM);
    cardVM.setResults(results);
    CardService cardService = new CardServiceImpl();

    System.out.println(cardService.drawCard(cardVM));


  }

}
