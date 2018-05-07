/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Events;

//import com.codename1.messaging.Message;
import Views.TerminalView;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;





/**
 *
 * @author dellpro
 */
public class SmsApi extends com.codename1.ui.Form implements TerminalView{
    public static final String ACCOUNT_SID = "ACc6e3f100af2f385d00399e2932d0dad1";
    public static final String AUTH_TOKEN = "b96c2629b3e2fa2d5ae26e42743ee9f0";

    public SmsApi() {
    }

    public void sendSms(String body) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(new PhoneNumber("+21621821220"),
        new PhoneNumber("+18327531831"), 
        body).create();
    }
    
    
}
