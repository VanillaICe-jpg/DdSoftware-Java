
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
 private static Scanner x;
    public static void main(String[] args) {               
        Scanner user = new Scanner(System.in);
        Scanner contrasenia = new Scanner(System.in);
        String username;
        String password;
        //Login
        //Archivo que contiene los usuarios que pueden acceder y sus contraseñas
        String archivo="miembros.csv";
        System.out.println("Identifíquese");
        System.out.println("Coloque su nombre de usuario:");
        username=user.nextLine();
        System.out.println("Coloque su contraseña:");
        password=contrasenia.nextLine();
        if(Login(username,password,archivo)==true){
        //Archivo que contiene los alumnos
        String nombreFich = "alumnos.csv";
        Scanner reader = new Scanner(System.in);
        int contadorL = -1;
        int caliF = 0;
        int [] calf=new int[30];
        Scanner operacion=new Scanner(System.in);
        File fichero = new File(nombreFich);
        //leer la lista
        //columna: matricula, primer apellido, segundo apellido y nombres
        ReadFile readFile = new ReadFile();
        List<Estudiante> estudianteList = readFile.readFile();
                
        //Capturar calificaciones
        Scanner scanner = new Scanner(System.in);
        int calificacion;
        for(Estudiante element : estudianteList){            
            while(true){
                System.out.println("Introduzca calificacion (1-100) de " + element.getNombres() + ":");
                calificacion = scanner.nextInt();
                if( calificacion<1 || calificacion>100){
                    System.out.println("Calificacion invalida. Intente de nuevo");
                }else {
                    break;
                }
            }            
            element.setCalificacion(calificacion);
        }
        
        //Verificar que todos los estudiantes tienen calificacion
        for(Estudiante element : estudianteList){
            if(element.getCalificacion() == -1){
                System.out.println("Error uno o más alumnos no se les ha capturado su calificacion");                
                break;
            }
        }
                
        //Generar archivo de calificaciones (opcional)
        Scanner read = new Scanner(System.in);
        String opcion;
        System.out.println("¿Quieres Generar el nuevo archivo de calificacioens? \n 1.- si \n 2.- no");
        opcion = read.nextLine();
        
        if (opcion.equals("1")) {
            File file = new File("alumnosCalf.csv");
            file.delete();
            CreateFile createFile = new CreateFile();
            createFile.createFile(estudianteList);
            System.out.println("Se ha generado el archivo 'alumnosCalf.csv' correctamete");
        }else {
            System.out.println("No se ha generado el archivo");
        }
                
    }
        else{
        System.out.println("acceso denegado");
        }
    }
       public static boolean Login(String username,String password,String archivo){
        boolean buscado=false;
        String Username="";
        String Password="";
  //Se lee el archivo
        try{
             x= new Scanner(new File(archivo));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !buscado){
                Username=x.next();
                Password=x.next();
 //Se verifica usuario y contraseña
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



