class Rectangle {
    height;
    width;

    constructor(width, height) {
        this.height = height;
        this.width = width;
    }

    getWidth(){
        return this.width;
    }
    getHeight(){
        return this.height;
    }
    setWidth(width){
        this.width = width;
    }
    setHeight(height) {
        this.height = height;
    }

    caculateArea() {
        return this.width * this.height;
    }

    caculatePremeter() {
        return (this.width + this.height) * 2;
    }
    drawRectangle(canvasRect) {
        const canvas =  document.getElementById(canvasRect);
        const ctx = canvas.getContext('2d');
        //
        const  grd = ctx.createLinearGradient(0,0,300,0);
        grd.addColorStop(0,"red");
        grd.addColorStop(1,"white");
        //
        ctx.fillStyle = grd;
        ctx.fillRect(20,20, this.width, this.height);
    }
}
