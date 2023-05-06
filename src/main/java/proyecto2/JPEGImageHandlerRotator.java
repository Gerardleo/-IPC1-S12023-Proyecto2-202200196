/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Gerardo
 */
public class JPEGImageHandlerRotator extends ImageHandler {

     String nombreCorto;
     BufferedImage jpg;
     BufferedImage bmp;
     File bmpTemporal;

    public JPEGImageHandlerRotator(String filename) {
     super(filename);
        File f = new File(filename);
        this.nombreCorto = FilenameUtils.removeExtension(f.getName());
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        bmpTemporal = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal);
        bmp = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {
        BufferedImage original = bmp;
        int filas = original.getWidth();
        int columnas = original.getHeight();

        BufferedImage horizontal = new BufferedImage(filas, columnas, original.getType());

        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                horizontal.setRGB(i, j, original.getRGB(filas - i - 1, j));
            }
        }

        ImageIO.write(horizontal, "jpg", new File("./horizontal " + nombreCorto + ".jpg"));
        
        BufferedImage vertical = new BufferedImage(filas, columnas, original.getType());
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                vertical.setRGB(i, j, original.getRGB(i, columnas - j - 1));
            }
        }

        ImageIO.write(vertical, "jpg", new File("./Vertical " + nombreCorto + ".jpg"));

        
        
        bmpTemporal.delete();
    }
    
    
}
