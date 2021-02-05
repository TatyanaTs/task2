package task2; //java -jar task2.jar test2.txt test3.txt

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class task2 extends Applet {

    public static void main(String[] args) throws Exception {
        int nPoints = 4;
        float[] xpoints = new float[nPoints];
        float[] ypoints = new float[nPoints];

        String filePath = args[0];
        Scanner scanner = new Scanner(new File(filePath));
        int i = 0;
        while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split("[\\\\n\\s]+");
                xpoints[i] = Float.parseFloat(data[0]);
                ypoints[i] = Float.parseFloat(data[1]);
                i++;
        }
        scanner.close();

        Path2D figure = new Path2D.Float();
        figure.moveTo(xpoints[0], ypoints[0]);
        figure.lineTo(xpoints[1], ypoints[1]);
        figure.lineTo(xpoints[2], ypoints[2]);
        figure.lineTo(xpoints[3], ypoints[3]);

        String filePath2 = args[1];
        Scanner scan = new Scanner(new File(filePath2));

        BufferedReader reader = new BufferedReader(new FileReader(filePath2));
        int lines = 0;
        while (reader.readLine() != null) {
            lines++; //подсчет количества чисел для массива
        }
        reader.close();

        float[][] points = new float[lines][2];
        int n = 0;
        while (scan.hasNextLine()) {
            String[] data = scan.nextLine().split("[\\\\n\\s]+");
            points[n][0] = Float.parseFloat(data[0]);
            points[n][1] = Float.parseFloat(data[1]);
            n++;
        }
        for (int a = 0; a < lines; a++) {
            Point2D point = new Point2D.Float(points[a][0], points[a][1]);
            System.out.println(point);
            if (figure.contains(point)) {
                System.out.println("Точка " + (a+1) + " = 2 - точка внутри");
            } else {
                Point2D top1 = new Point2D.Float(xpoints[0], ypoints[0]);
                Point2D top2 = new Point2D.Float(xpoints[1], ypoints[1]);
                Point2D top3 = new Point2D.Float(xpoints[2], ypoints[2]);
                Point2D top4 = new Point2D.Float(xpoints[3], ypoints[3]);
                if (point.equals(top1) || point.equals(top2) || point.equals(top3) || point.equals(top4)) {
                    System.out.println("Точка " + (a + 1) + " = 0 - точка на одной из вершин");
                } else {
                    System.out.println("Точка " + (a+1) + " = 1 - точка на одной из сторон или 3 - точка снаружи");
                }
            }
        }
    }
}
