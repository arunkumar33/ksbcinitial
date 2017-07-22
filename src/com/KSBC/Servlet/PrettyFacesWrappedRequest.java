package com.KSBC.Servlet;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PrettyFacesWrappedRequest extends HttpServletRequestWrapper {private final Map<String, String[]> modifiableParameters;
private Map<String, String[]> allParameters = null;

/**
 * Create a new request wrapper that will merge additional parameters into
 * the request object without prematurely reading parameters from the
 * original request.
 * 
 * @param request
 * @param additionalParams
 */
public PrettyFacesWrappedRequest(final HttpServletRequest request, 
                                                final Map<String, String[]> additionalParams)
{
	
    super(request);
    modifiableParameters = new TreeMap<String, String[]>();
    System.out.println("Coming here 1");
    modifiableParameters.putAll(additionalParams);
}

@Override
public String getParameter(final String name)
{
    String[] strings = getParameterMap().get(name);
    if (strings != null)
    {
        return strings[0];
    } 
    
    System.out.println("Coming here 2");
   return super.getParameter(name);  //original
  //  return "arun";
} 

@Override
public Map<String, String[]> getParameterMap()
{
	System.out.println("Coming here 3");
    if (allParameters == null)
    {
        allParameters = new TreeMap<String, String[]>();
        allParameters.putAll(super.getParameterMap());
        allParameters.putAll(modifiableParameters);
    }
    //Return an unmodifiable collection because we need to uphold the interface contract.
    return Collections.unmodifiableMap(allParameters);
}

@Override
public Enumeration<String> getParameterNames()
{
	System.out.println("Coming here 4");
    return Collections.enumeration(getParameterMap().keySet());
}

@Override
public String[] getParameterValues(final String name)
{
	System.out.println("Coming here 5");
    return getParameterMap().get(name);
}}
