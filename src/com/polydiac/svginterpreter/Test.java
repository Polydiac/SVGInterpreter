package com.polydiac.svginterpreter;

import sum.kern.Bildschirm;

import java.awt.*;

/**
 * Created by Sören on 09.03.2017.
 */
public class Test {
    public static void main(String[]args){
        Bildschirm bs = new Bildschirm();
        AdvStift st = new AdvStift();
        /*st.setzeFarbe("#e28356");
        st.bewegeBis(500, 500);
        st.drawBezierRel(117.14286, -84.28572, 270, -17.14286, 152.85714, 67.14288);
        st.hoch();
        st.bewegeBis(120,886.64792);
        st.runter();
        st.drawBezierRel(114.28571, -102.85714, 361.42857, 4.28571, 5.00, 2.00);
        st.setzeFarbe("#000000");
        st.bewegeBis(200, 400);
        st.drawEllipseF(40.0D, 100.0D);
        st.bewegeBis(500, 600);
        st.setzeFarbe(255, 10, 10);
        st.drawEllipseE(50.0D, 70.0D);
        st.bewegeBis(100, 300);
        System.out.print(st.hPosition() + " " + st.vPosition());
        st.drawEllipseE(100, 20);
        st.bewegeBis(500,500);
        st.drawBezierRel(-52.395147,134.88965, -68.002214,-44.59162);
        st.drawBezierRel(175.02211,-11.1479,72.66092,-42.78163, 85.11032,41.20022 );
        */
        /*st.hoch();
        st.bewegeBis(0,0);
        for (int i= 0; i<bs.breite();i=i+10){
            st.bewegeBis(i, 0);
            st.runter();
            st.bewegeBis(i, bs.hoehe());
            st.hoch();
        }
        for (int i= 0; i<bs.hoehe();i=i+10){
            st.bewegeBis(0, i);
            st.runter();
            st.bewegeBis(bs.breite(), i);
            st.hoch();
        }*/
        st.drawQuadBezier(100.0F, 100.0F, 200.0F, 400.00F, 300.0F, 300.0F);
        st.setzeFarbe("#0000FF");
        st.setzeLinienbreite(2);
        st.drawBezierAbs(100.0, 200.0, 300.0, 400.0, 200.0, 500.0);
        st.bewegeBis(100.0, 300.0);
        st.drawBezierRel(100.0, 300.0, 100.0, -100.0);
        st.bewegeBis(100, 400);
        st.drawBezierRel(100.0, 300.0, 100.0, -100.0, 100.0, 200.0);
        st.drawBezierAbs(21,168,57,16,119,16,215,84);
        st.bewegeBis(500, 500);
        st.drawEllipseE(200,100);
        st.runter();
        st.setzeFarbe(Color.black);
        st.bewegeBis(700, 500);
    }
}
