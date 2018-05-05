/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Matching;

/**
 * GUI builder created Form
 *
 * @author Nadia
 */
public class PackagingView extends com.codename1.ui.Form {

    public PackagingView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public PackagingView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Nom_label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Prix_label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Label gui_compa_label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_duree_label = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("PackagingView");
        setName("PackagingView");
        addComponent(gui_Nom_label);
        addComponent(gui_Prix_label);
        addComponent(gui_Label_2);
        addComponent(gui_Label_3);
        addComponent(gui_Label_4);
        addComponent(gui_Label_5);
        addComponent(gui_Container);
        addComponent(gui_compa_label);
        addComponent(gui_duree_label);
        addComponent(gui_Button);
        gui_Nom_label.setText("Nom");
                gui_Nom_label.setInlineStylesTheme(resourceObjectInstance);
        gui_Nom_label.setInlineAllStyles("fgColor:ff6072;");
        gui_Nom_label.setName("Nom_label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Nom_label.getParent().getLayout()).setInsets(gui_Nom_label, "1.5119443mm auto auto 32.524273%").setReferenceComponents(gui_Nom_label, "-1 -1 -1 -1").setReferencePositions(gui_Nom_label, "0.0 0.0 0.0 0.0");
        gui_Prix_label.setText("Prix");
                gui_Prix_label.setInlineStylesTheme(resourceObjectInstance);
        gui_Prix_label.setInlineAllStyles("font:5.0mm;");
        gui_Prix_label.setName("Prix_label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Prix_label.getParent().getLayout()).setInsets(gui_Prix_label, "6.6525555mm auto auto 28.571428%").setReferenceComponents(gui_Prix_label, "-1 -1 -1 -1").setReferencePositions(gui_Prix_label, "0.0 0.0 0.0 0.0");
        gui_Label_2.setText("DT");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_Label_2, "1 -1 -1 1 ").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 1.0");
        gui_Label_3.setPreferredSizeStr("28.878138mm inherit");
        gui_Label_3.setText("Profitez de        % ");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("fgColor:ff6072;");
        gui_Label_3.setName("Label_3");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "39.6% 4.7683716E-7mm auto 1.6631389mm").setReferenceComponents(gui_Label_3, "-1 -1 -1 -1").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        gui_Label_4.setPreferredSizeStr("inherit 5.7453885mm");
        gui_Label_4.setText("de compatibilit\u00E9");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setInlineAllStyles("fgColor:ff6072;");
        gui_Label_4.setName("Label_4");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "0.0mm auto 9.676444mm 0.0mm").setReferenceComponents(gui_Label_4, "1 -1 -1 3 ").setReferencePositions(gui_Label_4, "1.0 0.0 0.0 0.0");
        gui_Label_5.setPreferredSizeStr("26.761415mm 4.233444mm");
        gui_Label_5.setText("pendant       jours");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("fgColor:ff6072;");
        gui_Label_5.setName("Label_5");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "1.209555mm 1.2095556mm 6.6525545mm 2.5703056mm").setReferenceComponents(gui_Label_5, "3 3 -1 -1").setReferencePositions(gui_Label_5, "1.0 0.0 0.0 0.0");
        gui_Container.setPreferredSizeStr("28.424555mm 28.575748mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setInlineAllStyles("bgColor:ffb4de; transparency:87; opacity:0;");
        gui_Container.setName("Container");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "-0.15119465mm -8.940697E-8mm 1.5119444mm 1.511945mm").setReferenceComponents(gui_Container, "0 5 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        gui_compa_label.setText("%");
                gui_compa_label.setInlineStylesTheme(resourceObjectInstance);
        gui_compa_label.setName("compa_label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_compa_label.getParent().getLayout()).setInsets(gui_compa_label, "-0.15119444mm auto auto -0.60477775mm").setReferenceComponents(gui_compa_label, "3 -1 -1 0 ").setReferencePositions(gui_compa_label, "0.0 0.0 0.0 1.0");
        gui_duree_label.setText("nb");
                gui_duree_label.setInlineStylesTheme(resourceObjectInstance);
        gui_duree_label.setName("duree_label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_duree_label.getParent().getLayout()).setInsets(gui_duree_label, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_duree_label, "3 1 -1 -1").setReferencePositions(gui_duree_label, "1.0 0.0 0.0 0.0");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_Button.setIcon(resourceObjectInstance.getImage("acheter_btn.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "1.5119457mm 0.0mm auto auto").setReferenceComponents(gui_Button, "4 7 -1 -1").setReferencePositions(gui_Button, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
