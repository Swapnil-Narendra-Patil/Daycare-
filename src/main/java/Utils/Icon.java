
package Utils;
import javax.swing.JButton;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class Icon {

    
    private final int width= 100;
    private final int height = 100;
    
    
    public void setIcon(String path, JButton button) {
        URL uRL = getClass().getResource(path);
        ImageIcon imageIcon =  new ImageIcon(uRL, "set this image");
        Image image = imageIcon.getImage();
        Image setImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(setImage);
        button.setIcon(imageIcon);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
    }

}
