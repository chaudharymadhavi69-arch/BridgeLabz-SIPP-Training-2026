class solution {
    public static int towerOfHanoi(int n) {
        if (n == 0) {
            return 0;
        }
        return 2 * towerOfHanoi(n - 1) + 1;
    }
}
