/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Matching;

import Entities.User.User;
import Service.Matching.ServiceMatching;
import Views.TerminalView;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.mycompany.myapp.MyApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nadia
 */
public class TestView extends com.codename1.ui.Form implements TerminalView {
    
    
     ServiceMatching service=new ServiceMatching();
    ArrayList<User> matchings = new ArrayList<>();
    SpanLabel lb;
      public TestView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        init_form();
    }

    public TestView(com.codename1.ui.util.Resources resourceObjectInstance) {
     
        init_form();
    }
    @Override
    public void init_form()
    {
        TerminalView.super.init_form();
         this.setLayout(BoxLayout.y());
        TextModeLayout tm = new TextModeLayout(4, 2);
        
               
        lb = new SpanLabel("");
        this.add(lb);
        service=new ServiceMatching();
        matchings = service.getList2();
        if(matchings!=null && !matchings.isEmpty())
        {initi();}
       
    }
   private void initi()
    
    {
        int mm = Display.getInstance().convertToPixels(3);
  EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);

        this.setLayout(new BorderLayout());
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        
for(int i =0;i<matchings.size();i++)
{   
  
 String filePath = "file:///F:/xampp/htdocs/MySoulMate-Symphony/web"+matchings.get(i).getProfil().getPhoto();

        if (filePath != null) {
            try {

                String pathToBeStored;
                pathToBeStored = FileSystemStorage.getInstance().getAppHomePath() + System.currentTimeMillis();
                Image img;
                img = Image.createImage(filePath);
                 int displayHeight = Display.getInstance().getDisplayHeight();
    Image scaledPhotoImage = img.scaled(-1, displayHeight / 2);//String.valueOf(voyages.get(i).getPrix())
                data.add(createListEntry(scaledPhotoImage,matchings.get(i).getUsername(),matchings.get(i).getMatchtot()));
                
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    
  //  Button bouton = new Button("Inviter");
  //  this.add(bouton);
  //  bouton.addActionListener(e -> {
  //     service.Inviter(matchings.get(i).getId());
  //  });
    
    
    
DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
MultiList ml = new MultiList(model);

   this.add(BorderLayout.CENTER, ml);

   ml.addActionListener((ActionListener) (ActionEvent evt) -> {
   
        service.Inviter(matchings.get(ml.getSelectedIndex()));
        
        Button showNotification = new Button("Notification");
        showNotification.addActionListener(e -> ToastBar.showMessage("Invitation envoyée!", FontImage.MATERIAL_INFO));
        this.add(showNotification);
   
   
   });
   
    }
    DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
}



    
    private Map<String, Object> createListEntry(Image icon,String username, int matchtot) {
    Map<String, Object> entry = new HashMap<>();
    
    entry.put("Line1", icon);
    entry.put("Line2", username);
    entry.put("Line3", matchtot);
    return entry;
    }
    
//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Voir Matchings");
        setName("Matchings");
        addComponent(gui_Label);
        gui_Label.setText("Matching");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
}
