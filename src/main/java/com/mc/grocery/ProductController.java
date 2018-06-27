package com.mc.grocery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @RequestMapping("/")
    public String showHomepage(Model model){
        model.addAttribute("purchases", purchaseRepository.findAll());
        return "index";
    }
    @RequestMapping("/addproduct")
    public String addProduct(Model model){
        model.addAttribute("purchase" , new Purchase());
        model.addAttribute("products", productRepository.findAll());
        return "productForm";
    }

    @RequestMapping("/saveproduct")
    public String saveProduct(@ModelAttribute("purchase") Purchase purchase, Model model){
        purchaseRepository.save(purchase);
        return "redirect:/";
    }

    @PostConstruct
    public void fillTable(){
        Product product = new Product();
        product.setItemName("Potato");
        productRepository.save(product);

        product = new Product();
        product.setItemName("Bread");
        productRepository.save(product);

        product = new Product();
        product.setItemName("Milk");
        productRepository.save(product);

        product = new Product();
        product.setItemName("Peanut butter and Jelly");
        productRepository.save(product);
    }
}
