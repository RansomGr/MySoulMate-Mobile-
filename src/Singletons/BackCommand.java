/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singletons;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.myapp.MyApplication;

/**
 *
 * @author Ransom
 */
public class BackCommand {
    private static Command back;
    private BackCommand()
    {
        if(back==null)
        {
          BackCommand.back = new Command("retour") { 
          public void actionPerformed(ActionEvent ev) {MyApplication.enableTollBar(true);MyApplication.showPreviousView();}
           };
        }
    }
    public static Command getInstance()
    {
        BackCommand d = new BackCommand();
        return BackCommand.back;
    }
}
