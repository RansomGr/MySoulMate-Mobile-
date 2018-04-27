package Views.User;

import Entities.User.User;
import Service.User.ServiceUser;
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
    
    private TextField Login;
    private TextField password;
    private Button GoToForgot;
    private Button Logmein;
    private ServiceUser Su;
    public LoginView()
    {
        super();
        this.View=uib.createContainer(theme,"ui_Login").getComponentForm();
        this.View.setTitle("Se Connecter");// setting title on head of View
        Su = new ServiceUser();
        init_LoginView();
    }
    private void init_LoginView()
    {
           GoToForgot=(Button)uib.findByName("GoToForgot", this.View);
           Login=(TextField)uib.findByName("Login", this.View);
           password=(TextField)uib.findByName("password", this.View);
           Logmein=(Button)uib.findByName("Logmein", this.View);
           
           Login.setHint("Pseudo");
           password.setHint("mot de passe");
           password.setConstraint(TextField.PASSWORD);
           Logmein.addActionListener((ActionEvent evt) -> {
               User u = Su.fetchOneByCredentials(Login.getText(), password.getText());
             
           if(u.getId()!=-1)
           {
            MyApplication.setConnectedUser(u);
            MyApplication.getUiMainFrame().RenderView().show();
           }
           });
           GoToForgot.addActionListener((ActionEvent evt)->{
               MyApplication.getUiForgot().RenderView().show();
          });
    }
    

}
