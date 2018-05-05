/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Singletons.BackCommand;
import com.codename1.ui.Form;
import com.mycompany.myapp.MyApplication;

/**
 *
 * @author Ransom
 */
public interface TerminalView {  
    public default void init_form()
    {
        System.out.println("called me from TerminalView child");
        if(this instanceof Form)
        { 
        System.out.println("it's a Form instance");
        Form f= ((Form)this);
        f.setBackCommand(BackCommand.getInstance());
        }
    }
}
