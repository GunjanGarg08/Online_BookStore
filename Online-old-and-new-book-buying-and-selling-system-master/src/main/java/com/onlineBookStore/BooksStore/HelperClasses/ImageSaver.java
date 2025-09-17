package com.onlineBookStore.BooksStore.HelperClasses;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

import org.springframework.web.multipart.MultipartFile;

public class ImageSaver {

    /**
     * Save uploaded file to an external folder (not inside classpath).
     *
     * @param file     MultipartFile from the form
     * @param uploadDir absolute or relative directory (e.g. "./uploads/images")
     * @param fileName name to save (e.g. UUID + ext)
     * @return true if saved
     */
    public static boolean save(MultipartFile file, String uploadDir, String fileName) {
        try {
            Path uploadPath = Paths.get(uploadDir);
            if (Files.notExists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try (InputStream input = file.getInputStream()) {
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}




//package com.onlineBookStore.BooksStore.HelperClasses;
//
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.web.multipart.MultipartFile;
//
//public class ImageSaver {
//	static public boolean save(MultipartFile file, String filePath, String fileName) {
//		boolean flag = false;
//		try {
//			String path = new ClassPathResource(filePath).getFile().getAbsolutePath();
//			System.out.println(path);
//			Files.copy(file.getInputStream(), Paths.get(path + File.separator + fileName),
//					StandardCopyOption.REPLACE_EXISTING);
//			flag = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		return flag;
//	}
//}
