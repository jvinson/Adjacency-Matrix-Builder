/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adjacencymatrixbuilder;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import adjacencymatrixbuilder.Floyd;

/**
 *
 * @author JV
 */
public class AdjacencyMatrixBuilder {

    /**
     * @param args the command line arguments
     */
    
    public static final int INFINITY = 999;
    
    public static void main(String[] args) throws Exception{
        
        AdjacencyMatrixBuilder amb = new AdjacencyMatrixBuilder();
        amb.writeToFile(amb.generateMatrix());
        int [][] finalMatrix;
        finalMatrix = amb.generateMatrix();
        for(int i = 0; i <100; i++){
            for(int j = 0; j <100; j++){
                System.out.print(finalMatrix[i][j]);
            }
            System.out.print("\n");
        }
    }
    
    public int[][] generateMatrix(){
        boolean horizontalDirection = false;
        int[][] matrix = new int [100][100];
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                matrix[i][j] = 0;
            }
        }
        
        for(int i = 0; i < 100; i++){
            if(i !=0 & i%10 == 0){
                if(horizontalDirection)
                    horizontalDirection = false;
                else
                    horizontalDirection = true;
            }
            
            if(i >= 0 & i <= 9){//if statement for top row and top corners
                if(i == 0){
                    matrix[0][1] = 1;
                    matrix[0][10] = 1;
                }
                else if(i == 9){
                    //do nothing
                }
                else{
                    if(i%2 == 0){
                        matrix[i][i+1] = 1;
                        matrix[i][i+10] = 1;
                    }
                    else{
                        matrix[i][i+1] = 1;
                    }
                }
            }
                
            else if(i >= 90 & i <=99){//if statement for bottom row and bottom corners
                if(i == 90){
                    //do nothing
                }
                else if(i == 99){
                    matrix[99][i-1] = 1;
                    matrix[99][i-10] = 1;
                }
                else{
                    if(i%2 == 0){
                        matrix[i][i-1] = 1;
                    }
                    else{
                        matrix[i][i-1] = 1;
                        matrix[i][i-10] = 1;
                    }
                }
            }
                
            else if(i == 19 | i == 29 | i == 39 | i == 49 | i == 59 | i == 69 | i == 79 | i == 89){//if statement for leftmost column
                if(horizontalDirection){//if going west
                    matrix[i][i-1] = 1;
                    matrix[i][i-10] = 1;
                }
                else{//if going east
                    matrix[i][i-10] = 1;
                }
            }
                
            else if( i%10 == 0 & i!=0 & i!=90){//if statement for rightmost column
                if(horizontalDirection){//if going west
                    matrix[i][i+10] = 1;
                }
                else{//if going east
                    matrix[i][i+1] = 1;
                    matrix[i][i+10] = 1;
                }
            }
                
            else{
                if(horizontalDirection & i%2 == 0){
                    matrix[i][i-1] = 1;
                    matrix[i][i+10] = 1;
                }
                else if(horizontalDirection & i%2 != 0){
                    matrix[i][i-1] = 1;
                    matrix[i][i-10] = 1;
                }
                else if(!horizontalDirection & i%2 == 0){
                    matrix[i][i+1] = 1;
                    matrix[i][i+10] = 1;
                }
                else if(!horizontalDirection & i%2 != 0){
                    matrix[i][i+1] = 1;
                    matrix[i][i-10] = 1;
                }
            }
        }
        
        
        return matrix;
    }
    
    public void writeToFile(int [][] matrix) throws Exception{
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/users/JV/Documents/adjacencyMatrix.txt")/*, "utf-8"*/));
        
        for (int i = 0; i<matrix.length; i++){//writes data from array into new file
                for (int j = 0; j<matrix.length; j++){
                    //int X = (int) matrix[i][j];
                    writer.write(Integer.toString(matrix[i][j]));
                    //j++;
                    writer.write("   ");
                    //int Y = (int) matrix[i][j];
                    //writer.write(Integer.toString(Y));
                    //writer.newLine();
                }
            }
        writer.close();
    }
    
}
