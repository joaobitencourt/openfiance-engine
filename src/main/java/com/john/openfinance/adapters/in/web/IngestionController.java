package com.john.openfinance.adapters.in.web;

import com.john.openfinance.adapters.in.web.dto.RawBankTransaction;
import com.john.openfinance.adapters.out.kafka.TransactionProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ingestion")
public class IngestionController {

    private final TransactionProducer producer;

    public IngestionController(TransactionProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/simulate")
    public ResponseEntity<String> simulateBankWebhook(@RequestBody RawBankTransaction payload) {
        // Em um cenário real, aqui teríamos validações de segurança e autenticação do banco

        // Enviamos a transação para a fila do Kafka
        producer.sendRawTransaction(payload);

        return ResponseEntity.accepted().body("Transação recebida e enfileirada para processamento com sucesso!");
    }

}
