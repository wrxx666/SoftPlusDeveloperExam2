public class Main {
    public static void main(String[] args) {
        int[] prices = {5,100,20,66,16};
        try {
            int[]expectedResult = decryptData(prices, 50, 1, 3);
            for(int i : expectedResult){
                System.out.println(i);
            }
        }
        catch (Throwable e){
            e.printStackTrace();
            System.out.println("Unexpected error while array decrypt cause " + e.getLocalizedMessage());
        }

    }
    public static int[] decryptData(int[] price, int discount, int offset, int readLength){
        int[] result = {0,0};
        if(price != null) {
            result = new int[readLength];
            for (int i = offset, j = 0; i < offset + readLength; i++, j++) {
                double priceDouble = price[i];
                int newPrice = (int) (priceDouble - (priceDouble / 100 * discount));
                result[j] = (int) newPrice;
            }
        }
        return result;
    }
}
