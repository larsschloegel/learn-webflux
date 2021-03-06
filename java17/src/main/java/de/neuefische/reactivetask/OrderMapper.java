package de.neuefische.reactivetask;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
class OrderMapper {

	OrderDTO toOrderDTO(Order order) {
		return new OrderDTO(order.item().name(), order.payed(), order.price(), Map.of("self", "/api/orders/" + order.id(), "payment", "/api/orders/" + order.id() + "/payment"));
	}
	
	Order toOrder(OrderDTO orderDTO) {
		return new Order(null, Item.valueOf(orderDTO.item()), orderDTO.payed(), orderDTO.price());
	}
	
}
