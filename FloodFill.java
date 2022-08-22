class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Integer> queue= new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        queue.add(sr);
        queue.add(sc);
        int curr = image[sr][sc];
        if(curr == color)
            return image;
        image[sr][sc] = color;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            for(int[] dir:dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc]==curr){
                    image[nr][nc] = color;
                    queue.add(nr);
                    queue.add(nc);
                }
            }
        }
        return image;
    }
}
