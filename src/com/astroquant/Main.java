package com.company;

import java.util.Scanner;

public class Main {
    private String resources;
    private double distance;
    private String name;
public Main(String initResources, double initDistance, String initName)
{
    resources = initResources;
    distance = initDistance;
    name = initName;
}
public void print()
{
    System.out.println("The resources available on " + name + "is: " + resources ) ;
    System.out.println("The distance of the satellite from " + name + "is: " + distance + " meters");
}
    public static void main(String args[])
    {
        Main asteroid_A = new Main("Zinc, Copper, Gold", 200.00, " Asteroid A ");
        asteroid_A.print();
        Main asteroid_B = new Main("Silver, Titanium, Lead", 90.50, " Asteroid B ");
        asteroid_B.print();
        Main asteroid_C = new Main("Tin, Phosphorous, Uranium", 130.00, " Asteroid C ");
       asteroid_C.print();


     }
}

