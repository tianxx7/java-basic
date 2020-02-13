package kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

/**
 * @author labvi
 * @version 1.0.0
 */
public class Consumer {
    public static void main(String[] args) {
        Properties config= Common.getKafkaConsumerConfig();
        KafkaConsumer<Object, Object> consumer = new KafkaConsumer<>(config);
        consumer.subscribe(Collections.singletonList("topic-demo"));
//        consumer.assign(Arrays.asList(new TopicPartition("topic-demo", 0)));
        for (int i = 0; i < 1; i++) {
            ConsumerRecords<Object, Object> records = consumer.poll(Duration.ofMillis(1000));
            records.forEach(record -> {
                System.out.println("topic = "+record.topic()+", partition = " + record.partition()+", offset="+record.offset());
                System.out.println("key = "+record.key()+", value = " + record.value());
            });
        }
        consumer.commitSync();
//        consumer.close();
    }
}
