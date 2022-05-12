package org.example.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.http.Link;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.dao.TripDao;
import org.example.entities.Trip;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class Home {
    @Property
    private List<Trip> allTrips;
    @Property
    private Trip currentTrip;
    @Inject
    private Session session;
    @Inject
    private PageRenderLinkSource linkSource;

    public List<Trip> getTrips(){
        Criteria criteria = session.createCriteria(Trip.class);
        return criteria.list();
    }


    void setupRender(){
        allTrips = getTrips();
    }
    public String getHomePage(){
        return "home";
    }
    public Link onActionFromShowTripDetails(long id){
        return linkSource.createPageRenderLinkWithContext(TripSingle.class, id);
    }
}
