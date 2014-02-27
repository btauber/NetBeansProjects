package uf;

public class UF {
    private int[] id;
    public UF(int N) {
        id = new int[N];
        for(int i = 0;i < N;i++){
            id[i] = i;
        }
    }
    public void union(int p, int q) {
       int pid = id[p];
       int qid = id[q];
       for(int i = 0;i < id.length; i++){
           if(id[i]==pid){
               id[i] = qid;
           }
       }
    }
    
    public boolean connected(int p,int q) {
        return id[p]==id[q];
    }
    
    private int root(int i) {
        while(i!=  id[i]){
            i = id[i];
        }
        return i;
    }
    public static void main(String[] args) {
        
    }
    
}
