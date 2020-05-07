package com.cybertek.tests.day11_file_upload;

import org.testng.annotations.Test;

public class FileParthExample {

    @Test
    public void test(){
        //C:\Users\35844\IdeaProjects\EU2TestNGProject\src\test\resources\testfile.txt


        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";
        String filePath = projectPath+"/"+relativePath;
        System.out.println("filePath = " + filePath);
        //System.out.println(System.getProperty("os.name"));
    }

}
