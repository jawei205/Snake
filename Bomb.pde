class Bomb{
  float x;
  float y;
  float d = 50;

  Bomb() {
    this.x = floor(random(width/d))*d;
    this.y = floor(random(height/d))*d;
  }

  void show() {
    rectMode(CENTER);
    fill(0, 255, 255);
    rect(this.x, this.y, this.d, this.d);
  }
}
  
  
  
  
  
