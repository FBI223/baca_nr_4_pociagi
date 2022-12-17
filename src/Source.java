
import java.util.Scanner;



public class Source {


    public static Scanner skaner = new Scanner(System.in);


    public static class Pociag {
        String name_pociag = "";
        Wagon first = null ;
        Pociag next = null ;
    }


    public static class Wagon {
        String name_wagon = "";
        Wagon prev = null ;
        Wagon next = null ;

    }

    public static class Dworzec_Krakow {


        Pociag first_pociag_dworzec ;

        boolean czy_takie_same_stringi(String s1, String s2 )
        {
            boolean czy_takie_same = true ;
            int i = 0 ;

            System.out.println(s1.length());
            System.out.println(s2.length());

            if ( s1.length() != s2.length() )
            {
                czy_takie_same = false ;
            } else
            {
                while (i < s1.length())
                {
                    if ( s1.charAt(i) != s2.charAt(i)  )
                    {

                        System.out.println("s1 " + s1.charAt(i) + "     s2 " + s2.charAt(i) + "    " + ( s1.charAt(i) != s2.charAt(i)  ) );

                        czy_takie_same = false ;
                    }
                    i++ ;
                }
            }


            return czy_takie_same ;
        }


        public void nowy_pociag_wstaw( String t1, String w1)
        {
            Pociag temp_pociagg ;
            boolean czy_istnieje_juz_taki_pociag = false ;


            if ( first_pociag_dworzec == null )
            {
                first_pociag_dworzec = new Pociag();
                first_pociag_dworzec.name_pociag = t1;
                first_pociag_dworzec.first = new Wagon() ;
                first_pociag_dworzec.next = null;
                first_pociag_dworzec.first.name_wagon = w1;
                System.out.println("flaga 1 ");
                System.out.println(first_pociag_dworzec);
            } else
            {


                temp_pociagg = first_pociag_dworzec;
                System.out.println( temp_pociagg.name_pociag ) ;




                while ( (temp_pociagg.next != null )  && ( czy_istnieje_juz_taki_pociag == false ) )
                {
                    System.out.println("flaga 2 ");
                    System.out.println( temp_pociagg.name_pociag ) ;
                    czy_istnieje_juz_taki_pociag = czy_takie_same_stringi(temp_pociagg.name_pociag, t1)  ;

                    if ( czy_istnieje_juz_taki_pociag == false )
                    {
                        temp_pociagg = temp_pociagg.next;
                    }

                }

                if ( temp_pociagg.next == null )
                {
                    czy_istnieje_juz_taki_pociag = czy_takie_same_stringi(temp_pociagg.name_pociag, t1)  ;
                    System.out.println( "czy istnieje " + czy_istnieje_juz_taki_pociag );

                    System.out.println("flaga 2.4 ");
                    System.out.println( "temp_pociag "+ temp_pociagg.name_pociag ) ;
                    System.out.println( "t1 " + t1 ) ;
                    if ( temp_pociagg.name_pociag.equals(t1) == true )
                    {
                        czy_istnieje_juz_taki_pociag = true ;
                        System.out.println("flaga 2.5 ");
                    }
                }

                if ( czy_istnieje_juz_taki_pociag == false )
                {
                    System.out.println( temp_pociagg.name_pociag ) ;
                    System.out.println("flaga 3 ");
                    temp_pociagg.next = new Pociag();
                    System.out.println( temp_pociagg.name_pociag ) ;
                    temp_pociagg = temp_pociagg.next;
                    System.out.println( temp_pociagg.name_pociag ) ;
                    temp_pociagg.name_pociag = t1;
                    System.out.println( temp_pociagg.name_pociag ) ;
                    temp_pociagg.first = new Wagon();
                    temp_pociagg.first.name_wagon = w1;
                    System.out.println( temp_pociagg.name_pociag ) ;
                } else
                {
                    System.out.println( "Train " + t1 +" already exists" );
                }


            }




        }


        public void insert_first(String t1 , String w1)
        {

            Wagon temp_ostatni_wagon ;

            Pociag temp_pociag = first_pociag_dworzec ;
            while ( temp_pociag.name_pociag.equals(t1) == false )
            {
                if ( temp_pociag.next != null )
                {
                    temp_pociag = temp_pociag.next;
                }
            }

            if ( temp_pociag.name_pociag.equals(t1) == false  )
            {
                System.out.println("Train " + t1 + " does not exist") ;
            } else
            {

                if (temp_pociag.first.next == null)
                {
                    temp_pociag.first.prev = new Wagon();
                    temp_pociag.first.next = temp_pociag.first.prev ;
                    temp_pociag.first.prev.name_wagon = w1 ;

                    temp_pociag.first.prev.next = temp_pociag.first ;
                    temp_pociag.first.prev.prev = temp_pociag.first  ;

                    temp_pociag.first = temp_pociag.first.prev ;
                } else
                {

                    temp_ostatni_wagon = temp_pociag.first.prev ;

                    temp_pociag.first.prev = new Wagon();
                    temp_pociag.first.prev.name_wagon = w1;
                    temp_pociag.first.prev.prev = temp_ostatni_wagon ;
                    temp_ostatni_wagon.next = temp_pociag.first.prev ;
                    temp_pociag.first.prev.next = temp_pociag.first ;

                }

            }


        }



