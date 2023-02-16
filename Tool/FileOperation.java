package Tool;

import java.io.*;

/**
 * The type File operation.
 */
public class FileOperation implements MyTool {

    /**
     * 复制单个文件
     *
     * @param srcFile  the src file
     * @param destFile the dest file
     */
    public static void copyFile(File srcFile, File destFile){
        String filePath = srcFile.getAbsolutePath();
        String directory = destFile.getAbsolutePath();
        directory += "/" + filePath.substring(Math.max(filePath.lastIndexOf("\\"),filePath.lastIndexOf("/")) + 1);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            fis = new FileInputStream(filePath);
            fos = new FileOutputStream(directory);
            byte[] bytes = new byte[1024 * 1024];
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1){
                fos.write(bytes, 0, readCount);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 拷贝目录
     *
     * @param srcFile  the src file
     * @param destFile the dest file
     * @return 拷贝是否成功 boolean
     */
    public static boolean copyDirectory(File srcFile, File destFile){
        if(srcFile.isFile()){
            copyFile(srcFile,destFile);
            return true;
        }
        else {
            String src = srcFile.getAbsolutePath();
            String dest = destFile.getAbsolutePath();
            File newDir = new File(dest += "/" + src.substring(Math.max(src.lastIndexOf("\\"),src.lastIndexOf("/")) + 1));
            if(! newDir.exists()){
                newDir.mkdir();
            }
            else return false;

            File[] files = srcFile.listFiles();
            for (File file : files) {
                copyDirectory(file, newDir);
            }
            return true;
        }
    }

}
