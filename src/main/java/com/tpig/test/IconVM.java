package com.tpig.test;

/**
 * @author Wang Ruoruo
 * @date 2019/8/10
 * @time 12:00
 **/
public class IconVM {

  private static String DEFAULT_ICON = "   //\n"
      + " _oo\\\n"
      + "(__/ \\  _  _\n"
      + "   \\  \\/ \\/ \\\n"
      + "   (         )\\\n"
      + "    \\_______/  \\\n"
      + "     [[] [[]\n"
      + "     [[] [[]";

  private String[] icon;

  private int width;

  private int height;

  public IconVM() {
    this(DEFAULT_ICON);
  }

  public IconVM(String iconStr) {
    this.icon = structIcon(iconStr);
  }

  private String[] structIcon(String iconStr) {
    return iconStr.split("\n|\r\n");
  }

  public String[] getIcon() {
    return icon;
  }

  public void setIcon(String[] icon) {
    this.icon = icon;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
