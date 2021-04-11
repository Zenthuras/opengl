package model.geometry.objects;

import model.geometry.topology.Vector3f;
import model.geometry.topology.Solid;
import model.utils.Part;
import model.utils.TypeTopology;

import java.util.Arrays;

// Krychle nebo kvádr
public class Cube extends Solid {
    public Cube() {
        super();
        init();
    }

    private void init() {
        getVertices().add(new Vector3f(-1.0f, 1.0f, 1.0f));
        getVertices().add(new Vector3f(-1.0f, -1.0f, 1.0f));
        getVertices().add(new Vector3f(1.0f, -1.0f, 1.0f));
        getVertices().add(new Vector3f(1.0f, 1.0f, 1.0f));

        getVertices().add(new Vector3f(-1.0f, 1.0f, -1.0f));
        getVertices().add(new Vector3f(-1.0f, -1.0f, -1.0f));
        getVertices().add(new Vector3f(1.0f, -1.0f, -1.0f));
        getVertices().add(new Vector3f(1.0f, 1.0f, -1.0f));


        getIndices().addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 4, 5, 2, 3, 6, 7, 0, 2, 4, 6, 1, 3, 5, 7));

        getColors().add(new Vector3f(1.0f, 0, 0));
        getColors().add(new Vector3f(0, 1.0f, 0));
        getColors().add(new Vector3f(0, 0, 1.0f));
        getColors().add(new Vector3f(1.0f, 1.0f, 0));
        getColors().add(new Vector3f(1.0f, 0, 1.0f));
        getColors().add(new Vector3f(0, 1.0f, 1.0f));

        getParts().add(new Part(TypeTopology.QUADS, 0, 6));
    }
}