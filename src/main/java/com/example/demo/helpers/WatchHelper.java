package com.example.demo.helpers;

import com.example.demo.model.Watch;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by renliang on 2019/9/8.
 */
@Component
public class WatchHelper {

    public List<String> removeDuplicates(List<String> listWithDuplicates) {
        List<String> listWithoutDuplicates = new ArrayList<>(
                new HashSet<>(listWithDuplicates));
        return listWithoutDuplicates;
    }

    public Map<String, Long> getWatchNoCount(List<String> watchesForCheckout) {
        Map<String, Long> resultMap = new HashMap<>();
        watchesForCheckout.stream()
                .collect(Collectors.groupingBy(value -> value, Collectors.counting()))
                .forEach((value,count)->resultMap.put(value, count));
        return resultMap;
    }

    public int getTotalPrice(List<Watch> watchInfos, Map<String, Long> watchsForCheckout) {
        int price = 0;
        for (String watchNo : watchsForCheckout.keySet()) {
            Long count = watchsForCheckout.get(watchNo);
            Integer int_count = (int) (long) count;
            Watch watch = getWatchInfo(watchInfos, watchNo);
            int discountEligibleCount = watch.getDiscountEligibleCount();
            int this_price = 0;
            if(discountEligibleCount != 0) {
                int normal_count = int_count % discountEligibleCount;
                int dis_group_count =  int_count / discountEligibleCount;
                this_price = dis_group_count * watch.getDiscountPrice()
                        + normal_count * watch.getUnitPrice();
            } else {
                this_price = int_count * watch.getUnitPrice();
            }

            price += this_price;
        }

        return price;

    }

    public Watch getWatchInfo(List<Watch> watchInfos, String watchNo) {
        for (Watch watchInfo : watchInfos) {
            if (watchInfo.getWatchNo().equals(watchNo)) {
                return watchInfo;
            }
        }

        return null;
    }
}
