package com.tpig.test;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;

/**
 * @author Wang Ruoruo
 * @date 2019/8/10
 * @time 11:57
 **/
public class CardServiceImpl implements CardService {

  private static int CARD_MAX_WIDTH = 50;

  private static String TABLE_BOARD_CHAR = "`";

  private static int TABLE_BOARD_WIDTH = TABLE_BOARD_CHAR.length();

  private static String CARD_BOARD_CHAR = "*";

  private static int CARD_BOARD_WIDTH = CARD_BOARD_CHAR.length();

  private static String CARD_SPACE_CHAR = " ";

  private static int CARD_SPACE_WIDTH = CARD_SPACE_CHAR.length();

  private static int AVAILABLE_MAX_WIDTH =
      CARD_MAX_WIDTH - 2 * CARD_BOARD_WIDTH - 2 * CARD_SPACE_WIDTH;

  private static int TABLE_MAX_WIDTH = 40;

  private static int AVAILABLE_TABLE_MAX_WIDTH = TABLE_MAX_WIDTH - 2 * TABLE_BOARD_WIDTH;


  public String drawCard(CardVM cardVM) {
    if (cardVM == null) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    // draw first line
    stringBuilder.append(StringUtils.rightPad("", CARD_MAX_WIDTH, "*")).append("\n");
    // draw icon
    IconVM iconVM = cardVM.getIconVM();
    for (String piece : iconVM.getIcon()) {
      stringBuilder.append(drawLineContent(piece));
    }
    stringBuilder.append(drawLineContent(""));
    // draw request
    RequestVM requestVM = cardVM.getRequestVM();
    stringBuilder.append(drawLineContent(
        "request time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .format(requestVM.getRequestTime())));
    stringBuilder.append(drawLineContent("request user: " + requestVM.getRequestUser()));
    stringBuilder.append(drawLineContent("request content: " + requestVM.getRequestContent()));
    stringBuilder.append(drawLineContent(""));
    // draw metrics
    MetricsVM metricsVM = cardVM.getMetricsVM();
    stringBuilder
        .append(drawLineContent("started time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .format(metricsVM.getStartedTime())));
    stringBuilder
        .append(drawLineContent("ended time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .format(metricsVM.getEndedTime())));
    stringBuilder.append(drawLineContent("duration: " + metricsVM.getDuration() + " ms"));
    stringBuilder.append(drawLineContent(""));
    // draw result
    stringBuilder.append(drawLineContent("result:"));
    LinkedHashMap<String, String> results = cardVM.getResults();
    if (results != null && !results.isEmpty()) {
      stringBuilder
          .append(drawLineContent(StringUtils.rightPad("", TABLE_MAX_WIDTH, TABLE_BOARD_CHAR)));
      for (Entry<String, String> entry : results.entrySet()) {
        stringBuilder.append(drawTableOneEntry(entry.getKey(), entry.getValue()));
      }
      stringBuilder
          .append(drawLineContent(StringUtils.rightPad("", TABLE_MAX_WIDTH, TABLE_BOARD_CHAR)));
    }

    // draw last line
    stringBuilder.append(StringUtils.rightPad("", CARD_MAX_WIDTH, "*")).append("\n");
    return stringBuilder.toString();
  }

  /**
   * @param lineContent
   * @return
   */
  private String drawLineContent(String lineContent) {
    return drawBeginOfLineChars() + StringUtils.rightPad(lineContent, AVAILABLE_MAX_WIDTH)
        + drawEndOfLineChars();
  }

  private String drawBeginOfLineChars() {
    return CARD_BOARD_CHAR + CARD_SPACE_CHAR;
  }

  private String drawEndOfLineChars() {
    return CARD_SPACE_CHAR + CARD_BOARD_CHAR + "\n";
  }

  /**
   * @param key
   * @param value
   * @return
   */
  private String drawTableOneEntry(String key, String value) {
    String all = key + ":" + CARD_SPACE_CHAR + value;
    if (all.length() > AVAILABLE_TABLE_MAX_WIDTH) {
      int paragraphCount = all.length() / AVAILABLE_TABLE_MAX_WIDTH + 1;
      StringBuilder oneEntry = new StringBuilder();
      for (int i = 0; i < paragraphCount; i++) {
        String line = StringUtils
            .substring(all, i * AVAILABLE_TABLE_MAX_WIDTH,
                i * AVAILABLE_TABLE_MAX_WIDTH + AVAILABLE_TABLE_MAX_WIDTH);
        oneEntry.append(
            drawLineContent(TABLE_BOARD_CHAR + StringUtils.rightPad(line, AVAILABLE_TABLE_MAX_WIDTH)
                + TABLE_BOARD_CHAR));
      }
      oneEntry.append(drawLineContent(
          TABLE_BOARD_CHAR + StringUtils.rightPad("", AVAILABLE_TABLE_MAX_WIDTH)
              + TABLE_BOARD_CHAR));
      return oneEntry.toString();
    }
    return drawLineContent(
        TABLE_BOARD_CHAR + StringUtils.rightPad(all, AVAILABLE_TABLE_MAX_WIDTH) + TABLE_BOARD_CHAR);

  }
}
