package org.example.pages;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.example.entities.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BasePage {
    @Inject
    private Session session;



    public List<Trip> getTripsByCategory(int categoryId) {
        Criteria criteria = session.createCriteria(Trip.class);
        criteria.add(Restrictions.eq("category", categoryId));
        return criteria.list();
    }

    public List<Trip> getTripsById(long id) {
        Criteria criteria = session.createCriteria(Trip.class);
        criteria.add(Restrictions.eq("id", id));
        return criteria.list();
    }

    public List<Trip> getTrips() {
        Criteria criteria = session.createCriteria(Trip.class);
        return criteria.list();
    }

    public List<Employee> getEmployees() {
        Criteria criteria = session.createCriteria(Employee.class);
        return criteria.list();
    }

    public List<Post> getPosts() {
        Criteria criteria = session.createCriteria(Post.class);
        return criteria.list();
    }

    public List<Post> getPostsById(Long id) {
        Criteria criteria = session.createCriteria(Post.class);
        criteria.add(Restrictions.eq("id", id));
        return criteria.list();
    }
    public List<Comment> getComments(){
        Criteria criteria = session.createCriteria(Comment.class);
        return criteria.list();
    }
    public List<Review> getReview() {
        Criteria criteria = session.createCriteria(Review.class);
        return criteria.list();
    }

    @CommitAfter
    public void saveObject(Object object) {
        session.persist(object);
    }
//    public List<Comment> getCommentsByPostId() {
//        Criteria criteria = session.createCriteria(Comment.class);
//        criteria.add(Restrictions.eq("post_id", ))
//        return criteria.list();
//    }
    @Inject
    @Symbol(SymbolConstants.CONTEXT_PATH)
    private String contextPath;

    public String getCssPath(){
        return this.contextPath + "/css";
    }
    public String getImagesPath(){
        return this.contextPath + "/images";
    }
    public String getFontsPath(){
        return this.contextPath + "/fonts";
    }
    public String getJsPath(){
        return this.contextPath + "/js";
    }


}
