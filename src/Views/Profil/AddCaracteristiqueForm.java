package Views.Profil;

import static Utils.Constants.ADD_CARACTERISTIQUE;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;



/**
 *
 * @author SKIIN
 */


public class AddCaracteristiqueForm extends SideMenuBaseForm {

    
     private ConnectionRequest connexion; 
     public AddCaracteristiqueForm(Resources res) {
        super("Caractéristique",new BorderLayout());


        Button valider = new Button("valider");
        valider.setUIID("ButtonNew");
        
        Label Ttile = new Label("Remplir le Forumlaire");
        Ttile.setUIID("LabelTitle");
        
        TextField alcool = new TextField("","vous consomez de l'Alcool ?");   
        TextField cheveux = new TextField("","votre Couleur de cheveux");    
        TextField caractere = new TextField("","votre Caractére");      
        TextField corpulence = new TextField("","votre corpulence");       
        TextField cuisine = new TextField("","vous savez cuisinez ?");
        TextField origine = new TextField("","votre origine");
        TextField pilosite = new TextField("","votre pilosite");
        TextField profession = new TextField("","votre Profession");         
        TextField status = new TextField("","votre status social");        
        TextField tabac = new TextField("","vous fumez ?");        
        TextField taille = new TextField("","votre taille en M");             
        TextField yeux = new TextField("","Couleur des yeux");
              
  
        
        Validator v = new Validator();
        v.addConstraint(alcool, new LengthConstraint(2));
        v.addConstraint(cheveux, new LengthConstraint(2));
        v.addConstraint(caractere, new LengthConstraint(2));
        v.addConstraint(corpulence, new LengthConstraint(2));
        v.addConstraint(cuisine, new LengthConstraint(2));
        v.addConstraint(origine, new LengthConstraint(2));
        v.addConstraint(pilosite, new LengthConstraint(2));
        v.addConstraint(profession, new LengthConstraint(2));
        v.addConstraint(status, new LengthConstraint(2));
        v.addConstraint(tabac, new LengthConstraint(2));
        v.addConstraint(taille, new LengthConstraint(2));
        v.addConstraint(yeux, new LengthConstraint(2));
        
        
    
    
        Container content = BoxLayout.encloseY(
                Ttile,
                alcool,
                cheveux,
                caractere,
                corpulence,
                cuisine,
                origine,
                pilosite,
                profession,
                status,
                tabac,
                taille,
                yeux,
                valider
       
        );
        
        content.setScrollableY(true);
        add(BorderLayout.SOUTH, content);
        valider.requestFocus();
        
        
        
        connexion = new ConnectionRequest();
        valider.addActionListener(e ->{
             if (v.isValid()) {
                    connexion.setPost(true);
                    connexion.setHttpMethod("POST");
                    connexion.setUrl(ADD_CARACTERISTIQUE+
                            "?alcool="+alcool.getText()+
                            "&caractere="+caractere.getText()+
                            "&cheveux="+cheveux.getText()+
                            "&corpulence="+corpulence.getText()+
                            "&cuisine="+cuisine.getText()+
                            "&origine="+origine.getText()+
                            "&pilosite="+pilosite.getText()+
                            "&profession="+profession.getText()+
                            "&tabac="+tabac.getText()+
                            "&taille="+taille.getText()+
                            "&status="+status.getText()+
                            "&yeux="+yeux.getText()
                             );
                    
                        connexion.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                        connexion.addResponseListener((NetworkEvent evt) -> {
                        if(Dialog.show("Felicitation", "les caractéristique sont enregistrer avec succés", "Voir profile", null)){
                      //      new ProfileForm(res).show();
                        }
                       
                       
                     });
                    NetworkManager.getInstance().addToQueue(connexion);
            
                   }else{
                 
                   Dialog.show("Erreur", "Vérifiez vos informations...", "J'ai compris", null);
 
                   }
                 });
       
    }
    
    
    
  private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}
  
  
  
  private Slider createStarRankSlider() {
    Slider starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(5);
    Font fnt = Font.createTrueTypeFont("native:MainThin", "native:MainThin").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
  
    return starRank;
}

    @Override
    protected void showOtherForm(Resources res) {
     
    }
  
  
}
