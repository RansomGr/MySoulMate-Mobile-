/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.User.User;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.myapp.MyApplication;

/**
 *
 * @author Ransom
 */
public class AbstractView {
    protected Form View;
    protected UIBuilder uib;
    protected Resources theme;
    protected User ConnectedUser;
    public AbstractView()
    {
    this.theme=MyApplication.getTheme();
    uib=new UIBuilder();
    ConnectedUser=MyApplication.getConnectedUser();
   
    }
    public  Form RenderView()
    {
        return this.View;
    }
}
