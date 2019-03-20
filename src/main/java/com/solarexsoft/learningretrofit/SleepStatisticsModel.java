package com.solarexsoft.learningretrofit;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 18:03/2019/3/19
 *    Desc:
 * </pre>
 */

public class SleepStatisticsModel {

    /**
     * timestamp : 1552013340000
     * startTime : 1552013340000
     * endTime : 552013340000
     * timeAsleep : 1
     * timeInBed : 2
     * quality : a
     */

    private long timestamp;
    private long startTime;
    private long endTime;
    private int timeAsleep;
    private int timeInBed;
    private String quality;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getTimeAsleep() {
        return timeAsleep;
    }

    public void setTimeAsleep(int timeAsleep) {
        this.timeAsleep = timeAsleep;
    }

    public int getTimeInBed() {
        return timeInBed;
    }

    public void setTimeInBed(int timeInBed) {
        this.timeInBed = timeInBed;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
