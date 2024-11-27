package org.learning.dsa.graphs;

import java.util.*;

public class AccountsMerge721 {
    public static void main(String[] args) {

    }

    class Solution {
        class DisJointSet {
            int[] parent;
            int[] rank;

            DisJointSet(int n) {
                parent = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int findParent(int node) {
                if (node == parent[node]) return node;
                return parent[node] = findParent(parent[node]); // Path compression
            }

            void linkNode(int u, int v) {
                int parentU = findParent(u);
                int parentV = findParent(v);
                if (parentU == parentV) return;
                if (rank[parentU] < rank[parentV]) {
                    parent[parentU] = parentV;
                } else if (rank[parentU] > rank[parentV]) {
                    parent[parentV] = parentU;
                } else {
                    parent[parentV] = parentU;
                    rank[parentU]++;
                }
            }
        }

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int n = accounts.size();
            DisJointSet dj = new DisJointSet(n);
            Map<String, Integer> emailToIndex = new HashMap<>();

            // Map emails to account indices
            for (int i = 0; i < n; i++) {
                List<String> account = accounts.get(i);
                for (int j = 1; j < account.size(); j++) {
                    String email = account.get(j);
                    if (emailToIndex.containsKey(email)) {
                        dj.linkNode(i, emailToIndex.get(email));
                    } else {
                        emailToIndex.put(email, i);
                    }
                }
            }

            // Group emails by their ultimate parent
            Map<Integer, List<String>> groupedEmails = new HashMap<>();
            for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
                String email = entry.getKey();
                int parentIndex = dj.findParent(entry.getValue());
                groupedEmails.computeIfAbsent(parentIndex, k -> new ArrayList<>()).add(email);
            }

            // Prepare the result
            List<List<String>> result = new ArrayList<>();
            for (Map.Entry<Integer, List<String>> entry : groupedEmails.entrySet()) {
                int index = entry.getKey();
                List<String> emails = entry.getValue();
                Collections.sort(emails); // Sort emails lexicographically
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accounts.get(index).get(0)); // Add the name
                mergedAccount.addAll(emails);
                result.add(mergedAccount);
            }

            return result;
        }
    }

}
