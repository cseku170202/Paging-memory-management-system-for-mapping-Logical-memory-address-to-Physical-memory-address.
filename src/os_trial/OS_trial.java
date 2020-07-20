/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_trial;

import java.awt.Color;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 *
 * @author N.S
 */
public class OS_trial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        Scanner rum = new Scanner(System.in);
        System.out.println("Enter the Logical Memory Size:");
        int logical_memory_size=rum.nextInt();
        System.out.println("Enter the Physical Memory Size:");
        int physical_memory_size=rum.nextInt();
        System.out.println("Enter the Unit Size");
        int unit_size=rum.nextInt();
        int total_page=logical_memory_size/unit_size;
        int total_frame=physical_memory_size/unit_size;
        Vector v=new Vector();

       int i,j,t=0,ta;
       int l=0;
       int p=300,q=50;
       int A[]=new int[3];
       JFrame frame = new JFrame();
       JLabel label = null;
       j=total_page-1;
       //page number print
       for(i=1;i<=total_page;i++)
       {
           JButton rectangle = new JButton("Page No "+(j));
           rectangle.setBounds(p, q, 100, 35);
           rectangle.setBackground(Color.GREEN);
           frame.add(rectangle);
           q = q + 35;
           j--;
       } 
       
       label = new JLabel("LOGICAL  MEMORY  SPACE");
       label.setBounds(250, 20, 300, 30);
       frame.add(label);
       
       int r=250;
       int s=50;
       int m=logical_memory_size;
       int n=logical_memory_size-unit_size;
       for(i=1;i<=total_page;i++)
       {
           label = new JLabel(n+"k-"+m+"k");
           label.setBounds(r, s, 50, 35);
           frame.add(label);
           s = s + 35;
           
           n=n-unit_size;
           m=m-unit_size;
       }
       //logical memory space done
       
       
       //page table start
       label = new JLabel("PAGE  TABLE  INFORMATION");
       label.setBounds(550, 20, 300, 30);
       frame.add(label);
       
       
       int a=500;
       int b=50;
       int c=600;
       int d=50;
       for(i=0;i<total_frame;i++)
       {
           System.out.println("Enter Page Number & Frame Number");
           int page_no=rum.nextInt();
           int frame_no=rum.nextInt();
           
           v.add(page_no);
           v.add(frame_no);
           
           JButton rect = new JButton("Page No "+page_no);
           rect.setBounds(a, b, 100, 35);
           rect.setBackground(Color.CYAN);
           frame.add(rect);
           b = b + 35;
           
           JButton rect_frame = new JButton("Frame No "+frame_no);
           rect_frame.setBounds(c, d, 150, 35);
           rect_frame.setBackground(Color.CYAN);
           frame.add(rect_frame);
           d = d + 35;
       }
       //page table done
       
       //physical memory start
       int w=total_frame-1;
       int e=900;
       int f=50;
       for(i=0;i<total_frame;i++)
       {
           JButton rect1 = new JButton("Frame No "+w);
           rect1.setBounds(e, f, 150, 35);
           rect1.setBackground(Color.YELLOW);
           frame.add(rect1);
           f = f + 35;
           w--;
       }
       
       label = new JLabel("PHYSICAL  MEMORY  SPACE");
       label.setBounds(900, 20, 300, 30);
       frame.add(label);
       
       int g=1050;
       int h=50;
       int x=physical_memory_size;
       int y=physical_memory_size-unit_size;
       for(i=0;i<total_frame;i++)
       {
           label = new JLabel(y+"k-"+x+"k");
           label.setBounds(g, h, 150, 35);
           frame.add(label);
           h = h + 35;
           
           x = x - unit_size;
           y = y - unit_size;
       }

       frame.setLayout(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       //physical memory finish
    
        System.out.println("Enter a logical address you want to find position in frame :");
        int address=rum.nextInt();

        int address_page = address/(1024*unit_size);
        int offset=address%(unit_size*1024);
        boolean shymun=v.contains(address_page);
        int page_index=1;
        if(shymun == true)
        {
            for(i=0;i<v.size();i=i+2)
            {
                if(address_page==(int)v.get(i))
                {
                    page_index=i; 
                    break;
                }
            }
        }
        int t1=0;
        if(shymun==true &&  page_index%2==0)
        {
               System.out.println("Your given address is in frame "+v.get(page_index+1));
               t1=(int)v.get(page_index+1);
               t=(int)(v.get(page_index+1))*unit_size*1024+offset;
               System.out.println("Actual Physical Address : "+t);
        }
        else
        {
             System.out.println("The given address is not in the Frame " );
        }
        
        
       ta=t;
       d=b+60;
       c=b+80;
       b=b+100;
       if(t!=0){
       label = new JLabel("The Physical Address of "+address+" is = "+t);
       label.setBounds(500, b, 600, 30);
       frame.add(label);
       }
       
       if(t1!=0){
       label = new JLabel("The Frame number of "+address+" is = "+t1);
       label.setBounds(500, c, 600, 30);
       frame.add(label);
       }
       
       label = new JLabel("The Entered Logical Address = "+address);
       label.setBounds(500, d, 600, 30);
       frame.add(label);
       
       
       frame.setLayout(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       
    }
    
}
