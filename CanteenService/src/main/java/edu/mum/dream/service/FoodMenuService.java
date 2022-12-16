package edu.mum.dream.service;

import java.util.List;

import edu.mum.dream.domain.FoodMenu;

@FeignClient(value="feignDemo",url="https://localhost:3306/api")
public interface FoodMenuService {
	
	public void save(FoodMenu foodMenu);
	public FoodMenu update(FoodMenu foodMenu);
	public List<FoodMenu> findAll();
	public FoodMenu findOne(Long id);
	public List<FoodMenu >findAllMenuByResturantID(Long resturantId);

}
