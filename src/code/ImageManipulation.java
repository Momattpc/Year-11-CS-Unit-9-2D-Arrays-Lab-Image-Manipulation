package code;

import image.APImage;
import image.ImagePanel;
import image.Pixel;

public class ImageManipulation {

    /** CHALLENGE 0: Display Image
     *  Write a statement that will display the image in a window
     */








    public static void main(String[] args) {

        //APImage output = new APImage("cyberpunk2077.jpg");
        //grayScale("cyberpunk2077.jpg");
        //blackAndWhite("cyberpunk2077.jpg");
        edgeDetection("cyberpunk2077.jpg", 20);
        //output.draw();


    }


    /** CHALLENGE ONE: Grayscale
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     *
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value. */
    public static void grayScale(String pathOfFile) {
        APImage change1 = new APImage(pathOfFile);
        Pixel [] [] arrayone = new Pixel [change1.getHeight()] [change1.getWidth()];
        for (int i = 0; i < change1.getHeight(); i++){
            for (int j = 0; j < change1.getWidth(); j++){
                arrayone [i] [j] = change1.getPixel(j,i);
                int average = getAverageColour(change1.getPixel(j,i));
                arrayone[i][j].setRed(average);
                arrayone[i][j].setBlue(average);
                arrayone[i][j].setGreen(average);
            }
        }
        change1.draw();
    }

    /** A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        int avg = (pixel.getRed()+ pixel.getBlue()+ pixel.getGreen()) / 3;
        return avg;
    }

    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        APImage change2 = new APImage(pathOfFile);
        Pixel [] [] arrayone = new Pixel [change2.getHeight()] [change2.getWidth()];
        for (int i = 0; i < change2.getHeight(); i++){
            for (int j = 0; j < change2.getWidth(); j++){
                arrayone [i] [j] = change2.getPixel(j,i);
                int average = getAverageColour(change2.getPixel(j,i));
                if (average < 128){
                    arrayone [i] [j].setBlue(0);
                    arrayone [i] [j].setRed(0);
                    arrayone [i] [j].setGreen(0);
                }
                else {
                    arrayone [i] [j].setBlue(255);
                    arrayone [i] [j].setRed(255);
                    arrayone [i] [j].setGreen(255);
                }
            }
        }
        change2.draw();

    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        APImage change3 = new APImage(pathToFile);
        Pixel [] [] arrayone = new Pixel [change3.getHeight()] [change3.getWidth()];
        for (int i = 0; i < change3.getHeight(); i++){
            for (int j = 0; j < change3.getWidth(); j++){
                arrayone [i] [j] = change3.getPixel(j,i);
                int averageCurrent = getAverageColour(change3.getPixel(j,i));
                int averageleft = 0;
                int averagedown = 0;
                if (j+1 < change3.getWidth() && j-1 > -1){
                    averageleft = getAverageColour(change3.getPixel(j-1,i));
                }
                if (i+1 < change3.getHeight()){
                    averagedown = getAverageColour(change3.getPixel(j,i+1));
                }

                if (Math.abs(averageCurrent -averageleft) > threshold || Math.abs(averageCurrent - averagedown) > threshold){
                    arrayone [i] [j].setBlue(0);
                    arrayone [i] [j].setRed(0);
                    arrayone [i] [j].setGreen(0);
                }
                else {
                    arrayone [i] [j].setBlue(255);
                    arrayone [i] [j].setRed(255);
                    arrayone [i] [j].setGreen(255);
                }
            }
        }
        change3.draw();
    }

    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {

    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
    public static void rotateImage(String pathToFile) {

    }

}
