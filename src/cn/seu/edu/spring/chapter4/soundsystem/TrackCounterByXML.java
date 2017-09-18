package cn.seu.edu.spring.chapter4.soundsystem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18.
 */
public class TrackCounterByXML {
    private Map<Integer, Integer> trackCounter = new HashMap<>();

    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounter.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounter.containsKey(trackNumber) ? trackCounter.get(trackNumber) : 0;
    }
}
