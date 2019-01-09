package com.java.IO;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Filecopy {

	public static void copyFile(File sourceFile, File destFile)
            throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        
        int width=100,height=150; /* set the width and height here */
        BufferedImage inputImage=ImageIO.read(sourceFile);
        BufferedImage outputImage=new BufferedImage(width, height,
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g=outputImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.clearRect(0, 0, width, height);
        g.drawImage(inputImage, 0, 0, width, height, null);
        g.dispose();
        ImageIO.write(outputImage,"jpg",destFile);

        /*FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();

            // previous code: destination.transferFrom(source, 0, source.size());
            // to avoid infinite loops, should be:
            long count = 0;
            long size = source.size();
            while ((count += destination.transferFrom(source, count, size
                    - count)) < size)
                ;
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }*/
    }

    public static void main(String args[]) {
       try {
        File sourceFile = new File("C:/ganga/abc.jpg");
        File destFile = new File("C:/ganga/Songs/abc.jpg");
        copyFile(sourceFile,destFile);
        } catch (IOException ex) {
           ex.printStackTrace();
         }
    }
}
