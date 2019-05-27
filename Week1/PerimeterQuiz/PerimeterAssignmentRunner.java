import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int numPoints = 0;
        
        for (Point currPt : s.getPoints()) {
            numPoints++;
        }
        
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        int numPoints = getNumPoints(s);
        double perimeter = getPerimeter(s);

        return perimeter / numPoints;
    }

    public double getLargestSide(Shape s) {
        double longestSide = Double.MIN_VALUE;
        Point prevPt = s.getLastPoint();
        
        for(Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);

            longestSide = longestSide >= currDist ? longestSide : currDist;
            
            prevPt = currPt;
        }
        
        return longestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = Double.MIN_VALUE;
        
        for(Point currPt : s.getPoints()) {
            double currX = currPt.getX();

            largestX = largestX >= currX ? largestX : currX;
        }
        
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = Double.MIN_VALUE;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            
            double currPerimeter = getPerimeter(s);
            
            largestPerimeter = largestPerimeter >= currPerimeter ? largestPerimeter : currPerimeter;
        }
        
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        double largestPerimeter = Double.MIN_VALUE;
        DirectoryResource dr = new DirectoryResource();
        File temp = null;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            
            double currPerimeter = getPerimeter(s);
            
            if (largestPerimeter < currPerimeter) {
                temp = f;
                largestPerimeter = currPerimeter;
            }
        }

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("num of points = " + getNumPoints(s));
        System.out.println("average length = " + getAverageLength(s));
        System.out.println("longest side = " + getLargestSide(s));
        System.out.println("largest x = " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        System.out.println("largest perimeter = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println("file name = " + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        
        System.out.println("Assignment 1: Calculating information about shapes");
        System.out.println("==================================================");
        pr.testPerimeter();
        
        System.out.println("\n\nAssignment 2: Processing multiple Shape files");
        System.out.println("=============================================");
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
