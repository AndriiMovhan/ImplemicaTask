package com.movchan.cities;

import java.util.Arrays;

class Matrix {

    private final int[][] cost; // an array that contains the value of the ribs

    /**
     * Argument is the number of vertices in the graph
     *
     * @param vertices is the number of vertices in the graph
     */
    Matrix(int vertices) {
        cost = new int[vertices][vertices];
    }

    /**
     * Set the weight between the neighbors [Cities]
     *
     * @param i      point and point j that create an edge [path]
     * @param j      point and point i that create an edge [path]
     * @param weight of the edges - non-negative number
     */
    void setEdge(int i, int j, int weight) {
        cost[i][j] = weight;
    }

    /**
     * Freight cost
     *
     * @param i point and point j that create an edge [path]
     * @param j point and point i that create an edge [path]
     * @return 0 if i and j are the same, infinity, if there is no connection between the edges of the edges
     */
    private int getCost(int i, int j) {
        /* [0, 0, 1, 3, 0]
         * [0, 1, 0, 1, 4]
         * [0, 3, 1, 0, 1]
         * [0, 0, 4, 1, 0]*/
        if (i == j) {
            return 0;
        }
        if (cost[i][j] == 0) {
            return 10001;
        }
        return cost[i][j];
    }

    /**
     * Return the index of the smallest element of distances, ignoring those in visited
     *
     * @param result  Assign 1st top label equal to "origin" since that vertex
     * @param visited an array of visited cities
     * @return the index of the smallest element of distances, ignoring those in visited.
     */
    private int getCheapest(Integer[] result, boolean[] visited) {
        int best = -1;
        for (int i = 0; i < cost.length; i++) {
            if (!visited[i] && ((best < 0) || (result[i] < result[best]))) {
                best = i;
            }
        }
        return best;
    }

    /**
     * Returns The ways of minimum cost between pairs of cities
     *
     * @param source Initial vertex
     * @return an array of distances between cities
     */
    Integer[] getDistancesFromSource(int source) {
        Integer[] result = new Integer[cost.length];
        Arrays.fill(result, 10001); // set tops mark
        result[source] = source; // assign 1st top mark equal to "source", because this vertex
        boolean[] visited = new boolean[cost.length]; // visit the city
        for (int i = 0; i < cost.length; i++) {
            int City = getCheapest(result, visited); // select the top of which has a minimum mark
            visited[City] = true; // note selected vertex visited
            for (int j = 0; j < cost.length; j++) {
                result[j] = Math.min(result[j], result[City] + getCost(City, j)); // write the smallest path from one vertex to another
            }
        }
        return result;
    }
}