        public void insert_last(String t1 , String w1)
        {

            Wagon temp_ostatni_wagon ;
            Pociag temp_pociag = first_pociag_dworzec ;
            while ( temp_pociag.name_pociag.equals(t1) == false )
            {
                if ( temp_pociag.next != null )
                {
                    temp_pociag = temp_pociag.next;
                }
            }

            if ( temp_pociag.name_pociag.equals(t1) == false  )
            {
                System.out.println("Train " + t1 + " does not exist") ;
            } else
            {


                if (temp_pociag.first.next == null)
                {
                    temp_pociag.first.next = new Wagon();
                    temp_pociag.first.next.prev = temp_pociag.first ;
                    temp_pociag.first.next.name_wagon = w1 ;
                    temp_pociag.first.next.next = temp_pociag.first ;
                    temp_pociag.first.prev = temp_pociag.first.next ;

                } else
                {

                    temp_ostatni_wagon = temp_pociag.first.prev ;

                    temp_pociag.first.prev = new Wagon();
                    temp_pociag.first.prev.name_wagon = w1;
                    temp_pociag.first.prev.next = temp_pociag.first ;

                    temp_pociag.first.prev.prev = temp_ostatni_wagon;
                    temp_ostatni_wagon.next = temp_pociag.first.prev ;

                }


            }

        }

        public void display(String t1)
        {
            Wagon temp_wagon ;
            Pociag temp_pociag = first_pociag_dworzec ;
            String wyjscie = t1 + ": " ;

            if ( temp_pociag == null )
            {
                System.out.println("Train " + t1 + " does not exist") ;
            } else
            {
                while ( ((temp_pociag.name_pociag.equals(t1) == false  ) && ( temp_pociag.next != null ) ) )
                {
                    temp_pociag = temp_pociag.next;
                }

                if ( temp_pociag.name_pociag.equals(t1) == true )
                {

                    temp_wagon = temp_pociag.first;


                    while ( temp_wagon.next != null )
                    {
                        wyjscie += temp_wagon ;
                        wyjscie += " " ;
                        temp_wagon = temp_wagon.next ;
                    }

                    wyjscie += temp_wagon ;


                } else
                {
                    System.out.println("Train " + t1 + " does not exist") ;
                }


            }


        }





        public void display_trains()
        {

            String wyjscie = "Trains: ";
            Pociag temp_pociag = first_pociag_dworzec ;

            if ( temp_pociag != null )
            {
                wyjscie += temp_pociag.name_pociag ;
                while ( temp_pociag.next != null )
                {
                    temp_pociag = temp_pociag.next ;
                    wyjscie += " ";
                    wyjscie += temp_pociag.name_pociag;

                }


            }

            System.out.println(wyjscie);


        }

        public void reverse( String t1 )
        {
            Pociag temp_pociag = first_pociag_dworzec;
            Wagon temp_wagon_1;
            Wagon temp_wagon_2;
            boolean czy_istnieje = false;

            if ( temp_pociag == null )
            {
                System.out.println("Train " + t1 + " does not exist") ;
            } else
            {
                while ( ((temp_pociag.name_pociag.equals(t1) == false  ) && ( temp_pociag.next != null ) ) )
                {
                    temp_pociag = temp_pociag.next;
                }



                if ( temp_pociag.name_pociag.equals(t1) == true )
                {

                    if ( (temp_pociag.first.next != null ) && ( temp_pociag.first.next.next == null ) )
                    {
                        temp_pociag.first = temp_pociag.first.next ;

                    }else if (  temp_pociag.first.next.next != null  )
                    {



                        temp_wagon_1 = temp_pociag.first.prev;
                        temp_wagon_1.prev = temp_pociag.first;
                        temp_wagon_1.next = temp_wagon_1.prev;

                        temp_wagon_1 = temp_wagon_1.next ;

                        temp_pociag.first.prev = temp_pociag.first.next;
                        temp_pociag.first.next = temp_wagon_1;

                        while ( temp_wagon_1 != temp_pociag.first )
                        {
                            temp_wagon_2 = temp_wagon_1.prev ;
                            temp_wagon_1.prev = temp_wagon_1.next;
                            temp_wagon_1.next = temp_wagon_2 ;

                            temp_wagon_1 = temp_wagon_1.next ;
                        }

                        temp_pociag.first = temp_pociag.first.next ;


                    }


                } else
                {
                    System.out.println("Train " + t1 + " does not exist") ;
                }

            }

        }




