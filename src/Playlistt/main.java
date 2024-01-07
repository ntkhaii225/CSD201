/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Playlistt;

import java.util.ArrayList;
import java.util.Scanner;




/**
 *
 * @author ntkhai
 */
public class main {
    public static void MiniMenu()
    {
        System.out.println("1.Next Song");
        System.out.println("2.Previous Song");
    }
    
    public static void Menu()
    {
        System.out.println("======================");
        System.out.println("1. Show Playlist");
        System.out.println("2. Add");
        System.out.println("3. Remove");
        System.out.println("4. Select Song");
        System.out.println("5. Suffle");
        System.out.println("======================");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist l = new Playlist();
        int n;
        String str;
        ArrayList<String> list = new ArrayList();
        l.loadData(list);
        l.newPlaylist(l, list);
        int choice;
        Menu();
        do{
            System.out.println("Your choice:");
            choice = sc.nextInt();
            switch(choice) {
            case 1:
                System.out.println("Playlist Yoasobi");
                l.showPlaylist(l);
                break;
            case 2:
                String nameSong = l.name("adding");
                Node p = new Node(nameSong);
                l.addMusic(l, p);
                break;
            case 3:
                l.removeSongs(l);
                break;
            case 4:
                n = l.dem(l);
                str = l.selectSong(n, l);
                System.out.println("Current Song:" + str);
                MiniMenu();
                int chon = sc.nextInt();
                do{
                    if(chon == 1)
                {
                    l.skipSong(str, l);
                    break;
                }
                else 
                {
                    l.previousSong(str, l);
                    break;
                }
                }while(chon > 0 && chon < 3);
                
            case 5:
                n = l.dem(l);
                l.sufflePlaylist(n, l);
                break;
    }
        }while(choice > 0 && choice < 6);
        
    }
    
    
}
