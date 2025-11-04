package com.scaler.paymentservicejune25.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks")
public class WebhookController {

    // http://localhost:8080/webhooks/trigger
    @GetMapping("/trigger")
    public void triggerWebhook() {
        System.out.println("Webhook triggered!");
    }
}
