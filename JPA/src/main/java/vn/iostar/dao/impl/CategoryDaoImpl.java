package vn.iostar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iostar.configs.JPAConfig;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.entity.Category;

public class CategoryDaoImpl implements ICategoryDao{
	@Override
	public void insert(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			
			enma.persist(category);
			trans.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			enma.close();
		}
	}
	
	@Override
	public void update(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			
			enma.merge(category);
			trans.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			enma.close();
		}
	}
	
	@Override
	public void delete(int cateid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			Category category = enma.find(Category.class, cateid);
			if(category != null) {
				enma.remove(category);
			}else {
				throw new Exception("Khong tim thay");
			}
			
			trans.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			enma.close();
		}
	}
	
	@Override
	public Category findById(int cateid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Category category = enma.find(Category.class, cateid);
		return category;
	}
	
	@Override
	public List<Category> findAll(){
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}
	
	@Override
	public List<Category> findByCategoryname(String name){
		EntityManager enma = JPAConfig.getEntityManager();
		String jpl = "Select c from Category c Where c.catename like :name";
		TypedQuery<Category> query = enma.createNamedQuery(jpl, Category.class);
		query.setParameter("catename", "%" + name + "%");
		return query.getResultList();
	}
	
	@Override
	public List<Category>findAll(int page, int pagesize){
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}
	
	@Override
	public int count() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "select count(c) from Category c";
		Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}
}