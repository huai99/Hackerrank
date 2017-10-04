package UniversityCodeSprint3.The_Snake_vs_The_Wind;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char d = in.next().charAt(0);
        int x = in.nextInt();
        int y = in.nextInt();
        int[][] map = new int[n][n];
        recur(new boolean[n][n],map,x, y,String.valueOf(d),1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        in.close();
    }

    public static void recur(boolean[][]visited, int[][]map,int x, int y, String constraint,int sum){
        int n = visited.length;
        int total = (n)*(n);
        visited[x][y] = true;
        map[x][y] = sum;

        if(sum>=total){
            return;
        }

        int[] nextStep = getSameDirectionNextStep(x,y,constraint);
        if(isValid(nextStep[0],nextStep[1],visited)){
            int nextX = nextStep[0];
            int nextY = nextStep[1];
            recur(visited,map,nextX,nextY,constraint,sum+1);
            return;
        }

        nextStep = getPerpendicularDirectionNextStep(visited,x,y,constraint);
        if(isValid(nextStep[0],nextStep[1],visited)){
            int nextX = nextStep[0];
            int nextY = nextStep[1];
            recur(visited,map,nextX,nextY,constraint,sum+1);
            return;
        }

        nextStep = getDifferentDirectionNextStep(x,y,constraint);
        if(isValid(nextStep[0],nextStep[1],visited)){
            int nextX = nextStep[0];
            int nextY = nextStep[1];
            recur(visited,map,nextX,nextY,constraint,sum+1);
            return;
        }



    }

    public static int[] getSameDirectionNextStep(int x, int y, String constraint){
        switch(constraint){
            case "n":
                return new int[]{x-1,y};
            case "s":
                return new int[]{x+1,y};
            case "e":
                return new int[]{x,y+1};
            //west
            default:
                return new int[]{x,y-1};
        }
    }

    public static int[] getDifferentDirectionNextStep(int x, int y, String constraint){
        switch(constraint){
            case "n":
                return new int[]{x+1,y};
            case "s":
                return new int[]{x-1,y};
            case "e":
                return new int[]{x,y-1};
            //west
            default:
                return new int[]{x,y+1};
        }
    }

    public static int[] getPerpendicularDirectionNextStep(boolean[][] visited, int x, int y, String constraint){
        switch(constraint){
            case "n":
            case "s":
                if(isValid(x,y+1,visited)){
                    return new int[]{x,y+1};
                }else{
                    return new int[]{x,y-1};
                }
            case "e":
                //west
            default:
                if(isValid(x+1,y,visited)){
                    return new int[]{x+1,y};
                }else{
                    return new int[]{x-1,y};
                }
        }
    }

    public static boolean isValid(int x,int y, boolean[][]visit){
        int n = visit.length;
        if(x>=0 && x<n && y>=0 && y<n && !visit[x][y]){
            return true;
        }else{
            return false;
        }
    }
}
