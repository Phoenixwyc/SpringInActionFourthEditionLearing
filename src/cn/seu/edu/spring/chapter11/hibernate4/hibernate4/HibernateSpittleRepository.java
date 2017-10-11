package cn.seu.edu.spring.chapter11.hibernate4.hibernate4;

import cn.seu.edu.spring.chapter11.hibernate4.domain.Spittle;
import cn.seu.edu.spring.chapter11.hibernate4.repository.SpittleRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */
@Repository
public class HibernateSpittleRepository implements SpittleRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpittleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Spittle> findRecent(int count) {
        return (List<Spittle>) spittleCriteria()
                .setMaxResults(count)
                .list();
    }

    @Override
    public Spittle findOne(long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }

    @Override
    public Spittle save(Spittle spittle) {
        Serializable id = currentSession().save(spittle);
        return new Spittle((Long)id,
                spittle.getSpitter(),
                spittle.getMessage(),
                spittle.getPostedTime());
    }

    @Override
    public List<Spittle> findBySpitterId(long spitterId) {
        return (List<Spittle>) spittleCriteria()
                .add(Restrictions.eq("spitter.id", spitterId)).list();
    }

    @Override
    public void delete(long id) {
        currentSession().delete(findOne(id));
    }

    public List<Spittle> findAll() {
        return (List<Spittle>) spittleCriteria().list();
    }

    private Criteria spittleCriteria() {
        return currentSession()
                .createCriteria(Spittle.class)
                .addOrder(Order.desc("postedTime"));
    }
}
