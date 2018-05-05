/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 * GUI builder created Form
 *
 * @author dellpro
 */
public class Guiyyy extends com.codename1.ui.Form {

    public Guiyyy() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Guiyyy(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Lbl_type = new com.codename1.ui.Label();
    private com.codename1.components.SpanButton gui_valider = new com.codename1.components.SpanButton();
    private com.codename1.ui.ComboBox gui_Combo_Box = new com.codename1.ui.ComboBox();
    private com.codename1.ui.Label gui_lblDate = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Date_Spinner = new com.codename1.ui.Container();
    private com.codename1.ui.Container gui_heurDebut = new com.codename1.ui.Container();
    private com.codename1.ui.Container gui_heurFin = new com.codename1.ui.Container();
    private com.codename1.ui.Label gui_lblHeurDeb = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_lbldateFin = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Guiyyy");
        setName("Guiyyy");
        addComponent(gui_Lbl_type);
        addComponent(gui_valider);
        addComponent(gui_Combo_Box);
        addComponent(gui_lblDate);
        addComponent(gui_Date_Spinner);
        addComponent(gui_heurDebut);
        addComponent(gui_heurFin);
        addComponent(gui_lblHeurDeb);
        addComponent(gui_lbldateFin);
        gui_Lbl_type.setText("Type event");
                gui_Lbl_type.setInlineStylesTheme(resourceObjectInstance);
        gui_Lbl_type.setName("Lbl_type");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Lbl_type.getParent().getLayout()).setInsets(gui_Lbl_type, "6.0836496% auto auto 0.0mm").setReferenceComponents(gui_Lbl_type, "-1 -1 -1 3 ").setReferencePositions(gui_Lbl_type, "0.0 0.0 0.0 0.0");
        gui_valider.setText("Valider");
                gui_valider.setInlineStylesTheme(resourceObjectInstance);
        gui_valider.setName("valider");
        ((com.codename1.ui.layouts.LayeredLayout)gui_valider.getParent().getLayout()).setInsets(gui_valider, "auto auto 6.4638767% 0.0mm").setReferenceComponents(gui_valider, "-1 -1 -1 4 ").setReferencePositions(gui_valider, "0.0 0.0 0.0 0.0");
                gui_Combo_Box.setInlineStylesTheme(resourceObjectInstance);
        gui_Combo_Box.setName("Combo_Box");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Combo_Box.getParent().getLayout()).setInsets(gui_Combo_Box, "-10.58201mm 38.268158% -1.5872955mm auto").setReferenceComponents(gui_Combo_Box, "-1 -1 0 -1").setReferencePositions(gui_Combo_Box, "0.0 0.0 0.0 0.0");
        gui_lblDate.setText("Date");
                gui_lblDate.setInlineStylesTheme(resourceObjectInstance);
        gui_lblDate.setName("lblDate");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lblDate.getParent().getLayout()).setInsets(gui_lblDate, "9.471366% auto 85.83379% 23.324022%").setReferenceComponents(gui_lblDate, "4 -1 -1 -1").setReferencePositions(gui_lblDate, "0.0 0.0 0.0 0.0");
                gui_Date_Spinner.setInlineStylesTheme(resourceObjectInstance);
        gui_Date_Spinner.setName("Date_Spinner");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Date_Spinner.getParent().getLayout()).setInsets(gui_Date_Spinner, "13.8783245% 25.139664% auto auto").setReferenceComponents(gui_Date_Spinner, "-1 -1 -1 -1").setReferencePositions(gui_Date_Spinner, "0.0 0.0 0.0 0.0");
                gui_heurDebut.setInlineStylesTheme(resourceObjectInstance);
        gui_heurDebut.setName("heurDebut");
        ((com.codename1.ui.layouts.LayeredLayout)gui_heurDebut.getParent().getLayout()).setInsets(gui_heurDebut, "4.2328067mm auto 71.76719% -1.5873016mm").setReferenceComponents(gui_heurDebut, "4 -1 -1 2 ").setReferencePositions(gui_heurDebut, "1.0 0.0 0.0 0.0");
                gui_heurFin.setInlineStylesTheme(resourceObjectInstance);
        gui_heurFin.setName("heurFin");
        ((com.codename1.ui.layouts.LayeredLayout)gui_heurFin.getParent().getLayout()).setInsets(gui_heurFin, "60.898876% 55.963303% 0.0mm 1.5873032mm").setReferenceComponents(gui_heurFin, "-1 -1 1 2 ").setReferencePositions(gui_heurFin, "0.0 0.0 1.0 0.0");
        gui_lblHeurDeb.setText("Heure d\u00E9but");
                gui_lblHeurDeb.setInlineStylesTheme(resourceObjectInstance);
        gui_lblHeurDeb.setName("lblHeurDeb");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lblHeurDeb.getParent().getLayout()).setInsets(gui_lblHeurDeb, "45.627377% auto auto 20.94972%").setReferenceComponents(gui_lblHeurDeb, "-1 -1 -1 -1").setReferencePositions(gui_lblHeurDeb, "0.0 0.0 0.0 0.0");
        gui_lbldateFin.setText("Date fin");
                gui_lbldateFin.setInlineStylesTheme(resourceObjectInstance);
        gui_lbldateFin.setName("lbldateFin");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbldateFin.getParent().getLayout()).setInsets(gui_lbldateFin, "auto auto 28.326996% -1.8518524mm").setReferenceComponents(gui_lbldateFin, "-1 -1 -1 0 ").setReferencePositions(gui_lbldateFin, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
