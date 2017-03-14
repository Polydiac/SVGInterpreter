package com.polydiac.svginterpreter.Shapes;

import com.polydiac.svginterpreter.AdvStift;

import java.awt.geom.Point2D;

/**
 * Created by Sören on 12.03.2017.
 */
public class Shape {
    Point2D pos;
    String id;
    AdvStift st;
    String fill;
    String stroke;
    int stroke_width;


    public Shape(double xp, double yp, String ids){
        pos = new Point2D.Double(xp, yp);
        id = ids;
        st = new AdvStift();
    }

    public void setStyle(String style){
        String[] styles = style.split(";");
        for (String stylei: styles) {
            String[] sty = stylei.split(":");
            switch(sty[0]){
                case "fill":
                    this.fill = sty[1];
                    break;
                case "stroke":
                    this.stroke = sty[1];
                    break;
                case "stroke-width":
                    this.stroke_width = Integer.parseInt(sty[1]);
                    break;
                default:
                    continue;
            }

        }
    }

    public void draw(){

    }
    public void delete(){
        st.radiere();
        this.draw();
        st.normal();
    }
    public void translate(double transx, double transy){
        pos.setLocation(pos.getX() + transx, pos.getY() + transy);
    }
    public void scale(){

    }
    public void rotate(double angle){

    }
    public void rotate(double angle, Point2D center) {

    }
}
