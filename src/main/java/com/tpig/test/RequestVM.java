package com.tpig.test;

import java.util.Date;

/**
 * @author Wang Ruoruo
 * @date 2019/8/10
 * @time 13:51
 **/
public class RequestVM {

  private Date requestTime;

  private String requestUser;

  private String requestContent;

  public Date getRequestTime() {
    return requestTime;
  }

  public void setRequestTime(Date requestTime) {
    this.requestTime = requestTime;
  }

  public String getRequestUser() {
    return requestUser;
  }

  public void setRequestUser(String requestUser) {
    this.requestUser = requestUser;
  }

  public String getRequestContent() {
    return requestContent;
  }

  public void setRequestContent(String requestContent) {
    this.requestContent = requestContent;
  }
}
