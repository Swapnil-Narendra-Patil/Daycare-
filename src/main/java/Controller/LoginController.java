
package Controller;

import Configuration.DaycareStructure;
import Utils.Icon;
import models.Daycare;
import View.Login;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialOceanicTheme;


public class LoginController {

    private Daycare daycare;
    private Login login;
    
    public JButton loginImageButton;
    
    private Map<JButton, String> buttonIconMap = new HashMap<>();
    public LoginController() {  
        
        
        
        daycare = DaycareStructure.captureData();

        login = new Login(daycare);
        this.loginImageButton = login.loginImageButton;
        setIcons();
        login.pack();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
            
    }
    
    private void setIcons() {
        Icon imageHelper = new Icon();

        buttonIconMap.put(loginImageButton, "/icons/login.png");

        for (Map.Entry<JButton, String> button : buttonIconMap.entrySet()) {
            imageHelper.setIcon(button.getValue(), button.getKey());
        }}

    
    public static void main(String[] args) {
        try {
       
 // by including the https://github.com/material-ui-swing/DarkStackOverflowTheme
      UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialOceanicTheme()));
     } catch (UnsupportedLookAndFeelException e) {
     }
        LoginController lc = new LoginController();
    }
    
}
