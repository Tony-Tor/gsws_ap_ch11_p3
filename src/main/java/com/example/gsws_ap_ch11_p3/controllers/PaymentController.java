package com.example.gsws_ap_ch11_p3.controllers;

import com.example.gsws_ap_ch11_p3.restTemplate.PaymentProxy;
import com.example.gsws_ap_ch11_p3.model.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        return  paymentProxy.createPayment(payment);
    }
}
