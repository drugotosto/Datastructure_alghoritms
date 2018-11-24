package com.ferrero;

import com.ferrero.data_structures.stack.CardStackApp;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        int[] array = new int[]{1,2,3};
        System.out.println(String.format(" Array ritornato: %s", Arrays.toString(array)));

        // Avvio Stack Application
        CardStackApp.startCardStackApp();
    }
}
