package com.movchan.cities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitiesUntil {

    private CitiesUntil() {
    }

    public static void runCitiesTask() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Acer Nitro 5\\IdeaProjects\\demo\\src\\com\\movchan\\cities\\Input.txt"))) {
            String curLineOfFile = reader.readLine();
            int numberOfTests = Integer.parseInt(curLineOfFile);
            doAllTests(reader, numberOfTests);
        }
    }

    /* Do all tests */
    private static void doAllTests(BufferedReader reader, int source) throws IOException {
        String curLineOfFile;
        String[] citiesIds;
        int numberOfCities;
        for (int testIndex = 0; testIndex < source; testIndex++) { // the number of tests
            citiesIds = new String[10000]; // create an array of the condition of the job
            curLineOfFile = reader.readLine();
            numberOfCities = Integer.parseInt(curLineOfFile); // read the number of cities
            int matrixSize = numberOfCities + 1; // the problem of indexing the array from 0
            Matrix matrix = new Matrix(matrixSize);
            setMatrixEdges(reader, citiesIds, numberOfCities, matrix);
            curLineOfFile = reader.readLine();
            int routesToFind = Integer.parseInt(curLineOfFile); // number of calculated routes
            findAndOutputDestinationDistance(reader, citiesIds, matrix, routesToFind);
        }
    }

    private static void findAndOutputDestinationDistance(BufferedReader reader, String[] citiesIds, Matrix matrix, int routesToFind) throws IOException {
        String curLineOfFile;
        for (int routesIndex = 0; routesIndex < routesToFind; routesIndex++) {
            curLineOfFile = reader.readLine(); // reads the path
            String[] cityNames = curLineOfFile.split(" ");
            String start = cityNames[0];
            String destination = cityNames[1];
            List<String> listOfCitiesIds = new ArrayList<String>();
            fillListOfCitiesIds(citiesIds, listOfCitiesIds); // add ONLY not null elements from the array to the list
            citiesIds = listOfCitiesIds.toArray(new String[listOfCitiesIds.size()]);
            int startIndex = findIndexOfInitialCity(citiesIds, start); // find the index of the initial city
            int destinationIndex = findIndexOfEndOfCity(citiesIds, destination); // find the index of the end of the city
            Integer[] distancesFromSource = matrix.getDistancesFromSource(startIndex);
            int destinationDistance = distancesFromSource[destinationIndex];
            System.out.println(destinationDistance);
        }
    }

    private static int findIndexOfEndOfCity(String[] citiesIds, String destination) {
        int destinationIndex = 0;
        for (int i = 0; i < citiesIds.length; i++) {
            if (destination.equals(citiesIds[i])) {
                destinationIndex = i;
                break;
            }
        }
        return destinationIndex;
    }

    private static int findIndexOfInitialCity(String[] citiesIds, String start) {
        int startIndex = 0;
        for (int i = 0; i < citiesIds.length; i++) {
            if (start.equals(citiesIds[i])) {
                startIndex = i;
                break;
            }
        }
        return startIndex;
    }

    private static void fillListOfCitiesIds(String[] citiesIds, List<String> listOfCitiesIds) {
        for (String s : citiesIds) {
            if (s != null) {
                listOfCitiesIds.add(s);
            }
        }
    }

    private static void setMatrixEdges(BufferedReader reader, String[] citiesIds, int numberOfCities, Matrix matrix) throws IOException {
        String curLineOfFile;
        for (int cityIndex = 0; cityIndex < numberOfCities; cityIndex++) {
            curLineOfFile = reader.readLine(); // reads the name of the city
            String cityName = curLineOfFile;
            citiesIds[cityIndex] = cityName; // write the name of the city
            curLineOfFile = reader.readLine(); // read the next value (the number of neighbors)
            int numberOfNeighbours = Integer.parseInt(curLineOfFile);
            for (int neighbourIndex = 0; neighbourIndex < numberOfNeighbours; neighbourIndex++) {
                curLineOfFile = reader.readLine();
                String[] brokenLine = curLineOfFile.split(" ");
                int cityToConnect = Integer.parseInt(brokenLine[0]);// write the code neighbor
                int weightOfConnection = Integer.parseInt(brokenLine[1]);// write the weight of the edge
                matrix.setEdge(cityIndex, cityToConnect, weightOfConnection);
            }
        }
    }
}
