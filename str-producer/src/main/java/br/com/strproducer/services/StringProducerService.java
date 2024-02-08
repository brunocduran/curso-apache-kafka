package br.com.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("str-topic", message);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Error send message: {}", ex.getMessage());
                return;
            }
            log.info("Send message with success: {}", result.getProducerRecord().value());
            log.info(
                    "Partition {}, Offset {}",
                    result.getRecordMetadata().partition(),
                    result.getRecordMetadata().offset()
            );
        });
    }
}
