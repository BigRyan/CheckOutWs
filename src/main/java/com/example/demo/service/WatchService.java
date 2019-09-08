package com.example.demo.service;

import com.example.demo.model.Watch;
import com.example.demo.repository.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by renliang on 2019/9/8.
 */
@Service
public class WatchService {
    private final WatchRepository watchRepository;

    @Autowired
    public WatchService(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    public Watch findWatchByNo(String watchNo) {
        return watchRepository.findByWatchNo(watchNo);
    }
}
