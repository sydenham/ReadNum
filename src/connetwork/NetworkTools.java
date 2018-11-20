package connetwork;

public class NetworkTools {

    public static double[] createArray(int size, double initVal) {
        if (size < 1) {
            return null;
        }
        double[] arr = new double[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initVal;
        }
        return arr;
    }
    public static double[] createRandomArray(int size, double lowBound, double uppBound) {
        if (size < 1) {
            return null;
        }
        double[] arr = new double[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomValue(lowBound, uppBound);
        }
        return arr;
    }
    public static double[][] createRandomArray(int sizeX, int sizeY, double lowBound, double uppBound) {
        if (sizeY < 1 || sizeX < 1) {
            return null;
        }
        double[][] arr = new double[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            arr[i] = createRandomArray(sizeY, lowBound, uppBound);
        }
        return arr;
    }
    public static double randomValue(double lowBound, double uppBound){
        return Math.random()*(uppBound-lowBound) + uppBound;
    }
    public static Integer[] randomValues(int lowerBound, int upperBound, int amount) {

        lowerBound --;

        if(amount > (upperBound-lowerBound)){
            return null;
        }

        Integer[] values = new Integer[amount];
        for(int i = 0; i< amount; i++){
            int n = (int)(Math.random() * (upperBound-lowerBound+1) + lowerBound);
            while(containsValue(values, n)){
                n = (int)(Math.random() * (upperBound-lowerBound+1) + lowerBound);
            }
            values[i] = n;
        }
        return values;
    }

    public static <T extends Comparable<T>> boolean containsValue(T[] ar, T value){
        for(int i = 0; i < ar.length; i++){
            if(ar[i] != null){
                if(value.compareTo(ar[i]) == 0){
                    return true;
                }
            }

        }
        return false;
    }

    public static int indexOfHighestValue(double[] values){
        int index = 0;
        for(int i = 1; i < values.length; i++){
            if(values[i] > values[index]){
                index = i;
            }
        }
        return index;
    }


}
