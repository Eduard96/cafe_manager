package org.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.task.domains.Product;
import org.task.domains.Table;
import org.task.domains.users.Manager;
import org.task.domains.users.Waiter;
import org.task.services.ManagerService;
import org.task.utils.AssignForm;

import javax.validation.Valid;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private static final String MANAGER_PAGE_VIEW = "redirect:/manager/manager_page";
    private static final String MANAGER_VIEWS = "manager_views";
    private static final String CREATE_TABLE_VIEW = "/create_table";
    private static final String CREATE_WAITER_VIEW = "/create_waiter";
    private static final String CREATE_PRODUCT_VIEW = "/create_product";
    private static final String ASSIGN_TABLE_VIEW = "/assign_table";


    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping()
    public String showGreetingPage(Model model) {
        model.addAttribute("manager", new Manager());
        return "manager_views/manager_login";
    }

    @GetMapping("/manager_page")
    public String showActions(@ModelAttribute Manager manager) {
        if(managerService.exists(manager))
            return "manager_views/manager_page";
        return "redirect:/main_page";
    }

    @GetMapping("/add_waiter")
    public String showCreateWaiterPage(Model model) {
        model.addAttribute("waiter", new Waiter());
        return MANAGER_VIEWS + CREATE_WAITER_VIEW;
    }

    @PostMapping("/add_waiter")
    public String addWaiter(@ModelAttribute @Valid Waiter waiter,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return MANAGER_VIEWS + CREATE_WAITER_VIEW;
        managerService.saveWaiter(waiter);
        return MANAGER_PAGE_VIEW;
    }

    @GetMapping("/add_table")
    public String showCreateTablePage(Model model) {
        model.addAttribute("table", new Table());
        return MANAGER_VIEWS + CREATE_TABLE_VIEW;
    }

    @PostMapping("/add_table")
    public String addTable(@ModelAttribute @Valid Table table,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return MANAGER_VIEWS + CREATE_TABLE_VIEW;
        managerService.saveTable(table);
        return MANAGER_PAGE_VIEW;
    }

    @GetMapping("/add_product")
    public String showCreateProductPage(Model model) {
        model.addAttribute("product", new Product());
        return MANAGER_VIEWS + CREATE_PRODUCT_VIEW;
    }

    @PostMapping("/add_product")
    public String addProduct(@ModelAttribute @Valid Product product,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return MANAGER_VIEWS + CREATE_PRODUCT_VIEW;
        managerService.saveProduct(product);
        return MANAGER_PAGE_VIEW;
    }

    @GetMapping("/assign_table")
    public String showAssignTablePage(Model model) {
        model.addAttribute("assignForm", new AssignForm());
        return MANAGER_VIEWS + ASSIGN_TABLE_VIEW;
    }

    @PostMapping("/assign_table")
    public String assignTable(@ModelAttribute AssignForm assignForm) {
        System.out.println(assignForm.getWaiter_id() + " " + assignForm.getTable_id());
        managerService.assignTableToWaiter(assignForm);
        return MANAGER_PAGE_VIEW;
    }
}
