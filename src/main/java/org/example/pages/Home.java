package org.example.pages;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.http.Link;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.dao.TripDao;
import org.example.entities.Employee;
import org.example.entities.Post;
import org.example.entities.Trip;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class Home {
    @Property
    private List<Trip> allTrips;
    @Property
    private List<Employee> allEmployee;
    @Property
    private List<Post> allPost;
    @Property
    private Trip currentTrip;
    @Property
    private Employee currentEmployee;
    @Property
    private Post currentPost;
    @Inject
    private Session session;
    @Inject
    private PageRenderLinkSource linkSource;
    @Inject
    @Symbol(SymbolConstants.CONTEXT_PATH)
    private String contextPath;

    public List<Trip> getTrips(){
        Criteria criteria = session.createCriteria(Trip.class);
        return criteria.list();
    }
    public List<Employee> getEmployee(){
        Criteria criteria = session.createCriteria(Employee.class);
      return criteria.list();
    }
    public List<Post> getPost(){
        Criteria criteria = session.createCriteria(Post.class);
        return criteria.list();
    }

    public String getCssPath(){
        return this.contextPath + "/css";
    }

    void setupRender(){
        allTrips = getTrips();
        allEmployee = getEmployee();
        allPost = getPost();
    }
    public String getHomePage(){
        return "home";
    }
    public Link onActionFromShowTripDetails(long id){
        return linkSource.createPageRenderLinkWithContext(TripSingle.class, id);
    }
}
