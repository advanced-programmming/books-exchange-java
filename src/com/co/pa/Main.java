package com.co.pa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    int numCases = scanner.nextInt();

        for(int i = 0; i < numCases; i++){
            int numChildren = scanner.nextInt();
            int[] books = new int[numChildren];
            UnionFind unionFind = new UnionFind(numChildren);

            for(int j = 0; j < numChildren; j++)
                books[j] = scanner.nextInt();

            for(int j = 0; j < numChildren; j++)
                unionFind.union(j + 1, books[j]);

            for(int j = 0; j < numChildren; j++)
                System.out.print(unionFind.getResult(j + 1) + " ");

        }
    }
}

class UnionFind{
    private int size;
    private int[] control;

    public UnionFind(int size){
        this.size = size;
        this.control = new int[size + 1];

        for(int i = 0; i <= this.size; i++){
            this.control[i] = -1;
        }
    }

    public int getResult (int i){
        int result = find(i);
        return Math.abs(this.control[result]);
    }

    public int find(int node){
        if(this.control[node] <= - 1) return node;
        return find(this.control[node]);
    }

    public boolean union(int node1, int node2){
        int parent1 = find(node1);
        int parent2 = find(node2);

        if(parent1 != parent2){
            if(node1 < node2){
                this.control[parent1] = this.control[parent1] + this.control[parent2];
                this.control[node2] = node1;
            } else {
                this.control[parent2] = this.control[parent2] + this.control[parent1];
                this.control[node1] = node2;
            }
        }

        return true;
    }


}
