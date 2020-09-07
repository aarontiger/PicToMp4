import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileChangeName {

    public static void main(String[] args){
        FileChangeName fileChangeName = new FileChangeName();

        fileChangeName.getFileList("C:\\Users\\Lenovo\\Desktop\\现场车人抓图\\plate_pic01");

    }

    public List getFileList(String path) {
        String outputDir = "E:\\output1\\";
        List list = new ArrayList();
        try {
            File file = new File(path);
            String[] filelist = file.list();
            int j=0;
            for (int i = 0; i < filelist.length; i++,j++) {
                list.add(path+"\\"+filelist[i]);
                File oldFile = new File(path+"\\"+filelist[i]);
                String newFileName = outputDir+"image"+j+".jpg";
                File newFile = new File(newFileName);

                if (oldFile.exists() && oldFile.isFile()) {
                    oldFile.renameTo(newFile);
//                    Files.copy(oldFile.toPath(), newFile.toPath());
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
