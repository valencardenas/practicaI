/*
 Modulos 1 y 2, y sus metodos
 */
package liganatacion;

import java.util.Scanner;

/**
 *
 * @author Valentina
 */
public class modulos {
    private Scanner teclado;
    private int cont;
    private int cc,cc1;
    private String nombre;
    private  int naci, genero , estilo, estilo1;
    
    datos Nadador[]=new datos[100];/*ARREGLO DE OBJETOS*/
    
    public modulos(){/*constructor*/
        int aux1=0;
        int aux;
        do{
           teclado= new Scanner(System.in);
           System.out.println("\n1.Modulo 1\n2.Modulo 2\n3.Salir\n");
           aux=teclado.nextInt();
       
        switch (aux){
            case 1:
                   do{
                    teclado= new Scanner(System.in);
                    System.out.println("\n1.Ingresar\n2.Acttualizar\n3.Eliminar\n4.Buscar\n5.Volver al menú principal\n");
                    aux=teclado.nextInt();
       
                    switch (aux){
                            case 1:
                                Ingresar();
                                break;
                            case 2: 
                                Actualizar();
                                break;  
                            case 3: 
                                Eliminar();
                                break;  
                            case 4:
                                Buscar();
                                break;
                            case 5:
                                aux1=5;
                                break;
                            default:
                                System.out.print("Valor erroneo, Intente de nuevo\n");
                
                     }
                              
                     }while(aux1!=5);
                 
                        break;
            case 2: 
                    do{
                    teclado= new Scanner(System.in);
                    System.out.println("\n1.Inscribir Deportista\n2.Eliminar de la prueba\n3.Mostrar pruebas\n4.Volver al menú principal\n ");
                    aux=teclado.nextInt();
       
                        switch (aux){
                             case 1:
                                InscripcionP();
                                break;
                            case 2: 
                                EliminarP();
                                break;  
                            case 3: 
                                MostrarP();
                                break;  
                            case 4:
                                aux1=4;
                                break;

                            default:
                                System.out.print("Valor erroneo, Intente de nuevo\n");
                
                        }
                              
                     }while(aux1!=4);
                        break;  
            case 3: 
                System.out.print("Ha salido\n");
                aux1=3;
                        break;  

            default:
                System.out.print("Valor erroneo, Intente de nuevo\n");
                
         }
                              
        }while(aux1!=3);
    }

