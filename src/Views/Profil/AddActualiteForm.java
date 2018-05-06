package Views.Profil;

import Utils.Constants;
import com.codename1.capture.Capture;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.openGallery;
import static com.codename1.ui.CN1Constants.GALLERY_IMAGE;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import java.io.IOException;



/**
 *
 * @author SKIIN
 */


public class AddActualiteForm extends SideMenuBaseForm {

     Image img = null;
     Image toupload = null;
     Image image = null;
     String fileName;
     String filePath;
     private ConnectionRequest connexion; 
     public AddActualiteForm(Resources res) {
        super("Gestion Actualité",new BorderLayout());
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);

        
        Button avatar = new Button("Insérer une image");       
        Image defaultAvatar = FontImage.createMaterial(FontImage.MATERIAL_CAMERA,"round-mask.png", 8);
        Image circleMaskImage = res.getImage("round-mask.png");
        defaultAvatar = defaultAvatar.scaled(circleMaskImage.getWidth(), circleMaskImage.getHeight());
        defaultAvatar = ((FontImage)defaultAvatar).toEncodedImage();
        Object circleMask = circleMaskImage.createMask();
        defaultAvatar = defaultAvatar.applyMask(circleMask);
        avatar.setIcon(defaultAvatar);
        
        avatar.addActionListener(e -> {
            if(Dialog.show("Camera or Gallery", "Would you like to use the camera or the gallery for the picture?", "Camera", "Gallery")) {
                String pic = Capture.capturePhoto();
                if(pic != null) {
                    try {
                        Image img = Image.createImage(pic).fill(circleMaskImage.getWidth(), circleMaskImage.getHeight());
                        avatar.setIcon(img.applyMask(circleMask));
                        
                        System.out.println(Capture.capturePhoto());
                        
                    } catch(IOException err) {
                        ToastBar.showErrorMessage("An error occured while loading the image: " + err);
                        Log.e(err);
                    }
                }
            } else {
                openGallery(ee -> {
                    if(ee.getSource() != null) {
                        try {
                            Image imageAppercu = Image.createImage((String)ee.getSource()).fill(circleMaskImage.getWidth(), circleMaskImage.getHeight());
                            
                            filePath = (String) ee.getSource();
                            int fileNameIndex = filePath.lastIndexOf("/") + 1;
                            fileName = filePath.substring(fileNameIndex);

                            img = null;
                            toupload = null;

                            try {
                               
                                image = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
                                toupload = image;                            
                                refreshTheme();
                            
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            
                            avatar.setIcon(imageAppercu.applyMask(circleMask));
                        } catch(IOException err) {
                            ToastBar.showErrorMessage("An error occured while loading the image: " + err);
                            Log.e(err);
                        }
                    }
                }, GALLERY_IMAGE);
            }
        });
        
    
        Button valider = new Button("valider");
        valider.setUIID("ButtonNew");
        Label Ttile = new Label("Ajouter une Actualité");
        Ttile.setUIID("LabelTitle");     
        TextField contenu = new TextField("","Contenu");   
        
        TextField imageName = new TextField("","Nom du l'image");   
        Validator v = new Validator();
        v.addConstraint(contenu, new LengthConstraint(2));

        
         Button previous = new Button("Précédent");
            previous.setUIID("ButtonNew");
           
            
            
            previous.addActionListener(e-> {
              
                new ProfileForm(res).show();
                
            });
        
        Container content = BoxLayout.encloseY(
                Ttile,
                contenu,
                avatar,
                imageName,
                valider,
                previous
       
        );
        
        content.setScrollableY(true);
        add(BorderLayout.SOUTH, content);
        valider.requestFocus();
        
        
       /* try {
        MultipartRequest cr = new MultipartRequest();
        String  filePath = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
        cr.setUrl(Constants.ADD_ACTUALITE);
        cr.setPost(true);
        cr.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        String mime="image/png";    
        cr.addData("file", filePath, mime);        
        cr.setFilename("file", "avatar.png");
        cr.addResponseListener((NetworkEvent evt) -> {
    });
         } catch (IOException ex) {
             System.out.println(ex.getMessage());
         }*/
        
       
        
        connexion = new ConnectionRequest();
        valider.addActionListener(e ->{
             if (v.isValid()) {
                    connexion.setPost(true);
                    connexion.setHttpMethod("POST");                  
                    connexion.setUrl(Constants.ADD_ACTUALITE+
                            "?contenu="+contenu.getText()+
                            "&photo="+imageName.getText()+".png"+
                            "&idUser="+1);
                    
                        connexion.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                        connexion.addResponseListener((NetworkEvent evt) -> {
                        if(Dialog.show("Felicitation", "Actualité ajouter avec succés", "Voir les autres actualités", null)){
                           new ActualiteForm(res).show();
                        }
                                    
                     });
                    NetworkManager.getInstance().addToQueue(connexion);
            
                   }else{
                 
                   Dialog.show("Erreur", "Vérifiez vos informations...", "J'ai compris", null);
 
                   }
                 });
       
    }
    


    @Override
    protected void showOtherForm(Resources res) {
     
    }
  
  
}
