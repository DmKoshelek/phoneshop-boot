package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.forms.SearchForm;
import com.expertsoft.phoneshop.persistence.model.Phone;
import com.expertsoft.phoneshop.persistence.repository.PhoneRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class PhoneService {

    @Resource
    private PhoneRepository phoneRepository;

    public Page<Phone> getPhonesPage(Pageable pageable) {
        return phoneRepository.findAll(pageable);
    }

    public Page<Phone> searchPhones(SearchForm searchForm, Pageable pageable) {
        var query = StringUtils.defaultString(searchForm.getSearchQuery());
        var fromPrice = ObjectUtils.defaultIfNull(searchForm.getFromPrice(), BigDecimal.ZERO);
        var toPrice = ObjectUtils.defaultIfNull(searchForm.getToPrice(), BigDecimal.valueOf(Integer.MAX_VALUE));
        return phoneRepository.findAllBySearchFrom(query, fromPrice, toPrice, pageable);
    }
}
