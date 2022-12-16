package edu.mum.dream.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dream.dao.FoodMenuDao;
import edu.mum.dream.domain.FoodMenu;

@Repository
public class FoodMenuDaoImpl extends GenericDaoImpl<FoodMenu> implements FoodMenuDao {
	public FoodMenuDaoImpl() {
		super.setDaoType(FoodMenu.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodMenu> findAllMenuByCanteenID(Long canteenId) {

		Query query = entityManager
				.createQuery("select food from FoodMenu  food  " + "where food.canteenId =:canteenId");
		return (List<FoodMenu>) query.setParameter("canteenId", canteenId).getResultList();

	}

}
