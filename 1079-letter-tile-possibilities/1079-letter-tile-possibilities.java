class Solution {
    List<String> res = new ArrayList<>();
    Set<List<String>> set = new HashSet<>();
    boolean [] visited = new boolean[7];
    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 1) {
            return 1;
        }

        dfs(0, 0, new ArrayList<>(), tiles);
        return set.size() - 1;
    }

    public void dfs(int len, int idx, List<String> tmp, String tiles) {
        set.add(tmp);
        //System.out.println(tmp);

        if (tmp.size() == tiles.length()) {
            return;
        }

        for(int i = 0; i < tiles.length(); i++) {
            char c = tiles.charAt(i);
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(String.valueOf(tiles.charAt(i)));
                dfs(len + 1, idx + 1, tmp, tiles);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}