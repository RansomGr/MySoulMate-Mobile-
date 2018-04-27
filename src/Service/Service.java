/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.ui.List;

/**
 *
 * @author Ransom
 */
public interface Service {
   static  ConnectionRequest con=new ConnectionRequest();
   final String url="http://localhost/MySoulMate-Symphony/web/app_dev.php/";
   public void  create(Object o);
   public void  update(Object o);
   public void remove(Object o);
   public List<? extends Object> fetchAll();
   public Object fetchOneById();
}
