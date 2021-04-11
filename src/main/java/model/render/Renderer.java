package model.render;

import model.geometry.scene.Transformer;
import model.geometry.objects.Cube;
import model.geometry.topology.Solid;
import model.utils.Part;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

// Vykreslení scény
public class Renderer {
    private List<Solid> solids;

    public Renderer() {
        initSolids();
    }

    private void initSolids() {
        solids = new ArrayList<>();
        Cube cube = new Cube();
        Transformer transformer = new Transformer(cube.getVertices());
        transformer.scale(0.5);
        solids.add(cube);
    }

    public void render() {
        render(getSolids());
    }

    private void render(List<Solid> solids) {
        for (Solid solid : solids) {
            render(solid);
        }
    }

    private void render(Solid solid) {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        for (Part part : solid.getParts()) {
            switch (part.getType()) {
                case QUADS -> {
                    GL11.glBegin(GL11.GL_QUADS);
                    for (int i = 0; i < part.getCount(); i++) {
                        int indexA = part.getStartX() + i * 4;
                        int indexB = part.getStartX() + i * 4 + 1;
                        int indexC = part.getStartX() + i * 4 + 2;
                        int indexD = part.getStartX() + i * 4 + 3;
                        GL11.glColor3d(solid.getColors().get(i).getX(), solid.getColors().get(i).getY(), solid.getColors().get(i).getZ());
                        GL11.glVertex3d(solid.getVertices().get(solid.getIndices().get(indexA)).getX(), solid.getVertices().get(solid.getIndices().get(indexA)).getY(), solid.getVertices().get(solid.getIndices().get(indexA)).getZ());
                        GL11.glVertex3d(solid.getVertices().get(solid.getIndices().get(indexB)).getX(), solid.getVertices().get(solid.getIndices().get(indexB)).getY(), solid.getVertices().get(solid.getIndices().get(indexB)).getZ());
                        GL11.glVertex3d(solid.getVertices().get(solid.getIndices().get(indexC)).getX(), solid.getVertices().get(solid.getIndices().get(indexC)).getY(), solid.getVertices().get(solid.getIndices().get(indexC)).getZ());
                        GL11.glVertex3d(solid.getVertices().get(solid.getIndices().get(indexD)).getX(), solid.getVertices().get(solid.getIndices().get(indexD)).getY(), solid.getVertices().get(solid.getIndices().get(indexD)).getZ());
                    }
                    GL11.glEnd();
                }
                case LINES -> {
                    GL11.glBegin(GL11.GL_LINES);
                    for (int i = 0; i < part.getCount(); i++) {
                        int indexA = part.getStartX() + i * 2;
                        int indexB = part.getStartX() + i * 2 + 1;
                        GL11.glColor3d(solid.getColors().get(i).getX(), solid.getColors().get(i).getY(), solid.getColors().get(i).getZ());
                        GL11.glVertex3d(solid.getVertices().get(solid.getIndices().get(indexA)).getX(), solid.getVertices().get(solid.getIndices().get(indexA)).getY(), solid.getVertices().get(solid.getIndices().get(indexA)).getZ());
                        GL11.glVertex3d(solid.getVertices().get(solid.getIndices().get(indexB)).getX(), solid.getVertices().get(solid.getIndices().get(indexB)).getY(), solid.getVertices().get(solid.getIndices().get(indexB)).getZ());
                    }
                    GL11.glEnd();
                }
                case TRIANGLES -> {
                    GL11.glBegin(GL11.GL_TRIANGLES);
                    for (int i = 0; i < part.getCount(); i++) {
                        int indexA = part.getStartX() + i * 3;
                        int indexB = part.getStartX() + i * 3 + 1;
                        int indexC = part.getStartX() + i * 3 + 2;
                        GL11.glColor3d(solid.getColors().get(i).getX(), solid.getColors().get(i).getY(), solid.getColors().get(i).getZ());
                        GL11.glVertex3d(solid.getVertices().get(solid.getIndices().get(indexA)).getX(), solid.getVertices().get(solid.getIndices().get(indexA)).getY(), solid.getVertices().get(solid.getIndices().get(indexA)).getZ());
                        GL11.glVertex3d(solid.getVertices().get(solid.getIndices().get(indexB)).getX(), solid.getVertices().get(solid.getIndices().get(indexB)).getY(), solid.getVertices().get(solid.getIndices().get(indexB)).getZ());
                        GL11.glVertex3d(solid.getVertices().get(solid.getIndices().get(indexC)).getX(), solid.getVertices().get(solid.getIndices().get(indexC)).getY(), solid.getVertices().get(solid.getIndices().get(indexC)).getZ());
                    }
                }
            }
        }
    }

    public List<Solid> getSolids() {
        return solids;
    }

    public void setSolids(List<Solid> solids) {
        this.solids = solids;
    }
}