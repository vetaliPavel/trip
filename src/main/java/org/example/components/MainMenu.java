package org.example.components;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

public class MainMenu {
    @Parameter
    private String activeMenu;

    void setupRender() {

    }
    public String getHomePage(){
        return "home";
    }
    public String getTripsPage(){
        return "trips";
    }
    public String getBlogPage(){
        return "blog";
    }
    public String getContactPage(){
        return "contact";
    }
    public String getAboutPage(){
        return "about";
    }

    public String getHomeCssClass() {
        return activeMenu!= null && activeMenu.equals("home") ? "active" : "";
    }

    public String getTripsCssClass() {
        return activeMenu!= null && activeMenu.equals("trips") ? "active" : "";
    }

    public String getBlogCssClass(){
        return activeMenu!= null && activeMenu.equals("blog") ? "active" : "";
    }
    public String getAboutCssClass(){
        return activeMenu!= null && activeMenu.equals("about") ? "active" : "";
    }
    public String getContactCssClass(){
        return activeMenu!= null && activeMenu.equals("contact") ? "active" : "";
    }
}