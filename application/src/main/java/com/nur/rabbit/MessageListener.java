package com.nur.rabbit;

import com.nur.model.Property;
import com.nur.repositories.PropertyRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MessageListener {

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	RabbitTemplate template;

	@RabbitListener(queues = Config.QUEUE)
	public void listener(Response message) {
		try {
			if (Objects.isNull(message))
				return;
			Property property = propertyRepository.findPropertyById(message.getData().getId());
			Pattern pattern = Pattern.builder().cmd(Config.EXCHANGE).build();
			CustomMessage customMessage = CustomMessage.builder().id(property.getUserId())
					.message("Property reserve success").build();
			Response customMessage2 = Response.builder().pattern(pattern).data(customMessage).build();
			template.convertAndSend(Config.EXCHANGE, customMessage2);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}