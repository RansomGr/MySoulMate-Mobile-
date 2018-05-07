/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Matching;

import com.codename1.gif.GifImage;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import java.io.IOException;
import java.io.InputStream;


/**
 * GUI builder created Container
 *
 * @author Nadia
 */
public class PackagingView extends com.codename1.ui.Container {

    public PackagingView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public PackagingView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

    
    public void gif() throws IOException
    {
    InputStream i = Display.getInstance().getResourceAsStream(getClass(),"../../../res/Nadia/giphy.gif");
        //   GifImage image = new GifImage;
        GifImage  image = GifImage.decode((i),1177720);
        image.scale(1500,1000);
        Label gif =new Label(image);
    }
//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Grid_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(5, 1));
    private com.codename1.ui.Label gui_nom_label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Grid_Layout_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(1, 1));
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("PackagingView");
        addComponent(gui_Grid_Layout);
        gui_Grid_Layout.setPreferredSizeStr("31.146055mm 30.238888mm");
                gui_Grid_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout.setName("Grid_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Grid_Layout.getParent().getLayout()).setInsets(gui_Grid_Layout, "0.45358276mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Grid_Layout, "-1 -1 -1 -1").setReferencePositions(gui_Grid_Layout, "0.0 0.0 0.0 0.0");
        gui_Grid_Layout.addComponent(gui_nom_label);
        gui_Grid_Layout.addComponent(gui_Label_1);
        gui_Grid_Layout.addComponent(gui_Label);
        gui_Grid_Layout.addComponent(gui_Grid_Layout_1);
                gui_Grid_Layout_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout_1.setInlineAllStyles("font:2.5mm;");
        gui_Grid_Layout_1.setName("Grid_Layout_1");
        gui_Grid_Layout_1.addComponent(gui_Label_2);
        gui_Label_2.setText("pendant ... jours");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("alignment:center;");
        gui_Label_2.setName("Label_2");
        gui_Grid_Layout.addComponent(gui_Button);
        gui_nom_label.setText("nom");
                gui_nom_label.setInlineStylesTheme(resourceObjectInstance);
        gui_nom_label.setInlineAllStyles("alignment:center;");
        gui_nom_label.setName("nom_label");
        gui_Label_1.setText("prix");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("fgColor:ff6072; alignment:center;");
        gui_Label_1.setName("Label_1");
        gui_Label.setText("profitez de... %");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("alignment:center;");
        gui_Label.setName("Label");
                gui_Grid_Layout_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout_1.setInlineAllStyles("font:2.5mm;");
        gui_Grid_Layout_1.setName("Grid_Layout_1");
        gui_Button.setText("Acheter");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_Grid_Layout.setPreferredSizeStr("31.146055mm 30.238888mm");
                gui_Grid_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout.setName("Grid_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Grid_Layout.getParent().getLayout()).setInsets(gui_Grid_Layout, "0.45358276mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Grid_Layout, "-1 -1 -1 -1").setReferencePositions(gui_Grid_Layout, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
