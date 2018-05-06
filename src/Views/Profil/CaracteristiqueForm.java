package Views.Profil;

import Entities.Profil.Caracteristique;


import com.codename1.ui.Component;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 * @author Sofien
 */
public class CaracteristiqueForm extends SideMenuBaseForm {

    public CaracteristiqueForm(Resources res, Caracteristique c) {

        super("Détails Caractéristique", BoxLayout.y());   
            Font largeBoldMonospaceFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_SMALL);
            Font large = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_LARGE);
            Label alcool = new Label(c.getAlcool());
            alcool.setUIID("Label");
            addStringValue("Alcool", alcool);
            alcool.getStyle().setFgColor(0x2d3436);
            alcool.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(alcool, FontImage.MATERIAL_OPACITY);

            Label corpulence = new Label(c.getCorpulence());
            corpulence.setUIID("Label");
            addStringValue("Corpulence", corpulence);
            corpulence.getStyle().setFgColor(0x2d3436);
            corpulence.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(corpulence, FontImage.MATERIAL_ACCESSIBILITY);

            Label caractere = new Label(c.getCaractere());
            caractere.setUIID("Label");
            addStringValue("Caractére", caractere);
            caractere.getStyle().setFgColor(0x2d3436);
            caractere.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(caractere, FontImage.MATERIAL_INSERT_EMOTICON);

            Label cheveux = new Label(c.getCheveux());
            cheveux.setUIID("Label");
            addStringValue("Cheveux", cheveux);
            cheveux.getStyle().setFgColor(0x2d3436);
            cheveux.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(cheveux, FontImage.MATERIAL_FACE);

            Label cuisine = new Label(c.getCuisine());
            cuisine.setUIID("Label");
            addStringValue("Cuisine", cuisine);
            cuisine.getStyle().setFgColor(0x2d3436);
            cuisine.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(cuisine, FontImage.MATERIAL_RESTAURANT);

            Label origine = new Label(c.getOrigine());
            origine.setUIID("Label");
            addStringValue("Origine", origine);
            origine.getStyle().setFgColor(0x2d3436);
            origine.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(origine, FontImage.MATERIAL_FINGERPRINT);

            Label pilosite = new Label(c.getPilosite());
            pilosite.setUIID("Label");
            addStringValue("Pilosite", pilosite);
            pilosite.getStyle().setFgColor(0x2d3436);
            pilosite.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(pilosite, FontImage.MATERIAL_MAP);

            Label profession = new Label(c.getProfession());
            profession.setUIID("Label");
            addStringValue("Profession", profession);
            profession.getStyle().setFgColor(0x2d3436);
            profession.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(profession, FontImage.MATERIAL_EMAIL);

            Label taille = new Label(c.getTaille());
            taille.setUIID("Label");
            addStringValue("Taille", taille);
            taille.getStyle().setFgColor(0x2d3436);
            taille.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(taille, FontImage.MATERIAL_TEXT_FIELDS);

            Label status = new Label(c.getStatut());
            status.setUIID("Label");
            addStringValue("Status", status);
            status.getStyle().setFgColor(0x2d3436);
            status.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(status, FontImage.MATERIAL_WC);

            Label tabac = new Label(c.getTabac());
            tabac.setUIID("Label");
            addStringValue("Tabac", tabac);
            tabac.getStyle().setFgColor(0x2d3436);
            tabac.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(tabac, FontImage.MATERIAL_SMOKING_ROOMS);

            Label yeux = new Label(c.getTabac());
            yeux.setUIID("Label");
            addStringValue("Yeux", yeux);
            yeux.getStyle().setFgColor(0x2d3436);
            yeux.getUnselectedStyle().setFont(largeBoldMonospaceFont);
            FontImage.setMaterialIcon(yeux, FontImage.MATERIAL_VISIBILITY);
            refreshTheme();

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

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "Label")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }

    @Override
    protected void showOtherForm(Resources res) {

    }

}
