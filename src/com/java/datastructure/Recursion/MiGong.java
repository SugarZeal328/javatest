package com.java.datastructure.Recursion;

public class MiGong {

    public static void main(String[] args) {
        //创建一个二维数组模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙，第1行和第8行，第1列和第7列都是1
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 || i == 7) map[i][j] = 1;
                if (j == 0 || j == 6) map[i][j] = 1;
            }
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;

        //输出地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("DDDDDDDdddddddddddddd");
        setWay2(map,1,1);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯找路
    //如果小球能到达[6][5]位置，则表明通路找到
    //约定：当map[i][j]为2时，表示一条通路。3表示该点已走过，但走不通
    //策略：下、右、上、左，如果该点走不通，就回溯

    /**
     * @param map 地图
     * @param i   [i][j]表示从哪个位置开始出发
     * @param j
     * @return 找到通路，返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //表示路已通
            return true;
        } else {
            if (map[i][j] == 0){
                map[i][j] =2;
                if (setWay(map, i+1, j)){
                    return true;
                }else if (setWay(map, i, j+1)){
                    return true;
                }else if (setWay(map, i-1, j)){
                    return true;
                }else if (setWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) return true;
        else if (map[i][j] == 0){
            map[i][j] = 2;
            if (setWay2(map, i-1, j)) return true;
            if (setWay2(map, i, j+1)) return true;
            if (setWay2(map, i+1, j)) return true;
            if (setWay2(map, i, j-1)) return true;
            else map[i][j] = 3;
                  return false;
        }else return false;
    }
}
