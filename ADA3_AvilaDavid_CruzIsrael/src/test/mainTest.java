/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import test.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import java.util.Scanner;

/**
 *
 * @author userhp
 */
public class mainTest {
      private static Scanner x;
      public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Scanner contrasenia = new Scanner(System.in);
        String username;
        String password;
        String archivo="miembros.csv";
        System.out.println("Identifíquese");
        System.out.println("Coloque su nombre de usuario:");
        username=user.nextLine();
        System.out.println("Coloque su contraseña:");
        password=contrasenia.nextLine();
        if(Login(username,password,archivo)==true){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String nombreFich = "alumnos.csv";
        Scanner reader = new Scanner(System.in);
        int contadorL = -1;
        int caliF = 0;
        int [] calf=new int[30];
        Scanner operacion=new Scanner(System.in);
        File fichero = new File(nombreFich);
      
        
        System.out.print("Ingrese la calificacion del Alumno Basto Angel \n");  
        caliF = reader.nextInt();
        if(caliF > 100){
            while (caliF > 100)
            {System.out.print("Ingrese la calificacion del Alumno Basto Angel \n");  
        caliF = reader.nextInt();}
        }
        usuarios.add(new Usuario("1400", "Pacheco", "Basto","Angel","D. Software",caliF));
        
        
        System.out.print("Ingrese la calificacion del Alumno Ucan Alex \n");
        caliF = reader.nextInt();
        if(caliF > 100){
            while (caliF > 100)
            {System.out.print("Ingrese la calificacion del Alumno Ucan Alex \n");  
        caliF = reader.nextInt();}
        }
        usuarios.add(new Usuario("1401", "Osorio", "Ucan","Alex","D. Software",caliF));
        
        System.out.print("Ingrese la calificacion del Alumno Costa Villanueva \n");
        caliF = reader.nextInt();
        if(caliF > 100){
            while (caliF > 100){System.out.print("Ingrese la calificacion del Alumno Costa Villanueva \n");  
        caliF = reader.nextInt();}
        }
        usuarios.add(new Usuario("1402", "Costa", "Villanueva","Marta","D. Software",caliF));
        
        ExportarCSV(usuarios);
        ImportarCSV();
        
 try {
   BufferedReader fich = new BufferedReader(new FileReader(nombreFich));
   //Usamos la clase BufferReadeader para tener acceso a un metodo propio (readLine()) y asi mediante un contador contar las lineas.
   String linea;
   try {
    //En este caso la condicion final del while corresponde a null, para indicar el final de linea
    while((linea = fich.readLine()) != null){
     contadorL++;
    }
   System.out.println("El número de líneas :" + contadorL);
   } catch (IOException e) {
    // TODO Bloque catch generado automáticamente
    e.printStackTrace();
   }
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  for(int i=0;i<contadorL;i++){
   
      
  }
        }else{
        System.out.println("acceso denegado");
        }
        
        
    }
    
    public static void ExportarCSV(List<Usuario> usuarios) {
        String salidaArchivo = "alumnos.csv"; // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
        
        // Si existe un archivo llamado asi lo borra
        if(existe) {
            File archivoUsuarios = new File(salidaArchivo);
            archivoUsuarios.delete();
        }
        
        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("Matricula");
            salidaCSV.write("Primer Apellido");
            salidaCSV.write("Segundo Apellido");
            salidaCSV.write("Nombre");
            salidaCSV.write("Asignatura");
            salidaCSV.write("Calificacion");
            
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            // Recorremos la lista y lo insertamos en el archivo
            for(Usuario user : usuarios) {
               salidaCSV.write(user.getMatricula());
               salidaCSV.write(user.getApellido1());
               salidaCSV.write(user.getApellido2());
               salidaCSV.write(user.getNombre());
               salidaCSV.write(user.getAsignatura());
               salidaCSV.write(Integer.toString(user.getCalificacion()));
                
                
                
                
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }
            
            salidaCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }    
    }
    
    public static void ImportarCSV() {
        try{
            List<Usuario> usuarios = new ArrayList<Usuario>(); // Lista donde guardaremos los datos del archivo
            
            CsvReader leerUsuarios = new CsvReader("alumnos.csv");
            leerUsuarios.readHeaders();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String Matricula = leerUsuarios.get(0);
                String Apellido1 = leerUsuarios.get(1);
                String Apellido2 = leerUsuarios.get(2);
                String Nombre = leerUsuarios.get(3);
                String Asignatura = leerUsuarios.get(4);
                String Calificacion = leerUsuarios.get(5);
             
                
                usuarios.add(new Usuario(Matricula,Apellido1,Apellido2,Nombre,Asignatura,Integer.parseInt(Calificacion))); // Añade la informacion a la lista
            }
            
            leerUsuarios.close(); // Cierra el archivo
            
            // Recorremos la lista y la mostramos en la pantalla
            for(Usuario user : usuarios) {
                System.out.println(
                    user.getMatricula()+ " , " 
                    +user.getNombre() + " , "
                    +user.getApellido1()+ " , "
                    +user.getApellido1()+ " , "
                    +user.getAsignatura()+ " , "
                    +user.getCalificacion());
            }
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean Login(String username,String password,String archivo){
        boolean buscado=false;
        String Username="";
        String Password="";
        try{
             x= new Scanner(new File(archivo));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !buscado){
                Username=x.next();
                Password=x.next();
                if(Username.trim().equals(username)&& Password.trim().equals(password)){
                    buscado=true;
                }
            }
            x.close();
            return buscado;
            
        }
        catch(Exception e){
            return false;
          
        }
    }
     
    
    
}
