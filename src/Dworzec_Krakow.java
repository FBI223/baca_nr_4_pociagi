public class Dworzec_Krakow {


    Pociag first_pociag_dworzec ;

    public void nowy_pociag_wstaw( String t1, String w1)
    {
        Pociag temp_pociagg ;
        boolean czy_istnieje_juz_taki_pociag = false ;


        System.out.println("flaga 0 " + first_pociag_dworzec );

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

            while ( (temp_pociagg.next != null) && ( czy_istnieje_juz_taki_pociag == false ) )
            {
                System.out.println("flaga 2 ");
                System.out.println( temp_pociagg.name_pociag ) ;
                if ( temp_pociagg.name_pociag == t1 )
                {
                    czy_istnieje_juz_taki_pociag = true;
                } else
                {
                    temp_pociagg = temp_pociagg.next;
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


}
