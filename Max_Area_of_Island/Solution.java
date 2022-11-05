import java.util.*;
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int totalCells = rows*cols;
        int parent[] = new int[totalCells];
        int rank[] = new int[totalCells];
        int size[] = new int[totalCells];
        
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    int cell = row*cols+col;
                    parent[cell] = cell;
                    size[cell] = 1;
                }
            }
        }

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    if(row-1>=0&&grid[row-1][col]==1){
                        union(row,col,row-1,col,cols,parent,rank,size);
                    }
                    if(row+1<rows&&grid[row+1][col]==1){
                        union(row,col,row+1,col,cols,parent,rank,size);
                    }
                    if(col-1>=0&&grid[row][col-1]==1){
                        union(row,col,row,col-1,cols,parent,rank,size);
                    }
                    if(col+1<cols&&grid[row][col+1]==1){
                        union(row,col,row,col+1,cols,parent,rank,size);
                    }
                }
            }
        }
        
        for(int head=0;head<totalCells;head++){
            maxArea = Math.max(maxArea,size[head]);
        }
        
        return maxArea;
    }
    private void union(int row1,int col1,int row2,int col2,int cols,int parent[],int rank[],int size[]){
        int cell1 = row1*cols+col1;
        int cell2 = row2*cols+col2;
        
        int parCell1 = find(parent,cell1);
        int parCell2 = find(parent,cell2);
        
        if(parCell1==parCell2) return;
        
        if(rank[parCell1]>rank[parCell2]){
            parent[parCell2] = parCell1;
            size[parCell1]+=size[parCell2];
            size[parCell2] = 0;
        }else if(rank[parCell1]<rank[parCell2]){
            parent[parCell1] = parCell2;
            size[parCell2]+=size[parCell1];
            size[parCell1] = 0;
        }else{
            parent[parCell2] = parCell1;
            size[parCell1]+=size[parCell2];
            size[parCell2] = 0;
            rank[parCell1]++;
        }
    }
    private int find(int parent[],int cell){
        if(parent[cell]==cell) return cell;
        return parent[cell] = find(parent,parent[cell]);
    }
    public static void main(String[] args) throws Exception {}
}