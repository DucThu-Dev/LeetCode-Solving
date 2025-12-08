
import java.util.ArrayList;

class Solution {

    public int countTriples(int n) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            squares.add((i + 1) * (i + 1));
        }

        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            int sA = squares.get(i);
            for (int j = 1; j < n - 1; j++) {
                int sB = squares.get(j);
                for (int g = 2; g < n; g++) {
                    int sC = squares.get(g);
                    if (sA + sB == sC) {
                        result += 2;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
