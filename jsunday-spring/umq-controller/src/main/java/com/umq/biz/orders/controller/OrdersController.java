package com.umq.biz.orders.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class OrdersController {

    @RequestMapping("/orderList")
    public String orderList(){

        return "orderList";
    }

}
