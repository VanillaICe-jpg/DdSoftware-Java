
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class CreateFile {
    
    //matricula nombreasig calificacion 
    public void createFile(List<Estudiante> estudiantesList){
        
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("alumnosCalf.csv", true), "utf-8"));
            for (int i=0; i<estudiantesList.size(); i++){
                bufferedWriter.write(estudiantesList.get(i).getMatricula() + "," +
                        estudiantesList.get(i).getAsignatura() + "," +
                        estudiantesList.get(i).getPrimerApellido() + "," +
                         estudiantesList.get(i).getSegundoApellido() + "," +
                        estudiantesList.get(i).getNombres() + "," +
                        estudiantesList.get(i).getCalificacion() + "\n");
            }
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }        
        
    
}
