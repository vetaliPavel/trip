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
    private Long tripId;
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
        if(tripId!=null){
            List<Trip> trips = null;
          trips = getTripsById(tripId);
            if(trips!= null && !trips.isEmpty()){
                trip = trips.get(0);
            }
        }
    }

    @Inject
    @Symbol(SymbolConstants.CONTEXT_PATH)
    private String contextPath;

    public String getCssPath(){
        return this.contextPath + "/css";
    }
    public String getImagesPath(){
        return this.contextPath + "/images";
    }
    public String getBackgroundImage(){
        return "background-image:url('"+ getImagesPath() +"/fullImage/"+trip.getImage()+"')";
    }
}
