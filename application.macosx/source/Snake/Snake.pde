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

void setup() {
  fullScreen(); 
  frameRate(60);  //FPS

  //Spielfigur wird gesetzt
  x = width/2;
  y = height/2;

  for (int i = 0; i < bombs.length; i++) {
    bombs[i]= new Bomb();
  }
}


void draw() {
  background(51);
  noStroke();
  rectMode(CENTER);
  fill(255);
  rect(x, y, 50, 50);
  colorMode(HSB);


  //Geschwindigkeit wird zur Spielfigur hinzugefügt
  x=x+xs;
  y=y+ys;

  //Für die Bomben
  for (int i  =0; i < bombs.length; i++) {
    bombs[i].show(); // ... zeichne die Bombe

    if (dist(x, y, bombs[i].x, bombs[i].y) < 50 ) { 
      score = 0;
      fill(255);
      textSize(200);
      text("Bombe berührt!", 100, 350);
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
  if (score>hightscore) {
    hightscore++;  
    {  //highscore
    }
  }
}
//Wenn Pfeitasten gedrückt werden wird die Spielfigur bewegt
void keyPressed() {
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