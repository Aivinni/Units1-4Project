public class Util {
    public static double roundedToHundredth(double toRound) {
        toRound *= 100;
        toRound = (int)toRound;
        toRound /= 100.0;
        return toRound;
    }
    public static boolean isInt(double num) {
        return num - (int)num == 0;
    }
}
