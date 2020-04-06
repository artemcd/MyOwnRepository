public class Test {
    public static String[][] xForm = new String[25][25];

    public static void makeX(int x) {
        int sizeX = x, sizeY = x;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (i < sizeX && j < sizeY) {
                    if (i == j) {
                        xForm[i][j] = "X";
                    } else if (i + j == x - 1) {
                        xForm[i][j] = "X";
                    } else {
                        xForm[i][j] = " ";
                    }

                }
            }


        }

        for (int i = 0; i < x; i++)   {
            for (int j = 0; j < x; j++)   {
                System.out.print(xForm[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        makeX(25);
    }
}
