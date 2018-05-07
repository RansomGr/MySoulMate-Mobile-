package Views.Profil;

import Entities.Profil.Actualite;
import Utils.Constants;
import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;


import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;

import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import java.util.Map;


/**
 * @author SKINN
 */
public class DetailsActualiteForm extends SideMenuBaseForm {


    public DetailsActualiteForm(Resources res,Actualite actualite) {

     
        super("Détail Actualité",new BorderLayout());
       
        Label contenu = new Label(actualite.getContenu(),"ProfilePic");
        Label date = new Label(actualite.getDateAdd(),"ProfilePic");
        Label auteur = new Label(actualite.getUsername(),"ProfilePic");
       
        
         ImageViewer image = new ImageViewer();
         image.setImage(URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(400, 200, 0xffff0000), false), actualite.getPhoto(),
         Constants.IMAGE_ACTUALITE_URL + actualite.getPhoto()));
       

         
             Slider avg = createStarRankSlider();
             ConnectionRequest con = new ConnectionRequest();
             con.setUrl(Constants.GET_RATING+"?id="+actualite.getId());
             con.setPost(false);
             con.addResponseListener((NetworkEvent evt1) -> {
                        
                         JSONParser jsonp = new JSONParser();
                         
                         try {
                            
                             System.out.println(new String(con.getResponseData()));
                             Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));                             
                             System.out.println(tasks.get("avgRating").toString());
                             avg.setProgress(Math.round(Float.parseFloat(tasks.get("avgRating").toString())));
        
                            } catch (IOException ex) {
                            }
               });
               NetworkManager.getInstance().addToQueueAndWait(con);
            
         
         
         
         
        
         
         
         
         avg.setEditable(false);
         Button fab = new Button("Evaluer");
         Button fabd = new Button("Supprimer");
         fab.setUIID("ButtonNew");
         fabd.setUIID("ButtonNew");
         fabd.addActionListener(e -> {

              if(actualite.getCreateur().getId() == MyApplication.getConnectedUser().getId()){
                  
                   if(Dialog.show("Supprimer", "Vous etes sur de supprimer","Annuler","Supprimer")){
                            System.out.println("ok");
                 }else{
                  
                       
                    ConnectionRequest connexion = new ConnectionRequest();                    
                    connexion.setPost(true);
                    connexion.setHttpMethod("POST");
                    connexion.setUrl(Constants.DELETE_ACTUALTE+"?id="+actualite.getId());
                    connexion.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    connexion.addResponseListener((NetworkEvent evt) -> {
                        
                        System.out.println(new String(connexion.getResponseData()));
                        new ActualiteForm(res).show();
                        
                    });
                    NetworkManager.getInstance().addToQueue(connexion);
             
                 }
            
            
              }else{
                 Dialog.show("Alert", "Vous pouvez pas supprimer cette Actualité","OK",null);
                  
              }

        });

        fab.addActionListener(e -> {
                new RatingForm(res, actualite).show();
        });

            Button previous = new Button("Précédent");
            previous.setUIID("ButtonNew");
           
            
            
            previous.addActionListener(e-> {
              
                new ActualiteForm(res).show();
                
            });
        
        
           Container content = BoxLayout.encloseY(
             
                
                image,
                
                BorderLayout.center(avg).
                add(BorderLayout.WEST,(new Label("Moyenne : "))),
                
                BorderLayout.center(contenu).
                add(BorderLayout.WEST,(new Label("Contenu :"))),
                
                 BorderLayout.center(date).
                add(BorderLayout.WEST,(new Label("Date :"))),
                 
                 
                BorderLayout.center(auteur).
                add(BorderLayout.WEST,(new Label("Auteur :"))),
                  
                fab,
                fabd,
                previous
                );
        
        content.setScrollableY(true);
        add(BorderLayout.OVERLAY, content);
      

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
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
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

    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }

}
