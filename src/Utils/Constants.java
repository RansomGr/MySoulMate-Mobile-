package Utils;

import Service.Service;


/**
 *
 * @author Sofiene
 */
public class Constants {

       public final static String BASE_URL = Service.getUrl()+"api/";
       public final static String IMAGE_ACTUALITE_URL = Service.getUrl()+"images/actualite/";
       public final static String IMAGE_PROFILE_URL = Service.getUrl()+"images/";
       public final static String GET_PROFILE= BASE_URL+"profile/get";
       public final static String ADD_PROFILE= BASE_URL+"profile/add";
       public final static String GET_CARACTERISTIQUE = BASE_URL+"caracteristique/get";
       public final static String GET_ACTUALITE = BASE_URL+"actualite/get";
       public final static String ADD_ACTUALITE  = BASE_URL+"actualite/add";
       public final static String ADD_CARACTERISTIQUE = BASE_URL+"caracteristique/add";
       public final static String EVALUER_ACTUALTE = BASE_URL+"rate/add";
       public final static String GET_RATING = BASE_URL+"rate/get";    
       public final static String DELETE_ACTUALTE = BASE_URL+"actualite/delete";    
       public final static String HOROSCOPE = "http://horoscope-api.herokuapp.com/horoscope/today/";

}
