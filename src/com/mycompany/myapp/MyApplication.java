package com.mycompany.myapp;


import Entities.User.User;
import Views.User.LoginView;
import com.codename1.components.ImageViewer;
import static com.codename1.ui.CN.*;
import com.codename1.io.Log;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;


/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {
    private static  Resources theme;    
    private static User ConnectedUser;
    public static Resources  getTheme(){return MyApplication.theme;}// Theme
    public static User getConnectedUser(){return MyApplication.ConnectedUser; }// Session owner
    public static void setConnectedUser(User U) {MyApplication.ConnectedUser=U;}
    public static void setCurrentView(Form view){MyApplication.previous=current;MyApplication.current=view;MyApplication.current.show();}// switch the view remotly 
    public static Form getPreviousView(){return MyApplication.previous;}
    private static Form current;
    private static Form previous;

    public void init(Object context)  {  
    theme = UIManager.initFirstTheme("/theme");
    UIBuilder.registerCustomComponent("ImageViewer",ImageViewer.class);
    current=new LoginView(theme);
        // Pro only feature
        Log.bindCrashProtection(true);
    }
    public void start() {
        if(current!= null){
            current.show();
            return;
        }
    }
    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    public void destroy() {
    }
}
