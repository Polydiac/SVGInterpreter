package com.polydiac.svginterpreter; /**
 * Created by Sören on 08.03.2017.
 */
import org.apache.batik.util.XMLResourceDescriptor;
import org.apache.xml.utils.URI;
import org.w3c.dom.Document;


import java.io.IOException;

public class Svg {
    private Document doc;
    public Svg() {

    }
    /*public void readFile(URI file) {
        try {
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
            String uri = "http://www.example.org/diagram.svg";
            Document doc = f.createDocument(uri);
        } catch (IOException ex) {
            // ...
        }
    }*/
    public void draw() {

    }
}
