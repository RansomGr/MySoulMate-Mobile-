/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.User;

import Entities.User.User;
import Service.User.ServiceUser;
import Views.MainFrameView;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.myapp.MyApplication;

/**
 * GUI builder created Form
 *
 * @author Ransom
 */
public class LoginView extends com.codename1.ui.Form {
    private ServiceUser Su ;
    public LoginView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        init_form();
    }
     public void init_form()
     {
         gui_password.setConstraint(TextField.PASSWORD);
         gui_Frogot.addActionListener((evt) -> {
             MyApplication.setCurrentView(new ForgotView(MyApplication.getTheme()));
         });
         gui_login.addActionListener((evt) -> {
              Dialog ip = new InfiniteProgress().showInifiniteBlocking();
             Su = new ServiceUser();
             Su.fetchOneByCredentials(gui_username.getText(), gui_password.getText());
             if(MyApplication.getConnectedUser()!=null)
                 {

                      ip.dispose();
                     Toolbar.setGlobalToolbar(true);
                     MyApplication.setCurrentView(new MainFrameView(MyApplication.getTheme()));
                 }
             else
                 {
              ip.dispose();
               if(Dialog.show("Athentification", "Ce compte n'existe pas !","Recuprer","Ok"))
                 {
                     MyApplication.setCurrentView(new ForgotView(MyApplication.getTheme()));   
                 }
                 }
         });
      Command back = new Command("Back") {
        public void actionPerformed(ActionEvent ev) {
         MyApplication.getPreviousView().showBack();
     }
     };
this.setBackCommand(back);     
     }
    @Override
    public void layoutContainer() {
        if(Display.getInstance().isPortrait())
        this.setScrollableY(false);
        else
        this.setScrollableY(true);
        super.layoutContainer(); //To change body of generated methods, choose Tools | Templates.
    }
     
     
//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.CheckBox gui_remember_me = new com.codename1.ui.CheckBox();
    private com.codename1.ui.TextField gui_username = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_password = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_login = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_logo = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_Frogot = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableX(false);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Authentification");
        setName("LoginView");
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredWidthMM((float)112.16931);
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredHeightMM((float)183.33333);
        addComponent(gui_remember_me);
        addComponent(gui_username);
        addComponent(gui_password);
        addComponent(gui_login);
        addComponent(gui_Label);
        addComponent(gui_logo);
        addComponent(gui_Frogot);
        gui_remember_me.setPreferredSizeStr("inherit inherit");
        gui_remember_me.setText("Garder Ma Session Active");
                gui_remember_me.setInlineStylesTheme(resourceObjectInstance);
        gui_remember_me.setInlineAllStyles("font:2.0mm;");
        gui_remember_me.setName("remember_me");
        com.codename1.ui.FontImage.setMaterialIcon(gui_remember_me,"\ue5ca".charAt(0));
        ((com.codename1.ui.layouts.LayeredLayout)gui_remember_me.getParent().getLayout()).setInsets(gui_remember_me, "0.0mm auto auto auto").setReferenceComponents(gui_remember_me, "3 3 -1 3 ").setReferencePositions(gui_remember_me, "1.0 0.0 0.0 0.0");
        gui_username.setPreferredSizeStr("100.0mm 7.5%");
        gui_username.setHint("Pseudo");
                gui_username.setInlineStylesTheme(resourceObjectInstance);
        gui_username.setInlineAllStyles("alignment:center;");
        gui_username.setName("username");
        gui_username.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue7fd".charAt(0), gui_username.getUnselectedStyle()));
        ((com.codename1.ui.layouts.LayeredLayout)gui_username.getParent().getLayout()).setInsets(gui_username, "2.910053mm 0px auto 0px").setReferenceComponents(gui_username, "5 4 -1 4 ").setReferencePositions(gui_username, "1.0 0.0 0.0 0.0");
        gui_password.setPreferredSizeStr("100.0mm 7.5%");
        gui_password.setHint("mot de passe");
                gui_password.setInlineStylesTheme(resourceObjectInstance);
        gui_password.setInlineAllStyles("alignment:center;");
        gui_password.setName("password");
        gui_password.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue897".charAt(0), gui_password.getUnselectedStyle()));
        ((com.codename1.ui.layouts.LayeredLayout)gui_password.getParent().getLayout()).setInsets(gui_password, "1.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_password, "1 1 -1 1 ").setReferencePositions(gui_password, "1.0 0.0 0.0 0.0");
        gui_login.setPreferredSizeStr("58.99471mm 5.820106mm");
        gui_login.setText("Se Connecter");
                gui_login.setInlineStylesTheme(resourceObjectInstance);
        gui_login.setInlineAllStyles("font:3.0mm;");
        gui_login.setName("login");
        ((com.codename1.ui.layouts.LayeredLayout)gui_login.getParent().getLayout()).setInsets(gui_login, "2.910053mm 7.4074073% auto 5.026455mm").setReferenceComponents(gui_login, "2 4 -1 4 ").setReferencePositions(gui_login, "1.0 0.0 0.0 0.0");
        gui_Label.setPreferredSizeStr("105.02646mm 2.910053mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "2.1164021mm 9.0% 97.32894% 9.0%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        gui_logo.setPreferredSizeStr("60.05291mm 9.523809mm");
                gui_logo.setInlineStylesTheme(resourceObjectInstance);
        gui_logo.setInlineAllStyles("bgType:image_scaled_fit; bgImage:logo.png;");
        gui_logo.setName("logo");
        ((com.codename1.ui.layouts.LayeredLayout)gui_logo.getParent().getLayout()).setInsets(gui_logo, "1px 13.793103% auto 13.793103%").setReferenceComponents(gui_logo, "4 4 -1 4 ").setReferencePositions(gui_logo, "1.0 0.0 0.0 0.0");
        gui_Frogot.setPreferredSizeStr("29.100529mm 4.2328043mm");
        gui_Frogot.setText("Mot de passe Oublier ?");
                gui_Frogot.setInlineStylesTheme(resourceObjectInstance);
        gui_Frogot.setInlineAllStyles("font:2.0mm; alignment:center;");
        gui_Frogot.setName("Frogot");
        gui_Frogot.setPressedIcon(com.codename1.ui.FontImage.createMaterial("\ue85a".charAt(0), gui_Frogot.getPressedStyle()));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Frogot.getParent().getLayout()).setInsets(gui_Frogot, "0.0mm auto auto auto").setReferenceComponents(gui_Frogot, "0 0 -1 0 ").setReferencePositions(gui_Frogot, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}

