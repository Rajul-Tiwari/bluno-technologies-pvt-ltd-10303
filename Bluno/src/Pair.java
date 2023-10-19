import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import java.util.*;

public class Pair implements Comparable<Pair>{
    private String songName;
    private Long  n;
    private Long m;

    public Pair(String songName, Long n) {
        this.songName = songName;
        this.n = n;
    }
    void inc(){
        n++;
        m=System.currentTimeMillis();
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Input");

        int n=Integer.parseInt(sc.nextLine());
        Map<String,Pair> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();


        for(int i=0;i<n-1;i++){
            String songName=sc.nextLine();

            if(map.containsKey(songName)){
                Pair p = map.get(songName);
                p.inc();
            }else{
                Pair p = new Pair(songName,1L);
                map.put(songName,p);
            }
        }
        int k = Integer.parseInt(sc.nextLine());
        map.values().stream().sorted().limit(k).forEach(p-> System.out.println(p.songName));




    }
    @Override
    public int compareTo(Pair p) {
        return (n.compareTo(p.n))==0 ? (-m.compareTo(p.m)) :-(n.compareTo(p.n));
    }
    @Override
    public int hashCode() {
        return Objects.hash(songName);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if(obj instanceof String){
            return songName.equals(obj.toString());
        }
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        return songName.equals(other.songName);
    }


}
