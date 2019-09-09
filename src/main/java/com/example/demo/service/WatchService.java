package com.example.demo.service;

import com.example.demo.helpers.WatchHelper;
import com.example.demo.model.Watch;
import com.example.demo.repository.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by renliang on 2019/9/8.
 */
@Service
public class WatchService {
    private final WatchRepository watchRepository;
    private final WatchHelper watchHelper;

    @Autowired
    public WatchService(WatchRepository watchRepository, WatchHelper watchHelper) {
        this.watchRepository = watchRepository;
        this.watchHelper = watchHelper;
    }

    public Watch findWatchByNo(String watchNo) {
        return watchRepository.findByWatchNo(watchNo);
    }

    public int getTotalPrice(List<String> pickedWatches) {
        Map<String, Long> watchMap = watchHelper.getWatchNoCount(pickedWatches);
        Set<String> watchNoSet = watchMap.keySet();
        String[] array = watchNoSet.toArray(new String[watchNoSet.size()]);
        List<Watch> watchInfos = watchRepository.selectWatchesInfoByWatchNos(array);
        int price = watchHelper.getTotalPrice(watchInfos, watchMap);
        return price;
    }
}
