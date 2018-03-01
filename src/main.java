import file_parser.ReadFile;
import file_parser.WriteFile;

import java.util.Map;

public class main {


    public static void main(String[] args) throws Exception {
        String pathFoler = "C:\\Users\\tbasilien\\Downloads\\";
        Map<String, Object> stringObjectMap = ReadFile.getFileFromPath(pathFoler);





        WriteFile.writeFileToPath(pathFoler,stringObjectMap);
    }
}
