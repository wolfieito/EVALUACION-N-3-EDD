
import java.util.Comparator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martin
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList miList = new LinkedList();
        for(int i = 0; i < 14; i++){
            int ran = (int)(Math.random()*100)+1;
            miList.add(ran);
        }
        System.out.println(miList);
        
        Comparator c = new Comparator(){//clase anonima, no tiene nombre

            @Override
            public int compare(Object o1, Object o2) {
              int resu;
              //cero---->igual
              //positivo---->mayor
              //negativo----->menor
              Integer val1,val2;
              val1 = (Integer)o1;
              val2 = (Integer)o2;
              resu = val2 -val1;//mayor a menor
              //resu = val1 -val2;//menor a mayor
              
              return resu;
            }
        
        };
        
        miList.sort(c);
        System.out.println(miList);
        //oredenar lista con strings
        LinkedList<String> listaStrg = new LinkedList<String>();
        listaStrg.add("HOLA");
        listaStrg.add(" ");
        listaStrg.add("MUNDO");
        listaStrg.add(" ");
        listaStrg.add("CRUEL");
        listaStrg.add("!!");
        Comparator cmpStrg = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                String cade1 = (String) o1;
                String cade2 = (String) o2;
                char c1 = cade1.charAt(0);
                char c2 = cade2.charAt(0);
                
                return c1 - c2;
            }
        };
        System.out.println(listaStrg);
        listaStrg.sort(cmpStrg);
        System.out.println(listaStrg);
    }
    
}
