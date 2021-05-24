public class Main {
    public static void main(String[] args) {
        int[] prices = {5,100,20,66,16}; // Стартовые значения цен из примера
        int[] expectedResult = {0,0}; // Массив отображаемый в конце, для проверки работоспособности
        try {
            expectedResult = decryptData(prices, 50, 1, 3);
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        for(int i : expectedResult){
            System.out.println(i);
        }
    }
    //method is static for ease of testing
    public static int[] decryptData(int[] prices, int discount, int offset, int readLength){
        int[] result = {0,0};
        if(prices != null) {
            result = new int[readLength];
            int j = 0;
            for (int i = offset; i < offset + readLength; i++) {
                double priceDouble = prices[i];
                int newPrice = (int) (priceDouble - (priceDouble / 100 * discount));
                result[j] = (int) newPrice;
                j++;
            }
        }
        return result;
    }
}
/*
public @Nullable int[] decryptData(@NonNull int[] price,
@IntRange(from = 1) int discount,
@IntRange(from = 0) int offset,
@IntRange(from = 1) int readLength) {
 */
