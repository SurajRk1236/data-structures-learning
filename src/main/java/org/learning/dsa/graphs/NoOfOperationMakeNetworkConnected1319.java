package org.learning.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class NoOfOperationMakeNetworkConnected1319 {
    public static void main(String[] args) {

    }

    class Solution {
        class Disjoint {
            int[] parent;
            int[] rank;

            Disjoint(int n) {
                this.parent = new int[n];
                this.rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    rank[i] = 0;
                }
            }

            int getParent(int node) {
                if (node == parent[node]) return node;
                return parent[node] = getParent(parent[node]); // Path compression
            }

            void linkNodeRank(int u, int v) {
                int parentU = getParent(u);
                int parentV = getParent(v);
                if (parentU == parentV) return; // Already in the same component
                if (rank[parentU] < rank[parentV]) {
                    parent[parentU] = parentV;
                } else if (rank[parentU] > rank[parentV]) {
                    parent[parentV] = parentU;
                } else {
                    parent[parentV] = parentU;
                    rank[parentU]++; // Only increment rank if ranks were equal
                }
            }
        }


        public int makeConnected(int n, int[][] connections) {
            // If there are fewer edges than n - 1, it's impossible to connect all nodes
            if (connections.length < n - 1) return -1;

            Disjoint dj = new Disjoint(n);
            int extraEdges = 0;

            // Process all connections
            for (int[] connection : connections) {
                int u = connection[0];
                int v = connection[1];
                if (dj.getParent(u) == dj.getParent(v)) {
                    extraEdges++; // Redundant edge
                } else {
                    dj.linkNodeRank(u, v);
                }
            }

            // Count the number of connected components
            int components = 0;
            for (int i = 0; i < n; i++) {
                if (dj.getParent(i) == i) components++;
            }

            // To connect all components, we need (components - 1) edges
            return extraEdges >= components - 1 ? components - 1 : -1;
        }
    }

}