        void union(String t1, String t2 )
        {

            Pociag temp_pociag_1 = first_pociag_dworzec  ;
            Pociag temp_pociag_2 = first_pociag_dworzec    ;
            Pociag temp_przed_t2 = first_pociag_dworzec    ;

            Wagon temp_wagon;

            boolean czy_znalezione_t1 = false;
            boolean czy_znalezione_t2 = false ;

            if ( first_pociag_dworzec == null )
            {
                System.out.println("Train " + t1 + " does not exist") ;
                System.out.println("Train " + t2 + " does not exist") ;
            } else
            {
                while ( ((czy_znalezione_t1 == false ) || ( czy_znalezione_t2 == false ) ) && ( (temp_pociag_1 != null) || (temp_pociag_2 != null) ) )
                {

                    if ( czy_znalezione_t1 == false )
                    {
                        if ( temp_pociag_1.name_pociag.equals(t1) == true )
                        {
                            czy_znalezione_t1 = true ;
                        } else
                        {
                            if ( temp_pociag_1.next != null )
                            {
                                temp_pociag_1 = temp_pociag_1.next ;
                            }
                        }

                    }

                    if ( czy_znalezione_t2 == false )
                    {
                        if (temp_pociag_2.name_pociag.equals(t2) == true ) {
                            czy_znalezione_t2 = true;
                        } else
                        {
                            if ( temp_pociag_2.next != null )
                            {

                                if ( temp_pociag_2.next.name_pociag.equals(t2) == true )
                                {
                                    temp_przed_t2 = temp_pociag_2;
                                }

                                temp_pociag_2 = temp_pociag_2.next ;
                            }

                        }

                    }
                }

                if (  (czy_znalezione_t1 == false ) && ( czy_znalezione_t2 == false ) )
                {
                    System.out.println("Train " + t1 + " does not exist") ;
                    System.out.println( "Train " + t2 + " does not exist" ) ;

                } else if ( (czy_znalezione_t1 == false ) && ( czy_znalezione_t2 == true ) )
                {
                    System.out.println("Train " + t1 + " does not exist") ;
                } else if ( (czy_znalezione_t1 == false ) && ( czy_znalezione_t2 == true ) )
                {
                    System.out.println("Train " + t2 + " does not exist") ;

                } else if ( (czy_znalezione_t1 == true ) && ( czy_znalezione_t2 == true ) )
                {



                    temp_pociag_1.first.prev.next = temp_pociag_2.first ;
                    temp_wagon = temp_pociag_2.first.prev ; // ostatni wagon drugiego pociagu
                    temp_pociag_2.first.prev = temp_pociag_1.first.prev ;

                    temp_pociag_1.first.prev = temp_wagon ;
                    temp_wagon.next = temp_pociag_1.first ;


                    if ( temp_pociag_2 == first_pociag_dworzec )
                    {
                        first_pociag_dworzec = first_pociag_dworzec.next ;
                    } else if ( temp_pociag_2.next == null )
                    {

                        temp_przed_t2.next = null;

                    } else
                    {
                        temp_przed_t2.next  = temp_pociag_2.next ;
                        temp_pociag_2.next = null;
                    }


                }


            }



        }




