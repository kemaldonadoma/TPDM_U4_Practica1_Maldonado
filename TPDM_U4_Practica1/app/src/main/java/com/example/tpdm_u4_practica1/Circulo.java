package com.example.tpdm_u4_practica1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circulo {
    int x,y,r,mx,my,Red,Green,Blue;

    Thread hilo;
    public Circulo(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;

    }


    public void mover(){
        x += mx;
        y += my;
    }

    public void pintar(Canvas c, Paint p){
        p.setColor(Color.rgb(Red,Green,Blue));
        c.drawCircle(x,y,r,p);
    }



}
