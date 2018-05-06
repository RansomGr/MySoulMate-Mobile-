package Views.Profil;

import Utils.Constants;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author SKIIN
 */
public class HoroscopeForm extends SideMenuBaseForm {

    private int rc, ri, re;

    public HoroscopeForm(Resources res) {
        super("Gestion Actualité", new BorderLayout());
        Toolbar tb = new Toolbar(true);

        Label sapce = new Label("");
        sapce.setUIID("spaceLabel");
        Label rating = new Label("Contenu");
        Label rating1 = new Label("Image");
        Label rating2 = new Label("Efficasse");
        Label title = new Label("Votre Horoscope");
        title.setUIID("LabelTitle");

        Button valider = new Button("valider");
        valider.setUIID("ButtonNew");

        TextField year = new TextField("", "Année de naissance", 4, TextArea.NUMERIC);
        TextField month = new TextField("", "Mois de naissance", 4, TextArea.NUMERIC);
        TextField day = new TextField("", "jour de naissance", 4, TextArea.NUMERIC);

        Validator v = new Validator();

        Container content = BoxLayout.encloseY(
                title,
                year,
                month,
                day,
                valider
        );

        v.addConstraint(day, new LengthConstraint(1,"champs jour vide"),
                             new RegexConstraint("[0-9]+", "Jour n'est pas numérique"),
                             new NumericConstraint(true, 1, 31, "Jour invalide"));
        
        
        v.addConstraint(month, new LengthConstraint(1,"champs mois vide"),
                               new RegexConstraint("[0-9]+", "Mois n'est pas numérique"),
                               new NumericConstraint(true, 1, 12, "Mois invalide"));
        
        
        v.addConstraint(year, new LengthConstraint(4,"champs année contient 4 chiffre"),
                              new RegexConstraint("[0-9]+", "Année n'est pas numérique"),
                              new NumericConstraint(true, 1900, 2018, "Année invalide"));

     
        content.setScrollableY(true);
        add(BorderLayout.NORTH, content);

        valider.addActionListener(e -> {

            if (v.isValid()) {
                int Year = Integer.parseInt(year.getText());
                int Month = Integer.parseInt(month.getText());
                int Day = Integer.parseInt(day.getText());

                String sign = "";

                switch (Month) {
                    case 1:
                        if (Day <= 19) {
                            sign = "Capricorn";
                        } else {
                            sign = "Aquarius";
                        }   break;
                    case 2:
                        if (Day <= 18) {
                            sign = "Aquarius";
                        } else {
                            sign = "Pisces";
                        }   break;
                    case 3:
                        if (Day <= 20) {
                            sign = "Pisces";
                        } else {
                            sign = "Aries";
                        }   break;
                    case 4:
                        if (Day <= 19) {
                            sign = "Aries";
                        } else {
                            sign = "Taurus";
                        }   break;
                    case 5:
                        if (Day <= 20) {
                            sign = "Taurus";
                        } else {
                            sign = "Gemini";
                        }   break;
                    case 6:
                        if (Day <= 21) {
                            sign = "Gemini";
                        } else {
                            sign = "Cancer";
                        }   break;
                    case 7:
                        if (Day <= 22) {
                            sign = "Cancer";
                        } else {
                            sign = "Leo";
                        }   break;
                    case 8:
                        if (Day <= 22) {
                            sign = "Leo";
                        } else {
                            sign = "Virgo";
                        }   break;
                    case 9:
                        if (Day <= 22) {
                            sign = "Virgo";
                        } else {
                            sign = "Libra";
                        }   break;
                    case 10:
                        if (Day <= 23) {
                            sign = "Libra";
                        } else {
                            sign = "Scorpio";
                        }   break;
                    case 11:
                        if (Day <= 21) {
                            sign = "Scorpio";
                        } else {
                            sign = "Sagittarius";
                        }   break;
                    default:
                        if (Day <= 21) {
                            sign = "Sagittarius";
                        } else {
                            sign = "Capricorn";
                        }   break;
                }

                String url = Constants.HOROSCOPE + sign;
                ConnectionRequest con = new ConnectionRequest();
                con.setUrl(url);
                con.setPost(false);
                con.addResponseListener((NetworkEvent evt1) -> {

                    JSONParser jsonp = new JSONParser();

                    try {

                        System.out.println(new String(con.getResponseData()));
                        Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                        Dialog.show("Horoscope: " + tasks.get("sunsign").toString(), tasks.get("date").toString() + "\n"
                                + tasks.get("horoscope").toString(), "Merci :)", null);

                    } catch (IOException ex) {
                    }
                });
                NetworkManager.getInstance().addToQueueAndWait(con);

            } else {

                Dialog.show("Erreur",   v.getErrorMessage(year)+"\n"+
                                        v.getErrorMessage(month)+"\n"+
                                        v.getErrorMessage(day), "J'ai compris", null);

            }

        });

    }

    @Override
    protected void showOtherForm(Resources res) {

    }

}
