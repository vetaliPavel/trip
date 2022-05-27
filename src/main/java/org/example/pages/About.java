package org.example.pages;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.example.entities.Employee;

import java.util.List;

public class About extends BasePage{
    public String getAboutPage(){
        return "about";
    }

    @Property
    private List<Employee> allEmployee;
    @Property
    private Employee currentEmployee;

    void setupRender(){
        allEmployee = getEmployees();
    }
}
