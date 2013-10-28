package com.sunrays.tree;


 /*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 * To change this template use Options | File Templates.
 */

public class Test
{
    public static void main(String[] args)
    {
        Node root = new Node("Root","http://www.yahoo.com");

        Node home = new Node("Home","http://www.homr.com");
        Node Disney = new Node("Disney","http://www.disney.com");

        root.addChild(home);
        root.addChild(Disney);

        Node service = new Node("Service","http://www.softcomplex.com/services.html");
        Node Download = new Node("Download","http://www.softcomplex1.com/services.html");
        Node Order = new Node("Order","http://www.softcomplex2.com/services.html");
        Node Support = new Node("Support","http://www.softcomplex3.com/services.html");

        home.addChild(service);
        home.addChild(Download);
        home.addChild(Order);
        home.addChild(Support);

        /*

        ['Level 1 Item 1', 0,
			['Level 2 Item 0', 'links.html'],
			['Level 2 Item 1', 0],
        */

        Node level110 = new Node("Level 1 Item 1","0");
        Node level200 = new Node("Level 2 Item 0","links.html");
        Node level210 = new Node("Level 2 Item 1","0");
        CustomNode level220 = new CustomNode("Level 2 Item 2","0");

        level110.addChild(level200);
        level110.addChild(level210);
        level110.addChild(level220);

        service.addChild(level110);

        Disney.addChild(level110);

        System.out.println(Node.getTree(root));

    }

}
