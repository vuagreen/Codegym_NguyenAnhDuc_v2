var a = 100;
var b = "hello";
var c = true;
var d = {
    ho: "Nguyễn",
    ten: "Anh Đức"
};
{
    var m = 99;
    console.log(m);
}
console.log(a);
console.log(b);
console.log(c);
console.log(d.ho);
console.log(d.ten);
if (c) {
    console.log("OK");
}
else {
    console.log("Not");
}
// console.log("-------FOR--------");
// for (let i = 0; i <= 5; i++) {
//     console.log(i);
// }
var ds = ["a", "bb", "ccc"];
console.log(ds[1]);
//duyetmang theo FOR typescript
//FOR IN /OFF
for (var k in ds) {
    console.log("IN" + k);
}
for (var _i = 0, ds_1 = ds; _i < ds_1.length; _i++) {
    var x = ds_1[_i];
    console.log("OFF" + x);
}
//FUNCTION
function hello() {
    console.log("Hello World");
}
hello();
function bye() {
    return "goodbye";
}
// let x: string = bye();
// console.log(x);
console.log(bye());