 public void Ingresar(){
        int aux=0;
        estilo=0;
        teclado= new Scanner(System.in);
        System.out.print("Ingrese el nombre completo: ");
        nombre=teclado.nextLine();
        System.out.print("Ingrese el documento de identidad: ");
        cc=teclado.nextInt();
        for(int i = 0 ; i<cont;i++){
            cc1=Nadador[i].getCc();
            if(cc1==cc){
                aux=1;
                System.out.print("El deportista ya ha sido ingresado\n");
            }
        }
         if(aux==0){
        System.out.print("Ingrese el genero 1: femenino 2: masculino ");
        genero=teclado.nextInt();
        System.out.print("Ingrese el año de naciemiento (AAAA): ");
        naci=teclado.nextInt();
       
            datos Pers = new datos();
            Pers.setNombre(nombre);
            Pers.setCc(cc);
            Pers.setGenero(genero);
            Pers.setNaci(naci);
            Pers.setEstilo(estilo);
        
            Nadador[cont]=Pers;
            cont++;
        }
    }
    public void Actualizar(){
        int aux2=0;
        System.out.print("\nIngrese el documento del deportista para actualizar los datos\n ");
        cc=teclado.nextInt();
        for(int i = 0 ; i<cont;i++){
            cc1=Nadador[i].getCc();
            if(cc1==cc){
                System.out.print("Ingrese los datos para actualizar  ");
                aux2=1;
                teclado= new Scanner(System.in);
                System.out.print("Ingrese el nombre completo ");
                nombre=teclado.nextLine();
                 System.out.print("Ingrese el documento de identidad: ");
                cc=teclado.nextInt();
                System.out.print("Ingrese el genero 1: femenino 2: masculino ");
                 genero=teclado.nextInt();
                System.out.print("Ingrese el año de naciemiento ");
                naci=teclado.nextInt();
                Nadador[i].setNombre(nombre);
                Nadador[i].setCc(cc);
                Nadador[i].setGenero(genero);
                Nadador[i].setNaci(naci);
                break;
            }  
        }
        if(aux2==0)
            System.out.print("El deportista no esta inscrito");
               

        
    }
    public void Eliminar(){
        int posicionborrar=101;
        if (cont==0)
            System.out.print("No hay ningun deportista a eliminar\n ");
        else{
           /* datos Temporal[] = new datos[cont-1];*/
            System.out.print("Ingrese el documento de identidad del deportista a eliminar \n");
            cc=teclado.nextInt();
            for(int i=0;i<cont;i++){
                cc1=Nadador[i].getCc();
                if (cc == cc1){
                    posicionborrar=i;

                }
            }
            Nadador[posicionborrar]=null;
            for(int i=posicionborrar;i<cont;i++){
                Nadador[i]=Nadador[i+1];
                cont=cont-1;
            }
        }
    }
    public void Buscar(){
        String mostrar="";
        int aux=0;
        System.out.print("Ingrese el documento de identidad del deportista que desea buscar");
        cc=teclado.nextInt();
        if(cont!=0){
            for(int i=0;i<cont;i++){
                cc1=Nadador[i].getCc();
             if (cc == cc1){
                 System.out.print("\nDeportista encontrado\n\n");                
                 mostrar+="Nombre completo: "+Nadador[i].getNombre()+"\n"
                        +"Cedula: "+Nadador[i].getCc()+"\n";
                 System.out.print(mostrar);
                 if(Nadador[i].getGenero()==2)
                     System.out.print("Genero: Masculino\n");
                 else
                     System.out.print("Genero : Femenino\n");
                 if(Nadador[i].getNaci()>2010)
                     System.out.print("Categoria: No existe\n");
                 if(Nadador[i].getNaci()<=2010 && Nadador[i].getNaci()>=2006)
                     System.out.print("Categoria: Infantil A\n");
                 if(Nadador[i].getNaci()<=2005 && Nadador[i].getNaci()>=1999)
                     System.out.print("Categoria: Infantil B\n");
                 if(Nadador[i].getNaci()<=1998 && Nadador[i].getNaci()>=1991 )
                     System.out.print("Categoria: Juvenil\n");
                 if(Nadador[i].getNaci()<=1992)
                     System.out.print("Categoria: Senior\n");                 
                
                 aux=1;
                 break;
             }
            }
        }
        else 
            System.out.print("No hay ningun deportista\n ");
        if(aux==0)
            System.out.print("El deportista no ha sido encontrado\n");
    }    
    
    
    public void InscripcionP(){
        int aux=0;
            teclado.nextLine();
            System.out.print("Ingrese el documento del deportista a inscribir a la prueba\n");
            cc=teclado.nextInt();
            for(int i=0;i<cont;i++){
                cc1=Nadador[i].getCc();
                if(cc== cc1){
                    System.out.print("Pruba para inscribirse\n 1. libre \n 2. mariposa\n3. pecho\n4. espalda\n");
                    estilo=teclado.nextInt();   
                    Nadador[i].setEstilo(estilo);
                    System.out.print("Se ha inscricito satisfactoriamnete\n");
                    aux=1;
                }
                          
            }
            if(aux==0)
                System.out.print("El deportista no se encuentra en la base de datos\n");

            
        }
        public void EliminarP(){
            int posicionborrar=101,aux=0;
            System.out.print("\n\nIngrese el documento del deportista que desea eliminar de la prueba\n");
            cc=teclado.nextInt();
            for(int i=0;i<cont;i++){
                cc1=Nadador[i].getCc();
                if (cc == cc1){
                    if(Nadador[i].getEstilo()!=0){
                    posicionborrar=i;
                    aux=1;
                    }
                }
            if(aux==1)    
            Nadador[posicionborrar].setEstilo(0);
            else if(aux==0)
                System.out.print("\n No existe el numero de documento inscrito\n");
            
             }
        }
        public void MostrarP(){
            int aux=0;
            
            System.out.print("\n\nIngrese la prueba que quiere mostrar \n 1. libre \n 2. mariposa\n3. pecho\n4. espalda\n");
            estilo=teclado.nextInt();
            switch(estilo){
                case 1:
                    System.out.print("\nInscritos a la prueba estilo libre: \n\n");
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=2010 && Nadador[i].getNaci()>=2006){
                            System.out.print("\nCategoria Infantil A:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=2005 && Nadador[i].getNaci()>=1999){
                            System.out.print("\nCategoria Infantil B:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=1998 && Nadador[i].getNaci()>=1991){
                            System.out.print("\nCategoria Juvenil:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=1990){
                            System.out.print("\nCategoria Senior:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    
                    if(aux==0)
                        System.out.print("\nNo hay nadie inscrito en esta prueba\n");
                    break;
                case 2:
                    System.out.print("\nInscritos a la prueba estilo mariposa: \n\n");
                      for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=2010 && Nadador[i].getNaci()>=2006){
                            System.out.print("\nCategoria Infantil A:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=2005 && Nadador[i].getNaci()>=1999){
                            System.out.print("\nCategoria Infantil B:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=1998 && Nadador[i].getNaci()>=1991){
                            System.out.print("\nCategoria Juvenil:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=1990){
                            System.out.print("\nCategoria Senior:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    if(aux==0)
                        System.out.print("\nNo hay nadie inscrito en esta prueba\n");
                    break;
                case 3:
                     System.out.print("\nInscritos a la prueba estilo peccho: \n\n");
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=2010 && Nadador[i].getNaci()>=2006){
                            System.out.print("\nCategoria Infantil A:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=2005 && Nadador[i].getNaci()>=1999){
                            System.out.print("\nCategoria Infantil B:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=1998 && Nadador[i].getNaci()>=1991){
                            System.out.print("\nCategoria Juvenil:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=1990){
                            System.out.print("\nCategoria Senior:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    if(aux==0)
                        System.out.print("\nNo hay nadie inscrito en esta prueba\n");
                    break;
                  
                case 4:
                     System.out.print("\nInscritos a la prueba estilo espalda \n\n");
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=2010 && Nadador[i].getNaci()>=2006){
                            System.out.print("\nCategoria Infantil A:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=2005 && Nadador[i].getNaci()>=1999){
                            System.out.print("\nCategoria Infantil B:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=1998 && Nadador[i].getNaci()>=1991){
                            System.out.print("\nCategoria Juvenil:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    for(int i=0; i < cont ; i++){
                        estilo1=Nadador[i].getEstilo();
                        if(estilo1==estilo && Nadador[i].getNaci()<=1990){
                            System.out.print("\nCategoria Senior:\n");
                            escribir(i);
                            aux=1;
                        }    
                    }
                    if(aux==0)
                        System.out.print("\nNo hay nadie inscrito en esta prueba\n");                        
                    break;
                default:
                    System.out.print("\nNo existe otro estilo\n");
            }
                

            
        }
        
        
        
       public void escribir(int i){
           String mostrar1="";
           mostrar1+="Nombre completo: "+Nadador[i].getNombre()+"\n"
                        +"Cedula: "+Nadador[i].getCc()+"\n";
                        System.out.print(mostrar1);
                        if(Nadador[i].getGenero()==2)
                            System.out.print("Genero: Masculino\n");
                        else
                            System.out.print("Genero : Femenino\n");
                      /*  if(Nadador[i].getNaci()>2010)
                            System.out.print("Categoria: No existe\n");
                        if(Nadador[i].getNaci()<=2010 && Nadador[i].getNaci()>=2006)
                            System.out.print("Categoria: Infantil A\n");
                        if(Nadador[i].getNaci()<=2005 && Nadador[i].getNaci()>=1999)
                            System.out.print("Categoria: Infantil B\n");
                        if(Nadador[i].getNaci()<=1998 && Nadador[i].getNaci()>=1991 )
                            System.out.print("Categoria: Juvenil\n");
                        if(Nadador[i].getNaci()<=1990)
                            System.out.print("Categoria: Senior\n");*/
       } 
             
    }
