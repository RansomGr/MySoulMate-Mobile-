/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalAPI;


import java.util.HashMap;
import java.util.Map;

/**
 *This Class was made to resolve the nested JSONObjects Problem
 * the problem is within the CodeName1 API that cannot read nested JSONobjects 
 * 
 *Example
 *myObj = {
 *  "name":"John",
 *   "age":30,
 *  "cars": {
 *       "car1":"Ford",
 *      "car2":"BMW",
 *       "car3":"Fiat"
 *  }
 *}
 *using the JSon parser alone you Parse the object Cars because it's nested within the myObj object
 * 
 * 
 * @author Ransom(A.K..A amine Benmimoun)
 * +216 21 31 49 51
 * Esprit 3A11 - 2017/2018
 */
public class CustomEspritJSONParser {
    private String rawData;
    private Map<String,Object>Objects;
    private int begin;
    public CustomEspritJSONParser(String rawData)
    {
        this.rawData=rawData ;
        this.Objects=new HashMap<>();
    }
    public String read_value(char array[])
    {
        
        String value="";
        char one;
        int nest=0;
        int foist=begin;
           for(begin=begin; begin<array.length-1;begin++)
           {
                one=array[begin];
                if(array[begin]=='{'&&begin==foist)
                {
                  nest++;  
                  value+=one;
                }    
               else if(nest>=1&&begin!=foist)
               {
                    if(one=='{')
                        nest++;
                    else if(one=='}')
                        nest--;
                     value+=one;      
               }else  if((one!=','))
               value+=one;
               else 
               {
               break;
               }
           }
        return value;
    }
        public String read_index(char array[])
    {
        String index="";
        char one;
           if(array[begin]==' '&&array[begin-1]==',')// to skip the space after values
             begin++;
           for(begin=begin; begin<array.length-1;begin++)
           {              
               one=array[begin];
               if(one!='=')
               index+=one;
               else{
                   begin++;
                      break;
               }     
           }
        return index;
    }
    public Map<String,Object>getNestedItems()
    { 
        char one;
        
        char array[]=rawData.toCharArray();
        for(begin=1; begin<array.length-1;begin++)// skipped { and }
        { 
          this.Objects.put(read_index(array),read_value(array));          
        }
        return this.Objects;
    }
    
}
