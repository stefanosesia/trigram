package test.java.filemanager;

import main.java.filemanager.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class FileManagerTest {

    FileManager manager = new FileManager();
    File libraryDirectory = new File("src/test/sources");

    @BeforeEach
    void setUp() {
    }

    @Test
    void getFileList() {
        manager.readFolder(libraryDirectory);
        List<String> actualList = manager.getFileList();
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("example.txt");
        expectedList.add("LoremIpsum.txt");
        assertEquals(expectedList, actualList);
    }

}