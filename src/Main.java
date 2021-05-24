public class Main {
    public static void main(String[] args) {
        int[] price = {5,100,20,66,16}; // Стартовые значения цен из примера
        int[] checkResult = {0,0}; // Массив отображаемый в конце, для проверки работоспособности
        try {
            checkResult = decryptData(price, 50, 1, 3);
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        for(int i : checkResult){
            System.out.println(i);
        }
    }
    //method is static for ease of testing
    public static int[] decryptData(int[] price, int discount, int offset, int readLength){
        int[] result = {0,0};
        if(price != null) {
            result = new int[readLength];
            int j = 0;
            for (int i = offset; i < offset + readLength; i++) {
                double priceDouble = price[i];
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