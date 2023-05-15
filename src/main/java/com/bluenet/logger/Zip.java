package com.bluenet.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public Zip() {
        throw new UnsupportedOperationException("No class");
    }


    public static void zipOldLogs() throws IOException {
        String sourceFile = "logs/latest.log";
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        String format = simple.format(date);
        FileOutputStream fos = new FileOutputStream(getUniqueFileName("logs/" + format + ".zip"));
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        fileToZip.delete();
        zipOut.close();
        fis.close();
        fos.close();
    }

    private static String getUniqueFileName(String fileName) {
        String baseName = fileName;
        String extension = "";
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex >= 0) {
            baseName = fileName.substring(0, dotIndex);
            extension = fileName.substring(dotIndex);
        }
        int counter = 1;
        while (true) {
            String uniqueName = baseName + "-" + counter + extension;
            File file = new File(uniqueName);
            if (!file.exists()) {
                return uniqueName;
            }
            counter++;
        }
    }

}
