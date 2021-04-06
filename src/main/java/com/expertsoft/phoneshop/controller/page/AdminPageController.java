package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.persistence.model.User;
import com.expertsoft.phoneshop.service.PaginationService;
import com.expertsoft.phoneshop.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static com.expertsoft.phoneshop.PhoneShopConstants.ADMIN_PATH;

@Controller
@RequestMapping(ADMIN_PATH)
public class AdminPageController {

    private static final String ADMIN_PAGE = "admin/adminPanelPage";
    private static final String PAGE = "page";
    private static final String PAGINATION_LIST = "paginationList";

    @Resource
    private UserService userService;
    @Resource
    private PaginationService paginationService;

    @GetMapping
    public String getUserList(Model model,
                               @PageableDefault(size = 5) Pageable pageable) {
        var page = userService.getUsersPage(pageable);
        setAttributesToModel(model, page);
        return ADMIN_PAGE;
    }

    private void setAttributesToModel(Model model, Page<User> page) {
        model.addAttribute(PAGE, page);
        model.addAttribute(PAGINATION_LIST, paginationService.getPagination(page));
    }
}
