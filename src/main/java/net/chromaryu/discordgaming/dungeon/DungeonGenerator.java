package net.chromaryu.discordgaming.dungeon;

import java.util.Random;

public class DungeonGenerator {
  static String seed = "";
  static Random gen = new Random(seed);
  
  public static void setSeed(String s)
  {
    this.seed = s;
    this.gen = new Random(seed);
  }
  
  public static Dungeon generateDungeon()
  {
    Dungeon d = new Dungeon();
    return d;
  }
}
