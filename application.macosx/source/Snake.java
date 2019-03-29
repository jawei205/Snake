import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Snake extends PApplet {

//Initialisierungen

  

  



float x;
float y;
float xs=0;
float ys=0;
float eatx=random(width);
float eaty=random(height);
float d;
float farbe = 100;
int score=0;
int hightscore=0;

//Bomben
Bomb[] bombs = new Bomb[25];

public void setup() {
   
  frameRate(60);  //FPS
  
  //Spielfigur wird gesetzt
  x = width/2;
  y = height/2;

  for (int i = 0; i < bombs.length; i++) {
    bombs[i]= new Bomb();
  }
}


public void draw() {
  background(51);
  noStroke();
  rectMode(CENTER);
  fill(255);
  rect(x, y, 50, 50);
  colorMode(HSB);


//Geschwindigkeit wird zur Spielfigur hinzugef\u00fcgt
  x=x+xs;
  y=y+ys;
  
  //F\u00fcr die Bomben
  for (int i  =0; i < bombs.length; i++) {
    bombs[i].show(); // ... zeichne die Bombe

    if (dist(x, y, bombs[i].x, bombs[i].y) < 50 ) { 
      score = 0;
      fill(255);
       textSize(200);
      text("Bombe ber\u00fchrt!",100,350);
    }
  }
  
  //Distanz zu Nahrungsball
  if (dist(x, y, eatx, eaty)<35) {
    eatx=random(100, width-100);
    eaty = random(100, height-100);
    score++;
      
    
    farbe = random(50, 200);
  }
  textSize(32);
  fill(255);
  text("Score:"+score, 20, 50); //Score text
  text("Highscore:" +hightscore, 20, 100);
  ellipse(eatx, eaty, 20, 20);
if (score>hightscore){
 hightscore++;  {  //highscore
 }
}
}
//Wenn Pfeitasten gedr\u00fcckt werden wird die Spielfigur bewegt
public void keyPressed() {
  if (keyCode==UP) {
    ys-=3;
  }

  if (keyCode==DOWN) {
    ys+=3;
  }

  if (keyCode==RIGHT) {
    xs+=3;
  }

  if (keyCode==LEFT) {
    xs-=3;
  }
}
class Bomb{
    float x;
  float y;
  float d = 50;

  Bomb() {
    this.x = floor(random(width/d))*d;
    this.y = floor(random(height/d))*d;
  }

  public void show() {
    rectMode(CENTER);
    fill(0, 255, 255);
    rect(this.x, this.y, this.d, this.d);
  }
}
  
  
  
  
  

  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Snake" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
