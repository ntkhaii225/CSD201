/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Playlistt;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ntkhai
 */

class Node{
    String data;
    Node pNext;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }
    
}
public class Playlist {
    Node pHead;
    Node pTail;
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    String filename = "song.txt";
    Scanner input = new Scanner(filename);
    ArrayList<String> list = new ArrayList<String>();
    public Playlist() {
        this.pHead = this.pTail = null;
    } 
    
    
    public void loadData(ArrayList<String> list)
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("song.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(line != null)
                list.add(line);
                 
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public int check(String str)
    {
        int choice;
        while(true)
            {
               try{
                   System.out.println("Do you want to continue " + str +  " song:");
                   System.out.println("1. Yes / 2. No");
                   choice = Integer.parseInt(sc.nextLine());
                   break;
               } catch(Exception ex)
               {
                   System.out.println("Error format");
               }
            }
        return choice;
    }
    
    public String name(String str)
    {
        System.out.println("Input name the song you want to " + str + ":");
        String name = sc.nextLine();
        return name;
    }
    
    public Node createNode()
    {
        Node p = new Node();
        for(String nameSong : list)
        {
            p = new Node(nameSong);
        }
//            String nameSong = name("add");
//            p = new Node(nameSong);
       
        return p;
    }
    
    public Playlist newPlaylist(Playlist l, ArrayList<String> list)
    {
//        do{
            for(String nameSong : list)
            {
                Node p = new Node(nameSong);
                addMusic(l, p);
            }
//            choice = check("adding");
//        }while(choice == 1);
        return l;
    }
    
    public void addMusic(Playlist l, Node p)
    {
        //addHead
        if(l.pHead == null)
        {
            l.pHead = l.pTail = p;
            return;
        }
        p.pNext = l.pHead;
        l.pHead =  p;
    }
    
    public void showPlaylist(Playlist l)
    {
        for(Node i = l.pHead; i != null; i = i.pNext)
        {
            if(i.pNext == null)
            {
                System.out.println(i.data);
                return;
            }
            System.out.print(i.data + " - ");
        }
        if(l.pHead == null)
        {
            System.out.println("Playlist is null");
        }
    }
    
    public int dem(Playlist l)
    {
        int dem = 0;
        for(Node i = l.pHead; i != null; i = i.pNext)
        {
            dem++;
        }
        return dem;
    }
    
    public void removeSongs(Playlist l)
    {
        int choice;
        do{
            boolean check = false;
            String str = name("delete");
            Node j = new Node();
            if(l.pHead.data.equals(str))
            {
                l.pHead = l.pHead.pNext;
                check = true;
            }
            else
            {
                for(Node i = l.pHead; i != null; i = i.pNext)
                {
                if(i.data.equals(str))
                {
                    j.pNext = i.pNext;
                    check = true; 
                    break;
                }
                j = i;
                }
            }
            
            if(check)
                System.out.println(str + " has been deleted");
            else 
                System.out.println("Not found");
            choice = check("deleting");
        }while(choice == 1);
    }
    
    public int randomSong(String[] arr, Playlist l)
    {
        Node i = l.pHead;
        for(int j = 0; j < arr.length; j++)
        {
            arr[j] = i.data;
            i = i.pNext;
        }
        int select = random.nextInt(arr.length);
        return select;
    }
    
    public String selectSong(int n, Playlist l)
    {
        String[] arr = new String[n];
        int select = randomSong(arr,l);
        return arr[select];
    }
    
    
    public void skipSong(String currentSong, Playlist l)
    {
        if(l.pTail.data.equals(currentSong))
        {
            System.out.println(l.pHead.data);
            return;
        }
        for(Node i = l.pHead; i.pNext != null; i = i.pNext)
        {
            if(i.data.equals(currentSong))
            {
                System.out.println(i.pNext.data);
            }
        }
    }
    
    public void previousSong(String currentSong, Playlist l)
    {
        if(l.pHead.data.equals(currentSong))
        {
            System.out.println(l.pTail.data);
            return;
        }
        
        Node q = new Node();
        for(Node i = l.pHead.pNext; i != null; i = i.pNext)
        {
            if(i.data.equals(currentSong))
            {
                System.out.println(q.data);
            }
            q = i;
        }
    }
    
    public void sufflePlaylist(int n, Playlist l) //Fisher Yates Shuffle
    {
        String[] arr = new String[n];
        Node i = l.pHead;
        for(int j = 0; j < arr.length; j++)
        {
            arr[j] = i.data;
            i = i.pNext;
        }
        int check = 0;
        int select;
        for(int k = arr.length - 1; k > 0; k--)
        {
            while(true)
            {
                select = random.nextInt(k);
                if(select != check || select != k)
                    break;
            }
                swap(select, k, arr);
                check = select;
        }
        
        for(Node p = l.pHead; p != null; p = p.pNext)
        {
            p.data = arr[check];
            check++;
        }
    }
    
    public void swap(int a, int b, String[] arr)
    {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        
    }
    
    public void delete()
    {
        this.pHead = null;
    }

}


