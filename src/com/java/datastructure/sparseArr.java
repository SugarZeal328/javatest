package com.java.datastructure;

import java.util.Arrays;

public class sparseArr {

    public static void main(String[] args){
        //创建棋盘
        chessArr chess = new chessArr();
        chess.createBroad(5,5);
        chess.chessBoard[0][0] = 1;
        chess.chessBoard[1][2] = 2;
        chess.chessBoard[2][4] = 3;
        chess.chessBoard[3][3] = 4;
        chess.chessBoard[4][4] = 5;

        //打印棋盘
        System.out.println("打印棋盘");
        for (int i = 0; i < chess.chessBoard.length; i++){
            System.out.println(Arrays.toString(chess.chessBoard[i]));
        }

        //创建稀疏数组
        System.out.println("创建棋盘的稀疏矩阵");
        sparseArr sparse = new sparseArr();
        sparse.creatsparseArr(chess);

        //由稀疏矩阵转出棋盘
        System.out.println("由稀疏矩阵输入棋盘");
        chess.reverseBroad(sparse);

    }


   int sparseArr[][];

    //创建稀疏数组方法
    public int[][] creatsparseArr(chessArr chess){
        int rowNum = 1;
        int colNum = 3;

        //确定稀疏矩阵的行数：棋盘中不为0的元素个数 + 1
        for (int i = 0; i < chess.chessBoard.length; i++){
            for (int j = 0; j < chess.chessBoard[0].length; j++){
                if (chess.chessBoard[i][j] != 0){
                    rowNum++;
                }
            }
        }

        //创建稀疏矩阵
        int tempArr[][] = new int[rowNum][colNum];
        sparseArr = tempArr;

        //给稀疏矩阵赋值
        int count = 1;
        for (int i = 0; i < chess.chessBoard.length; i++){
            for (int j = 0; j < chess.chessBoard[0].length; j++){
                if (chess.chessBoard[i][j] != 0){

                    sparseArr[count][0] = i;//记录非0元素的行数
                    sparseArr[count][1] = j;//记录非0元素的列数
                    sparseArr[count][2] = chess.chessBoard[i][j];//记录非0元素的值
                    count++;

                }
            }
        }

        //给稀疏数组第一行赋值：棋盘的行、列、非0元素数
        sparseArr[0][0] = chess.chessBoard.length;
        sparseArr[0][1] = chess.chessBoard[0].length;
        sparseArr[0][2] = sparseArr.length - 1;

        //输出稀疏矩阵
        for (int i = 0; i < sparseArr.length; i++){
            System.out.println(Arrays.toString(sparseArr[i]));
        }

        return sparseArr;
    }
}

class chessArr{
    int chessBoard[][];

    //创建棋盘
    public int[][] createBroad(int rowNum, int colNum){

        int tempArr1[][] = new int[rowNum][colNum];
        chessBoard = tempArr1;
        return chessBoard;

    }

    //从稀疏数组中恢复棋盘
    public void reverseBroad(sparseArr spa){

        int tempAarr2[][] = new int[spa.sparseArr[0][0]][spa.sparseArr[0][1]];
        chessBoard = tempAarr2;

        //读取稀疏数组，给非0元素赋值
        for (int i = 1; i < spa.sparseArr.length; i++){
            chessBoard[spa.sparseArr[i][0]][spa.sparseArr[i][1]] =
                    spa.sparseArr[i][2];
        }

        //输出棋盘
        for (int i = 0; i < chessBoard.length; i++){
            System.out.println(Arrays.toString(chessBoard[i]));
        }

    }
}
