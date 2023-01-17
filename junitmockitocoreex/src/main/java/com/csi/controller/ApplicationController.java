package com.csi.controller;

public class ApplicationController {

    public static void main(String[] args) {

        ApplicationController controller= new ApplicationController();

        System.out.println("Addition Result: "+ controller.add(4, 5));
    }

    public int add(int n1, int n2) {
        return n1 + n2;
    }
}
