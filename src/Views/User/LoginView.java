package Views.User;

import Views.AbstractView;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.myapp.MyApplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ransom
 */
public class LoginView extends AbstractView{
    
    private TextField emailTf;
    private Button GoToForgot;
    public LoginView()
    {
        super();
        this.View=uib.createContainer(theme,"ui_Login").getComponentForm();
         this.View.setTitle("Se Connecter");// setting title on head of View
      init_LoginView();
    }
    private void init_LoginView()
    {
           GoToForgot=(Button)uib.findByName("GoToForgot", this.View);
           GoToForgot.addActionListener((ActionEvent evt)->{
               MyApplication.getUiForgot().RenderView().show();
          });
    }
    

}
