package com.trainingproject.core.servlets;


import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=JSON path based servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/postservletexample" })
public class PostServletExample extends SlingAllMethodsServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        response.setContentType("Application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            // getParameterFromRequest

            String load = request.getParameter("load");

            JSONObject obj = new JSONObject(load);

            int firstNumber = obj.optInt("firstNumber");
            int secondNumber = obj.optInt("secondNumber");

            int sum = firstNumber+secondNumber;
            response.setStatus(SlingHttpServletResponse.SC_OK);
            response.getWriter().write("value of first number is"+ firstNumber+ "value of second number is" + secondNumber+ "value of sum is: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}

