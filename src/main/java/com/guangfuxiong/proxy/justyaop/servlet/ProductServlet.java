package com.guangfuxiong.proxy.justyaop.servlet;

import com.guangfuxiong.proxy.justyaop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductServlet {
    @Autowired
    ProductService productService;
    public void addProduct(){
        productService.addProduct();
    }
    public void updateProduct(){
        productService.updateProduct();
    }
}
