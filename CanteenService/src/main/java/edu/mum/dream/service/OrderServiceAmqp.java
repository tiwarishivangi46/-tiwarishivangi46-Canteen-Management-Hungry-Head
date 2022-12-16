package edu.mum.dream.service;



import edu.mum.dream.domain.Order;
@FeignClient(value="feignDemo",url="https://localhost:3306/api")
public interface OrderServiceAmqp {
	
	public void publish(Order order);

}
