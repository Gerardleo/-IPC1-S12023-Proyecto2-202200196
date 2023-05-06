/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Gerardo
 */
public class JPEGImageHandlerColors extends ImageHandler {
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File bmpTemporal;
    

    
    public JPEGImageHandlerColors(String filename) {
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
        int porcentaje = 80; 
        BufferedImage original = bmp;

        
        //Rojo
        BufferedImage rojo = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < original.getWidth(); i++) {
            for(int v = 0; v < original.getHeight(); v++) {
                Color color = new Color(original.getRGB(i,v));
                int red = color.getRed();
                int green = 0;
                int blue = 0;
                Color newColor = new Color(red, green, blue);
                rojo.setRGB(i,v,newColor.getRGB());
            }
        }
        ImageIO.write(rojo, "jpg", new File("./Rojo " + nombreCorto + ".jpg"));
        
        BufferedImage verde = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < original.getWidth(); i++) {
            for(int v = 0; v < original.getHeight(); v++) {
                Color color = new Color(original.getRGB(i,v));
                int green = color.getGreen();
                int red = (int) (color.getRed() * (1 - (porcentaje / 100.0)));
                int blue = (int) (color.getBlue() * (1 - (porcentaje / 100.0)));
                Color newColor = new Color(red, green, blue);
                verde.setRGB(i,v,newColor.getRGB());
            }
        }
        ImageIO.write(verde, "jpg", new File("./Verde " + nombreCorto + ".jpg"));

        // Azul
        BufferedImage azul = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < original.getWidth(); i++) {
            for(int v = 0; v < original.getHeight(); v++) {
                Color color = new Color(original.getRGB(i,v));
                int red = 0;
                int green = 0;
                int blue = color.getBlue();
                Color newColor = new Color(red, green, blue);
                azul.setRGB(i,v,newColor.getRGB());
            }
        }
        ImageIO.write(azul, "jpg", new File("./Azul " + nombreCorto + ".jpg"));

        //Sepia
        BufferedImage sepia = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < original.getWidth(); i++) {
            for(int v = 0; v < original.getHeight(); v++) {
                Color color = new Color(original.getRGB(i,v));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int rNew = (int) (red * 0.393 + green * 0.769 + blue * 0.189);
                int gNew = (int) (red * 0.349 + green * 0.686 + blue * 0.168);
                int bNew = (int) (red * 0.272 + green * 0.534 + blue * 0.131);
                red = Math.min(rNew, 255);
                green = Math.min(gNew, 255);
                blue = Math.min(bNew, 255);
                Color newColor = new Color(red, green, blue);
                sepia.setRGB(i,v,newColor.getRGB());
            }
        }
        ImageIO.write(sepia, "jpg", new File("./Sepia " + nombreCorto + ".jpg"));
        bmpTemporal.delete();
    }

}
