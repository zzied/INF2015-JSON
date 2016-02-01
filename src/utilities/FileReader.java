/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author zzaier
 */
public class FileReader {

    public static String loadFileIntoString(String filePath) 
            throws FileNotFoundException, IOException {
        String fileString = new String(Files.readAllBytes(Paths.get(filePath)), 
                StandardCharsets.UTF_8);

        return fileString;

    }
}
