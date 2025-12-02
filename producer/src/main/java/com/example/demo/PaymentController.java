package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping()
    public String registrarVenda(@RequestBody String venda) {
        kafkaTemplate.send("stock-topic", venda);
        return "Venda registrada com sucesso!";
    }
}