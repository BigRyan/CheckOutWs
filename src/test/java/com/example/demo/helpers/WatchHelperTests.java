package com.example.demo.helpers;

import com.example.demo.model.Watch;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by renliang on 2019/9/8.
 */
public class WatchHelperTests {

    static WatchHelper watchHelper = null;
    static List<Watch> watchInfo = null;

    @BeforeClass
    public static void setup() {
        watchHelper = new WatchHelper();

        watchInfo = new ArrayList<>();
        Watch rolex = new Watch(1, "001", "Rolex", 100, 3, 200);
        Watch mk = new Watch(2, "002", "Michael Kors", 80, 2, 120);
        Watch swatch = new Watch(3, "003", "Swatch", 50, 0, 0);
        Watch casio = new Watch(4, "004", "Casio", 30, 0, 0);
        watchInfo.add(rolex);
        watchInfo.add(mk);
        watchInfo.add(swatch);
        watchInfo.add(casio);
    }

    @Test
    public void testRemoveDuplicates() {
        String[] duplicates = new String[] {"001","001","002","002","003"};
        List<String> result = watchHelper.removeDuplicates(Arrays.asList(duplicates));
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void testGetWatchNoCount() {
        String[] duplicates = new String[] {"001", "001","001","002","002","003"};
        Map<String, Long> map = watchHelper.getWatchNoCount(Arrays.asList(duplicates));
        assertThat(map.get("001")).isEqualTo(3);
    }

    @Test
    public void testGetTotalPriceWithAllDiscounts() {
        Map<String, Long> watchesMap = new HashMap<>();
        watchesMap.put("001",6L);
        watchesMap.put("002",4L);
        int price = watchHelper.getTotalPrice(watchInfo, watchesMap);
        assertThat(price).isEqualTo(640);
    }

    @Test
    public void testGetTotalPriceMixSingle() {
        Map<String, Long> watchesMap = new HashMap<>();
        watchesMap.put("001",7L);
        int price = watchHelper.getTotalPrice(watchInfo, watchesMap);
        assertThat(price).isEqualTo(500);
    }

    @Test
    public void testGetTotalPriceMixMultiCategory() {
        Map<String, Long> watchesMap = new HashMap<>();
        watchesMap.put("001",7L);
        watchesMap.put("002",2L);
        watchesMap.put("003",3L);
        watchesMap.put("004",1L);
        int price = watchHelper.getTotalPrice(watchInfo, watchesMap);
        assertThat(price).isEqualTo(800);
    }

}
