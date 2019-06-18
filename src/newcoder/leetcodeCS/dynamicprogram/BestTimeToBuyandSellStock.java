package newcoder.leetcodeCS.dynamicprogram;

public class BestTimeToBuyandSellStock {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int curPrice : prices) {
            // 第一次购买,始终买当前所有里面最便宜的那一次,第一次买，利润肯定为负，但是要找出最少的那一个
            if (firstBuy < -curPrice) {
                firstBuy = -curPrice;
            }
            // 第一次卖出去的可能的最大利润
            if (firstSell < firstBuy + curPrice) {
                firstSell = firstBuy + curPrice;
            }
            //注意第二次的利润已经包含第一次的了，这也是唯一一个不一样的难点
            //同理，第二次购买,但是注意这里有个状态的加成 sell1
            if (secondBuy < firstSell - curPrice) {
                secondBuy = firstSell - curPrice;
            }
            //最后一次
            if (secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice;
            }
        }
        return secondSell;
    }
}
