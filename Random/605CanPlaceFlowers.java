package Random;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n == 1;
        }
        if (flowerbed.length == 2) {
            if (n == 1 && flowerbed[0] == 0 && flowerbed[1] == 0) {
                return true;
            } else return false;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;
            flowerbed[0] = 1;
        }
        if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
                n--;
                flowerbed[flowerbed.length - 1] = 1;
        }
        for (int i = 0; i < flowerbed.length - 2; i++) {
            if (n <= 0) return true;
            int first = flowerbed[i], second = flowerbed[i + 1], third = flowerbed[i + 2];
            if (first == 0 && second == 0 && third == 0) {
                n--;
                flowerbed[i + 1] = 1;
            }
        }
        return n == 0;
    }
}
