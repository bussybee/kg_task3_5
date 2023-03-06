package ru.vsu.cs.maslova_e_i;

import java.util.List;

public class ModelUtils {

    public static void deleteModelVertices(Model model, List<Integer> vertexNumbers) {

        if (model == null || model.vertices.size() == 0 || vertexNumbers.size() == 0) {
            return;
        }

        for (int number : vertexNumbers) {
            deleteModelVertex(model, number - 1);
            deleteModelPolygons(model, number - 1);
        }
    }

    private static void deleteModelVertex(Model model, int index) {
        model.vertices.remove(index);
    }

    private static void deleteModelPolygons(Model model, int deletedVertexIndex) {
        List<Integer> curPolygonVertexIndices;

        for (int polygonIndex = 0; polygonIndex < model.polygons.size(); polygonIndex++) {

            curPolygonVertexIndices = model.polygons.get(polygonIndex).getVertexIndices();

            for (int index = 0; index < curPolygonVertexIndices.size(); index++) {

                switch (Integer.compare(deletedVertexIndex, curPolygonVertexIndices.get(index))) {
                    case -1 -> curPolygonVertexIndices.set(index, curPolygonVertexIndices.get(index) - 1);
                    case 0 -> {
                        model.polygons.remove(polygonIndex);
                        polygonIndex--;
                    }
                }
            }
        }
    }
}
