package Views.Profil;

import Entities.Profil.Actualite;
import Service.Profil.ActualiteService;
import Utils.Constants;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;

/**
 *
 * @author SKIIN
 */
public class ActualiteForm extends SideMenuBaseForm {

    public ActualiteForm(Resources res) {
        super("Tout les Actualités", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setupSideMenu(res);
        ActualiteService controller = new ActualiteService();
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(Constants.GET_ACTUALITE);
        req.addResponseListener((NetworkEvent evt) -> {
            ArrayList<Actualite> actualites = controller.ParseActualite(new String(req.getResponseData()));
            for (int i = 0; i < actualites.size(); i++) {

                addButton(
                        res,
                        actualites.get(i).getPhoto(),
                        actualites.get(i).getDateAdd(),
                        actualites.get(i).getUsername(),
                        actualites.get(i).getContenu(),
                        actualites.get(i)
                );
            }

        });

        NetworkManager.getInstance().addToQueue(req);
        refreshTheme();

    }

    private void addButton(Resources res, String img, String title, String email, String categorie, Actualite a) {
        //load image from url
        ImageViewer image = new ImageViewer();
        image.setImage(URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(150, 150, 0xffff0000), false), img,
                Constants.IMAGE_ACTUALITE_URL + img));

        Button button = new Button();
        button.setUIID("Label");
        Container cnt = BorderLayout.west(image);
        cnt.setLeadComponent(button);
        Label ta = new Label(title, "Label");
        //set font motif to label
        FontImage.setMaterialIcon(ta, FontImage.MATERIAL_DATE_RANGE);
        
        Label category = new Label(categorie, "Label");
        FontImage.setMaterialIcon(category, FontImage.MATERIAL_CHAT);

        Label emails = new Label(email + "", "Label");
        FontImage.setMaterialIcon(emails, FontImage.MATERIAL_PERSON);

        cnt.add(BorderLayout.CENTER,
                BoxLayout.encloseY(
                        new Label(""),
                        new Label(""),
                        new Label(""),
                        new Label(""),
                        new Label(""),
                        new Label(""),
                        ta,
                        BoxLayout.encloseX(category),
                        BoxLayout.encloseX(emails)
                )
        );

        add(cnt);

        button.addActionListener((ActionListener) (ActionEvent e) -> {

          new DetailsActualiteForm(res,a).show();

        });
        this.animateLayout(0);
        refreshTheme();
    }

    @Override
    protected void showOtherForm(Resources res) {

    }

}
