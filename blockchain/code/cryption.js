const utf8Array = [];
const cipherArray = [];
const plainText = "我们的最低价是1元";
for (let i = 0; i < plainText.length; i++) {
    utf8Array[i] = plainText.charCodeAt(i);
    cipherArray[i] = plainText.charCodeAt(i) + 3;
}

console.log(utf8Array); // [25105, 20204, 30340, 26368, 20302, 20215, 26159, 49, 20803]
console.log(cipherArray); // [25108, 20207, 30343, 26371, 20305, 20218, 26162, 52, 20806]

for (let i = 0; i < cipherArray.length; i++) {
    console.log(String.fromCharCode(cipherArray[i]))
}

for (let i = 0; i < utf8Array.length; i++) {
    console.log(String.fromCharCode(utf8Array[i]))
}