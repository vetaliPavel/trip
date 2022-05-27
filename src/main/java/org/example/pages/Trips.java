package org.example.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.http.Link;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.entities.Trip;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Trips extends BasePage{

    public String getTripsPage(){
        return "trips";
    }

    @Property
    private List<Trip> allTrips;
    @Property
    private Trip currentTrip;

    @Inject
    private PageRenderLinkSource linkSource;
    public static final int CATEGORY_SEA = 2;



    void setupRender() {
        allTrips = getTripsByCategory(CATEGORY_SEA);
    }
    public Link onActionFromShowTripDetails(long id){
        return linkSource.createPageRenderLinkWithContext(TripSingle.class, id);
    }


}
