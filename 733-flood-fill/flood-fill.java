class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int ini = image[sr][sc];
         if (ini == color)
            return image;

        func(image, sr, sc, color, ini);
        return image;
    }

    void func(int[][] image, int r, int c, int color, int init) {
        int m = image.length;
        int n = image[0].length;

         if (r < 0 || c < 0 || r >= m || c >= n)
            return;

      
        if (image[r][c] != init)
            return;
        image[r][c] = color;
        func(image, r, c + 1, color, init);
        func(image, r, c - 1, color, init);
        func(image, r + 1, c, color, init);
        func(image, r - 1, c, color, init);
    }
}