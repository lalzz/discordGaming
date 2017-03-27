package net.chromaryu.discordgaming.dungeon;

import java.util.Random;
import java.util.HashMap;

/**
 * Created by midgard on 17/03/06.
 */
public class Dungeon {
    private static HashMap<String,String> dungeon = new HashMap<>();
    int[][] map;
    
    public Dungeon()
    {
        Random gen = new Random();
        int size = gen.nextInt(25)+10;
        map = new int[size][size];
        for(int[] i : map)
        {
         for(int j: i)
         {
             int type = gen.nextInt(10);
             if(type==9)
                 
                 if(type==1
         }
        }
    }
    public Dungeon(int[][] data)
    {
        map = data;
    }
    public String toString()
     {
                        return Arrays.toString(map);
     }
                    
}
