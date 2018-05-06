/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.User;


import Service.User.ServiceUser;
import com.codename1.ui.Display;
import com.mycompany.myapp.MyApplication;
import java.util.Timer;
import java.util.TimerTask;

/**
 * GUI builder created Form
 *
 * @author Ransom
 */
public class ForgotView extends com.codename1.ui.Form {

    private ServiceUser Su;
    private static boolean result;
    private int timercount;
    private boolean check;
    private Timer t;
    public ForgotView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
         init_form();
    }
     public static void reply(boolean result)
     {
         ForgotView.result=result;
     }
     public void startCustomRequestListener()
     {
          timercount=0;
             check=false;
             t= new Timer();
                 t.schedule(new TimerTask() {
                     @Override
                     public void run() {
                     System.out.println("timercount:"+timercount);
                     timercount++;
                     if(timercount==2&&check)
                         {
                               Su.checkEmail(gui_Email.getText());
                              gui_SendEmail.setEnabled(ForgotView.result);
                             timercount=0;
                             check=false;
                         }else if(timercount==2)
                         {
                             timercount=0;
                         }
                     }  
                 },1000,1000);
     }
      public void init_form()
     { 
             ForgotView.result=false;
             gui_SendEmail.setEnabled(false);
             Su = new ServiceUser(); 
             startCustomRequestListener();
             gui_Email.addDataChangeListener((type, index) -> {
             if(timercount>0){timercount--;check=true;}
         });
         gui_BackToLogin.addActionListener((evt) -> {
             MyApplication.setCurrentView(new LoginView(MyApplication.getTheme()));
             t.cancel();
         });
     gui_SendEmail.addActionListener((evt) -> {
     Su.sendEmailRecovery(gui_Email.getText());
     });
     
     }

    @Override
    public void layoutContainer() {
          if(Display.getInstance().isPortrait())
               this.setScrollableY(false);
          else
          {
                this.setScrollableY(false);
          }
        super.layoutContainer(); //To change body of generated methods, choose Tools | Templates.
    }
      

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Email = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_SendEmail = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_BackToLogin = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ForgotView");
        setName("Recuperation Compte");
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredWidthMM((float)117.72487);
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredHeightMM((float)190.21164);
        addComponent(gui_Label);
        addComponent(gui_Label_1);
        addComponent(gui_Email);
        addComponent(gui_SendEmail);
        addComponent(gui_BackToLogin);
        gui_Label.setPreferredSizeStr("97.61905mm 2.1164021mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "3.4391532mm 5.0% auto 5.0%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        gui_Label_1.setPreferredSizeStr("43.650795mm 9.523809mm");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("bgImage:logo.png;");
        gui_Label_1.setName("Label_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "-3.4391534mm 13.793103% auto 13.793103%").setReferenceComponents(gui_Label_1, "0 0 -1 0 ").setReferencePositions(gui_Label_1, "1.0 0.0 0.0 0.0");
        gui_Email.setPreferredSizeStr("99.4709mm inherit");
        gui_Email.setHint("Adress Email");
                gui_Email.setInlineStylesTheme(resourceObjectInstance);
        gui_Email.setName("Email");
        gui_Email.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue0be".charAt(0), gui_Email.getUnselectedStyle()));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Email.getParent().getLayout()).setInsets(gui_Email, "0.26455027mm 2.3809538mm auto 2.1164017mm").setReferenceComponents(gui_Email, "1 0 -1 0 ").setReferencePositions(gui_Email, "1.0 0.0 0.0 0.0");
        gui_SendEmail.setPreferredSizeStr("50.79365mm inherit");
        gui_SendEmail.setText("Envoyer email recuperation");
                gui_SendEmail.setInlineStylesTheme(resourceObjectInstance);
        gui_SendEmail.setInlineAllStyles("font:2.5mm;");
        gui_SendEmail.setInlineDisabledStyles("opacity:80;");
        gui_SendEmail.setName("SendEmail");
        com.codename1.ui.FontImage.setMaterialIcon(gui_SendEmail,"\ue163".charAt(0));
        ((com.codename1.ui.layouts.LayeredLayout)gui_SendEmail.getParent().getLayout()).setInsets(gui_SendEmail, "1.8518524mm 10.0% auto 10.0%").setReferenceComponents(gui_SendEmail, "2 0 -1 0 ").setReferencePositions(gui_SendEmail, "1.0 0.0 0.0 0.0");
        gui_BackToLogin.setPreferredSizeStr("25.132275mm inherit");
        gui_BackToLogin.setText("Se Connecter");
                gui_BackToLogin.setInlineStylesTheme(resourceObjectInstance);
        gui_BackToLogin.setName("BackToLogin");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BackToLogin,"\ue853".charAt(0));
        ((com.codename1.ui.layouts.LayeredLayout)gui_BackToLogin.getParent().getLayout()).setInsets(gui_BackToLogin, "2.1164021mm 20.0% auto 20.0%").setReferenceComponents(gui_BackToLogin, "3 0 -1 0 ").setReferencePositions(gui_BackToLogin, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
