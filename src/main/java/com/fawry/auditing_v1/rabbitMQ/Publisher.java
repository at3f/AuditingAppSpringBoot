package com.fawry.auditing_v1.rabbitMQ;

import com.fawry.auditing_v1.dtos.ActionDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(ActionDto actionDto) {
        rabbitTemplate.convertAndSend(this.queue.getName(), actionDto);
    }
}
