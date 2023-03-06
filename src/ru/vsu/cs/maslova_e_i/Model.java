package ru.vsu.cs.maslova_e_i;

import java.util.*;
import java.util.List;

public class Model {
    public List<Vector3f> vertices = new ArrayList<>();
    public List<Vector2f> textureVertices = new ArrayList<>();
    public List<Vector3f> normals = new ArrayList<>();
    public List<Polygon> polygons = new ArrayList<>();

    public Map<Integer, String> comments = new HashMap<>();
    public Map<Integer, String> materials = new HashMap<>();
    public String mtlFileName = "";
}
