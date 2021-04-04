package model.geometry.objects;

import model.utils.Part;

import java.util.ArrayList;
import java.util.List;

public abstract class Solid {
    private List<Point> vertices;
    private List<Integer> indices;
    private List<Point> colors;
    private List<Double> textureCoordinates;
    private List<Part> parts;

    public Solid() {
        this.vertices = new ArrayList<>();
        this.indices = new ArrayList<>();
        this.colors = new ArrayList<>();
        this.textureCoordinates = new ArrayList<>();
        this.parts = new ArrayList<>();
    }

    public List<Point> getVertices() {
        return vertices;
    }

    public void setVertices(List<Point> vertices) {
        this.vertices = vertices;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public List<Point> getColors() {
        return colors;
    }

    public void setColors(List<Point> colors) {
        this.colors = colors;
    }

    public List<Double> getTextureCoordinates() {
        return textureCoordinates;
    }

    public void setTextureCoordinates(List<Double> textureCoordinates) {
        this.textureCoordinates = textureCoordinates;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }


}
