package ru.vsu.cs.maslova_e_i;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Model model = ObjReader.read(Files.readString(Path.of("src/cube.obj")));
        ModelUtils.deleteModelVertices(model, List.of(1, 3, 5));
        PrintWriter out = new PrintWriter("src/cube.obj");
        out.println(ObjWriter.getContent(model));
        out.close();
    }
}

