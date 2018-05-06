/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package Views.Profil;

import Entities.Profil.Profil;
import Service.Profil.ProfileService;
import Utils.Constants;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.MyApplication;

public class ProfileForm extends SideMenuBaseForm {
    
            private Profil profile;
            public ProfileForm(Resources res) {
            super(BoxLayout.y());
            Toolbar tb = getToolbar();
            tb.setTitleCentered(false);
        
            ProfileService profileService = new ProfileService();
            ConnectionRequest req = new ConnectionRequest();
            req.setUrl(Constants.GET_PROFILE+"?idUser="+1);    
            req.addResponseListener((NetworkEvent evt) -> {
          //  profile = profileService.ParseProfile(new String(req.getResponseData())).get(0);        
            profile= MyApplication.getConnectedUser().getProfil();
              ImageViewer image =new ImageViewer();
              image.setImage(URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(150, 150, 0xffff0000), false),profile.getPhoto(),
                            Constants.IMAGE_PROFILE_URL+profile.getPhoto()));  
        
               add(new Label("Information Générale : ", "TodayTitle"));
              
               addButtonBottom("Nom : "+MyApplication.getConnectedUser().getNom(), 0xd997f1, true);
               addButtonBottom("Prenom : "+MyApplication.getConnectedUser().getPrenom(), 0x5ae29d, false);
               addButtonBottom("Gender : "+MyApplication.getConnectedUser().getGender(), 0x4dc2ff, false);
               addButtonBottom("Description : "+profile.getDescription(), 0xffc06f, false);
               
               
               
                 Image profilePic = image.getImage();
                 Image mask = res.getImage("round-mask.png");
       
        
        profilePic =profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        
       

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.centerAbsolute(
                                BoxLayout.encloseY(
                                    new Label(MyApplication.getConnectedUser().getUsername(), "Title"),
                                    new Label(MyApplication.getConnectedUser().getEmail(), "SubTitle")
                                )
                            ).add(BorderLayout.WEST, profilePicLabel)
                       
                );
        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        fab.setHidden(true);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
            
            FloatingActionButton addCaraceristique = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
            FloatingActionButton getCaraceristique = FloatingActionButton.createFAB(FontImage.MATERIAL_TOC);
            
            
                  
             addCaraceristique.addActionListener((ActionListener) (ActionEvent evt1) -> {
                new AddCaracteristiqueForm(res).show();
          
            });
             
             
                     
             getCaraceristique.addActionListener((ActionListener) (ActionEvent evt1) -> {
                   new CaracteristiqueForm(res, profile.getCaracteristique()).show();               
            });
             
     
         
         add(LayeredLayout.encloseIn(                                 
                               BorderLayout.center(
                               FlowLayout.encloseCenter(                                  
                               addCaraceristique,
                               getCaraceristique))));
                           
  
              
       
               
               
         refreshTheme();
         });
         NetworkManager.getInstance().addToQueue(req);
         setupSideMenu(res);
     
    }
    
    private void addButtonBottom(String text, int color, boolean first) {
        MultiButton finishLandingPage = new MultiButton(text);
        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIcon(createCircleLine(color, finishLandingPage.getPreferredH(),  first));
        finishLandingPage.setIconUIID("Container");
        add(FlowLayout.encloseIn(finishLandingPage));
    }
    
    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if(first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }

    @Override
    protected void showOtherForm(Resources res) {
       
    }
}
