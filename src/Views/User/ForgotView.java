/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.User;

import Views.AbstractView;
import com.codename1.ui.Button;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.myapp.MyApplication;

/**
 *
 * @author Ransom
 */
public class ForgotView extends AbstractView {
     private TextField emailTf;
     private Button BacktoLogin;
     public ForgotView()
    {
         super();
         this.View=uib.createContainer(theme,"ui_Forgot").getComponentForm();// Getting Instence of Form 
         this.View.setTitle("Recuperer Compte");// setting title on head of View
         init_ForgotView();
         
    } 
     private void init_ForgotView()
     {
          emailTf=(TextField)uib.findByName("emailTf",this.View);
         emailTf.setHint("Email");
         BacktoLogin=(Button)uib.findByName("BacktoLogin", this.View);
         BacktoLogin.addActionListener((ActionEvent evt)->{
             MyApplication.getUiLogin().RenderView().show();
         }); 
     }
    
}
