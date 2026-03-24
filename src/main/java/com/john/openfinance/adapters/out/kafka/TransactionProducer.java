package com.john.openfinance.adapters.out.kafka;

import com.john.openfinance.adapters.in.web.dto.RawBankTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class TransactionProducer {

    private static final Logger log = LoggerFactory.getLogger(TransactionProducer.class);
    private static final String TOPIC = "raw-transactions-topic";

    // O Spring injeta automaticamente o KafkaTemplate configurado
    private final KafkaTemplate<String, RawBankTransaction> kafkaTemplate;

    public TransactionProducer(KafkaTemplate<String, RawBankTransaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRawTransaction(RawBankTransaction transaction) {
        log.info("Enviando transação [{}] do banco {} para o Kafka...",
                transaction.transactionId(), transaction.bankCode());

        // Envia para o tópico. A chave (opcional) ajuda a manter a ordem das mensagens
        // Vamos usar o bankCode como chave para ilustrar
        kafkaTemplate.send(TOPIC, transaction.bankCode(), transaction);
    }

}
