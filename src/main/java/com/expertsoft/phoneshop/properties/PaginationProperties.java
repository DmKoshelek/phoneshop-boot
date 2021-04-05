package com.expertsoft.phoneshop.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Positive;

@Validated
@Component
@ConfigurationProperties("phoneshop.pagination")
public class PaginationProperties {

    @Positive
    private int maxPageCount = 5;

    public int getMaxPageCount() {
        return maxPageCount;
    }

    public void setMaxPageCount(int maxPageCount) {
        this.maxPageCount = maxPageCount;
    }
}
