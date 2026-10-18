
import java.util.*;

class Solution {
    class Pair {
        String str;
        int dis;

        Pair(String str, int dis) {
            this.str = str;
            this.dis = dis;
        }
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }

        Queue<Pair> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();

        q.add(new Pair("0000", 0));
        vis.add("0000");

        while (!q.isEmpty()) {
            Pair p = q.poll();

            String s = p.str;
            int d = p.dis;

            if (s.equals(target)) {
                return d;
            }

            char[] arr = s.toCharArray();

            for (int i = 0; i < 4; i++) {
                char org = arr[i];
                arr[i] = (char) ('0' + (org - '0' + 1) % 10);
                String next = new String(arr);

                if (!vis.contains(next) && !dead.contains(next)) {
                    vis.add(next);
                    q.add(new Pair(next, d + 1));
                }
                arr[i] = (char) ('0' + (org - '0' + 9) % 10);
                next = new String(arr);

                if (!vis.contains(next) && !dead.contains(next)) {
                    vis.add(next);
                    q.add(new Pair(next, d + 1));
                }
                arr[i] = org;
            }
        }

        return -1;
    }
}
