package com.sunrays.tree;

import java.util.ArrayList;

 /*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 * To change this template use Options | File Templates.
 */

public class Node
{
    private String label;
    private String link;
    private ArrayList children;

    public static String SPAN_BEGIN = "<span style=\"position:relative; border-style:double; overflow:scroll; width:90%; vertical-align:top\">";
    public static String SPAN_END = "</span>";

    public Node()
    {

    }

    public Node(String label, String link)
    {
        this(label,link,null);
    }

    public Node(String label, String link,ArrayList children)
    {
        this.children = children;
        this.label = label;
        this.link = link;
    }


    public ArrayList getChildren()
    {
        return children;
    }

    public void setChildren(ArrayList children)
    {
        this.children = children;
    }

    public void resetChildren()
    {
        this.children = new ArrayList();
    }

    public void addChild(Node node)
    {
        if(children == null) children = new ArrayList();
        children.add(node);
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public boolean isLeaf()
    {
        return (children == null || children.size() == 0);

    }


    public String toString()
    {
        //['Level 1 Item 0', 'links.html'],

        StringBuffer sb = null;

        if ( "0".equals(getLink()))
        {
            sb = new StringBuffer(" ['"+getLabel()+"', "+getLink() );
        }
        else
        {
            sb = new StringBuffer(" ['"+getLabel()+"', '"+getLink()+ "'");
        }

        if (children != null)
        {
            int size = children.size();
            for(int i=0;i< size;i++)
            {
                sb.append( ","+ children.get(i).toString());
            }
        }
        sb.append("] ");
        return sb.toString();
    }

    public static String getTree(Node node)
    {
        return "[" + node.toString() + "]";
    }

}
