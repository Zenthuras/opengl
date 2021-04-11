package model.geometry.topology;

import model.utils.Part;

import java.util.ArrayList;
import java.util.List;

// Obecné těleso pro všechny topologie
public abstract class Solid {
    private List<Vector3f> vertices;
    private List<Integer> indices;
    private List<Vector3f> colors;
    private List<Float> textureCoordinates;
    private List<Part> parts;

    public Solid() {
        this.vertices = new ArrayList<>();
        this.indices = new ArrayList<>();
        this.colors = new ArrayList<>();
        this.textureCoordinates = new ArrayList<>();
        this.parts = new ArrayList<>();
    }

    public List<Vector3f> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vector3f> vertices) {
        this.vertices = vertices;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public List<Vector3f> getColors() {
        return colors;
    }

    public void setColors(List<Vector3f> colors) {
        this.colors = colors;
    }

    public List<Float> getTextureCoordinates() {
        return textureCoordinates;
    }

    public void setTextureCoordinates(List<Float> textureCoordinates) {
        this.textureCoordinates = textureCoordinates;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }


}
