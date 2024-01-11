/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ntkhai
 */

class Node{
    char data;
    Node pNext;

    public Node() {
    }

    public Node(char data) {
        this.data = data;
        
    }
    
}

public class Stack {
    Node sTop;

    public Stack() {
        sTop = null;
    }
    
    public void clear()
    {
        this.sTop = null;
    }
    
    public boolean isEmpty()
    {
        if(this.sTop == null)
            return true;
        return false;
    }
    
     public void push(Node p)
    {
        //addHead
        if(sTop == null)
        {
            sTop = p;
            return;
        }
        else
        {
           p.pNext = sTop;
           sTop = p;
        }
    }
   
     public void pop(Stack s)
     {
         sTop = sTop.pNext;
         
     }
     
     public char top(Stack s)
     {
         char str = sTop.data;
         return str;
     }
     
    public Node createNode(char s)
    {
        Node p = new Node(s);
        return p;
    }
    
    public void show(Stack s)
    {
        for(Node i = sTop; i != null; i = i.pNext)
        {
            System.out.println(i.data);
        }
    }
    
    public int check(String str, Stack s)
    {
        for(Character c : str.toCharArray())
        {
            if(c == '{' || c == '('||c == '[')
            {
                Node p = new Node(c);
                s.push(p);
                
            }
            else if(c == '}'||c == ']'||c == ')')
            {
                if(c == '}' && s.sTop.data == '{')
                {
                    s.pop(s);
                }
                else if(c == ']' && s.sTop.data == '[')
                {
                    s.pop(s);
                }
                else if(c == ')' && s.sTop.data == '(' )
                {
                    s.pop(s);
                }
                else 
                    return -1;
            }  
        }
        if(s.sTop == null)
        return 0;
        else 
            return -1;
    }
    
    public int checkInt(String str)
    {
        int dem = 0;
        for(Character c : str.toCharArray())
        {
            if(c == '{' || c == '('||c == '['||c == '}'||c == ']'||c == ')')
                dem++;
        }
        return dem;
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        String str = "[7*(1+2)]";
        
//        StringBuilder sb = new StringBuilder();
//        for(Character c : str.toCharArray())
//        {
//            if(c == '{' || c == '('||c == '['||c == '}'||c == ']'||c == ')'|| c == ' ')
//            {
//                sb.append(c);
//            }
//        }
//        System.out.println(sb.toString());
//        for(Character c : str.toCharArray())
//        {
//            Node p = new Node(c);
//            if(c == '{' || c == '('||c == '['||c == '}'||c == ']'||c == ')')
//            s.push(p);
//        }
//        s.pop(s);
//        s.show(s);
        
        int amen = s.check(str, s);
        System.out.println(amen);
    }
}


