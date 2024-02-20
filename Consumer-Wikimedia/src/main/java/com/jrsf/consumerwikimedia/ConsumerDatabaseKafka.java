package com.jrsf.consumerwikimedia;

import com.jrsf.consumerwikimedia.entity.WikimediaData;
import com.jrsf.consumerwikimedia.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerDatabaseKafka {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerDatabaseKafka.class);

    private WikimediaDataRepository repository;

    public ConsumerDatabaseKafka(WikimediaDataRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String eventMessage) {
        LOGGER.info(String.format("Event message received data: -> %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiData(eventMessage);
        repository.save(wikimediaData);
    }
}
