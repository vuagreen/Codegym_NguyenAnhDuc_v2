/**
 * Created by nhatnk on 4/26/17.
 */

function Hero(image, top, left, size) {
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;
    this.setimg = function (y) {
        this.image = y;
    };
    this.getHeroElement = function () {
        return '<img width="' + this.size + '"' +
            ' height="' + this.size + '"' +
            ' src="' + this.image + '"' +
            ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
    };
    let x = 200;
    this.moveRight = function () {
        this.left += x;
        console.log('ok: ' + this.left);
    };
    this.moveDown = function () {
        this.top += x;
        console.log('ok: ' + this.top);
    };
    this.moveLeft = function () {
        this.left -= x;
        console.log('ok: ' + this.left);
    };
    this.moveUp = function () {
        this.top -= x;
        console.log('ok: ' + this.top);
    };

}

var count = 1;
let y = "";
y = "doremon.jpg";
var hero = new Hero(y, 20, 30, 200);
let temp = true;
let temp2 = true;

function start() {
    if (hero.left < window.innerWidth - hero.size - 100 && temp) {
        hero.moveRight();
    } else {
        if (hero.top < window.innerHeight - hero.size - 150 && temp2) {
            hero.moveDown();
            temp = false;
        } else {
            if (hero.left > 100) {
                hero.moveLeft();
                temp2 = false;
            } else {
                if (hero.top > 100) {
                    hero.moveUp();
                } else {
                    if (count % 2 === 1) {
                        y = "pikachu.png";
                    } else {
                        y = "doremon.jpg";
                    }
                    hero.setimg(y);

                    temp = true;
                    temp2 = true;
                    count++;
                }
            }
        }

    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 500)
}

start();