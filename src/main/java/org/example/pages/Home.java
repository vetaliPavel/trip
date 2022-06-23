package org.example.pages;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.http.Link;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.dao.TripDao;
import org.example.entities.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Home extends BasePage {
    public String getHomePage(){
        return "home";
    }

    @Property
    private List<Trip> allTrips;
    @Property
    private List<Employee> allEmployee;
    @Property
    private List<Post> allPost;
    @Property
    private List<Review> allReview;
    @Property
    private Review currentReview;
    @Property
    private Trip currentTrip;
    @Property
    private Employee currentEmployee;
    @Property
    private Post currentPost;
    public static final int CATEGORY_MOUNTAINS = 1;
    @Inject
    private PageRenderLinkSource linkSource;
    @Inject
    @Symbol(SymbolConstants.CONTEXT_PATH)
    private String contextPath;

    void setupRender(){
        allTrips = getTripsByCategory(CATEGORY_MOUNTAINS);
        allEmployee = getEmployees();
        allPost = getPosts();
        allReview = getReview();
    }
    public Link onActionFromShowTripDetails(long id){
        return linkSource.createPageRenderLinkWithContext(TripSingle.class, id);
    }
    public Link onActionFromShowPostDetails(long id) {
        return linkSource.createPageRenderLinkWithContext(Single.class, id);
    }






}
