package com.polydiac.svginterpreter.Shapes;

/**
 * Created by Sören on 12.03.2017.
 */
public class Rect extends Shape{
    double width;
    double height;

    public Rect(double xp, double yp, String ids, double pwidth, double pheight){
        super(xp, yp, ids);
        width = pwidth;
        height = pheight;
    }

    public void draw(){
        st.bewegeBis(this.pos.getX(), this.pos.getY());
    }


}
