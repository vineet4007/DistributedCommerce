package com.scaler.paymentservicejune25.controllers;

import com.scaler.paymentservicejune25.services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate/{orderId}")
    public String generatePaymentLink(@PathVariable("orderId") String orderId) throws StripeException {
        //Call OrderService API to get order details.

        return paymentService.generatePaymentLink(orderId);
    }
}
