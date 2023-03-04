/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.controllers;

import com.dxhh.pojo.Category;
import com.dxhh.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        List<Category> cates = new ArrayList<>();
        cates.add(new Category(1, "Mobile"));
        cates.add(new Category(2, "Tablet"));
        cates.add(new Category(3, "Desktop"));

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "SS S23 Ultra", "", 23000000l, null, "https://cdn1.smartprix.com/rx-izLSMVlI0-w420-h420/samsung-galaxy-s23-u.webp", null, Boolean.TRUE));
        products.add(new Product(1, "iPhone 14 ProMax", "", 40000000l, null, "https://hiphone.vn/wp-content/uploads/2022/09/Den.jpg", null, Boolean.TRUE));
        products.add(new Product(1, "SS S23 Ultra", "", 23000000l, null, "https://cdn1.smartprix.com/rx-izLSMVlI0-w420-h420/samsung-galaxy-s23-u.webp", null, Boolean.TRUE));
        products.add(new Product(1, "SS S23 Ultra", "", 23000000l, null, "https://hiphone.vn/wp-content/uploads/2022/09/Den.jpg", null, Boolean.TRUE));
        products.add(new Product(1, "SS S23 Ultra", "", 23000000l, null, "https://cdn1.smartprix.com/rx-izLSMVlI0-w420-h420/samsung-galaxy-s23-u.webp", null, Boolean.TRUE));

        model.addAttribute("categories", cates);
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/hello/")
    public String hello(Model model,
            @RequestParam(name = "name", required = false) String name) {
        model.addAttribute("name", name);
        return "index";
    }
}
