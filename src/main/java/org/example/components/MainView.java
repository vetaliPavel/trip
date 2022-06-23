package org.example.components;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;

public class MainView {
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
