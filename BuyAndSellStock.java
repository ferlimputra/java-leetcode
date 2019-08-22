import java.util.stream.IntStream;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share
 * of the stock), design an algorithm to find the maximum profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example 1:
 * 
 * Input: [7,1,5,3,6,4]
 * 
 * Output: 5
 * 
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Not 7-1 =
 * 6, as selling price needs to be larger than buying price.
 * 
 * Example 2:
 * 
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is done, i.e. max profit =
 * 0.
 */

/**
 * BuyAndSellStock
 */
public class BuyAndSellStock {

  // Input 1: [7,1,5,3,6,4]
  // Input 2: [7,6,4,3,1]
  public static int maxProfit(int[] prices) {
    int highestPrice = IntStream.of(prices).max().orElse(0);
    int highestProfit = 0;

    /*
     * int profit = IntStream.range(0, prices.length).map(i -> prices[i]) .filter(i -> (prices[i] -
     * buyPrice) > highestProfit).max().orElse(0);
     */

    // Loop 1: look for buy price
    for (int i = 0; i < prices.length - 1; i++) {
      int buyPrice = prices[i];

      // No profit for buying at highest price
      if (buyPrice == highestPrice) {
        continue;
      }

      // Loop 2: look for sell price with highest profit

      // Solution 1: for loop
      for (int j = i + 1; j < prices.length; j++) {
        if (prices[j] > buyPrice) {
          int profit = prices[j] - buyPrice;
          System.out.println(String.format("Profit: %d", profit));
          if (profit > highestProfit) {
            highestProfit = profit;
          }
        }
      }


      // Solution 2: stream map
      /*
       * System.out.println(String.format("Buy price: %d", buyPrice));
       * 
       * int[] profits = IntStream.range(i + 1, prices.length).map(j -> prices[j] -
       * buyPrice).toArray();
       * 
       * System.out.println(String.format("Profits: %s", String.join(", ",
       * Arrays.toString(profits))));
       * 
       * int currentHighestProfit = IntStream.of(profits).max().getAsInt();
       * 
       * if (currentHighestProfit > highestProfit) { highestProfit = currentHighestProfit; }
       */
    }
    return highestProfit;
  }

  public static void main(String[] args) {
    int[] prices1 = new int[] {1, 2};
    // int[] result = IntStream.range(2, prices1.length).map(j -> prices1[j]).toArray();
    // System.out.println(String.join(", ", Arrays.toString(result)));
    System.out.println(String.format("Profit: %d", maxProfit(prices1)));
  }
}
