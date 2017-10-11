package cn.seu.edu.spring.chapter11.hibernate4.hibernate4;

import cn.seu.edu.spring.chapter11.hibernate4.domain.Spitter;
import cn.seu.edu.spring.chapter11.hibernate4.repository.SpitterRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */
@Repository
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {
        Serializable id = currentSession().save(spitter);
        return new Spitter((Long) id,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
    }

    @Override
    public Spitter findOne(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession().createCriteria(Spitter.class)
                .add(Restrictions.eq("username", username))
                .list()
                .get(0);
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) currentSession().createCriteria(Spitter.class).list();
    }
}
