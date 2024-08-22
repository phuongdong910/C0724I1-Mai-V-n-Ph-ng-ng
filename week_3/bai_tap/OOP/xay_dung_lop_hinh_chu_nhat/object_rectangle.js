const rec = new Rectangle(100,180);

document.write("<br>", "<br>", "Area rectangle: ", rec.caculateArea(), "<br>");
document.write("Peremeter rectangle: ", rec.caculatePremeter(),"<br>");


// Hiển thị hình chữ nhật lên canvas
rec.drawRectangle('myCanvas');

rec.setWidth(300);
rec.setHeight(150);
rec.drawRectangle('myCanvas');