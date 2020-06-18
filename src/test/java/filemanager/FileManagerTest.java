package filemanager;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class FileManagerTest {

    FileManager manager = new FileManager();
    File libraryDirectory = new File("src/test/sources");

    @Test
    void getFileList() {
        manager.readFolder(libraryDirectory);
        List<String> actualList = manager.getFileList();
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("easy.txt");
        expectedList.add("example.txt");
        expectedList.add("LoremIpsum.txt");
        assertEquals(expectedList, actualList);
    }

}