package ru.vsu.cs.maslova_e_i;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class ModelUtilsTest {

    // считывается моделька, удаляется вершина(ы), считывается правильная моделька и сравниваются
    @Test
    void deleteOneVertexInCubeTest() throws IOException {
        Model actualModel = ObjReader.read(Files.readString(Path.of("src/cube.obj")));
        ModelUtils.deleteModelVertices(actualModel, List.of(1));

        Model expectedModel = ObjReader.read(Files.readString(
                Path.of("src/cubeAfterOneVertexRemoval.obj")));

        Assertions.assertEquals(ObjWriter.getContent(expectedModel), ObjWriter.getContent(actualModel));
    }

    @Test
    void deleteWithoutVerticesTest() throws IOException {
        Model actualModel = ObjReader.read(Files.readString(Path.of("src/cube.obj")));
        ModelUtils.deleteModelVertices(actualModel, List.of());

        Model expectedModel = ObjReader.read(Files.readString(Path.of("src/cube.obj")));

        Assertions.assertEquals(ObjWriter.getContent(expectedModel), ObjWriter.getContent(actualModel));
    }

    @Test
    void deleteTwoVertexInCubeTest() throws IOException {
        Model actualModel = ObjReader.read(Files.readString(Path.of("src/cube.obj")));
        ModelUtils.deleteModelVertices(actualModel, List.of(1, 3));

        Model expectedModel = ObjReader.read(Files.readString(
                Path.of("src/cubeAfterTwoVertexRemoval.obj")));

        Assertions.assertEquals(ObjWriter.getContent(expectedModel), ObjWriter.getContent(actualModel));
    }

    @Test
    void deleteThreeVertexInCubeTest() throws IOException {
        Model actualModel = ObjReader.read(Files.readString(Path.of("src/cube.obj")));
        ModelUtils.deleteModelVertices(actualModel, List.of(1, 3, 5));

        Model expectedModel = ObjReader.read(Files.readString(
                Path.of("src/cubeAfterThreeVertexRemoval.obj")));

        Assertions.assertEquals(ObjWriter.getContent(expectedModel), ObjWriter.getContent(actualModel));
    }
}