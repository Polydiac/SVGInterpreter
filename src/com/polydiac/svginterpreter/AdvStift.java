package com.polydiac.svginterpreter;

import sum.kern.*;

import java.awt.*;
import java.awt.geom.*;

/**
 * Created by Sören on 09.03.2017.
 */
public class AdvStift extends Buntstift{

    public AdvStift() {
        super();
    }

    public AdvStift(Fenster pFenster) {
        super(pFenster);
    }

    public void drawBezierAbs(double x1, double y1, double cx1, double cy1, double cx2, double cy2, double x2, double y2){
        Point2D.Double p0 = new Point2D.Double(x1, y1);
        Point2D.Double p1 = new Point2D.Double(cx1, cy1);
        Point2D.Double p2 = new Point2D.Double(cx2, cy2);
        Point2D.Double p3 = new Point2D.Double(x2, y2);


        Point2D.Double[] points = {p0, p1, p2, p3};
        double SEGMENT_COUNT = calcSubdivision(points);
        Point2D.Double q0 = calcBezier(points, 0);
        for(int i = 1; i <= SEGMENT_COUNT; i++)
        {
            double t = i / SEGMENT_COUNT;
            Point2D.Double q1 = calcBezier(points, t);
            this.zeichneLinie(q0, q1);
            q0 = q1;
        }
        this.zStiftV = p3.x;
        this.zStiftH = p3.y;
    }

    public void drawBezierRel( double cx1, double cy1, double cx2, double cy2, double x2, double y2){

        Point2D.Double p0 = new Point2D.Double(this.zStiftH, this.zStiftV);
        Point2D.Double p1 = new Point2D.Double(p0.x + cx1, p0.y + cy1);
        Point2D.Double p2 = new Point2D.Double(p1.x + cx2, p1.y + cy2);
        Point2D.Double p3 = new Point2D.Double(p2.x + x2, p2.y + y2);


        Point2D.Double[] points = {p0, p1, p2, p3};
        double SEGMENT_COUNT = calcSubdivision(points);
        Point2D.Double q0 = calcBezier(points, 0);
        for(int i = 1; i <= SEGMENT_COUNT; i++)
        {
            double t = i / SEGMENT_COUNT;
            Point2D.Double q1 = calcBezier(points, t);
            this.zeichneLinie(q0, q1);
            q0 = q1;
        }
        this.zStiftV = p3.x;
        this.zStiftH = p3.y;
    }
    public void drawBezierAbs(double x1, double y1, double cx1, double cy1, double x2, double y2){

        Point2D.Double p0 = new Point2D.Double(x1, y1);
        Point2D.Double p1 = new Point2D.Double(cx1, cy1);
        Point2D.Double p2 = new Point2D.Double(x2, y2);


        Point2D.Double[] points = {p0, p2, p1};
        double SEGMENT_COUNT = calcSubdivision(points);
        Point2D.Double q0 = calcBezier(points, 0);
        for(int i = 1; i <= SEGMENT_COUNT; i++)
        {
            double t = i / SEGMENT_COUNT;
            Point2D.Double q1 = calcBezier(points, t);
            this.zeichneLinie(q0, q1);
            q0 = q1;
        }
        this.zStiftV = p2.x;
        this.zStiftH = p2.y;
    }

    public void drawBezierRel( double cx1, double cy1, double x2, double y2){

        Point2D.Double p0 = new Point2D.Double(this.zStiftH, this.zStiftV);
        Point2D.Double p1 = new Point2D.Double(p0.x + cx1, p0.y + cy1);
        Point2D.Double p2 = new Point2D.Double(p1.x + x2, p1.y + y2);


        Point2D.Double[] points = {p0, p1, p2};
        double SEGMENT_COUNT = calcSubdivision(points);
        Point2D.Double q0 = calcBezier(points, 0);
        for(int i = 1; i <= SEGMENT_COUNT; i++)
        {
            double t = i / SEGMENT_COUNT;
            Point2D.Double q1 = calcBezier(points, t);
            this.zeichneLinie(q0, q1);
            q0 = q1;
        }
        this.zStiftV = p2.x;
        this.zStiftH = p2.y;
    }


