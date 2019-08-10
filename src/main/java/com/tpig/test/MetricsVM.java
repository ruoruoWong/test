package com.tpig.test;

import java.util.Date;

/**
 * @author Wang Ruoruo
 * @date 2019/8/10
 * @time 13:11
 **/
public class MetricsVM {

  private Date startedTime;

  private Date endedTime;

  private long duration;

  public Date getStartedTime() {
    return startedTime;
  }

  public void setStartedTime(Date startedTime) {
    this.startedTime = startedTime;
  }

  public Date getEndedTime() {
    return endedTime;
  }

  public void setEndedTime(Date endedTime) {
    this.endedTime = endedTime;
  }

  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }
}
