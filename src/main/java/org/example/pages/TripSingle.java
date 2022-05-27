package org.example.pages;

import com.oracle.webservices.api.message.PropertySet;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.example.entities.Trip;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TripSingle extends BasePage {

    @Property
    private long tripId;
    @Inject
    private Session session;
    @Property
    private Trip trip;

    void onActivate(long tripId){
        this.tripId = tripId;
    }
    void onActivate(){

    }
    void setupRender(){
        if(tripId!=0){
            List<Trip> trips = null;
          trips = getTripsById(tripId);
            if(trips!= null && !trips.isEmpty()){
                trip = trips.get(0);
            }
        }
    }

    public String getBackgroundImage(){
        return "background-image:url('"+ getImagesPath() +"/fullImage/"+trip.getImage()+"')";
    }
}
