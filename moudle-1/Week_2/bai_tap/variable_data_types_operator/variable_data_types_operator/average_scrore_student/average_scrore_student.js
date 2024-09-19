let inputphysics;
let inputchemistry;
let inputbiology;

inputphysics = +prompt("Enter the physics");
inputchemistry = +prompt("Enter the chemistry");
inputbiology = +prompt("Enter the biology");

let average_scrore_student = (inputchemistry + inputphysics + inputbiology)/3;
document.write('The average scrore student is:' + average_scrore_student);