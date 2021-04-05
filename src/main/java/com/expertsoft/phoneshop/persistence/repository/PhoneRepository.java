package com.expertsoft.phoneshop.persistence.repository;

import com.expertsoft.phoneshop.persistence.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Page<Phone> findAllByBrandContainsAndModelContainsAndPriceBetween(String brand, String model,
                                                                      BigDecimal fromPrice, BigDecimal toPrice,
                                                                      Pageable pageable);

    @Query("select p from Phone p where (lower(p.brand) like lower(concat(concat('%',?1), '%')) or " +
            "lower(p.model) like lower(concat(concat('%',?1), '%'))) and p.price between ?2 and ?3")
    Page<Phone> findAllBySearchFrom(String phase,
                                    BigDecimal fromPrice, BigDecimal toPrice,
                                    Pageable pageable);
}
