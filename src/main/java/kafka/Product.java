package kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author labvi
 * @version 1.0.0
 */
public class Product {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties config= Common.getKafkaProducerConfig();
        Producer<String,String> producer = new KafkaProducer<>(config);
        for (int i = 0; i < 5; i++) {
            //同步方式发送消息
            ProducerRecord<String,String> producerRecord = new ProducerRecord<>("topic-demo","hello kafka"+i);
            Future<RecordMetadata> future = producer.send(producerRecord);
            RecordMetadata recordMetadata = future.get();
            System.out.println(recordMetadata.topic()+"-"+recordMetadata.partition()+":"+recordMetadata.offset());
        }
        producer.close();
    }
}
