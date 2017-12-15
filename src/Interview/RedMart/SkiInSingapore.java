package Interview.RedMart;

import java.io.*;
import java.util.ArrayList;

//Correct answer for raw data is Length:15, Drop: 1422
//Correct answer for test data is Length:5, Drop: 8

public class SkiInSingapore {
    private static int max_length = 0;
    private static int max_drop = 0;

    static class SkiData {
        int length;
        int drop;

        SkiData(int length, int drop) {
            this.length = length;
            this.drop = drop;
        }
    }

    public static void main(String[] args) {
        String fileName = "src/Interview/RedMart/data/raw_data";
        int[][] map = getData(fileName);
        int height = map.length;
        int width = map[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                SkiData skiData = explore(map, i, j, map[i][j]);
                int result = skiData.length;
                if (result > max_length) {
                    max_length = result;
                    max_drop = skiData.drop;
                } else if (max_length == result) {
                    skiData = explore(map, i, j, map[i][j]);
                    max_drop = Math.max(skiData.drop, max_drop);
                }
            }
        }
        System.out.println("Max Length: " + max_length);
        System.out.println("Max Drop: " + max_drop);
    }

    private static SkiData explore(int[][] map, int x, int y, int peak) {
        int max_height = map.length;
        int max_width = map[0].length;
        int temp = 0;
        int current_height = map[x][y];
        int max_drop = peak - current_height;
        ArrayList<int[]> processList = new ArrayList<>();

        if (y > 0 && current_height > map[x][y - 1]) {
            processList.add(new int[]{x, y - 1});
        }

        if (y < max_width - 1 && current_height > map[x][y + 1]) {
            processList.add(new int[]{x, y + 1});
        }

        if (x < max_height - 1 && current_height > map[x + 1][y]) {
            processList.add(new int[]{x + 1, y});
        }

        if (x > 0 && current_height > map[x - 1][y]) {
            processList.add(new int[]{x - 1, y});
        }

        for (int[] chosen : processList) {
            int x_coordinate = chosen[0];
            int y_coordinate = chosen[1];
            SkiData newData = explore(map, x_coordinate, y_coordinate, peak);
            int length = newData.length;
            if (length > temp) {
                temp = length;
                max_drop = newData.drop;
            } else if (length == temp) {
                if (newData.drop > max_drop) {
                    max_drop = newData.drop;
                }
            }
        }
        temp++;
        return new SkiData(temp, max_drop);
    }

    private static int getMax(int west, int east, int south, int north) {
        int max = west;
        max = Math.max(max, east);
        max = Math.max(max, south);
        max = Math.max(max, north);
        return max;
    }

    private static int[][] getData(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            String[] size_arr = reader.readLine().split(" ");
            int height = Integer.parseInt(size_arr[0]);
            int width = Integer.parseInt(size_arr[1]);
            int[] storage = new int[height * width];
            int track = 0;
            while ((text = reader.readLine()) != null) {
                String[] raw = text.split(" ");
                for (String data : raw) {
                    storage[track] = Integer.parseInt(data);
                    track++;
                }
            }
            return parseMap(height, width, storage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ignored) {
            }
        }
        return new int[1][1];
    }

    private static int[][] parseMap(int height, int width, int[] raw) {
        int[][] map = new int[height][width];
        int track = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = raw[track];
                track++;
            }
        }
        return map;
    }
}
