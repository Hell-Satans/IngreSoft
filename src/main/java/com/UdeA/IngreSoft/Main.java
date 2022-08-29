package com.UdeA.IngreSoft;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Empresa empresa1=new Empresa("0001A","CLARO S.A.S.","Cra 12 # 34 - 56","7603015","123456789-1");
        System.out.println("El nombre de la empresa es: "+empresa1.getNombre());
        System.out.println("La direccion de la empresa es: "+empresa1.getDireccion());
        System.out.println("El telefono de la empresa es: "+empresa1.getTelefono());
        System.out.println("El nit de la empresa es: "+empresa1.getNit());
        empresa1.setNombre("COMCEL SAS");
        empresa1.setDireccion("Calle 77 # 15 - 14");
        empresa1.setTelefono("4856355");
        empresa1.setNit("55658444-2");
        System.out.println("La empresa cambio su razon social a: "+empresa1.getNombre());
        System.out.println("La empresa cambio su dirección a: "+empresa1.getDireccion());
        System.out.println("La empresa cambio su telefono a: "+empresa1.getTelefono());
        System.out.println("La empresa cambio su nit a: "+empresa1.getNit());

        Scanner x=new Scanner(System.in);
        String dia, mes, anho;
        System.out.println("Ingrese dia de creación de la cuenta");
        dia=x.next();
        System.out.println("Ingrese mes de creacion de la cuenta");
        mes=x.next();
        System.out.println("Ingrese año de creacion de la cuenta");
        anho=x.next();

        date create1=new date(dia,mes,anho);

        empresa1.setCreatedAt(create1);
        System.out.println("La empresa creo su cuenta en nuestro software el: "+empresa1.getCreatedAt().toString());
    }
}
