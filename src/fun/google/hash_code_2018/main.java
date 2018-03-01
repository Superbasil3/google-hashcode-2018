package fun.google.hash_code_2018;

import fun.google.hash_code_2018.file_parser.ReadFile;
import fun.google.hash_code_2018.file_parser.WriteFile;

import java.util.Map;

public class main {


    public static void main(String[] args) throws Exception {
        String pathFoler = "E:\\Workspace\\Toolbox\\hash_code_2018\\ressources\\";
        Map<String, Object> stringObjectMap = ReadFile.getFileFromPath(pathFoler);





        WriteFile.writeFileToPath(pathFoler,stringObjectMap);
    }
}
