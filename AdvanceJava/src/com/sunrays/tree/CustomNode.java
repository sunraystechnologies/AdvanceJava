package com.sunrays.tree;

import java.util.ArrayList;

 /*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 * To change this template use Options | File Templates.
 */
public class CustomNode extends Node
{
    String tableContent = "This is Table data";

    public CustomNode()
    {
    }

    public CustomNode(String label, String link)
    {
        super(label, link);
    }

    public CustomNode(String label, String link, ArrayList children)
    {
        super(label, link, children);
    }

    public String getLabel()
    {
        StringBuffer sb = new StringBuffer(SPAN_BEGIN  + "<TABLE><TR><TD>" + super.getLabel()+"</TD>");
        sb.append("<TD>" +tableContent+"</TD></TR>" + SPAN_END);
        return sb.toString();
    }


}
