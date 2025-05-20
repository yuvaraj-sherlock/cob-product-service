package com.cob.product.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/validate-filter")
    public ResponseEntity<?> validateFilter(HttpServletRequest request){
        String role = (String) request.getAttribute("role");
        if(role.equalsIgnoreCase("ROLE_ADMIN")){
            return ResponseEntity.ok("You are allowed to access this API");
        }else{
            return ResponseEntity.ok("You are not allowed to access this API");
        }
    }
}
