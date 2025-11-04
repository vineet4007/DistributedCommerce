package com.scaler.paymentservicejune25.services;

import com.stripe.exception.StripeException;

public interface PaymentService {
    String generatePaymentLink(String orderId) throws StripeException;
}
