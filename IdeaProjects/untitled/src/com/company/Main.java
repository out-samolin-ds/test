package com.company;

import java.io.*;
import java.lang.reflect.Array;
public class Main {

    public static void main(String[] args) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int [] b = new int[4];
        for (int i =0; i<b.length;i++){
            b[i]= Integer.parseInt(rd.readLine());
        }
        java.util.Arrays.sort(b);
        System.out.print(b[3]);
    }
}
