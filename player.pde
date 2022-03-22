
class football {
  int r;
  float x, y, vy, gravity;
  football() {
    this.r = 100;
    this.x = 50;
    this.y = height - this.r;
    this.vy = 0;
    this.gravity = 3;
  }

  void jump() {
    if (this.y == height - this.r) {
      this.vy = -35;
    }
  }

  boolean hits(bear bear) {
    float x1 = this.x + this.r * 0.5;
    float y1 = this.y + this.r * 0.5;
    float x2 = bear.x + bear.r * 0.5;
    float y2 = bear.y + bear.r * 0.5;
    return collideCircleCircle(x1, y1, this.r, x2, y2, bear.r);
  }

  void move() {
    this.y += this.vy;
    this.vy += this.gravity;
    this.y = constrain(this.y, 0, height - this.r);
  }

  void show() {
    image(fImg, this.x, this.y, this.r, this.r);

  
  }
}


boolean collideCircleCircle (float x, float y, float d, float x2, float y2, float d2) {
  //2d
  if ( dist(x, y, x2, y2) <= (d/2)+(d2/2) ) {
    return true;
  }
  return false;
};
