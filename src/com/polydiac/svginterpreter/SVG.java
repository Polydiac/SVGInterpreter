package com.polydiac.svginterpreter; /**
 * Created by Sören on 08.03.2017.
 */

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SVG{
    public File file;
    private Document doc;
    String id;
    String width;
    String height;
    public ShapeList shapes = new ShapeList();

    public SVG(){

    }

    public void read(String stfile){
        try {
            this.file = new File(stfile);
            if ( this.file.exists()) {
                DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                this.doc = docBuilder.parse(this.file);
            }
            else {
                System.out.println("file does not exist");
            }


        }catch (SAXParseException err) {
            System.out.println ("** Parsing error" + ", line "
                    + err.getLineNumber () + ", uri " + err.getSystemId ());
            System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
            Exception x = e.getException ();
            ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
            t.printStackTrace ();
        }

    }

    public Document getDoc(){
        return this.doc;
    }
    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public void printDOM() {
        String docstring = this.doc.toString();
        System.out.print(docstring);
    }

    public void parse(){
        NodeList rootnode = this.doc.getElementsByTagName("svg");
        for (int i = 0; i<rootnode.getLength();i++){
            NamedNodeMap svg = rootnode.item(i).getAttributes();
            this.id = svg.getNamedItem("id").getNodeValue();
            this.width = svg.getNamedItem("width").getNodeValue();
            this.height = svg.getNamedItem("height").getNodeValue();
        }
        NodeList groups = this.doc.getElementsByTagName("g");
        for (int i = 0; i<groups.getLength(); i++) {
            Node group = groups.item(i);
            ShapeList groupL = new ShapeList(group.getAttributes().getNamedItem("id").toString());
            for (int y = 0; y<group.getChildNodes().getLength(); i++){
                NodeList =
            }

        }
    }

}
