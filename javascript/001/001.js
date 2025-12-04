// var 的问题：意外全局
if (true) {
  var x = 10;
}
console.log(x); // 10（泄露到全局）

// let：安全块级
if (true) {
  let y = 20;
}
// console.log(y); // 报错：y 未定义

// const：常量
const PI = 3.14;
// PI = 3.1415; // 报错：不可赋值

// 但 const 对象可改内部
const person = { name: 'Alice' };
person.name = 'Bob'; // OK
console.log(person.name); // Bob