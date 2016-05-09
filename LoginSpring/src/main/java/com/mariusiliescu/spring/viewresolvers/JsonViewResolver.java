package com.mariusiliescu.spring.viewresolvers;

import java.util.Locale;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Component
public class JsonViewResolver implements ViewResolver {

    public View resolveViewName(String viewName, Locale locale) throws Exception {
        MappingJacksonJsonView view = new MappingJacksonJsonView();
       // view.setPrettyPrint(true);    
        return view;
    }
}