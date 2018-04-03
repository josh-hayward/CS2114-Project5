// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with 
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor 
// will I accept the actions of those who do.
// -- Cameron Moore (cam1111)
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class 
 * @author Cameron Moore (cam1111)
 * @version 2018.04.01
 */
public class Input 
{
    public Input()
    {
        
    }
    
    public static final void main(String[] args) throws FileNotFoundException
    {
        Scanner survey = new Scanner(new File(args[0]));
        survey.useDelimiter(",");
        Scanner songList = new Scanner(new File(args[1]));
        songList.useDelimiter(",");
    }
}
