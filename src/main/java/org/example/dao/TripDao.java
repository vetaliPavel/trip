package org.example.dao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.entities.Trip;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TripDao {

    public static Session getCurrentSessionFromConfig() {
        // SessionFactory in Hibernate 5 example
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
    public List<Trip> getTrips(){
        Session session = null;
        try {
            session =  getCurrentSessionFromConfig();
            Criteria criteria = session.createCriteria(Trip.class);
            List<Trip> trips = criteria.list();
            return criteria.list();
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }
    // запрос к базе данных о поля "username"
//    public List<Users> getUserByUsername(String userName) {
//        List<Users> userAll = null;
//        Criteria criteria = session.createCriteria(Users.class);
//        criteria.add(Restrictions.like("username", userName));
//        userAll = criteria.list();
//        return userAll;
//    }
}
