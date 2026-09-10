class Solution {
    Map<List<Integer>, Integer> map; 
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        map = new HashMap<>();
        return dfs(price, special, needs);
    }
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }

        int minCost = 0;

        for (int i = 0; i < needs.size(); i++) {
            minCost = minCost + (needs.get(i) * price.get(i));
        }

        for (List<Integer> offer: special) {
            List<Integer> remaining = new ArrayList<>();
            boolean canUse = true;

            for (int i = 0 ; i < needs.size(); i++) {
                if (offer.get(i) > needs.get(i)) {
                    canUse = false;
                    break;
                }

                remaining.add(needs.get(i) - offer.get(i));
            }

            if (!canUse) {
                continue;
            }

            int cost = offer.get(offer.size() - 1) + dfs(price, special, remaining);

            minCost = Math.min(minCost, cost);
        }

        map.put(needs, minCost);

        return minCost;
    }
}