package vn.iostar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import vn.iostar.configs.JPAConfig;
import vn.iostar.dao.IUserDao;
import vn.iostar.entity.User;


public class UserDaoImpl implements IUserDao{

	@Override
	public List<User> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findById(int id) {
		
		EntityManager enma = JPAConfig.getEntityManager();
		User user = enma.find(User.class,id);
		return user;
	}

	@Override
	public void insert(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			
			enma.persist(user);
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
	public User findByUserName(String username) {
		EntityManager enma = JPAConfig.getEntityManager();
		User user = enma.find(User.class, username);
		return user;
	}

	@Override
	public boolean checkExistUsername(String username) {
		  EntityManager enma = JPAConfig.getEntityManager();
	        TypedQuery<Long> query = enma.createNamedQuery("User.findByUsername", Long.class);
	        query.setParameter("username", username);
	        Long count = query.getSingleResult();
	        return count > 0;
		
	}

	@Override
	public User checkExistEmail(String email) {
		EntityManager enma = JPAConfig.getEntityManager();
	    TypedQuery<User> query = enma.createNamedQuery("User.findByEmail", User.class);
	    query.setParameter("email", email);

	    try {
	        return query.getSingleResult();
	        } catch (NoResultException e) {
	        return null; 
	    } finally {
	        enma.close();
	    }
	}

	@Override
	public boolean checkExistPhone(String phone) {
		EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Long> query = enma.createNamedQuery("User.findByPhone", Long.class);
        query.setParameter("phone", phone);
        Long count = query.getSingleResult();
        return count > 0;
	}

	@Override
	public boolean updatePassword(String email, String password) {
		EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();
            TypedQuery<User> query = enma.createQuery("User.findByEmail", User.class);
            query.setParameter("email", email);
            User user = query.getSingleResult();
            if (user != null) {
                user.setPassword(password);
                enma.merge(user);
                trans.commit();
                return true;
            } else {
                trans.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return false;
        } finally {
            enma.close();
        }
	}

	@Override
	public int editProfile(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();
            enma.merge(user);
            trans.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return 0;
        } finally {
            enma.close();
        }

	}

	@Override
	public User findByEmail(String email) {
		EntityManager enma = JPAConfig.getEntityManager();
		User user = enma.find(User.class,email);
		return user;
	}
	
}
