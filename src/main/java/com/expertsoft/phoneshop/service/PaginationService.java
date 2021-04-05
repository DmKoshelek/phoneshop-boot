package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.properties.PaginationProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.max;

@Service
public class PaginationService {

    private final static int MIN_PAGE_NUMBER = 0;

    @Resource
    private PaginationProperties paginationProperties;

    public List<Integer> getPagination(Page page) {
        int currentPageNumber = page.getNumber();
        int totalPages = page.getTotalPages();
        int firstElement = max(MIN_PAGE_NUMBER, currentPageNumber - paginationProperties.getMaxPageCount() / 2);
        return IntStream.iterate(firstElement, i -> i + 1)
                .limit(paginationProperties.getMaxPageCount())
                .filter(i -> i < totalPages)
                .boxed()
                .collect(Collectors.toList());
    }
}
