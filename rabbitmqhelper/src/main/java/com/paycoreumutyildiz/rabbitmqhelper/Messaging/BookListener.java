package com.paycoreumutyildiz.rabbitmqhelper.Messaging;

import com.paycoreumutyildiz.rabbitmqhelper.Configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void printAverageBookPrice(List<Integer> prices){
        Integer total = prices.stream().reduce(0,(a,b) ->  a + b );
        Integer average = total / prices.size();
        System.out.println("Book prices average : " + average);
    }
}
