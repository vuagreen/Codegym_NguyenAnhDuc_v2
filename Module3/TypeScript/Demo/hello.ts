var a:number = 100;
var b: string = "hello";
var c: boolean = true;
var d: any = {
    ho: "Nguyễn",
    ten: "Anh Đức"
};
{
    let m: number = 99;
    console.log(m);
}
console.log(a);
console.log(b);
console.log(c);
console.log(d.ho);
console.log(d.ten);

if (c) {
    console.log("OK");

} else {
    console.log("Not");
}

// console.log("-------FOR--------");
// for (let i = 0; i <= 5; i++) {
//     console.log(i);
// }

var ds: string[] = ["a", "bb", "ccc"];
console.log(ds[1]);
//duyetmang theo FOR typescript
//FOR IN /OFF
for (let k in ds) {
    console.log("IN" + k);
}
for (let x of ds) {
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

//
