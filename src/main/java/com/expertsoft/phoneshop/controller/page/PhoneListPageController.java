package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.forms.SearchForm;
import com.expertsoft.phoneshop.persistence.model.Phone;
import com.expertsoft.phoneshop.service.PaginationService;
import com.expertsoft.phoneshop.service.PhoneService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static com.expertsoft.phoneshop.PhoneShopConstants.PHONES_PATH;

@Controller
@RequestMapping(PHONES_PATH)
public class PhoneListPageController {

    private static final String PHONE_LIST_PAGE = "phoneListPage";
    private static final String PAGE = "page";
    private static final String PAGINATION_LIST = "paginationList";
    private static final String SEARCH_FORM = "searchForm";
    private static final String SORT_PARAMETER = "sortParameter";


    @Resource
    private PhoneService phoneService;

    @Resource
    private PaginationService paginationService;

    @GetMapping
    public String getPhoneList(Model model,
                               @PageableDefault(size = 5) Pageable pageable) {
        var page = phoneService.getPhonesPage(pageable);
        setAttributesToModel(model, new SearchForm(), page);
        return PHONE_LIST_PAGE;
    }

    @GetMapping("/search")
    public String searchPhoneList(Model model, @ModelAttribute("searchForm") SearchForm searchForm,
                                  @PageableDefault(size = 5) Pageable pageable) {
        var page = phoneService.searchPhones(searchForm, pageable);
        setAttributesToModel(model, searchForm, page);
        return PHONE_LIST_PAGE;
    }

    private void setAttributesToModel(Model model, SearchForm searchForm, Page<Phone> page) {
        model.addAttribute(PAGE, page);
        model.addAttribute(PAGINATION_LIST, paginationService.getPagination(page));
        model.addAttribute(SEARCH_FORM, searchForm);
    }
}