    public void drawEllipseF(double rx, double ry) {
        Graphics2D g = (Graphics2D)this.get2DGraphics(this.kenntPrivatschirm.getGraphics()).create();
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(hints);
        if(g != null) {
            this.setzeZustand(g);
            g.fill(new java.awt.geom.Ellipse2D.Double(this.zStiftV - rx, this.zStiftH - ry, 2.0D * rx, 2.0D * ry));
        }
    }
    public void drawEllipseE(double rx, double ry) {
        Graphics2D g = (Graphics2D)this.get2DGraphics(this.kenntPrivatschirm.getGraphics()).create();
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(hints);
        if(g != null) {
            this.setzeZustand(g);
            g.draw(new java.awt.geom.Ellipse2D.Double(this.zStiftV - rx, this.zStiftH - ry, 2.0D * rx, 2.0D * ry));
        }
    }

    public void setzeFarbe(int r, int g, int b) {
        Color c = new Color(r,g,b);
        this.setzeFarbe(c);
    }
    public void setzeFarbe(int r, int g, int b, int a) {
        Color c = new Color(r,g,b,a);
        this.setzeFarbe(c);
    }
    public void setzeFarbe(String hex){

        Color c = Color.decode(hex);
        this.setzeFarbe(c);
    }
    public void drawQuadBezier(float x1,float y1, float cx, float cy, float x2, float y2){
        Graphics2D g2 = this.get2DGraphics(this.kenntPrivatschirm.getGraphics());
        QuadCurve2D.Float q = new QuadCurve2D.Float(x1, y1, cx, cy, x2, y2);
        g2.draw(q);
    }

    protected void zeichneLinie(double x1, double y1, double x2, double y2) {
        Graphics2D g = (Graphics2D)this.get2DGraphics(this.kenntPrivatschirm.getGraphics()).create();
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(hints);
        if(g != null) {
            this.setzeZustand(g);
            g.draw(new java.awt.geom.Line2D.Double(x1, y1, x2, y2));
        }
        g.dispose();

    }

    protected void zeichneLinie(Point2D p0, Point2D p1) {
        Graphics2D g = (Graphics2D) this.get2DGraphics(this.kenntPrivatschirm.getGraphics()).create();
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(hints);
        if (g != null) {
            this.setzeZustand(g);
            g.draw(new java.awt.geom.Line2D.Double(p0.getX(), p0.getY(), p1.getX(), p1.getY()));
        }
        g.dispose();
    }
    protected Point2D.Double calcBezier(Point2D.Double[] points, double t){
        if(points.length==1){
            return new Point2D.Double(points[0].x, points[0].y);
        }
        else {
            Point2D.Double[] newpoints = new Point2D.Double[points.length-1];
            for(int i=0; i < newpoints.length; i++){
                double x = (1-t) * points[i].x + t * points[i + 1].x;
                double y = (1-t) * points[i].y + t * points[i + 1].y;
                newpoints[i] = new Point2D.Double(x,y);
            }
            return this.calcBezier(newpoints, t);
        }
    }

    protected double calcSubdivision(Point2D[] points){
        double estimatedLength = 0;
        for(int i = 1; i<points.length-1; i++) {
            estimatedLength = estimatedLength + Math.sqrt(Math.pow(points[i].getX() - points[i-1].getX(), 2) + Math.pow(points[i].getY() - points[i-1].getY(), 2));
        }
        double NoLessThan = 23.5;
        double segs = estimatedLength/50.0;

        return Math.ceil(Math.sqrt(segs*segs*0.6 + NoLessThan*NoLessThan));
    }

    public void bewegeUm(double pDistanz, double pRichtung){
        double w = pRichtung * 3.141592653589793D / 180.0D;
        double x = this.zStiftH + pDistanz * Math.cos(w);
        double y = this.zStiftV - pDistanz * Math.sin(w);
        if(!this.zHoch) {
            this.zeichneLinie(this.zStiftH, this.zStiftV, x, y);
        }

        this.zStiftH = x;
        this.zStiftV = y;
    }

}