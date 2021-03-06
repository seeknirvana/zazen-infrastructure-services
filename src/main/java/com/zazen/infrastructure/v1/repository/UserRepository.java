package com.zazen.infrastructure.v1.repository;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zazen.infrastructure.v1.pojos.Location;
import com.zazen.infrastructure.v1.pojos.User;

@Component
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserRepository extends BaseRepository {
	
	@Transactional
	public User save(User user){
		User createdUser = (User) super.save(user);
		return createdUser;
	}
	
	public User findOne(String userUUID){
		User user = getSession().find(User.class, userUUID);
		return user;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> findAll(){
		Query query = getSession().createQuery("FROM "+ User.class.getName());
		return query.list();
	}
	
	public List<User> findAll(List<String> userUUIDs){
		Query query = getSession().createQuery(" FROM "+ User.class.getName() 
				+ " where id IN (:ids)")
				.setParameterList("id", userUUIDs);
				
		return query.list();
	}
	
	public List<User> findUserByLocation(String latitude, String longitude){
		//#TODO get the users by joining on location and matching passed in location and latitude
		Query query = getSession().createQuery("Select u FROM "+ User.class.getName() 
				+ " u inner join " +Location.class.getName()
				+ " l on  u.id = l.userId "
				+ "where l.latitude LIKE :latitude and l.longitude LIKE :longitude")
				.setParameter("latitude", "%"+latitude+'%')
				.setParameter("longitude", "%"+longitude+"%");
		return query.list();
	}
}
