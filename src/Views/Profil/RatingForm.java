package Views.Profil;



import Entities.Profil.Actualite;
import static Utils.Constants.EVALUER_ACTUALTE;
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
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Validator;



/**
 *
 * @author SKIIN
 */


public class RatingForm extends SideMenuBaseForm {

  
     private ConnectionRequest connexion;
     private int rc,ri,re;
    public RatingForm(Resources res,Actualite actualite) {
        super("Gestion Actualité",new BorderLayout());
        Toolbar tb = new Toolbar(true);
        
        Label sapce = new Label("");
        sapce.setUIID("spaceLabel");
        Label rating = new Label("Contenu");
        Label rating1 = new Label("Image");
        Label rating2 = new Label("Efficasse");
        Label title = new Label("Évaluer l'Actualité"); 
        title.setUIID("LabelTitle");
        
        Button valider = new Button("valider");
        valider.setUIID("ButtonNew");
        Slider contenu = createStarRankSlider();
        Slider image = createStarRankSlider();
        Slider efficacite  = createStarRankSlider();
   
               Button previous = new Button("Précédent");
            previous.setUIID("ButtonNew");
           
            
            
            previous.addActionListener(e-> {
              
                new DetailsActualiteForm(res,actualite).show();
                
            });
        Validator v = new Validator();
        
   
          contenu.addActionListener((ActionListener) (ActionEvent evt) -> {
              rc = contenu.getProgress();
        });
        
          
           image.addActionListener((ActionListener) (ActionEvent evt) -> {
              ri = image.getProgress();
        });
           
           
            efficacite.addActionListener((ActionListener) (ActionEvent evt) -> {
              re = efficacite.getProgress();
        });
        
        Container content = BoxLayout.encloseY(
             
                sapce,
                title,
                BorderLayout.center(rating).
                add(BorderLayout.WEST,(contenu)), 
                
                BorderLayout.center(rating1).
                add(BorderLayout.WEST,(image)),   
                
                BorderLayout.center(rating2).
                add(BorderLayout.WEST,(efficacite)),  
                
              
                valider,
                previous
       
        );
        
        content.setScrollableY(true);
        add(BorderLayout.OVERLAY, content);
        valider.requestFocus();
        
     
        connexion = new ConnectionRequest();
        valider.addActionListener(e ->{
             if (v.isValid()) {
             connexion.setPost(true);
                    connexion.setHttpMethod("POST");
                    connexion.setUrl(EVALUER_ACTUALTE+
                            "?ratec="+rc+
                            "&ratei="+ri+
                            "&ratee="+re+
                            "&idActualite="+actualite.getId()+
                            "&idUser="+1);
                    connexion.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    connexion.addResponseListener((NetworkEvent evt) -> {
                        System.out.println(new String(connexion.getResponseData()));
                        if(Dialog.show("Félicitation", "Actualité Evaluer avec succés", "Voir autre Actualités", null)){
                             new ActualiteForm(res).show();
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
