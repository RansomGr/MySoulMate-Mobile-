/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import com.codename1.io.ConnectionRequest;
import java.util.List;
/**
 *
 * @author Ransom
 */
public interface Service<T> {
   static  ConnectionRequest con=new ConnectionRequest();
   // decomment for use
   

   final String url="http://localhost/MySoulMate-Symphony/web/app_dev.php/"; // localhost app_dev
    //final String url="http://localhost/MySoulMate-Symphony/web/"; // localhost app (use command
   //s cache clear --env=prod)
   //final String url="http://192.168.1.8/MySoulMate-Symphony/web/"; // server side
    
  //final String url="http://192.168.1.8/MySoulMate-Symphony/web/"; // server side
  // final String url="http://localhost/MySoulMate-Symphony/web/app_dev.php/"; // localhost app_dev
//  final String url="http://localhost/MySoulMate-Symphony/web/"; // localhost app (use command

  // final String url="http://192.168.1.8/MySoulMate-Symphony/web/"; // server side
   public void  create(T o);
   public void  update(T o);
   public void  remove(T o);
   public List<T> fetchAll();
   public Object fetchOneById(int id);
   public static String getUrl(){return Service.url;}

}
