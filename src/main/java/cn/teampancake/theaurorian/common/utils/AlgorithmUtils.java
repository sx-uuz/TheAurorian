package cn.teampancake.theaurorian.common.utils;

public class AlgorithmUtils {

    public static String convert3DtoString(int[][][] array) {
        StringBuilder sb = new StringBuilder();
        for (int[][] twoD : array) {
            for (int[] oneD : twoD) {
                for (int i = 0; i < oneD.length; i++) {
                    sb.append(oneD[i]);
                    if (i < oneD.length - 1) {
                        sb.append(",");
                    }
                }
                sb.append(";");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static int[][][] convertStringTo3D(String str) {
        String[] twoDArraysStr = str.split("\n");
        int[][][] array = new int[twoDArraysStr.length][][];
        for (int i = 0; i < twoDArraysStr.length; i++) {
            String[] oneDArraysStr = twoDArraysStr[i].split(";");
            array[i] = new int[oneDArraysStr.length][];
            for (int j = 0; j < oneDArraysStr.length; j++) {
                String[] elementsStr = oneDArraysStr[j].split(",");
                array[i][j] = new int[elementsStr.length];
                for (int k = 0; k < elementsStr.length; k++) {
                    array[i][j][k] = Integer.parseInt(elementsStr[k]);
                }
            }
        }

        return array;
    }

}