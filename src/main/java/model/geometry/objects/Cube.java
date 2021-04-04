package model.geometry.objects;

import model.utils.Part;
import model.utils.TypeTopology;

import java.util.Arrays;

public class Cube extends Solid {
    public Cube() {
        super();
        init();
    }

    private void init() {
        getVertices().add(new Point(-1.0d, 1.0d, 1.0d));
        getVertices().add(new Point(-1.0d, -1.0d, 1.0d));
        getVertices().add(new Point(1.0d, -1.0d, 1.0d));
        getVertices().add(new Point(1.0d, 1.0d, 1.0d));

        getVertices().add(new Point(-1.0d, 1.0d, -1.0d));
        getVertices().add(new Point(-1.0d, -1.0d, -1.0d));
        getVertices().add(new Point(1.0d, -1.0d, -1.0d));
        getVertices().add(new Point(1.0d, 1.0d, -1.0d));


        getIndices().addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 4, 5, 2, 3, 6, 7, 0, 2, 4, 6, 1, 3, 5, 7));

        getColors().add(new Point(1.0d, 0, 0));
        getColors().add(new Point(0, 1.0d, 0));
        getColors().add(new Point(0, 0, 1.0d));
        getColors().add(new Point(1.0d, 1.0d, 0));
        getColors().add(new Point(1.0d, 0, 1.0d));
        getColors().add(new Point(0, 1.0d, 1.0d));

        getParts().add(new Part(TypeTopology.QUADS, 0, 6));
    }
}