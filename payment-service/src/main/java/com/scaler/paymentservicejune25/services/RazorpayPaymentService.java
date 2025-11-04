package com.scaler.paymentservicejune25.services;

import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentService implements PaymentService {
    @Override
    public String generatePaymentLink(String orderId) {
        return "Razorpay not supported yet!";
    }
}
