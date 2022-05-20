package org.example.pages;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.entities.Employee;
import org.example.entities.Post;
import org.example.entities.Trip;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BasePage {
    @Inject
    private Session session;


    public List<Trip> getTripsByCategory(int categoryId){
        Criteria criteria = session.createCriteria(Trip.class);
        criteria.add(Restrictions.eq("category", categoryId));
        return criteria.list();
    }
    public List<Trip> getTripsById(long id){
        Criteria criteria = session.createCriteria(Trip.class);
        criteria.add(Restrictions.eq("id", id));
        return criteria.list();
    }
    public List<Trip> getTrips(){
        Criteria criteria = session.createCriteria(Trip.class);
        return criteria.list();
    }

    public List<Employee> getEmployees(){
        Criteria criteria = session.createCriteria(Employee.class);
        return criteria.list();
    }
    public List<Post> getPosts(){
        Criteria criteria = session.createCriteria(Post.class);
        return criteria.list();
    }

}
