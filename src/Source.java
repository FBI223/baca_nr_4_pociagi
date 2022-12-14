
import java.util.Scanner;



public class Source {


    public static Scanner skaner = new Scanner(System.in);




    public static class Dworzec_Krakow
    {




    }




    public static void main(String[] args)
    {


//        Pociag temp_pp = new Pociag();
//        Pociag p1 = new Pociag();
//        Pociag p2  = new Pociag() ;
//        Pociag p3  = new Pociag() ;
//
//        Wagon w1 = new Wagon() ;
//        Wagon w2 = new Wagon();
//        Wagon w3 = new Wagon();
//        Wagon temp_22 = new Wagon();


//        temp_pp = p1;
//        temp_pp.name_pociag = "p1" ;
//
//        System.out.println(temp_pp);
//        System.out.println(temp_pp.name_pociag);
//        System.out.println();
//
//        temp_pp.next = p2;
//        temp_pp = temp_pp.next;
//
//        temp_pp.name_pociag = "p2" ;
//
//        System.out.println(temp_pp);
//        System.out.println(temp_pp.name_pociag);
//        System.out.println();
//
//        temp_pp.next = p3;
//        temp_pp = temp_pp.next;
//        temp_pp.name_pociag = "p3" ;
//
//        System.out.println(temp_pp);
//        System.out.println(temp_pp.name_pociag);
//        System.out.println();
//
//        temp_pp.next = new Pociag();
//        temp_pp = temp_pp.next;
//        temp_pp.name_pociag = "p4" ;
//
//        System.out.println(temp_pp);
//        System.out.println(temp_pp.name_pociag);
//        System.out.println();


        Dworzec_Krakow dworzec_ruczaj = new Dworzec_Krakow() ;
        Pociag temp_pociagix ;

        String temp_string = "";
        String temp_string_wagon = "";
        String temp_string_pociag = "";

        boolean flaga_czy_error = false ;

        int ile_zestawow_danych = 0;
        int ile_komend_w_zestawie = 0;

        int i = 0 ;
        int j = 0 ;
        int k = 0 ;

        temp_string = skaner.nextLine();
        ile_zestawow_danych =  Integer.parseInt(temp_string) ;
        temp_string = skaner.nextLine();
        ile_komend_w_zestawie = Integer.parseInt(temp_string) ;

        while ( i < ile_zestawow_danych )
        {
            while ( j < ile_komend_w_zestawie )
            {
                flaga_czy_error = false ;
                temp_string = skaner.nextLine();


                if ( ( temp_string.charAt(0) == 'N' ) && ( temp_string.charAt(1) == 'e' ) && ( temp_string.charAt(2) == 'w' ) )
                {
                    k = 4 ;
                    while ( temp_string.charAt(k) != ' ' )
                    {
                        temp_string_pociag += temp_string.charAt(k);
                        k++;
                    }
                    k++;
                    while ( k < temp_string.length())
                    {
                        temp_string_wagon += temp_string.charAt(k);
                        k++;
                    }

                }



                // dworzec_ruczaj.nowy_pociag_wstaw(temp_string_pociag,temp_string_wagon);
                System.out.println("--------");



                j++;
            }
            i++;
        }


    }

}


