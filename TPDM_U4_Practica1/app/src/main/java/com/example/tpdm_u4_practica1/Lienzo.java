package com.example.tpdm_u4_practica1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Lienzo extends View {
Circulo puntero = null;
 Circulo[] circulos = new Circulo[10];
 Thread hilo;



 public Lienzo(Context context){
     super(context);
     for(int i =0;i<circulos.length;i++){
         circulos[i] = new Circulo(400,400,(int)(Math.random()*100)+20);
         circulos[i].Red =(int)(Math.random()*255)+1;
         circulos[i].Green =(int)(Math.random()*255)+1;
         circulos[i].Blue =(int)(Math.random()*255)+1;
         circulos[i].mx = ((int)(Math.random()*5)+1)-(int)(Math.random()*100)+10;
         circulos[i].my = ((int)(Math.random()*5)+1)-(int)(Math.random()*100)+10;
     }

     hilo = new Thread(){
         public void run(){
             while(true){
                 for(int i =0;i<circulos.length;i++){

                     circulos[i].mover();

                 }
                 try{
                     sleep(50);
                 }catch (InterruptedException e){
                     //error
                 }
                 invalidate();

             }

         }
     };

     hilo.start();

 }

 public void colision(Circulo p,Canvas c){
     if(p.x >=c.getWidth()){
        p.mx=p.mx*-1 ;
     }
     if(p.x<=1){
         p.mx=p.mx*-1 ;
     }
     if(p.y >= c.getHeight()){
         p.my=p.my*-1 ;
     }
     if(p.y <=1){
         p.my=p.my*-1 ;
     }

 }

 protected void onDraw(Canvas c){

     Paint p = new Paint();
     for(int i =0;i<circulos.length;i++){
         colision(circulos[i],c);
         circulos[i].pintar(c,p);
     }
 }



}
