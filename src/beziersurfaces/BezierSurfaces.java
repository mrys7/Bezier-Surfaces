package beziersurfaces;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class BezierSurfaces {

    public static void main(String[] args) throws IOException{
        double Px;
        double Py;
        double Pz;
        int surfaceStart=0;
        int surfaceEnd=16;
        LinkedList<pt> ptsTeapot = new LinkedList<pt>();
        LinkedList<pt> ptsTeacup = new LinkedList<pt>();
        LinkedList<pt> ptsTeaspoon = new LinkedList<pt>();
        BufferedReader scan1, scan2, scan3;
        PrintWriter fileTeapot, fileTeacup, fileTeaspoon;
        String fileLine;
        String [] lineWords;
            scan1 = new BufferedReader(new FileReader("src/files/teapotrim.txt"));
            scan2 = new BufferedReader(new FileReader("src/files/teacup.txt"));
            scan3 = new BufferedReader(new FileReader("src/files/teaspoon.txt"));
            fileTeapot = new PrintWriter("src/files/teapotrim_edited.txt");
            fileTeacup = new PrintWriter("src/files/teacup_edited.txt");
            fileTeaspoon = new PrintWriter("src/files/teaspoon_edited.txt");
            
            while((fileLine = scan1.readLine()) != null){
            lineWords = fileLine.split(" ");
            ptsTeapot.add(new pt(Double.parseDouble(lineWords[0]), Double.parseDouble(lineWords[1]), Double.parseDouble(lineWords[2])));
            }
            
            while((fileLine = scan2.readLine()) != null){
            lineWords = fileLine.split(" ");
            ptsTeacup.add(new pt(Double.parseDouble(lineWords[0]), Double.parseDouble(lineWords[1]), Double.parseDouble(lineWords[2])));
            }
            
            while((fileLine = scan3.readLine()) != null){
            lineWords = fileLine.split(" ");
            ptsTeaspoon.add(new pt(Double.parseDouble(lineWords[0]), Double.parseDouble(lineWords[1]), Double.parseDouble(lineWords[2])));
            }
            
            scan1.close();
            scan2.close();
            scan3.close();
        
        for(int i=0; i<32; i++){
            surfaceStart = i*16;
            surfaceEnd = 16 + i*16;
            
            for(double v=0.0; v<=1.0; v+=0.01){
                for(double w=0.0; w<=1.0; w+=0.01){
                    Px = (ptsTeapot.get(surfaceStart).get_X()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+1).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+2).get_X()+ptsTeapot.get(surfaceStart+3).get_X()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(ptsTeapot.get(surfaceStart+4).get_X()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+5).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+6).get_X()+ptsTeapot.get(surfaceStart+7).get_X()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(ptsTeapot.get(surfaceStart+8).get_X()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+9).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+10).get_X()+ptsTeapot.get(surfaceStart+11).get_X()*Math.pow(v, 3))*(3*w*w*(1-w))+(ptsTeapot.get(surfaceStart+12).get_X()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+13).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+14).get_X()+ptsTeapot.get(surfaceStart+15).get_X()*Math.pow(v, 3))*(Math.pow(w, 3));
                    Py = (ptsTeapot.get(surfaceStart).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+1).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+2).get_Y()+ptsTeapot.get(surfaceStart+3).get_Y()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(ptsTeapot.get(surfaceStart+4).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+5).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+6).get_Y()+ptsTeapot.get(surfaceStart+7).get_Y()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(ptsTeapot.get(surfaceStart+8).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+9).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+10).get_Y()+ptsTeapot.get(surfaceStart+11).get_Y()*Math.pow(v, 3))*(3*w*w*(1-w))+(ptsTeapot.get(surfaceStart+12).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+13).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+14).get_Y()+ptsTeapot.get(surfaceStart+15).get_Y()*Math.pow(v, 3))*(Math.pow(w, 3));
                    Pz = (ptsTeapot.get(surfaceStart).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+1).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+2).get_Z()+ptsTeapot.get(surfaceStart+3).get_Z()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(ptsTeapot.get(surfaceStart+4).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+5).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+6).get_Z()+ptsTeapot.get(surfaceStart+7).get_Z()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(ptsTeapot.get(surfaceStart+8).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+9).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+10).get_Z()+ptsTeapot.get(surfaceStart+11).get_Z()*Math.pow(v, 3))*(3*w*w*(1-w))+(ptsTeapot.get(surfaceStart+12).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeapot.get(surfaceStart+13).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeapot.get(surfaceStart+14).get_Z()+ptsTeapot.get(surfaceStart+15).get_Z()*Math.pow(v, 3))*(Math.pow(w, 3));
                    fileTeapot.println(Px + " " + Py + " " +Pz);
                }
            }
        }
        
        for(int i=0; i<26; i++){
            surfaceStart = i*16;
            surfaceEnd = 16 + i*16;
            
            for(double v=0.0; v<=1.0; v+=0.01){
                for(double w=0.0; w<=1.0; w+=0.01){
                    Px = (ptsTeacup.get(surfaceStart).get_X()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+1).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+2).get_X()+ptsTeacup.get(surfaceStart+3).get_X()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(ptsTeacup.get(surfaceStart+4).get_X()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+5).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+6).get_X()+ptsTeacup.get(surfaceStart+7).get_X()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(ptsTeacup.get(surfaceStart+8).get_X()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+9).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+10).get_X()+ptsTeacup.get(surfaceStart+11).get_X()*Math.pow(v, 3))*(3*w*w*(1-w))+(ptsTeacup.get(surfaceStart+12).get_X()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+13).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+14).get_X()+ptsTeacup.get(surfaceStart+15).get_X()*Math.pow(v, 3))*(Math.pow(w, 3));
                    Py = (ptsTeacup.get(surfaceStart).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+1).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+2).get_Y()+ptsTeacup.get(surfaceStart+3).get_Y()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(ptsTeacup.get(surfaceStart+4).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+5).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+6).get_Y()+ptsTeacup.get(surfaceStart+7).get_Y()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(ptsTeacup.get(surfaceStart+8).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+9).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+10).get_Y()+ptsTeacup.get(surfaceStart+11).get_Y()*Math.pow(v, 3))*(3*w*w*(1-w))+(ptsTeacup.get(surfaceStart+12).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+13).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+14).get_Y()+ptsTeacup.get(surfaceStart+15).get_Y()*Math.pow(v, 3))*(Math.pow(w, 3));
                    Pz = (ptsTeacup.get(surfaceStart).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+1).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+2).get_Z()+ptsTeacup.get(surfaceStart+3).get_Z()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(ptsTeacup.get(surfaceStart+4).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+5).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+6).get_Z()+ptsTeacup.get(surfaceStart+7).get_Z()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(ptsTeacup.get(surfaceStart+8).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+9).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+10).get_Z()+ptsTeacup.get(surfaceStart+11).get_Z()*Math.pow(v, 3))*(3*w*w*(1-w))+(ptsTeacup.get(surfaceStart+12).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeacup.get(surfaceStart+13).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeacup.get(surfaceStart+14).get_Z()+ptsTeacup.get(surfaceStart+15).get_Z()*Math.pow(v, 3))*(Math.pow(w, 3));
                    fileTeacup.println(Px + " " + Py + " " +Pz);
                }
            }
        }
        
        for(int i=0; i<16; i++){
            surfaceStart = i*16;
            surfaceEnd = 16 + i*16;
            
            for(double v=0.0; v<=1.0; v+=0.01){
                for(double w=0.0; w<=1.0; w+=0.01){
                    Px = (ptsTeaspoon.get(surfaceStart).get_X()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+1).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+2).get_X()+ptsTeaspoon.get(surfaceStart+3).get_X()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(ptsTeaspoon.get(surfaceStart+4).get_X()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+5).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+6).get_X()+ptsTeaspoon.get(surfaceStart+7).get_X()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(ptsTeaspoon.get(surfaceStart+8).get_X()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+9).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+10).get_X()+ptsTeaspoon.get(surfaceStart+11).get_X()*Math.pow(v, 3))*(3*w*w*(1-w))+(ptsTeaspoon.get(surfaceStart+12).get_X()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+13).get_X()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+14).get_X()+ptsTeaspoon.get(surfaceStart+15).get_X()*Math.pow(v, 3))*(Math.pow(w, 3));
                    Py = (ptsTeaspoon.get(surfaceStart).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+1).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+2).get_Y()+ptsTeaspoon.get(surfaceStart+3).get_Y()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(ptsTeaspoon.get(surfaceStart+4).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+5).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+6).get_Y()+ptsTeaspoon.get(surfaceStart+7).get_Y()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(ptsTeaspoon.get(surfaceStart+8).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+9).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+10).get_Y()+ptsTeaspoon.get(surfaceStart+11).get_Y()*Math.pow(v, 3))*(3*w*w*(1-w))+(ptsTeaspoon.get(surfaceStart+12).get_Y()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+13).get_Y()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+14).get_Y()+ptsTeaspoon.get(surfaceStart+15).get_Y()*Math.pow(v, 3))*(Math.pow(w, 3));
                    Pz = (ptsTeaspoon.get(surfaceStart).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+1).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+2).get_Z()+ptsTeaspoon.get(surfaceStart+3).get_Z()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(ptsTeaspoon.get(surfaceStart+4).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+5).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+6).get_Z()+ptsTeaspoon.get(surfaceStart+7).get_Z()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(ptsTeaspoon.get(surfaceStart+8).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+9).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+10).get_Z()+ptsTeaspoon.get(surfaceStart+11).get_Z()*Math.pow(v, 3))*(3*w*w*(1-w))+(ptsTeaspoon.get(surfaceStart+12).get_Z()*Math.pow(1-v, 3)+3*v*ptsTeaspoon.get(surfaceStart+13).get_Z()*Math.pow(1-v, 2)+3*v*v*(1-v)*ptsTeaspoon.get(surfaceStart+14).get_Z()+ptsTeaspoon.get(surfaceStart+15).get_Z()*Math.pow(v, 3))*(Math.pow(w, 3));
                    fileTeaspoon.println(Px + " " + Py + " " +Pz);
                }
            }
        }
        fileTeapot.close();
        fileTeacup.close();
        fileTeaspoon.close();
        
    }
    
}
