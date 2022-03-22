/* autogenerated by Processing revision 1281 on 2022-03-22 */
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

public class football_game_assignment_ extends PApplet {



football football;
PImage fImg;
PImage lImg;
PImage bImg;
ArrayList<bear> bears = new ArrayList<bear>();


 public void mousePressed() {
  bears.add(new bear());
}

 public void setup() {
  /* size commented out by preprocessor */;
  fImg = loadImage("fooball.png");
  lImg = loadImage("bear.png");
  bImg = loadImage("backgroundf.png");
  football = new football();
}


 public void keyPressed() {
  if (key == ' ') {
    football.jump();
  }
}

 public void draw() {

  if (random(1) < 0.008f) {
    bears.add(new bear());
  }

  background(bImg);
  for (bear t : bears) {
    t.move();
    t.show();
    if (football.hits(t)) {
      print("game over");
      noLoop();
    }
  }

  football.show();
  football.move();
}

class bear {
  int r;
  float x, y;
  bear() {
    this.r = 75;
    this.x = width;
    this.y = height - this.r;
  }

   public void move() {
    this.x -= 18;
  }

   public void show() {
    image(lImg, this.x, this.y, this.r, this.r);

    
  }
}

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

   public void jump() {
    if (this.y == height - this.r) {
      this.vy = -35;
    }
  }

   public boolean hits(bear bear) {
    float x1 = this.x + this.r * 0.5f;
    float y1 = this.y + this.r * 0.5f;
    float x2 = bear.x + bear.r * 0.5f;
    float y2 = bear.y + bear.r * 0.5f;
    return collideCircleCircle(x1, y1, this.r, x2, y2, bear.r);
  }

   public void move() {
    this.y += this.vy;
    this.vy += this.gravity;
    this.y = constrain(this.y, 0, height - this.r);
  }

   public void show() {
    image(fImg, this.x, this.y, this.r, this.r);

  
  }
}


 public boolean collideCircleCircle (float x, float y, float d, float x2, float y2, float d2) {
  //2d
  if ( dist(x, y, x2, y2) <= (d/2)+(d2/2) ) {
    return true;
  }
  return false;
};


  public void settings() { size(800, 450); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "football_game_assignment_" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
