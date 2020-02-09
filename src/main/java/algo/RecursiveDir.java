package algo;

import java.io.File;

/**
 * 递归遍历目录下所有文件
 * @author labvi
 * @version 1.0.0
 */
public class RecursiveDir {
    private static void recursiveDir(File dir){
        if (null == dir || !dir.isDirectory()){
            System.out.println(dir.getAbsolutePath());
            return;
        }
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                recursiveDir(files[i]);
            }else {
                System.out.println(files[i].getAbsolutePath());
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("D:\\project\\java_web\\java-basic\\src\\main");
        recursiveDir(file);
    }
}
