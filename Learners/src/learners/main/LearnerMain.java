/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package learners.main;

import learners.classifiers.Classifer;
import learners.classifiers.bayes.NaiveBayes;
import learners.data.DataSet;
import learners.data.DataSetLoader;
/**
 *
 * @author Dv6
 */
public class LearnerMain {


  
    public static void main(String[] args) {
                
     
        DataSet d= new DataSet("hello");
        DataSetLoader dl = new DataSetLoader();
        DataSetLoader.setDATABASE_URL("jdbc:mysql://localhost:3306/test");
        
        d = dl.DatasetLoader("select * from weather",d);
             
       //NaiveBayes 
       NaiveBayes nb = new NaiveBayes();
       Classifer c = nb.Train(d);
       
       
  
         System.out.println(c.StringSummary());

   
  }
    
    
}
