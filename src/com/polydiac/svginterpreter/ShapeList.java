package com.polydiac.svginterpreter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sören on 14.03.2017.
 */
public class ShapeList extends ArrayList{

    public String id;

    public ShapeList(int initialCapacity) {
        super(initialCapacity);
    }

    public ShapeList() {
    }

    public ShapeList(Collection c) {
        super(c);
    }

    public ShapeList(String id){
        this.id = id;
    }

}
