package org.learning.dsa.binary_search;

import java.util.HashMap;
import java.util.Map;

public class StickerToSellWord691 {
    public static void main(String[] args) {
        System.out.println(minStickersv2(new String[]{"notice","possible"},"basicbasic"));
    }

    public static int minStickersv2(String[] stickers, String target) {
        int N = target.length();
        int[] dp = new int[1 << N];
        for (int i = 1; i < 1 << N; i++) dp[i] = -1;

        for (int state = 0; state < 1 << N; state++) {
            if (dp[state] == -1) continue;
            for (String sticker: stickers) {
                int now = state;
                for (char letter: sticker.toCharArray()) {
                    for (int i = 0; i < N; i++) {
                        if (((now >> i) & 1) == 1) continue;
                        if (target.charAt(i) == letter) {
                            now |= 1 << i;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                    dp[now] = dp[state] + 1;
                }
            }
        }
        return dp[(1 << N) - 1];
    }

    private static Map<Character, Boolean> data = new HashMap<>();
    private static int result = Integer.MAX_VALUE;

    public static int minStickers(String[] stickers, String target) {
        // Initialize the data map to track the target characters
        for (int i = 0; i < target.length(); i++) {
            data.put(target.charAt(i), false);
        }
        int count = 0;
        helper(count, stickers, target, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static void helper(int count, String[] stickers, String target, int index) {
        // Base case: if all characters are covered, update the result
        if (index == target.length()) {
            result = Math.min(result, count);
            return;
        }

        // Get the current character in the target
        char currentChar = target.charAt(index);

        // If the current character is already covered, move to the next character
        if (data.get(currentChar)) {
            helper(count, stickers, target, index + 1);
            return;
        }

        // Try using each sticker that contains the current character
        for (String sticker : stickers) {
            if (sticker.indexOf(currentChar) != -1) {
                // Mark the current character and any other characters covered by this sticker
                boolean[] used = new boolean[target.length()];
                for (int i = 0; i < target.length(); i++) {
                    if (sticker.indexOf(target.charAt(i)) != -1 && !data.get(target.charAt(i))) {
                        data.put(target.charAt(i), true);
                        used[i] = true;
                    }
                }

                // Recurse to the next index with incremented count
                helper(count + 1, stickers, target, index + 1);

                // Backtrack: unmark the characters covered by this sticker
                for (int i = 0; i < target.length(); i++) {
                    if (used[i]) {
                        data.put(target.charAt(i), false);
                    }
                }
            }
        }
    }
}
