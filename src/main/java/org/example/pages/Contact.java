package org.example.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.example.entities.FeedBack;

public class Contact extends BasePage {
    public String getContactPage() {
        return "contact";
    }
    @Component(id="contactForm")
private Form contactForm;

    @Persist
    @Property
    private FeedBack feedBack;

    void setupRender() {
        feedBack = new FeedBack();
    }
public void onValidateFromContactForm(){
        if(feedBack.getEmail() == null){
            contactForm.recordError("Enter your email");
        }else if(!feedBack.getEmail().contains("@")){
            contactForm.recordError("Email is not valid");
        }
    }

    public void onSuccessFromContactForm() {
        saveObject(feedBack);
    }

}
