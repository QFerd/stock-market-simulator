package com.revature.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository("gameRepository")
@Transactional
public class GameRepositoryImpl {

}

/*
 * public class UserRepositoryImpl implements UserRepository{
	
	private static Logger logger = Logger.getLogger(UserRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}
	
	@Override
	public void register(User user) {
		logger.info("Attempting to register user.");
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		logger.info("Attempting to list all users.");
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User getUser(String username) {
		try {
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("username", username))
					.list().get(0);
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}
	}

}
 */