        public void del_first(String t1 , String t2)
        {
            Pociag temp_pociag = first_pociag_dworzec ;
            Pociag temp_pociag_przed = first_pociag_dworzec  ;
            Wagon temp_wagon ;
            String temp_wagon_name ;
            String temp_pociag_name;

            if ( temp_pociag == null )
            {
                System.out.println( "Train " + t1 + " does not exist" );
            } else
            {
                while ( (temp_pociag.name_pociag.equals(t1) == false ) &&  ( temp_pociag != null ) )
                {

                     if ( temp_pociag.next != null )
                     {
                         if ( temp_pociag.next.name_pociag.equals(t1) == true  )
                         {
                             temp_pociag_przed = temp_pociag ;
                         }
                     }

                    temp_pociag = temp_pociag.next ;

                }

                if ( first_pociag_dworzec == null )
                {
                    System.out.println( "Train " + t1 + " does not exist" );
                } else
                {

                    if ( first_pociag_dworzec.next == null )
                    {
                        if ( first_pociag_dworzec.name_pociag.equals(t1) == true  )
                        {
                            temp_wagon_name = first_pociag_dworzec.first.name_wagon ;

                            if ( first_pociag_dworzec.first.next == null )
                            {

                                first_pociag_dworzec = new Pociag() ;
                                first_pociag_dworzec.name_pociag = t2;
                                first_pociag_dworzec.first = new Wagon() ;
                                first_pociag_dworzec.first.name_wagon = temp_wagon_name ;
                            } else
                            {
                                first_pociag_dworzec.next = new Pociag() ;
                                first_pociag_dworzec.next.name_pociag = t2;
                                // temp_wagon_name = first_pociag_dworzec.first.name_wagon ;
                                first_pociag_dworzec.next.first = new Wagon() ;
                                first_pociag_dworzec.next.first.name_wagon = temp_wagon_name;

                                first_pociag_dworzec.first = temp_pociag.first.next ;

                            }



                        } else
                        {
                            System.out.println( "Train " + t1 + " does not exist" );
                        }
                    } else
                    {
                        temp_wagon_name = temp_pociag.first.name_wagon ;
                        temp_pociag_name = temp_pociag.name_pociag ;

                        if ( temp_pociag.first.next == null  )
                        {


                            if ( temp_pociag.next == null )
                            {
                                temp_pociag_przed.next = new Pociag();
                                temp_pociag_przed.next.name_pociag = temp_pociag.name_pociag;
                                temp_pociag_przed.next.first = new Wagon();
                                temp_pociag_przed.next.first.name_wagon = temp_pociag.first.name_wagon ;



                            } else if ( temp_pociag == first_pociag_dworzec )
                            {

                                temp_pociag_przed = temp_pociag ;
                                first_pociag_dworzec = first_pociag_dworzec.next ;

                                while ( temp_pociag.next != null )
                                {
                                    temp_pociag = temp_pociag.next ;
                                }

                                temp_pociag.next = new Pociag() ;
                                temp_pociag.next.name_pociag = temp_pociag_przed.name_pociag ;
                                temp_pociag.next.first = new Wagon();
                                temp_pociag.next.first.name_wagon = temp_pociag_przed.first.name_wagon ;



                            } else
                            {

                                temp_pociag_przed = temp_pociag;
                                temp_pociag_przed.next = temp_pociag.next;


                                while ( temp_pociag.next != null )
                                {
                                    temp_pociag = temp_pociag.next ;

                                }

                                temp_pociag.next = new Pociag();
                                temp_pociag.next.name_pociag = temp_pociag_przed.name_pociag;
                                temp_pociag.next.first = new Wagon();
                                temp_pociag.next.first.name_wagon = temp_pociag_przed.first.name_wagon;

                            }


                        } else
                        {



                        }







                    }


//
//                    if ( temp_pociag.first.next == null )
//                    {
//                        temp_wagon_name = temp_pociag.first.name_wagon ;
//
//
//
//
//                        if ( temp_pociag == first_pociag_dworzec )
//                        {
//                            first_pociag_dworzec = first_pociag_dworzec.next ;
//                        } else if ( temp_pociag.next == null )
//                        {
//
//                            temp_pociag_przed.next = null;
//
//                        } else
//                        {
//                            temp_pociag_przed.next  = temp_pociag_przed.next ;
//                            temp_pociag_przed.next = null;
//                        }
//
//                    }





                }



            }



        }






    }


    public static void main(String[] args)
    {


        Dworzec_Krakow dworzec_glowny = new Dworzec_Krakow();



        Pociag temp_pp = new Pociag();
        Pociag p1 = new Pociag();
        Pociag p2  = new Pociag() ;
        Pociag p3  = new Pociag() ;

        Wagon w1 = new Wagon() ;
        Wagon w2 = new Wagon();
        Wagon w3 = new Wagon();
        Wagon temp_ww = new Wagon();

        dworzec_glowny.first_pociag_dworzec = p1;
        temp_pp = dworzec_glowny.first_pociag_dworzec;
        temp_pp.name_pociag = "p1";
        temp_pp.next = p2;
        temp_pp = temp_pp.next;
        temp_pp.name_pociag = "p2";
        temp_pp.next = p3;
        temp_pp = temp_pp.next;
        temp_pp.name_pociag = "p3" ;

        System.out.println(dworzec_glowny.first_pociag_dworzec.name_pociag);
        System.out.println(dworzec_glowny.first_pociag_dworzec );
        System.out.println( );
        System.out.println(dworzec_glowny.first_pociag_dworzec.next.name_pociag );
        System.out.println(dworzec_glowny.first_pociag_dworzec.next );
        System.out.println( );
        System.out.println(dworzec_glowny.first_pociag_dworzec.next.next );
        System.out.println(dworzec_glowny.first_pociag_dworzec.next.next.name_pociag );
        System.out.println( );


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
                    temp_string_pociag = "";
                    temp_string_wagon = "" ;

                    while ( temp_string.charAt(k) != '_' )
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



                    dworzec_ruczaj.nowy_pociag_wstaw(temp_string_pociag,temp_string_wagon);
                    System.out.println("--------");


                }







                j++;
            }
            i++;
        }


    }

}


