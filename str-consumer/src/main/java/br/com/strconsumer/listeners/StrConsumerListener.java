package br.com.strconsumer.listeners;

import br.com.strconsumer.custom.StrConsumerCustomListner;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    //Configuracao antes de criar a anotacao personalizada
    /*@KafkaListener(groupId = "group-1",
            topicPartitions = {
                @TopicPartition(topic = "str-topic", partitions = {"0"})
            },
            containerFactory = "strContainerFactory")
    public void create(String message){
        log.info("CREATE ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic = "str-topic", partitions = {"1"})
            },
            containerFactory = "strContainerFactory")
    public void log(String message){
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
    public void history(String message){
        log.info("HISTORY ::: Receive message {}", message);
    }*/

    @StrConsumerCustomListner(groupId = "group-1")
    public void create(String message){
        log.info("CREATE ::: Receive message {}", message);
    }

    @StrConsumerCustomListner(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: Receive message {}", message);
    }

    @StrConsumerCustomListner(groupId = "group-2")
    public void history(String message){
        log.info("HISTORY ::: Receive message {}", message);
    }
}
